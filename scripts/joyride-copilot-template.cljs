;; Script for Exploring and installing instructions and prompts from GitHub Copilot Instructions Template
;; https://github.com/TheSethRose/GitHub-Copilot-Instructions-Template
;;
;; Joyride: https://github.com/BetterThanTomorrow/joyride
;; Install it from the Extensions pane in VS Code
;;
;; Install in Joyride as User script:
;; 1. Select all script code + Copy
;; 2. In VS Code Command Palette: Joyride: Create User Script...
;;    * Name it 'copilot-template'
;; 3. In the editor that opens: Select all + Paste
;;
;; Use, from any VS Code window:
;; 1. Command Palette: Joyride: Run User Script...
;; 2. Select 'copilot_template.cljs'

(ns copilot-template
  (:require ["vscode" :as vscode]
            ["path" :as path]
            ["fs" :as fs]
            [promesa.core :as p]
            [joyride.core :as joyride]))

(def CONTENT-BASE-URL "https://raw.githubusercontent.com/TheSethRose/GitHub-Copilot-Instructions-Template/main/.github/")
;; Preference management for picker memory
(def PREFS-KEY "copilot-template-preferences")

;; Static index of your repository structure
(def repository-index
  {:instructions
   [{:title "General Coding Standards"
     :filename "general-coding-standards.instructions.md"
     :description "Core coding standards and best practices for consistent, maintainable, and high-quality code"
     :link "instructions/general-coding-standards.instructions.md"}
    {:title "Copilot Instructions"
     :filename "copilot.instructions.md"
     :description "Code generation guidelines and Copilot configuration"
     :link "instructions/copilot.instructions.md"}
    {:title "Debug Instructions"
     :filename "debug.instructions.md"
     :description "Error handling and debugging practices"
     :link "instructions/debug.instructions.md"}
    {:title "Review Instructions"
     :filename "review.instructions.md"
     :description "Code review standards and practices"
     :link "instructions/review.instructions.md"}
    {:title "PR Instructions"
     :filename "pr.instructions.md"
     :description "Pull request documentation standards"
     :link "instructions/pr.instructions.md"}
    {:title "Security and OWASP"
     :filename "security-and-owasp.instructions.md"
     :description "Security best practices and OWASP guidelines"
     :link "instructions/security-and-owasp.instructions.md"}
    {:title "Performance Optimization"
     :filename "performance-optimization.instructions.md"
     :description "Performance guidelines and optimization strategies"
     :link "instructions/performance-optimization.instructions.md"}
    {:title "Markdown Standards"
     :filename "markdown-standards.instructions.md"
     :description "Markdown formatting and documentation standards"
     :link "instructions/markdown-standards.instructions.md"}
    {:title "Localization"
     :filename "localization.instructions.md"
     :description "Internationalization and localization guidelines"
     :link "instructions/localization.instructions.md"}
    ;; Language-specific instructions
    {:title "TypeScript React Standards"
     :filename "typescript-react-standards.instructions.md"
     :description "TypeScript and React development standards"
     :link "instructions/languages/typescript/typescript-react-standards.instructions.md"}
    {:title "Next.js Tailwind"
     :filename "nextjs-tailwind.instructions.md"
     :description "Next.js and Tailwind CSS development guidelines"
     :link "instructions/languages/typescript/nextjs-tailwind.instructions.md"}
    {:title "Azure Functions TypeScript"
     :filename "azure-functions-typescript.instructions.md"
     :description "Azure Functions development with TypeScript"
     :link "instructions/languages/typescript/azure-functions-typescript.instructions.md"}
    {:title "C# Instructions"
     :filename "csharp.instructions.md"
     :description ".NET and C# development standards"
     :link "instructions/languages/csharp/csharp.instructions.md"}
    {:title "ASP.NET REST APIs"
     :filename "aspnet-rest-apis.instructions.md"
     :description "ASP.NET Core REST API development guidelines"
     :link "instructions/languages/csharp/aspnet-rest-apis.instructions.md"}
    {:title "Blazor Instructions"
     :filename "blazor.instructions.md"
     :description "Blazor development standards and practices"
     :link "instructions/languages/csharp/blazor.instructions.md"}
    {:title ".NET MAUI"
     :filename "dotnet-maui.instructions.md"
     :description ".NET MAUI development guidelines"
     :link "instructions/languages/csharp/dotnet-maui.instructions.md"}
    {:title "Python Coding Standards"
     :filename "python-coding-standards.instructions.md"
     :description "Python development standards and best practices"
     :link "instructions/languages/python/python-coding-standards.instructions.md"}
    {:title "Go Instructions"
     :filename "go.instructions.md"
     :description "Go development standards and practices"
     :link "instructions/languages/go/go.instructions.md"}
    {:title "Angular Instructions"
     :filename "angular.instructions.md"
     :description "Angular development standards and practices"
     :link "instructions/languages/angular/angular.instructions.md"}
    {:title "Bicep Code Best Practices"
     :filename "bicep-code-best-practices.instructions.md"
     :description "Bicep infrastructure as code best practices"
     :link "instructions/languages/infrastructure/bicep-code-best-practices.instructions.md"}
    {:title "Terraform for Azure"
     :filename "generate-modern-terraform-code-for-azure.instructions.md"
     :description "Modern Terraform code generation for Azure"
     :link "instructions/languages/infrastructure/generate-modern-terraform-code-for-azure.instructions.md"}
    {:title "CMake vcpkg"
     :filename "cmake-vcpkg.instructions.md"
     :description "CMake and vcpkg development guidelines"
     :link "instructions/languages/cpp/cmake-vcpkg.instructions.md"}
    {:title "GenAI Script"
     :filename "genaiscript.instructions.md"
     :description "AI script generation guidelines"
     :link "instructions/languages/ai/genaiscript.instructions.md"}]

   :prompts
   [{:title "Clean Project"
     :filename "clean.prompt.md"
     :description "Comprehensive project cleanup and maintenance"
     :link "prompts/clean.prompt.md"}
    {:title "Commit Workflow"
     :filename "commit.prompt.md"
     :description "Automated Git commit workflow"
     :link "prompts/commit.prompt.md"}
    {:title "Diagnose Database"
     :filename "diagnose-database.prompt.md"
     :description "Database health monitoring and diagnostics"
     :link "prompts/diagnose-database.prompt.md"}
    {:title "Deploy React App"
     :filename "deploy-react-app.prompt.md"
     :description "React TypeScript portfolio deployment"
     :link "prompts/deploy-react-app.prompt.md"}
    {:title "Document Project"
     :filename "document-project.prompt.md"
     :description "Technical documentation generation"
     :link "prompts/document-project.prompt.md"}
    {:title "Explain"
     :filename "explain.prompt.md"
     :description "Technical guidance and educational support"
     :link "prompts/explain.prompt.md"}
    {:title "Generate Code"
     :filename "generate-code.prompt.md"
     :description "Code scaffolding and generation"
     :link "prompts/generate-code.prompt.md"}
    {:title "Optimize Performance"
     :filename "optimize-performance.prompt.md"
     :description "Performance analysis and optimization"
     :link "prompts/optimize-performance.prompt.md"}
    {:title "Review Code"
     :filename "review.prompt.md"
     :description "Comprehensive code review process"
     :link "prompts/review.prompt.md"}
    {:title "Seed Database"
     :filename "seed-database.prompt.md"
     :description "Database seeding and test data management"
     :link "prompts/seed-database.prompt.md"}
    {:title "Think Deep"
     :filename "think.prompt.md"
     :description "Deep reasoning and solution planning"
     :link "prompts/think.prompt.md"}
    {:title "Validate Schema"
     :filename "validate-schema.prompt.md"
     :description "Database schema validation and management"
     :link "prompts/validate-schema.prompt.md"}
    {:title "Analyze Requirements"
     :filename "analyze-requirements.prompt.md"
     :description "Requirements analysis and planning"
     :link "prompts/analyze-requirements.prompt.md"}
    {:title "Audit Security"
     :filename "audit-security.prompt.md"
     :description "React TypeScript security audit"
     :link "prompts/audit-security.prompt.md"}
    {:title "Build Dockerfile"
     :filename "build-dockerfile.prompt.md"
     :description "Multi-stage Dockerfile creation"
     :link "prompts/build-dockerfile.prompt.md"}
    {:title "Debug React"
     :filename "debug-react.prompt.md"
     :description "React TypeScript debugging"
     :link "prompts/debug-react.prompt.md"}
    {:title "Generate Issues"
     :filename "generate-issues.prompt.md"
     :description "Generate GitHub issues from specifications"
     :link "prompts/generate-issues.prompt.md"}
    {:title "Migrate Database"
     :filename "migrate-database.prompt.md"
     :description "Database migration management"
     :link "prompts/migrate-database.prompt.md"}
    {:title "Setup React Portfolio"
     :filename "setup-react-portfolio.prompt.md"
     :description "React TypeScript portfolio setup"
     :link "prompts/setup-react-portfolio.prompt.md"}]

   :chatmodes
   [{:title "Debug Mode"
     :filename "debug.chatmode.md"
     :description "Debugging assistance mode"
     :link "chatmodes/debug.chatmode.md"}
    {:title "Planner Mode"
     :filename "planner.chatmode.md"
     :description "Project planning and architecture mode"
     :link "chatmodes/planner.chatmode.md"}
    {:title "PRD Mode"
     :filename "prd.chatmode.md"
     :description "Product requirements document mode"
     :link "chatmodes/prd.chatmode.md"}
    {:title "Process Tracking"
     :filename "process-tracking.chatmode.md"
     :description "Process tracking and management mode"
     :link "chatmodes/process-tracking.chatmode.md"}
    {:title "Prompt Engineer"
     :filename "prompt-engineer.chatmode.md"
     :description "Prompt engineering assistance mode"
     :link "chatmodes/prompt-engineer.chatmode.md"}
    {:title "PostgreSQL DBA"
     :filename "postgresql-dba.chatmode.md"
     :description "PostgreSQL database administrator mode"
     :link "chatmodes/postgresql-dba.chatmode.md"}
    {:title "GPT-4.1 Coding Agent"
     :filename "gpt-4.1-coding-agent.chatmode.md"
     :description "Advanced coding agent mode"
     :link "chatmodes/gpt-4.1-coding-agent.chatmode.md"}
    {:title "Refine Issue"
     :filename "refine-issue.chatmode.md"
     :description "Issue refinement and analysis mode"
     :link "chatmodes/refine-issue.chatmode.md"}]})

(defn get-vscode-user-dir []
  (let [context (joyride/extension-context)
        global-storage-uri (.-globalStorageUri context)
        global-storage-path (.-fsPath global-storage-uri)]
    ;; Get the User directory, which is two levels up from the extension's globalStorage directory
    ;; The path structure is: User/globalStorage/extension-id
    (-> global-storage-path
        path/dirname
        path/dirname)))

(defn get-preferences []
  (let [context (joyride/extension-context)
        global-state (.-globalState context)
        stored (.get global-state PREFS-KEY)]
    (if stored
      (js->clj (js/JSON.parse stored) :keywordize-keys true)
      {})))

(defn save-preference [key value]
  (let [context (joyride/extension-context)
        global-state (.-globalState context)
        current-prefs (get-preferences)
        updated-prefs (assoc current-prefs key value)]
    (.update global-state PREFS-KEY (js/JSON.stringify (clj->js updated-prefs)))))

(defn get-preference [key default-value]
  (get (get-preferences) key default-value))

(defn show-picker-with-memory+
  [items {:keys [title placeholder preference-key match-fn save-fn]}]
  (let [last-choice (get-preference preference-key nil)
        items-js (clj->js items)
        picker (vscode/window.createQuickPick)]

    (set! (.-items picker) items-js)
    (set! (.-title picker) title)
    (set! (.-placeholder picker) placeholder)
    (set! (.-ignoreFocusOut picker) true)

    (when last-choice
      (when-let [active-index (some->> items-js
                                       (map-indexed vector)
                                       (some (fn [[idx item]]
                                               (when (match-fn item last-choice) idx))))]
        (set! (.-activeItems picker) #js [(aget items-js active-index)])))

    ;; Return a promise that handles the user interaction
    (js/Promise.
     (fn [resolve _reject]
       (.onDidAccept picker
                     (fn []
                       (let [selected (first (.-selectedItems picker))]
                         (.hide picker)
                         (when selected
                           (let [selected-clj (js->clj selected :keywordize-keys true)]
                             (save-preference preference-key (save-fn selected-clj))
                             (resolve selected-clj))))))
       (.onDidHide picker
                   (fn []
                     (resolve nil)))
       (.show picker)))))

(def categories
  [{:label "Browse Individual Items"
    :iconPath (vscode/ThemeIcon. "list-flat")
    :description "Browse and install individual items"
    :detail "Select specific instructions, prompts, or chatmodes"
    :category "browse"}
   {:label "Install Chatmodes"
    :iconPath (vscode/ThemeIcon. "color-mode")
    :description "Install all chatmodes"
    :detail "Install all 8 conversation behavior settings for different activities"
    :category "chatmodes-bulk"}
   {:label "Install Instructions (Core)"
    :iconPath (vscode/ThemeIcon. "list-ordered")
    :description "Install core instructions only"
    :detail "Install 9 general coding standards and best practices (excluding language-specific)"
    :category "instructions-core-bulk"}
   {:label "Install Language Instructions"
    :iconPath (vscode/ThemeIcon. "code")
    :description "Install language-specific instructions"
    :detail "Choose a specific programming language to install instructions for"
    :category "instructions-language-bulk"}
   {:label "Install Prompts"
    :iconPath (vscode/ThemeIcon. "chevron-right")
    :description "Install all prompts"
    :detail "Install all 19 task-specific templates for common development tasks"
    :category "prompts-bulk"}])

(def sub-categories
  [{:label "Instructions"
    :iconPath (vscode/ThemeIcon. "list-ordered")
    :description "Coding styles and best practices"
    :detail "Guidelines for generating code that follows specific patterns"
    :category "instructions"}
   {:label "Prompts"
    :iconPath (vscode/ThemeIcon. "chevron-right")
    :description "Task-specific templates"
    :detail "Pre-defined prompts for common tasks like testing, documentation, etc."
    :category "prompts"}
   {:label "Chatmodes"
    :iconPath (vscode/ThemeIcon. "color-mode")
    :description "Conversation behavior settings"
    :detail "Configure how Copilot Chat behaves for different activities"
    :category "chatmodes"}])

(def languages
  [{:label "TypeScript"
    :iconPath (vscode/ThemeIcon. "code")
    :description "TypeScript and React development"
    :detail "3 TypeScript/React instructions"
    :language "typescript"}
   {:label "C#"
    :iconPath (vscode/ThemeIcon. "code")
    :description ".NET and C# development"
    :detail "4 C#/.NET instructions"
    :language "csharp"}
   {:label "Python"
    :iconPath (vscode/ThemeIcon. "code")
    :description "Python development"
    :detail "1 Python instruction"
    :language "python"}
   {:label "Go"
    :iconPath (vscode/ThemeIcon. "code")
    :description "Go development"
    :detail "1 Go instruction"
    :language "go"}
   {:label "Angular"
    :iconPath (vscode/ThemeIcon. "code")
    :description "Angular development"
    :detail "1 Angular instruction"
    :language "angular"}
   {:label "Infrastructure"
    :iconPath (vscode/ThemeIcon. "code")
    :description "Infrastructure as Code"
    :detail "2 Infrastructure instructions (Bicep, Terraform)"
    :language "infrastructure"}
   {:label "C++"
    :iconPath (vscode/ThemeIcon. "code")
    :description "C++ development"
    :detail "1 C++ instruction"
    :language "cpp"}
   {:label "AI/GenAI"
    :iconPath (vscode/ThemeIcon. "code")
    :description "AI and GenAI development"
    :detail "1 AI instruction"
    :language "ai"}])

(def actions
  [{:label "View Content"
    :iconPath (vscode/ThemeIcon. "preview")
    :description "Open in untitled editor"
    :detail "Preview the markdown content in an editor"
    :action :view}
   {:label "Install Globally"
    :iconPath (vscode/ThemeIcon. "globe")
    :description "Save to user profile"
    :detail "Available across all your workspaces"
    :action :global}
   {:label "Install in Workspace"
    :iconPath (vscode/ThemeIcon. "github-project")
    :description "Save to this workspace only"
    :detail "Only available in this project"
    :action :workspace}])

(defn fetch-content+ [link]
  (let [content-url (str CONTENT-BASE-URL link)]
    (p/let [response (js/fetch content-url)
            text (.text response)]
      text)))

(defn show-category-picker+ []
  (show-picker-with-memory+
   categories
   {:title "GitHub Copilot Instructions Template"
    :placeholder "Select category"
    :preference-key :last-category
    :match-fn (fn [item last-choice] (= (.-category item) last-choice))
    :save-fn :category}))

(defn show-sub-category-picker+ []
  (show-picker-with-memory+
   sub-categories
   {:title "GitHub Copilot Instructions Template"
    :placeholder "Select type"
    :preference-key :last-sub-category
    :match-fn (fn [item last-choice] (= (.-category item) last-choice))
    :save-fn :category}))

(defn show-language-picker+ []
  (show-picker-with-memory+
   languages
   {:title "GitHub Copilot Instructions Template - Language Selection"
    :placeholder "Select programming language"
    :preference-key :last-language
    :match-fn (fn [item last-choice] (= (.-language item) last-choice))
    :save-fn :language}))

(defn get-core-instructions []
  (filter (fn [item]
            (let [link (:link item)]
              (not (re-find #"languages/" link))))
          (:instructions repository-index)))

(defn get-language-instructions [language]
  (filter (fn [item]
            (let [link (:link item)]
              (re-find (re-pattern (str "languages/" language "/")) link)))
          (:instructions repository-index)))

(defn install-bulk-items! [items category action-type]
  (p/let [results (js/Promise.all
                   (map (fn [item]
                          (p/let [content (fetch-content+ (:link item))]
                            (case (keyword action-type)
                              :global
                              (install-globally! content {:item item} category)
                              :workspace
                              (install-to-workspace! content {:item item} category))))
                        items))]
    (let [successes (filter :success results)
          failures (filter #(not (:success %)) results)]
      (if (seq failures)
        (vscode/window.showWarningMessage
         (str "Installed " (count successes) " items, " (count failures) " failed"))
        (vscode/window.showInformationMessage
         (str "Successfully installed " (count successes) " items")))
      {:success (empty? failures) :installed (count successes) :failed (count failures)})))

(defn show-install-action-picker+ [item-type]
  (show-picker-with-memory+
   [{:label "Install Globally"
     :iconPath (vscode/ThemeIcon. "globe")
     :description "Save to user profile"
     :detail "Available across all your workspaces"
     :action :global}
    {:label "Install in Workspace"
     :iconPath (vscode/ThemeIcon. "github-project")
     :description "Save to this workspace only"
     :detail "Only available in this project"
     :action :workspace}]
   {:title "GitHub Copilot Instructions Template"
    :placeholder (str "Install " item-type " where?")
    :preference-key :last-bulk-action
    :match-fn (fn [action-item last-choice] (= (name (.-action action-item)) (name last-choice)))
    :save-fn :action}))

(defn show-item-picker [items category-name]
  (let [items-with-metadata (map (fn [item]
                                   {:label (:title item)
                                    :iconPath (vscode/ThemeIcon. "copilot")
                                    :description (:filename item)
                                    :detail (:description item)
                                    :item item})
                                 items)
        preference-key (keyword (str "last-item-" category-name))]

    (show-picker-with-memory+
     items-with-metadata
     {:title "GitHub Copilot Instructions Template"
      :placeholder (str "Select a " category-name " item")
      :preference-key preference-key
      :match-fn (fn [item last-choice]
                  (= (-> item .-item .-filename) (:filename last-choice)))
      :save-fn (fn [selected-clj] (-> selected-clj :item))})))

(defn show-action-menu+ [item]
  (show-picker-with-memory+
   actions
   {:title "GitHub Copilot Instructions Template"
    :placeholder (str "Action for " (-> item :item :title))
    :preference-key :last-action
    :match-fn (fn [action-item last-choice] (= (name (.-action action-item)) (name last-choice)))
    :save-fn :action}))

(defn open-in-untitled-editor+ [content _]
  (p/let [doc (vscode/workspace.openTextDocument #js {:content content
                                                      :language "markdown"})
          _ (vscode/window.showTextDocument doc)]
    {:success true}))

(defn install-globally! [content item category]
  (p/let [vscode-user-dir (get-vscode-user-dir)
          dir-path (cond
                     ;; Instructions go in .vscode/instructions in user home
                     (= category "instructions")
                     (.join path (.. js/process -env -HOME) ".vscode" "instructions")

                     ;; Both prompts and chatmodes go in User/prompts folder
                     (or (= category "prompts") (= category "chatmodes"))
                     (.join path vscode-user-dir "prompts")

                     ;; Unknown category
                     :else nil)

          filename (-> item :item :filename)]

    (if dir-path
      (try
        (when-not (.existsSync fs dir-path)
          (.mkdirSync fs dir-path #js {:recursive true}))

        (let [file-path (.join path dir-path filename)]
          (.writeFileSync fs file-path content)
          (vscode/window.showInformationMessage
           (str "Installed " filename " globally"))

          {:success true :path file-path})
        (catch :default err
          (vscode/window.showErrorMessage
           (str "Failed to install " filename ": " (.-message err)))
          {:success false :error (.-message err)}))

      (do
        (vscode/window.showErrorMessage
         (str "Unknown category: " category))
        {:success false :error (str "Unknown category: " category)}))))

(defn install-to-workspace! [content item category]
  (if-let [workspace-folder (first vscode/workspace.workspaceFolders)]
    (let [filename (:filename (:item item))
          workspace-path (-> workspace-folder .-uri .-fsPath)
          dir-path (case category
                     "instructions" (.join path workspace-path ".github" "instructions")
                     "prompts" (.join path workspace-path ".github" "prompts")
                     "chatmodes" (.join path workspace-path ".github" "chatmodes")
                     nil)]

      (if dir-path
        (do
          (when-not (.existsSync fs dir-path)
            (.mkdirSync fs dir-path #js {:recursive true}))

          (let [file-path (.join path dir-path filename)]
            (.writeFileSync fs file-path content)
            (vscode/window.showInformationMessage
             (str "Installed " filename " to workspace"))

            {:success true :path file-path}))

        (do
          (vscode/window.showErrorMessage
           (str "Unknown category: " category))
          {:success false :error "Unknown category"})))

    (do
      (vscode/window.showErrorMessage "No workspace folder open")
      {:success false :error "No workspace folder"})))

(defn open-installed-file+ [file-path]
  (p/let [uri (vscode/Uri.file file-path)
          doc (vscode/workspace.openTextDocument uri)
          _ (vscode/window.showTextDocument doc)]
    {:success true}))

(defn execute-action! [item action-type category]
  (p/let [content (fetch-content+ (-> item :item :link))]
    (case (keyword action-type)
      :view
      (open-in-untitled-editor+ content (-> item :item :filename))

      :global
      (p/let [result (install-globally! content item category)]
        (when (:success result)
          (open-installed-file+ (:path result)))
        result)

      :workspace
      (p/let [result (install-to-workspace! content item category)]
        (when (:success result)
          (open-installed-file+ (:path result)))
        result)

      ;; Unknown action
      (do
        (vscode/window.showErrorMessage (str "Unknown action: " action-type))
        {:success false :error "Unknown action"}))))

(defn main []
  (p/catch
   (p/let [category (show-category-picker+)]
     (when category
       (let [category-name (:category category)]
         (cond
           ;; Browse individual items
           (= category-name "browse")
           (p/let [sub-category (show-sub-category-picker+)]
             (when sub-category
               (p/let [sub-category-name (:category sub-category)
                       category-items (get repository-index (keyword sub-category-name))
                       item (show-item-picker category-items (subs sub-category-name 0 (dec (count sub-category-name))))]
                 (when item
                   (p/let [action (show-action-menu+ item)]
                     (when action
                       (execute-action! item (:action action) sub-category-name)))))))

           ;; Bulk install chatmodes
           (= category-name "chatmodes-bulk")
           (p/let [action (show-install-action-picker+ "chatmodes")]
             (when action
               (install-bulk-items! (:chatmodes repository-index) "chatmodes" (:action action))))

           ;; Bulk install core instructions
           (= category-name "instructions-core-bulk")
           (p/let [action (show-install-action-picker+ "core instructions")]
             (when action
               (install-bulk-items! (get-core-instructions) "instructions" (:action action))))

           ;; Bulk install language instructions
           (= category-name "instructions-language-bulk")
           (p/let [language (show-language-picker+)]
             (when language
               (p/let [action (show-install-action-picker+ (str (:language language) " instructions"))]
                 (when action
                   (install-bulk-items! (get-language-instructions (:language language)) "instructions" (:action action))))))

           ;; Bulk install prompts
           (= category-name "prompts-bulk")
           (p/let [action (show-install-action-picker+ "prompts")]
             (when action
               (install-bulk-items! (:prompts repository-index) "prompts" (:action action))))

           ;; Unknown category
           :else
           (vscode/window.showErrorMessage (str "Unknown category: " category-name))))))

   (fn [error]
     (vscode/window.showErrorMessage (str "Error: " (.-message error)))
     (js/console.error "Error in copilot-template:" error))))

;; Run the script directly when loaded, unless loaded in the REPL
(when (= (joyride/invoked-script) joyride/*file*)
  (main))

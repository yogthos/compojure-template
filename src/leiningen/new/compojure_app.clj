(ns leiningen.new.compojure-app
  (:use [leiningen.new.templates :only [renderer sanitize year ->files]]
        [leinjacker.utils :only [lein-generation]]))

(defn check-lein-version []
  (if (< (lein-generation) 2)
    (throw (new Exception "Leiningen v2 is required..."))))

(defn compojure-app
  "Create a new Compojure project"
  [name]
  (check-lein-version)
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)}
        render #((renderer "compojure_app") % data)]
    (println "Generating a lovely new Compojure project named" (str name "..."))
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["README.md"   (render "README.md")]
             ["src/{{sanitized}}/repl.clj"         (render "repl.clj")]
             ["src/{{sanitized}}/handler.clj"      (render "handler.clj")]
             ["src/{{sanitized}}/routes/home.clj"  (render "home.clj")]
             ["src/{{sanitized}}/views/layout.clj" (render "layout.clj")]
             ["resources/public/css/screen.css"    (render "screen.css")]
             "resources/public/js"
             "resources/public/img"
             "src/{{sanitized}}/models"
             ["test/{{sanitized}}/test/handler.clj" (render "handler_test.clj")])))

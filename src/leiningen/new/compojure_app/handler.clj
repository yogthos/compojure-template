(ns {{name}}.handler
  (:require [compojure.core :refer [GET defroutes routes]]
            [hiccup.middleware :refer [wrap-base-url]]
            [hiccup.page :refer [html5 include-css]]
            [ring.middleware.defaults
             :refer [wrap-defaults site-defaults]]
            [compojure.route :as route]))

(defn init []
  (println "{{name}} is starting"))

(defn destroy []
  (println "{{name}} is shutting down"))

(defn home []
  (html5
    [:head
     [:title "Welcome to {{name}}"]
     (include-css "/css/screen.css")]
    [:body [:h1 "Hello World!"]]))


(defroutes app-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (wrap-base-url)))



(ns {{name}}.handler
  (:use compojure.core                
        ring.middleware.resource
        ring.middleware.file-info
        hiccup.middleware
        {{name}}.routes.home)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn init []
  (println "{{name}} is starting"))

(defn destroy []
  (println "{{name}} is shutting down"))
  
(defroutes app-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site (routes home-routes app-routes)))

(def war-handler 
  (-> app    
    (wrap-resource "public") 
    (wrap-base-url)
    (wrap-file-info)))
  


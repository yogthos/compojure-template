(ns {{name}}.handler
  (:use compojure.core                
        ring.middleware.resource
        ring.middleware.file-info
        hiccup.middleware)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [{{name}}.common :as common]))

(defn home [] 
  (common/layout [:h1 "Hello World!"]))

(defroutes app-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site app-routes))

(def war-handler 
  (-> app    
    (wrap-resource "public") 
    (wrap-base-url)
    (wrap-file-info)))
  


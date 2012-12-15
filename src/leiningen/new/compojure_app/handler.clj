(ns {{name}}.handler
  (:use compojure.core                
        ring.middleware.resource
        ring.middleware.file-info)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [{{name}}.common :as common]))

(defroutes app-routes
  (GET "/" [] (common/layout [:h1 "Hello World!"]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site app-routes))

(def war-handler 
  (-> app    
    (wrap-resource "public") 
    (wrap-file-info)))
  


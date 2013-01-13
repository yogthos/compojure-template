(ns {{name}}.routes.home
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [{{name}}.views.layout :as layout]))

(defn home [] 
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))
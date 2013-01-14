(ns {{name}}.routes.home
  (:use compojure.core)
  (:require [{{name}}.views.layout :as layout]))

(defn home [] 
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))

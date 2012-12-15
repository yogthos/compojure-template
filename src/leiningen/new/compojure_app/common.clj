(ns {{name}}.common
  (:use [hiccup.page :only [html5 include-css]]))

(defmacro page [f form-params & body]
  `(defn ~f [~'request]
     (let [~form-params 
           (into {} (for [[k# v#] (:form-params ~'request)] 
                      [(keyword k#) v#]))]
       ~@body)))
       
(defn layout [& body]
  (html5 
    [:head
     [:title "Welcome to {{name}}"]
     (include-css "/css/screen.css")]
    (into [:body] body)))
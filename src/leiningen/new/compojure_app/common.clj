(ns {{name}}.common
  (:use [hiccup.def :only [defhtml]] 
        [hiccup.page :only [include-css]]))
       
(defhtml layout [& body]  
  [:head
   [:title "Welcome to {{name}}"]
   (include-css "/css/screen.css")]
  [:body body])

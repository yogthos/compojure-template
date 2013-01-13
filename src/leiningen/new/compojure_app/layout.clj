(ns {{name}}.views.layout
  (:use [hiccup.def :only [defhtml]] 
        [hiccup.page :only [include-css]]))
       
(defhtml common [& body]  
  [:head
   [:title "Welcome to {{name}}"]
   (include-css "/css/screen.css")]
  [:body body])

(ns ^:figwheel-always domina-demo.core
    (:require-macros [hiccups.core :as hiccups])
    (:require
     [domina :as dom]
     [domina.css :as $] ;;https://github.com/levand/domina
     [garden.core :refer [css]] ;;https://github.com/noprompt/garden
     [hiccups.runtime :as hiccupsrt] ;;https://github.com/teropa/hiccups
     ))

(enable-console-print!)

(hiccups/defhtml my-template []
  [:div
    [:a {:href "https://github.com/teropa/hiccups"} "hiccup"]])

(hiccups/defhtml my-template-2 []
  [:ul (for [x (range 1 4)] [:li x])])

(hiccups/defhtml my-template-3 []
  [:div [:div#content.pretty "hello world"] (my-template-2)])

(hiccups/defhtml styles []
  [:style (css [:body {:font-family "Verdana"
                       :font-size "20px"}])])

(dom/append! ($/sel "#app") (styles))
(dom/append! ($/sel "#app") (my-template-3))

(ns hello-world.core
  (:require
   [goog.string.format]
   [clojure.browser.repl :as repl]))

(defonce conn
  (repl/connect "http://localhost:9000/repl"))

(def format goog.string.format)

(defn say-hello-fn [sayer]
  (println (format "Hello from %s" (:f-name sayer))))

(defn say-stuff-fn [sayer stuff]
  (println (format "%s says %s" (:f-name sayer) stuff)))

(defprotocol ISayStuff
  (say-hello [sayer])
  (say-stuff [sayer stuff]))

(defn reify-sayer [f-name stuff]
  (reify
    ISayStuff
    (say-hello [_] (.alert js/window f-name))
    (say-stuff [_ _] (.alert js/window (format "%s says %s" f-name stuff)))))

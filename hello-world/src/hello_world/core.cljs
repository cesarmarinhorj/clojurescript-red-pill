(ns hello-world.core
  (:require
   [goog.string.format]
   [clojure.browser.repl :as repl]))

(defonce conn
  (repl/connect "http://localhost:9000/repl"))

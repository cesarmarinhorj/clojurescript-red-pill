(ns hello-world.core
  (:require [clojure.browser.repl :as repl]))

(defonce conn
  (repl/connect "http://localhost:9000/repl"))

(defn say-hello []
  (println "hello world"))

(def my-name "Amir Rajan")

(def my-dictionary {:name "Amir"})

(def jane-doe
  { :name {:f-name "Jane"
           :l-name "Doe" }})

(def john-doe
  { :name {:f-name "John"
           :l-name "Doe" }})

(def jane-doe-twin
  { :name {:f-name "Jane"
           :l-name "Doe" }})

(def all-people
  [jane-doe john-doe jane-doe-twin])

(defn say-hello [person]
  (println
   (str
    (:f-name (:name person))
    " says hello")))

(defn say-hello-pretty [person]
  (->> person
       :name
       :f-name (str " says hello")
       println))

(defn say-hello-fixed [person]
  (->> person
       :name
       :f-name
       ((fn [p] (str p " says hello")))
       println))

(defn say-hello-anon [person]
  (->> person
       :name
       :f-name
       (#(str % " says hello"))
       println))

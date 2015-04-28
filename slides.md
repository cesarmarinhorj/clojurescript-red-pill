~
#Taking the Red Pill with ClojureScript

Amir Rajan
t:   @amirrajan
w:   amirrajan.net
src: github.com/amirrajan/clojurescript-quick-start



























































~
#Terms

##Object Oriented Language

Having a class keyword doesn't make a
language object oriented, it makes it class oriented.

A class a factory method for generating objects.

##Simple vs Easy

Easy is a synonym for familiar, "within reach". Simple is measurable.

- Does it have dependencies?
- Does it have long running state?
- Does it cause side effects (implicit or explicit)?
- Is there Cognitive Friction?

##Hard vs Complex

Hard is a synonym for unfamiliar, "distant".

- Things that are Hard can (eventually) become Easy.
- Things that are Complex can't become Simple.
- To make something Complex as a verb: Complect.














































~
#ClojureScript

##It's Hard

- Syntax is hard.
- Immutability is hard.
- It goes against the inertia of mind
  - Classes and mutability are easy

##It's Simple

- Syntax is simple.
- Immutability is simple.
- Functions are simple.

##It's Serious

- Has Support Licensing
- Started in June of 2011 (wasn't built a week ago)
- 4,300 GitHub Stars
- Open Source (Apache 2.0)
- 106 Contributors
- Notable Companies:
    - eBay
    - Yahoo
    - CircleCI
    - Living Social
    - Staples
    - WalMart
    - Cisco
    - Prismatic
    - Full list on ClojureScript wiki
- Built on Google Closure
  - Open Source (Apache 2.0)
  - Used on Gmail and Google Docs

##JavaScriptified™

[Google Closure](https://closure-compiler.appspot.com/home)









































~
#Figwheel

Demo of [Figwheel](https://github.com/bhauman/lein-figwheel)
















































~
#REPL

    (enable-console-print!)

    (println "hello")

    (+ 1 2)

    (map println [1 2 3])




































~
#def

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

    (def all-people [jane-doe john-doe jane-doe-twin])

    ;;more at: https://himera.herokuapp.com/synonym.html
























































~
#def can be used for functions

    (def hello-world
        (fn [] (println "hello world")))

















































~
#defn

    (defn say-hello []
      (println "hello world"))

    ;;the parenthesis it burns!
    (defn say-hello [person]
      (println
        (str
          (:f-name (:name person))
          " says hello")))



































~
#thread last `->>`

    (defn say-hello-pretty [person]
      (->> person
           :name
           :f-name
           (str " says hello")
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

    (defn say-hello-goog [person]
      (->> person :name :f-name
           (goog.string.format "%s says hello")
           println))
































~
#JavaScript Interop

    <script>
        window.asPre = function(obj) {
            document.getElementById("app").innerHTML = "<pre>" + JSON.stringify(obj, null, 2) + "</pre>";
        }
    </script>

    (.log js/console "hello")

    (.alert js/window "hello")

    (.getElementById js/document "app")

    (.-innerHTML (.getElementById js/document "app"))

    (set! (.-innerHTML (.getElementById js/document "app")) "Sweet")

    (.asPre js/window h/jane-doe)

    (.asPre js/window (clj->js h/jane-doe))








































~
#ClojureScript Libraries

- Domina
- Hiccups
- Garden
- More at: https://github.com/clojure/clojurescript/wiki#libraries








































~
#A Quote

>Spoon Boy: Do not try to bend the spoon. Instead...
>           only try to realize the truth.

>Neo: What truth?

>Spoon Boy: There is no spoon.

>Neo: There is no spoon?


































~
#A Quote

>Spoon Boy: Then you'll see, that it is not the spoon
>           that bends, it is only yourself.

















































~
#Records

    (defrecord Person [:f-name :l-name])

    (Person. "Amir" "Rajan")

    (defn create-person [{:keys [f-name l-name]}]
      (Person. f-name l-name))

    (create-person {:f-name "Amir" :l-name "Rajan"})



































~
#Protocols

    (defprotocol ISayStuff
      (say-hello [sayer])
      (say-stuff [sayer stuff]))

    (defrecord Person [f-name l-name]
      ISayStuff
      (say-hello [sayer]
        (println (goog.string.format "Hello from %s" (:f-name sayer))))
      (say-stuff [sayer stuff]
        (println (goog.string.format "%s says %s" (:f-name sayer) stuff))))

    (defn create-person [{:keys [f-name l-name]}]
      (Person. f-name l-name))

    (def jane-doe-map
      {:f-name "Jane" :l-name "Doe"})

    (def jane-doe-person
      (create-person jane-doe-map))










































~
#Extending Protocols

    (defprotocol ISayStuff
      (say-hello [sayer])
      (say-stuff [sayer stuff]))

    (defrecord Person [f-name l-name]
      ISayStuff
      (say-hello [sayer]
        (println (goog.string.format "Hello from %s" (:f-name sayer))))
      (say-stuff [sayer stuff]
        (println (goog.string.format "%s says %s" (:f-name sayer) stuff))))

    (extend-type cljs.core/PersistentArrayMap
      ISayStuff
      (say-hello [sayer]
        (println (goog.string.format "Hello from %s" (:f-name sayer))))
      (say-stuff [sayer stuff]
        (println (goog.string.format "%s says %s" (:f-name sayer) stuff))))

    (defn create-person [{:keys [f-name l-name]}]
      (Person. f-name l-name))

    (def jane-doe-map
      {:f-name "Jane" :l-name "Doe"})

    (def jane-doe-person
      (create-person jane-doe-map))

























































~
#Cleanup

    (def format goog.string.format)

    (defn say-hello-fn [sayer]
      (println (format "Hello from %s" (:f-name sayer))))

    (defn say-stuff-fn [sayer stuff]
      (println (format "%s says %s" (:f-name sayer) stuff)))

    (defprotocol ISayStuff
      (say-hello [sayer])
      (say-stuff [sayer stuff]))

    (defrecord Person [f-name l-name]
      ISayStuff
      (say-hello [sayer] (say-hello-fn sayer))
      (say-stuff [sayer stuff] (say-stuff-fn sayer stuff)))

    (defn create-person [{:keys [f-name l-name]}]
      (Person. f-name l-name))

    (def jane-doe-map
      {:f-name "Jane" :l-name "Doe"})

    (def jane-doe-person
      (create-person jane-doe-map))

    (extend-type cljs.core/PersistentArrayMap
      ISayStuff
      (say-hello [sayer] (say-hello-fn sayer))
      (say-stuff [sayer stuff] (say-stuff-fn sayer stuff)))





























~
#Reify

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






























~
#Links

[InfoQ Simple Made Easy](http://www.infoq.com/presentations/Simple-Made-Easy)
[InfoQ Value of Values](http://www.infoq.com/presentations/Value-Values)
[InfoQ Design Composition Performance](http://www.infoq.com/presentations/Design-Composition-Performance)
[InfoQ Core.Async](http://www.infoq.com/presentations/clojure-core-async)

[Quantum Tic Tac Toe](https://github.com/levand/qttt)

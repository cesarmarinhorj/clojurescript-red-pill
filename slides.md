~
#Taking the Red Pill with ClojureScript

Amir Rajan
t:   @amirrajan
w:   amirrajan.net
src: github.com/amirrajan/clojurescript-quick-start



























































~
#Terms

##Object Oriented Language

Having a class keyword doesn't make a language object oriented, it makes it class oriented.

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
  - Classes and immutability are easy

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
        (fn [] println "hello world"))

    (def hello-world-anon
        #(println "hello world"))

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

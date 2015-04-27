(ns ^:figwheel-always om-demo.core
    (:require-macros [cljs.core.async.macros :refer [go]])
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]
              [clojure.browser.repl :as repl]
              [clojure.set :as set]
              [cljs.core.async :refer [put! chan <!]]))

(enable-console-print!)

(def questions
  [#{"gentle" "persuasive" "humble" "original"}
   #{"attractive" "god fearing" "stubborn" "sweet"}
   #{"easily led" "bold" "loyal" "charming"}
   #{"open minded" "obliging" "will power" "cheerful"}
   #{"jovial" "precise" "nervy" "even tempered"}
   #{"competitive" "considerate" "joyful" "harmonious"}
   #{"fussy" "obedient" "unconquerable" "playful"}
   #{"brave" "inspiring" "submissive" "timid"}
   #{"sociable" "patient" "self reliant" "soft spoken"}
   #{"adventurous" "receptive" "cordial" "moderate"}
   #{"talkative" "controlled" "conventional" "decisive"}
   #{"polished" "daring" "diplomatic" "satisfied"}
   #{"aggressive" "life of the party" "easy mark" "fearful"}
   #{"cautious" "determined" "convincing" "good natured"}
   #{"willing" "eager" "agreeable" "high spirited"}
   #{"confident" "sympathetic" "tolerant" "assertive"}
   #{"well disciplined" "generous" "animated" "persistent"}
   #{"admirable" "kind" "resigned" "force of character"}
   #{"respectful" "pioneering" "optimistic" "accommodating"}
   #{"argumentative" "adaptable" "nonchalant" "light hearted"}
   #{"trusting" "contented" "positive" "peaceful"}
   #{"good mixer" "cultured" "vigorous" "lenient"}
   #{"companionable" "accurate" "outspoken" "restrained"}
   #{"restless" "neighborly" "popular" "devout"}])

(def at-home-percentile
  {:d {0  94, 1  86, 2  76,
       3  62, 4  54, 5  52,
       6  48, 7  44, 8  40,
       9  36, 10 34, 11 30,
       12 26, 13 22, 14 20,
       15 16, 16 12, 17 11,
       18 10, 19  9, 20  8,
       21  6}
   :i {0  94, 1  86, 2  74,
       3  60, 4  52, 5  46,
       6  36, 7  30, 8  24,
       9  20, 10 18, 11 14,
       12 13, 13 12, 14 11,
       15 10, 16  9, 17  8,
       18  7, 19  6}
   :s {0  94, 1  90, 2  86,
       3  78, 4  64, 5  58,
       6  52, 7  46, 8  38,
       9  30, 10 28, 11 20,
       12 14, 13 10, 14  9,
       15  9, 16  8, 17  7,
       18  7, 19  6}
   :c {0  94, 1  90, 2  86,
       3  78, 4  70, 5  60,
       6  52, 7  48, 8  42,
       9  34, 10 28, 11 20,
       12 14, 13 10, 14  8,
       15  7, 16  6}})


(def at-work-percentile
  {:d {0  10, 1  14, 2  26,
       3  35, 4  37, 5  41,
       6  48, 7  51, 8  61,
       9  69, 10 76, 11 77,
       12 79, 13 81, 14 82,
       15 86, 16 90, 17 91,
       18 92, 19 93, 20 94,
       21 94, 22 96, 23 98}
   :i {0  12, 1  20, 2  27,
       3  37, 4  48, 5  58,
       6  66, 7  75, 8  81,
       9  85, 10 88, 11 89,
       12 90, 13 91, 14 92,
       15 93, 16 94, 17 94,
       18 95, 19 96, 20 96,
       21 97, 22 97, 23 98}
   :s {0  20, 1  25, 2  30,
       3  41, 4  45, 5  51,
       6  58, 7  64, 8  70,
       9  75, 10 80, 11 85,
       12 90, 13 90, 14 91,
       15 91, 16 92, 17 92,
       18 93, 19 94, 20 95,
       21 96, 22 97, 23 98}
   :c {0   7, 1  23, 2  28,
       3  42, 4  51, 5  63,
       6  73, 7  79, 8  87,
       9  89, 10 90, 11 91,
       12 92, 13 92, 14 93,
       15 94, 16 95, 17 96,
       18 96, 19 97, 20 97,
       21 97, 22 98, 23 98}})

(def at-work
  {:d #{"stubborn" "bold" "competitive" "unconquerable"
        "brave" "self reliant" "adventurous" "conventional"
        "daring" "aggressive" "determined" "assertive"
        "persistent" "force of character" "pioneering" "argumentative"
        "positive" "vigorous" "outspoken" "restless"}
   :i #{"persuasive" "attractive" "charming" "cheerful"
        "playful" "inspiring" "sociable" "talkative"
        "life of the party" "convincing" "confident" "admirable"
        "optimistic" "light hearted" "good mixer" "companionable"
        "popular"}
   :s #{"gentle" "loyal" "obliging" "even tempered"
        "considerate" "obidient" "patient" "moderate"
        "controlled" "satisfied" "easy mark" "good natured"
        "willing" "generous" "kind" "accommodating"
        "trusting" "lenient" "neighborly"}
   :c #{"humble" "god fearing" "open minded" "precise"
        "soft spoken" "receptive" "diplomatic" "cautious"
        "agreeable" "well disciplined" "respectful" "adaptable"
        "peaceful" "accurate" "devout"}})

(def at-home
  {:d #{"original" "stubborn" "bold" "will power"
        "nervy" "competitive" "unconquerable" "self reliant"
        "adventurous" "decisive" "daring" "high spirited"
        "assertive" "persistent" "force of character" "pioneering"
        "argumentative" "positive" "vigorous" "outspoken"
        "restless"}
   :i #{"attractive" "charming" "cheerful" "jovial"
        "joyful" "playful" "sociable" "cordial"
        "talkative" "polished" "life of the party" "convincing"
        "animated" "admirable" "optimistic" "light hearted"
        "trusting" "good mixer" "companionable" "popular"}
   :s #{"gentle" "sweet" "obliging" "even tempered"
        "considerate" "submissive" "patient" "moderate"
        "controlled" "satisfied" "easy mark" "sympathetic"
        "generous" "accommodating" "nonchalant" "contented"
        "lenient" "restrained" "neighborly"}
   :c #{"humble" "god fearing" "easily led" "precise"
        "harmonious" "fussy" "timid" "conventional"
        "fearful" "cautious" "agreeable" "tolerant"
        "well disciplined" "resigned" "peaceful" "cultured"
        "devout"}})

(def app-state
  (atom {:answers-most #{}
         :answers-least #{}}))

(defn generate-graph [columns]
  (.generateGraph js/window (clj->js {:columns [["mid" 50 50 50 50]
                                                (into ["at work"] (:at-work columns))
                                                (into ["at home"] (:at-home columns))]})))

(defn score [score-set answer-set] (count (set/intersection score-set answer-set)))

(defn graph-data [app owner]
  (let [d-work (score (:d at-work) (:answers-most app))
        i-work (score (:i at-work) (:answers-most app))
        s-work (score (:s at-work) (:answers-most app))
        c-work (score (:c at-work) (:answers-most app))

        d-home (score (:d at-home) (:answers-least app))
        i-home (score (:i at-home) (:answers-least app))
        s-home (score (:s at-home) (:answers-least app))
        c-home (score (:c at-home) (:answers-least app))]
    {:at-work {:d (get (:d at-work-percentile) d-work)
               :i (get (:i at-work-percentile) i-work)
               :s (get (:s at-work-percentile) s-work)
               :c (get (:c at-work-percentile) c-work)}
     :at-home {:d (get (:d at-home-percentile) d-home)
               :i (get (:i at-home-percentile) i-home)
               :s (get (:s at-home-percentile) s-home)
               :c (get (:c at-home-percentile) c-home)}}))

(defn graph-data-flat [app owner]
  (let [d-work (score (:d at-work) (:answers-most app))
        i-work (score (:i at-work) (:answers-most app))
        s-work (score (:s at-work) (:answers-most app))
        c-work (score (:c at-work) (:answers-most app))

        d-home (score (:d at-home) (:answers-least app))
        i-home (score (:i at-home) (:answers-least app))
        s-home (score (:s at-home) (:answers-least app))
        c-home (score (:c at-home) (:answers-least app))]
    {:at-work [(get (:d at-work-percentile) d-work)
               (get (:i at-work-percentile) i-work)
               (get (:s at-work-percentile) s-work)
               (get (:c at-work-percentile) c-work)]
     :at-home [(get (:d at-home-percentile) d-home)
               (get (:i at-home-percentile) i-home)
               (get (:s at-home-percentile) s-home)
               (get (:c at-home-percentile) c-home)]}))

(defn apply-answer-to [app owner channel xs]
  (go (loop []
        (let [item (<! (om/get-state owner channel))]
          (om/transact! (app xs) #(into #{} (conj (remove (:answers item) %) (:selected item))))
          (recur)))))

(defn select [options on-change-channel]
  (apply dom/select #js
         {:onChange #(put! on-change-channel {:answers options :selected (.. % -target -value) })}
         (map #(dom/option nil %) (into ["select one"] options))))

(defn answers-view [answers]
  (apply dom/div nil (map #(dom/div nil %) answers)))

(defn question-view [questions]
  (reify
    om/IRenderState
    (render-state [this {:keys [most least]}]
      (dom/div nil
               (dom/div nil "least like")
               (select questions least)
               (dom/div nil "most like")
               (select questions most)
               (dom/hr nil)))))

(defn main-view [app owner]
  (reify
    om/IInitState
    (init-state [_] {:most (chan) :least (chan) })
    om/IWillMount
    (will-mount [_]
      (apply-answer-to app owner :least :answers-least)
      (apply-answer-to app owner :most  :answers-most))
    om/IDidMount
    (did-mount [_]
      (generate-graph (graph-data-flat app owner)))
    om/IRenderState
    (render-state [this {:keys [most least]}]
      (generate-graph (graph-data-flat app owner))
      (dom/div nil
               (apply dom/div nil
                      (om/build-all question-view
                                    questions
                                    {:init-state {:most most :least least}}))
               (dom/div nil
                        (dom/h2 nil "results")
                        (dom/hr nil))
               (dom/div #js {:id "chart" })
               (let [graph-values (graph-data app owner)]
                 (dom/div nil
                   (dom/h2 nil "at work")
                   (dom/hr nil)
                   (dom/div nil "d: " (:d (:at-work graph-values)))
                   (dom/div nil "i: " (:i (:at-work graph-values)))
                   (dom/div nil "s: " (:s (:at-work graph-values)))
                   (dom/div nil "c: " (:c (:at-work graph-values)))

                   (dom/h2 nil "at home")
                   (dom/hr nil)
                   (dom/div nil "d: " (:d (:at-home graph-values)))
                   (dom/div nil "i: " (:i (:at-home graph-values)))
                   (dom/div nil "s: " (:s (:at-home graph-values)))
                   (dom/div nil "c: " (:c (:at-home graph-values)))))
               (dom/hr nil)))))

(om/root
 main-view
 app-state
 {:target (. js/document (getElementById "app"))})

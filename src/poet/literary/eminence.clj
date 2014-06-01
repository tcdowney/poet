;; There is nothing to writing. All you do is sit down at a typewriter and bleed.
;;
;; - Ernest Hemingway

(ns poet.literary.eminence
  (:require [clojure.string]))

(defn
  the-metathesis
  "Swaps the 'h' and the 'e' in the word 'the'"
  [text]
    (clojure.string/replace text
                            #"\A[tT][hH][eE]\z"
                            #(str (first %1) (second (rest %1)) (second %1))))

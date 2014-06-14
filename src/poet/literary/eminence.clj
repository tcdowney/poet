;; There is nothing to writing. All you do is sit down at a typewriter and bleed.
;;
;; - Ernest Hemingway

(ns poet.literary.eminence
  (:require [clojure.string])
  (:require [poet.utilities :as utils]))

(defn
  the-metathesis
  "Swaps the 'h' and the 'e' in the word 'the'"
  [text]
    (clojure.string/replace text
                            #"(?i)\Athe\z"
                            #(str (first %1) (second (rest %1)) (second %1))))

(defn
  ike-metathesis-ie-variation
  "Swaps all occurrences of the letters 'ike' with 'iek'"
  [text]
    (clojure.string/replace text
                            #"(?i)\wike"
                            #(str (first %1 )
                                  (second %1)
                                  (second (rest (rest %1)))
                                  (second (rest %1)))))

(defn
  ike-metathesis-ei-variation
  "Swaps all occurrences of the letters 'ike' with 'eik'"
  [text]
    (clojure.string/replace text
                            #"(?i)\wike"
                            #(str (first %1 )
                                  (second (rest (rest %1)))
                                  (second %1)
                                  (second (rest %1)))))

;; Perfection is achieved, not when there is nothing more to add,
;; but when there is nothing left to take away.
;;
;; - Antoine de Saint-Exupery

(ns poet.literary.efficiency
  (:require [clojure.string])
  (:require [poet.utilities :as utils]))

(defn
  dalek
  "EXTERMINATE!  Exterminates the 'e' on all interior 'ex's"
  [text]
    (clojure.string/replace text #"\wex" #(str (first %1) "x")))

(defn
  wh-refiner
  "Removes suplerfluous h's -- sometimes."
  [text]
    (clojure.string/replace text #"[wW]h[^oy]" #(str (first %1) (second (rest %1)))))

(defn
  are-to-r
  "Replaces all 'are's with 'r's!"
  [text]
    (clojure.string/replace text
                            #"\A[aA][rR][eE]\z"
                            #(if (utils/capitalized? (first %1))
                              "R"
                              "r")))

(defn
  you-to-u
  "Replaces all 'you's with 'u's!"
  [text]
    (clojure.string/replace text
                            #"\A[yY][oO][uU]"
                            #(if (utils/capitalized? (first %1))
                              "U"
                              "u")))

(defn
  why-to-y
  "Replaces all 'why's with 'y's!"
  [text]
    (clojure.string/replace text
                            #"\A[wW][hH][yY]\z"
                            #(if (utils/capitalized? (first %1))
                              "Y"
                              "y")))

(def efficiency-functions (list poet.literary.efficiency/dalek
                                poet.literary.efficiency/wh-refiner
                                poet.literary.efficiency/why-to-y
                                poet.literary.efficiency/are-to-r
                                poet.literary.efficiency/you-to-u))

(defn optimize-efficiency [tokens functions]
  (cond
    (empty? functions) tokens
    :else (recur (map (first functions) tokens) (rest functions))))

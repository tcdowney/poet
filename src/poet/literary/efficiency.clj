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

(defn
  too-few-2s
  "Replaces instances of -too, -to, and -two with 2"
  [text]
    (clojure.string/replace text #"([tT][oO][oO]\z|[tT][oO]\z|[tT][wW][oO]\z)" "2"))

(defn
  need-more-4s
  "Replaces instances of four, fore, and for with 4"
  [text]
    (clojure.string/replace text #"([fF][oO][uU][rR]|[fF][oO][rR]([eE]|))" "4"))

(defn
  thats-gr8
  "Replaces instances of -ate with 8"
  [text]
    (clojure.string/replace text #"[aA][tT][eE]\z" "8"))

(defn
  first-consec-dup-chars
  "Given a string, it returns the first occurrence of consecutive duplicate characters."
  [chars]
    (cond
     (> 2 (count chars)) ()
     (= (first chars) (second chars))
       (apply str (cons (first chars) (cons (second chars) ())))
     :else (recur (rest chars))))

(defn
  flying-solo
  "Given a substring, replaces all instances of that substring in a string with its first character."
  [text substr]
    (if-not (empty? substr)
      (clojure.string/replace text (re-pattern substr) (str (first substr)))
      text))

(defn
  flying-doop
  "Calls flying-solo on a given string with the first occurrence of consecutive duplicate characters"
  [string]
    (flying-solo string (first-consec-dup-chars string)))

(def efficiency-functions (list poet.literary.efficiency/dalek
                                poet.literary.efficiency/wh-refiner
                                poet.literary.efficiency/too-few-2s
                                poet.literary.efficiency/thats-gr8
                                poet.literary.efficiency/why-to-y
                                poet.literary.efficiency/are-to-r
                                poet.literary.efficiency/you-to-u
                                poet.literary.efficiency/flying-doop))

(defn optimize-efficiency [tokens functions]
  (cond
    (empty? functions) tokens
    :else (recur (map (first functions) tokens) (rest functions))))

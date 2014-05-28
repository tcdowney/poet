(ns poet.literary.eminence
  (:require [clojure.string]))

(defn
  first-consec-dup-chars
  "Returns the first occurence of consecutive duplicate characters."
  [chars]
    (cond
     (or (empty? chars) (> 2 (count chars))) ()
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

(defn flying-doop [string]
  (flying-solo string (first-consec-dup-chars string)))

(defn
  solo-circumnavigation
  "Maps flying-doop over a list of strings."
  [strings]
    (map flying-doop strings))

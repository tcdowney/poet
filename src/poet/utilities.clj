(ns poet.utilities
  (:require [clojure.string]))

(defn capitalized? [s]
  (= (str s) (clojure.string/capitalize s)))

(defn upper-case? [s]
  (= (str s) (clojure.string/upper-case s)))

(defn vowel? [c]
  (or (= \a c)
      (= \A c)
      (= \e c)
      (= \E c)
      (= \i c)
      (= \I c)
      (= \o c)
      (= \O c)
      (= \u c)
      (= \U c)))

(defn 
  count-vowels
  "Counts the number of vowels that occur in a given string"
  [s]
    (count (filter vowel? (seq s))))

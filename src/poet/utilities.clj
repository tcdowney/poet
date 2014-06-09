(ns poet.utilities
  (:require [clojure.string]))

(defn capitalized? [s]
  (= (str s) (clojure.string/capitalize s)))

(defn upper-case? [s]
  (= (str s) (clojure.string/upper-case s)))

(defn
  vowel?
  "Takes a character or single character string and returns true if it is a vowel"
  [s]
    (let [c (first (clojure.string/lower-case s))]
      (and
        (or
          (char? s)
          (= 1 (count s)))
        (or
          (= \a c)
          (= \e c)
          (= \i c)
          (= \o c)
          (= \u c)))))

(defn
  count-vowels
  "Counts the number of vowels that occur in a given string"
  [s]
    (count (filter vowel? (seq s))))

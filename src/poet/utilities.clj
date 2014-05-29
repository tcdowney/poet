(ns poet.utilities
  (:require [clojure.string]))

(defn capitalized? [s]
  (= (str s) (clojure.string/capitalize s)))

(defn upper-case? [s]
  (= (str s) (clojure.string/upper-case s)))

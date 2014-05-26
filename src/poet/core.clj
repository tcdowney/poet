(ns poet.core
  (:require [poet.nlp :as nlp])
  (:require [clojure.string]))

(nlp/de-tokenize (nlp/tokenize (slurp "/home/tcdowney/Dev/spams/hey")))

(defn reversify [tokens]
  (map clojure.string/reverse tokens))

(defn poemify [path]
  (spit (str path "-poemified")
        (nlp/de-tokenize (reversify (nlp/tokenize (slurp path))))))

(defn -main [& args]
  (when-not (empty? args)
    (poemify (first args))
    (recur (rest args))))

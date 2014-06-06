(ns poet.core
  (:require [poet.nlp :as nlp])
  (:require [poet.literary.eminence :as eminence])
  (:require [poet.literary.efficiency :as efficiency])
  (:require [clojure.string]))

(defn poemify [path]
  (spit (str path "-poemified")
        (nlp/de-tokenize (efficiency/optimize-efficiency (nlp/tokenize (slurp path))
                                                         efficiency/efficiency-functions))))

(defn -main [& args]
  (when-not (empty? args)
    (poemify (first args))
    (recur (rest args))))

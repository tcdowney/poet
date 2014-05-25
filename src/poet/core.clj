(ns poet.core)

(defn poemify [path]
  (spit (str path "-poemified")
        (str (slurp path) "\nAdded another line of poem!")))

(defn -main [& args]
  (when-not (empty? args)
    (poemify (first args))
    (recur (rest args))))

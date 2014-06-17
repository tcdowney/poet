;; Random numbers should not be generated with a method chosen at random.
;;
;; - Donald Knuth
;;
;; These are, though. :)

(ns poet.literary.spontaneity)

(defn
  happenstance
  "Returns the given function if the result of (rand-int n) is 0, else returns the identity function"
  [func n]
    (if (= 0 (rand-int n))
      func
      identity))

(defn
  fifty-fifty
  "50% chance of returning the given function, %50 chance of returning the identity function"
  [func]
    (happenstance func 2))

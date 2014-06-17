;; Originality is nothing but judicious imitation.
;;
;; - Voltaire

(ns poet.literary.ingenuity
  (:require [poet.nlp :as nlp]))

(def sample-text
  "In great families, when an advantageous place cannot be obtained, either in possession, reversion, remainder, or expectancy, for the young man who is growing up, it is a very general custom to send him to sea. The board, in imitation of so wise and salutary an example, took counsel together on the expediency of shipping off Oliver Twist, in some small trading vessel bound to a good unhealthy port. This suggested itself as the very best thing that could possibly be done with him: the probability being, that the skipper would flog him to death, in a playful mood, some day after dinner, or would knock his brains out with an iron bar; both pastimes being, as is pretty generally known, very favourite and common recreations among gentleman of that class. The more the case presented itself to the board, in this point of view, the more manifold the advantages of the step appeared; so, they came to the conclusion that the only way of providing for Oliver effectually, was to send him to sea without delay.  Mr. Bumble had been despatched to make various preliminary inquiries, with the view of finding out some captain or other who wanted a cabin-boy without any friends; and was returning to the workhouse to communicate the result of his mission; when he encountered at the gate, no less a person than Mr. Sowerberry, the parochial undertaker.")

(identity sample-text)

(nlp/tokenize (first (nlp/get-sentences sample-text)))

(defn markov-chains [sentenceVector]
  (let
    [maps (for [sentence sentenceVector
                m (let [words (nlp/tokenize sentence)]
                    (for [p (partition 2 1 words)]
                         {(first p) [(second p)]}))]
                m)]
    (apply merge-with concat maps)))

(markov-chains (nlp/get-sentences sample-text))

(defn sentence [data]
  (loop [ws (data :start)
         acc []]
    (let [w (rand-nth ws)
          nws (data w)
          nacc (concat acc [w])]
      (if (= \. (last w))
        (clojure.string/join " " nacc)
        (recur nws nacc)))))

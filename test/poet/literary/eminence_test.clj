(ns poet.literary.eminence-test
  (:require [clojure.test :refer :all]
            [poet.literary.eminence :refer :all]))

(deftest the-metathesis-test
  (testing "that it converts 'the' to 'teh'"
    (is (= "teh" (the-metathesis "the")))
    (is (= "TEH" (the-metathesis "THE"))))
  (testing "that it does not convert all instances of -'the' or 'the'- to 'teh'"
    (is (= "theatre" (the-metathesis "theatre")))
    (is (= "apotheosis" (the-metathesis "apotheosis"))))
  (testing "that it handles mixed cases of 'the' and preserves the case of each letter"
    (is (= "teH" (the-metathesis "tHe")))
    (is (= "TEh" (the-metathesis "ThE")))))

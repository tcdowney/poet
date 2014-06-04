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

(deftest ike-metathesis-ie-variation-test
  (testing "that it converts -ike and -ike- to iek"
    (is (= "Did you liek your experience at IKEA?"
           (ike-metathesis-ie-variation "Did you like your experience at IKEA?")))
    (is (= "Siekston, Missouri" (ike-metathesis-ie-variation "Sikeston, Missouri"))))
  (testing "that it does not convert ike- to iek"
    (is (= "IKEA?" (ike-metathesis-ie-variation "IKEA?")))
    (is (= "Ike" (ike-metathesis-ie-variation "Ike"))))
  (testing "that it handles mixed cases of -'ike' and preserves the case of each letter"
    (is (= "lieK" (ike-metathesis-ie-variation "liKe")))
    (is (= "lIEk" (ike-metathesis-ie-variation "lIkE")))))

(deftest ike-metathesis-ei-variation-test
  (testing "that it converts -ike and -ike- to eik"
    (is (= "Did you leik your experience at IKEA?"
           (ike-metathesis-ei-variation "Did you like your experience at IKEA?")))
    (is (= "Seikston, Missouri" (ike-metathesis-ei-variation "Sikeston, Missouri"))))
  (testing "that it does not convert ike- to eik"
    (is (= "IKEA?" (ike-metathesis-ei-variation "IKEA?")))
    (is (= "Ike" (ike-metathesis-ei-variation "Ike"))))
  (testing "that it handles mixed cases of -'ike' and preserves the case of each letter"
    (is (= "leiK" (ike-metathesis-ei-variation "liKe")))
    (is (= "lEIk" (ike-metathesis-ei-variation "lIkE")))))

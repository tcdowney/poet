(ns poet.literary.efficiency-test
  (:require [clojure.test :refer :all]
            [poet.literary.efficiency :refer :all]))

(deftest dalek-test
  (testing "that it removes the e from all interior occurences of ex"
    (is (= "Exterminate the exile and the nxt fellow."
           (dalek "Exterminate the exile and the next fellow."))))
  (testing "that it leaves string that do not contain ex alone"
    (is (= "I remain unchanged."
           (dalek "I remain unchanged."))))
  (testing "that it can handle the empty string"
    (is (= "" (dalek "")))))

(deftest wh-refiner-test
  (testing "that it removes the h from a the word 'What'"
    (is (= "Wat" (wh-refiner "What"))))
  (testing "that it removes the h from a the word 'whistle'"
    (is (= "wistle" (wh-refiner "whistle"))))
  (testing "that it leaves string that it leaves 'who' alone"
    (is (= "who" (wh-refiner "who"))))
  (testing "that it leaves string that it leaves 'why' alone"
    (is (= "why" (wh-refiner "why"))))
  (testing "that it can handle the empty string"
    (is (= "" (wh-refiner "")))))

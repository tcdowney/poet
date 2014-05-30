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

(deftest are-to-r-test
  (testing "that it turns capital ARE into R"
    (is (= "R" (are-to-r "ARE"))))
  (testing "that it can handle mixed cases"
    (is (= "r" (are-to-r "aRe")))
    (is (= "R" (are-to-r "ArE")))
    (is (= "r" (are-to-r "arE"))))
  (testing "that it turns lowercase are into r"
    (is (= "r" (are-to-r "are"))))
  (testing "that it ignores words that merely contain the word are"
    (is (= "area" (are-to-r "area")))
    (is (= "mare" (are-to-r "mare")))))

(deftest you-to-u-test
  (testing "that it turns capital YOU into U"
    (is (= "U" (you-to-u "YOU"))))
  (testing "that it can handle mixed cases"
    (is (= "u" (you-to-u "yOu")))
    (is (= "U" (you-to-u "YoU")))
    (is (= "u" (you-to-u "yoU"))))
  (testing "that it turns lowercase you into u"
    (is (= "u" (you-to-u "you"))))
  (testing "that it ignores words that merely contain the word you"
    (is (= "youse" (are-to-r "youse")))
    (is (= "heyou" (are-to-r "heyou")))))

(deftest why-to-y-test
  (testing "that it turns capital WHY into Y"
    (is (= "Y" (why-to-y "WHY"))))
  (testing "that it can handle mixed cases"
    (is (= "y" (why-to-y "wHy")))
    (is (= "Y" (why-to-y "WhY")))
    (is (= "y" (why-to-y "whY"))))
  (testing "that it turns lowercase why into y"
    (is (= "y" (why-to-y "why"))))
  (testing "that it ignores words that merely contain the word why"
    (is (= "whyte" (are-to-r "whyte")))
    (is (= "saywhy" (are-to-r "saywhy")))))




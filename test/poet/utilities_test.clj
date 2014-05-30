(ns poet.utilities-test
  (:require [clojure.test :refer :all]
            [poet.utilities :refer :all]))

(deftest capitalized?-test
  (testing "when a character is passed in"
    (is (= true (capitalized? \A)))
    (is (= false (capitalized? \a))))
  (testing "when a string is passed in"
    (is (= true (capitalized? "A capitalized string.")))
    (is (= false (capitalized? "a string that isn't capitalized")))))

(deftest upper-case?-test
  (testing "when a character is passed in"
    (is (= true (upper-case? \A)))
    (is (= false (upper-case? \a))))
  (testing "when a string is passed in"
    (is (= true (upper-case? "AN UPPER-CASE STRING")))
    (is (= false (upper-case? "a lower-case string")))))

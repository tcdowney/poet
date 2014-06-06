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

(deftest vowel?-test
  (testing "that is returns true when a vowel is passed in"
    (is (= true (vowel? \a)))
    (is (= true (vowel? \e)))
    (is (= true (vowel? \i)))
    (is (= true (vowel? \o)))
    (is (= true (vowel? \u))))
  (testing "that is returns false when a consonant is passed in"
    (is (= false (vowel? \b)))
    (is (= false (vowel? \d)))
    (is (= false (vowel? \n)))
    (is (= false (vowel? \p)))
    (is (= false (vowel? \z)))))

(deftest count-vowels-test
  (testing "that it counts the number of vowels in a string"
    (is (= 5 (count-vowels "Hello there pal!")))
    (is (= 1 (count-vowels "a")))
    (is (= 0 (count-vowels "ddd"))))
  (testing "that it handles the empty string"
    (is (= 0 (count-vowels "")))))
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
  (testing "that it returns true when a vowel character is passed in"
    (is (= true (vowel? \a)))
    (is (= true (vowel? \A)))
    (is (= true (vowel? \e)))
    (is (= true (vowel? \E)))
    (is (= true (vowel? \i)))
    (is (= true (vowel? \I)))
    (is (= true (vowel? \o)))
    (is (= true (vowel? \O)))
    (is (= true (vowel? \u)))
    (is (= true (vowel? \U))))
  (testing "that it returns false when a non-vowel character is passed in"
    (is (= false (vowel? \b)))
    (is (= false (vowel? "o242")))
    (is (= false (vowel? \$)))
    (is (= false (vowel? \1)))
    (is (= false (vowel? \Z)))))

(deftest count-vowels-test
  (testing "that it counts the number of vowels in a string"
    (is (= 5 (count-vowels "Hello there pal!")))
    (is (= 1 (count-vowels "A")))
    (is (= 0 (count-vowels "ddd"))))
  (testing "that it handles the empty string"
    (is (= 0 (count-vowels "")))))
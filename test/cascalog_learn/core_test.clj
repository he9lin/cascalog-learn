(ns cascalog-learn.core-test
  (:use [midje sweet cascalog])
  (:require [clojure.test :refer :all]
            [cascalog-learn.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(facts
  query => (produces [[3 10] [1 5] [5 11]]))

(facts
  query => (produces [[1 5] [3 10] [5 11]]))

(facts
  word-count => (produces []))

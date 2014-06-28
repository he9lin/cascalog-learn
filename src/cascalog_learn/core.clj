(ns cascalog-learn.basics)

(use 'cascalog.api)
(use 'cascalog.playground)

(def src
  [[1 2] [1 3]
   [3 4] [3 6]
   [5 2] [5 9]])

;; adds the values in each input tuple, sorts the output and returns
;; 2-tuples of the first number and the sum. [1 2] becomes [1 3], for
;; example.
(def query
  (<- [?x ?sum]
      (src ?x ?y)
      (:sort ?x)
      (c/sum ?y :> ?sum)))

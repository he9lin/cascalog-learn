(ns cascalog-learn.core)

;; Some clojure basics

(let [[x y :as coords] [1 2 3 4 5 6]]
  (str "x: " x ", y: " y ", total dimensions " (count coords)))

(import '(java.io InputStream File))
(.exists (File. "/tmpi"))

(defn shout
  ([s] (.toUpperCase s))
  {:tag String})
(shout "Hello")

(first {:fname "Aaron", :lname "Bedra"})
(first [:the :quick :brown :fox])


;; Cascalog

(use 'cascalog.api)
(use 'cascalog.playground)

(?- (stdout)
    sentence)

(?- (stdout)
    (<- [?line]
        (sentence :> ?line)))

(take 2 person)
(take 2 age)

(require '[cascalog.logic.def :as def])

(def/defmapcatfn tokenise  [line]
    "reads in a line of string and splits it by a regular expression"
    (clojure.string/split line #"[\[\]\\\(\),.)\s]+"))

(?- (stdout)
    (<- [?word]
        (sentence :> ?line)
        (tokenise :< ?line :> ?word)))

(require '[cascalog.logic.ops :as c])

(def word-count
    (<- [?word ?count]
        (sentence :> ?line)
        (tokenise :< ?line :> ?word)
        (c/count :> ?count)))

(?- (stdout) word-count)

(?<- (stdout)
     [?word ?count]
     (sentence ?line)
     (tokenise ?line :> ?word)
     (c/count ?count))


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

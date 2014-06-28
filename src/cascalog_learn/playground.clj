(ns cascalog-learn.playround)

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

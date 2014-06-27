(ns cascalog-learn.core)

(use 'cascalog.api)
(use 'cascalog.playground)

(?- (stdout)
    sentence)

; (?- (stdout)
;     (<- [?line]
;         (sentence :> ?line)))
;
; (take 2 person)
; (take 2 age)
;
; (require '[cascalog.logic.def :as def])
;
; (def/defmapcatfn tokenise  [line]
;     "reads in a line of string and splits it by a regular expression"
;     (clojure.string/split line #"[\[\]\\\(\),.)\s]+"))
;
; (?- (stdout)
;     (<- [?word]
;         (sentence :> ?line)
;         (tokenise :< ?line :> ?word)))
;
; (require '[cascalog.logic.ops :as c])
;
; (?- (stdout)
;     (<- [?word ?count]
;         (sentence :> ?line)
;         (tokenise :< ?line :> ?word)
;         (c/count :> ?count)))
;
; (?<- (stdout)
;      [?word ?count]
;      (sentence ?line)
;      (tokenise ?line :> ?word)
;      (c/count ?count))
;
; (let [[x y :as coords] [1 2 3 4 5 6]]
;   (str "x: " x ", y: " y ", total dimensions " (count coords)))
;
; (import '(java.io InputStream File))
; (.exists (File. "/tmpi"))
;
; (defn shout
;   ([s] (.toUpperCase s))
;   {:tag String})
; (shout "Hello")
;
; (first {:fname "Aaron", :lname "Bedra"})
; (first (:the :quick :brown :fox))

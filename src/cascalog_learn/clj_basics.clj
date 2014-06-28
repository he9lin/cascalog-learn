(ns cascalog-learn.clj-basics)

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

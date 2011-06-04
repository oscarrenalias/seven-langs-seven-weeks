(ns day1.code)

(defn big-string
	"Returns true if the given string is longer than the given number"
	[st n]
	(if (> (count st) n) true false))

(defn collection-type 
	"Returns a symbol with the type of the given collection"
	[col] 
	(if (= (type col) clojure.lang.PersistentVector) 
		:vector (if (= (type col) clojure.lang.PersistentArrayMap) 
			:map (if (= (type col) clojure.lang.PersistentList) :list :dontknow))))

(defn -main [& args]
	(do 
		(if (= (big-string "1234" 5) true) (println "String is longer!") (println "String is shorter"))
		(if (= (big-string "1234" 3) true) (println "String is longer!") (println "String is shorter"))
		(println (collection-type [ 1 2 3 4]))
		(println (collection-type (list 1 2 3 4)))))
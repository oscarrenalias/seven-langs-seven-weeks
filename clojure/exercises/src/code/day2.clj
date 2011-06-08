(ns code.day2)

(defprotocol Account
	(deposit [c amount])
	(withdraw [c amount]))
	
(defrecord SimpleAccount [initial-amount] Account           
	(deposit [_ amount] (println (str "Depositing: " amount)))  
	(withdraw [_ amount] (println (str "Withdrawing: " amount))) 
	Object
	(toString [this] (str "toString")))
	
(defmacro unless-else 
	"Unless macro with an else clause"
	[expr form else-form]
	(list 'if expr else-form form))
	
(defn day2
	[]
	; test the protocol implementation
	(do
		(def acc (SimpleAccount. 1000))
		(deposit acc 50)
		(withdraw acc 500)
		(unless-else true (println "This should not print") (println "This should print"))
		(unless-else false (println "This should print") (println "This should not print"))))

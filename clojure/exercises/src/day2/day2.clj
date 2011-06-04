(ns day2.day2)

(defprotocol Account
	(deposit [c amount])
	(withdraw [c amount]))
	
(defrecord SimpleAccount [initial-amount] Account           
	(deposit [_ amount] (println (str "Depositing: " amount)))  
	(withdraw [_ amount] (println (str "Withdrawing: " amount))) 
	Object
	(toString [this] (str "toString")))
	
(defn day2
	[]
	; test the protocol implementation
	(do
		(def acc (SimpleAccount. 1000))
		(deposit acc 50)
		(withdraw acc 500)))

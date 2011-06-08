(ns code.day3)

(defn init-account 
	"Initializes the list of operations for the account"
	[] 
	(ref []))
	
(defn deposit-account 
	"Depoosits money in the given account"
	[ac total] 
	(dosync (alter ac conj total)))	
	
(defn withdraw-account 
	"Withdraws money from the account"
	[ac total] 
	(deposit-account ac (- total)))	
	
(defn total-account
	"Calculates the current amount in the account based on the transactions so far"
	[ac]
	(reduce (fn [x y] (+ x y)) 0 @ac))
	
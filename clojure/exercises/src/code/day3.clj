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
	
; implementation of the barber shop
(defn msg [& m] (println (str m)))

; this defines the number of seats available at the barber's shop
(def seats 3)

(defn init-shop [] (ref []))

(defn receive-customer
	[q cid]
	(msg "Receiving customer: " cid)
	(dosync 
		(if (< (count @q) seats)
			(alter q conj cid)
			(msg "Sending customer away: " cid))))
			
(defn cut-hair
	[q]
	(dosync 
		(if (> (count @q) 0)
			(
				(msg "Cutting hair of customer: " )
				(Thread/sleep (rand-int 100))
				(alter q rest))
			(msg "No customers left!"))))
			
(defn run-shop 
	[q]
	(doseq [c (range 1 200)]
		(Thread/sleep (rand-int 100))
		(future (receive-customer q c))))
			
(defn day3 [] 
	(def shop (init-shop))
	(run-shop shop))
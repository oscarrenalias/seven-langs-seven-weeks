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
(def barber (agent 0))

; Adds a customer to the queue if there's an emtpy seat, or else send the customer away
(defn receive-customer
	[q cid]
	(msg "Receiving customer: " cid)
	(dosync 
		(if (< (count @q) seats)
			(do (alter q conj cid) (send-off barber cut-hair q))
			(msg "Sending customer away: " cid))))
	
; does a haircut		
(defn cut-hair
	[total q]
	(dosync 
		(if (> (count @q) 0)
			(do 
				(msg "Cutting hair of customer: " (first @q)) 
				(Thread/sleep (rand-int 100)) 
				(alter q next) (inc total))
			(msg "No customers left!"))))
			
; runs the shop for some time
(defn run-shop 
	[q]
	(doseq [c (range 1 200)]
		(Thread/sleep (rand-int 100))
		(future (receive-customer q c))))
			
; can be used to run the demo
(defn day3 [] 
	(let [shop (ref [])]
		(do (run-shop shop) (msg "Total number of haircuts today " (str @barber)))))
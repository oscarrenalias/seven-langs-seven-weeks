; some macros created while playing around with macros
(defmacro benchmark 
	"Defines a macro that reports how long the given function ran"
	[f]                                                                            
	`(let [start# (System/nanoTime) result# ~f] {:result result# :elapsed (- (System/nanoTime) start#)}))

(ns code.main
	(:use code.day1 code.day2 code.day3))

(defn -main [& args]
	((println "Day 1")
	 (day1)	 
	 (println "Day 2")
	 (day2)
	 (println "Day 3")
	 (day3)))
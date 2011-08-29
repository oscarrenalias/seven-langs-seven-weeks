module Main where
	double :: Integer -> Integer
	double x = x + x
	
	factorial :: Integer -> Integer
	factorial 0 = 1
	factorial x = x * factorial (x - 1)
	
	factorialPattern :: Integer -> Integer 
	factorialPattern x
	        | x > 1 = x * factorialPattern (x - 1)
	        | otherwise = 1
	
	listSize :: [a] -> Integer
	listSize [] = 0
	listSize (h:t) = 1 + listSize t
	
	listProduct :: [a] -> Integer
	listProduct [] = 1
	listProduct (h:t) = 1 * listProduct t
	
	-- This could be rewritten without pattern matching
	allEven :: [Integer] -> [Integer]
	allEven [] = []
	allEven (h:t)
		| (even h) = h:allEven t
		| otherwise = allEven t
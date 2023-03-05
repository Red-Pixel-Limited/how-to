concat1 :: [[a]] -> [a]
concat1 xss = [x | xs <- xss, x <- xs]

concat2 :: [[a]] -> [a]
concat2 = foldr (++) []


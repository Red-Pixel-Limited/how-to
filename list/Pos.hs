-- unsafe

third :: [a] -> a
third xs = xs !! 2

third1 :: [c] -> c
third1 = head . tail . tail

third2 :: [c] -> c
third2 = head . drop 2

-- splitAt' 3 [1, 2, 3, 4]
-- ([1,2,3],[4])
splitAt' :: Int -> [a] -> ([a], [a])
splitAt' i xs = (take i xs, drop i xs)

-- charAt 2 "abc"
-- 'c'
charAt :: Int -> [a] -> a
charAt index s = s !! index


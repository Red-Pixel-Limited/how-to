import Data.Maybe

-- head --

head' :: [a] -> Maybe a
head' [] = Nothing
head' (x : _) = Just x

-- tail --

tail' :: [a] -> Maybe [a]
tail' [] = Nothing 
tail' (_ : xs) = Just xs

safetail :: [a] -> [a]
safetail [] = []
safetail (_ : xs) = xs

-- last --

last' :: [a] -> a
last' xs = xs !! (length xs - 1)

-- last' :: [a] -> a
-- last' = head . reverse

maybeLast :: [a] -> Maybe a
maybeLast [] = Nothing
maybeLast xs = Just (last' xs)

-- pattern matching --

testCharWithLenConstraint :: [Char] -> Bool
testCharWithLenConstraint ['a', _, _] = True
testCharWithLenConstraint _ = False

testCharWithNoLenConstraint :: [Char] -> Bool
testCharWithNoLenConstraint ('a' : _) = True 
testCharWithNoLenConstraint _ = False

maybeThird :: [a] -> Maybe a
maybeThird (_ : _ : x : _) = Just x
maybeThird _ = Nothing

-- unsafe
third :: [a] -> a
third xs = xs !! 2
third' = head . tail . tail
third'' = head . drop 2

-- Order in high oder functions --

-- (1+) = \y = 1 + y
-- (*2) = \x -> x * 2

-- divideByOne [1..3]
-- [1.0,2.0,3.0]
divideByOne :: [Double] -> [Double]
divideByOne = map (/ 1)

-- oneDivideByN [1..3]
-- [1.0,0.5,0.3333333333333333]
oneDivideByN :: [Double] -> [Double]
oneDivideByN = map (1 /)

-- init --

-- collection without last item
init' :: [a] -> [a]
init' xs = take (length xs - 1) xs

-- concat --

concat' :: [[a]] -> [a]
concat' xss = [x | xs <- xss, x <- xs]

concat'' :: [[a]] -> [a]
concat'' = foldr (++) []

-- splitAt --

-- splitAt' 3 [1, 2, 3, 4]
-- ([1,2,3],[4])
splitAt' :: Int -> [a] -> ([a], [a])
splitAt' i xs = (take i xs, drop i xs)

-- chatAt --

-- charAt 2 "abc"
-- 'c'
charAt :: Int -> [a] -> a
charAt index s = s !! index

-- tuple

firsts :: [(a, b)] -> [a]
firsts xs = [x | (x, _) <- xs]

fsts :: [(a, b)] -> [a]
fsts = map fst

-- length

length' :: [a] -> Int
length' xs = sum [1 | _ <- xs]

-- length' :: [a] -> Int
-- length' = sum . map (const 1)

-- length' :: [a] -> Int
-- length' [] = 0
-- length' (_ : xs) = 1 + length' xs


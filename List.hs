import Data.Maybe
import Data.Char (isAsciiLower)

safetail :: [a] -> [a]
safetail [] = []
safetail (_ : xs) = xs

head' :: [a] -> Maybe a
head' [] = Nothing
head' (x : _) = Just x

tail' :: [a] -> Maybe [a]
tail' [] = Nothing 
tail' (_ : xs) = Just xs

maybeThird :: [a] -> Maybe a
maybeThird (_ : _ : x : _) = Just x
maybeThird _ = Nothing

-- unsafe
-- third xs = xs !! 2
-- third = head . tail . tail
-- third = head . drop 2

last' :: [a] -> a
last' xs = xs !! (length xs - 1)

last'' :: [a] -> a
last'' = head . reverse

maybeLast :: [a] -> Maybe a
maybeLast [] = Nothing
maybeLast xs = Just (last' xs)

-- collection without last item
init' :: [a] -> [a]
init' xs = take (length xs - 1) xs

-- >>> seqn [Just 1, Nothing, Just 2]
-- Nothing
-- >>> seqn [Just 1, Just 2]
-- Just [1,2]

seqn :: Monad m => [m a] -> m [a]
seqn [] = return []
seqn (act : acts) = do
  x <- act
  xs <- seqn acts
  return (x : xs)

-- Order in high oder functions
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

-- splitAt' 3 [1, 2, 3, 4]
-- ([1,2,3],[4])
splitAt' :: Int -> [a] -> ([a], [a])
splitAt' i xs = (take i xs, drop i xs)

concat' :: [[a]] -> [a]
concat' xss = [x | xs <- xss, x <- xs]

concat'' :: [[a]] -> [a]
concat'' = foldr (++) []

firsts :: [(a, b)] -> [a]
firsts xs = [x | (x, _) <- xs]

fsts :: [(a, b)] -> [a]
fsts = map fst

length' :: [a] -> Int
length' xs = sum [1 | _ <- xs]

length'' :: [a] -> Int
length'' = sum . map (const 1)

-- find 'b' [('a', 1), ('b', 2), ('c', 3), ('b', 4)]
-- [2,4]
find :: Eq a => a -> [(a, b)] -> [b]
find k t = [v | (k', v) <- t, k == k']

-- Gets character at position
-- charAt 2 "abc" 
-- 'c'
charAt :: Int -> [a] -> a
charAt index s = s !! index 

-- counts lower charcters 
-- lowers "aAb"
-- 2
lowers :: String -> Int
lowers s = length [c | c <- s, isAsciiLower c]

import Data.Maybe

last1 :: [a] -> a
last1 xs = xs !! (length xs - 1)

last2 :: [a] -> a
last2 = head . reverse

maybeLast :: [a] -> Maybe a
maybeLast [] = Nothing
maybeLast xs = Just (last2 xs)


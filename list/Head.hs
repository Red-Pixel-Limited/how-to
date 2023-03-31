import Data.Maybe

head' :: [a] -> Maybe a
head' [] = Nothing
head' (x : _) = Just x


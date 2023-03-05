import Data.Maybe

tail' :: [a] -> Maybe [a]
tail' [] = Nothing 
tail' (_ : xs) = Just xs

safetail :: [a] -> [a]
safetail [] = []
safetail (_ : xs) = xs


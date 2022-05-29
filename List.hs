import Data.Maybe

safetail :: [a] -> [a]
safetail [] = []
safetail (_ : xs) = xs

maybeThird :: [a] -> Maybe a
maybeThird (_ : _ : x : _) = Just x
maybeThird _ = Nothing

-- unsafe
-- third xs = xs !! 2
-- third = head . tail . tail
-- third = head . drop 2

last' :: [a] -> a
last' xs = xs !! (length xs - 1)

-- last' = head . reverse

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
    x  <- act
    xs <- seqn acts
    return (x : xs)

-- Order in high oder functions
-- (1+) = \y = 1 + y
-- (*2) = \x -> x * 2

-- divideByOne [1..3] 
-- [1.0,2.0,3.0]
divideByOne :: [Double] -> [Double]
divideByOne =  map (/1)

-- oneDivideByN [1..3]
-- [1.0,0.5,0.3333333333333333] 
oneDivideByN :: [Double] -> [Double]
oneDivideByN = map (1/)


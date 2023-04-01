pair :: a -> b -> (a, b)
pair x y = (x, y)

swap :: (a, b) -> (b, a)
swap (x, y) = (y, x)

fst' :: (a, b) -> a
fst' (x, _) = x

snd' :: (a, b) -> b
snd' (_, y) = y

-- cortesian product

-- [(x, y) | x <- [1, 2], y <- [3, 4, 5]]
-- [(1,3),(1,4),(1,5),(2,3),(2,4),(2,5)]

-- when y is limited by x
-- [(x, y) | x <- [1..3], y <- [x..3]]
-- [(1,1),(1,2),(1,3),(2,2),(2,3),(3,3)]


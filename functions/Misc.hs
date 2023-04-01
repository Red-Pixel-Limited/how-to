-- Execute twice
twice :: (a -> a) -> a -> a
twice f x = f (f x)

-- Apply a function
apply :: (a -> b) -> a -> b
apply f = f

-- const
const' :: a -> b -> a
const' x _ = x

-- const' :: a -> (b -> a)
-- const' x = \_ -> x

-- const' :: a -> (b -> a)
-- const' = \x -> \_ -> x


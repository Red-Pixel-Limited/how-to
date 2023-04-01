-- In Haskell, functions are curried by default.

const' :: a -> b -> a
const' x _ = x

-- const' :: a -> (b -> a)
-- const' x = \_ -> x

-- const' :: a -> (b -> a)
-- const' = \x -> \_ -> x


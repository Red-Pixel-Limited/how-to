import Control.Monad (ap)

f :: (a1 -> a2) -> (b1 -> b2) -> (a1, b1) -> (a2, b2)
f =  flip flip snd . (ap .) . flip flip fst . ((.) .) . flip . (((.) . (,)) .)

-- f (+1) ("foo" ++) (2, "asd")
-- (3,"fooasd")

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

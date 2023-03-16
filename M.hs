import Control.Monad (filterM)

lift :: [a] -> [IO a]
lift xs = do
  return <$> xs

printEven :: (Integral a, Show a) => [a] -> IO ()
printEven numbers = do
  filterM (pure . even) numbers >>= print

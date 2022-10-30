import Control.Monad.Reader
import Data.Char
import Data.Text.Unsafe (unsafeDupablePerformIO)

upper :: Reader String String
upper = do
    asks $ map toUpper

greet :: Reader String String
greet = do
  name <- ask
  return $ "Hello, " ++ name ++ "!"

compose :: Reader String String
compose = do
  g <- greet
  u <- upper
  return $ g ++ " Your name in upper case: " ++ u

main = print . runReader compose $ "Bob"
-- "Hello, Bob! Your name in upper case: BOB"


import Data.List.NonEmpty

class Semigroup' a where
  (<>)    :: a -> a -> a
  sconcat :: NonEmpty a -> a
  stimes  :: Integral b => b -> a -> a
  
class Semigroup' a => Monoid' a where
  mempty  :: a
  mappend :: a -> a -> a
  mconcat :: NonEmpty a -> a


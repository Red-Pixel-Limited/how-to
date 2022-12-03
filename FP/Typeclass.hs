import Data.List.NonEmpty

class Semigroup' a where
  (<>)    :: a -> a -> a
  sconcat :: NonEmpty a -> a
  stimes  :: Integral b => b -> a -> a

class Semigroup' a => Monoid' a where
  mempty  :: a
  mappend :: a -> a -> a
  mconcat :: NonEmpty a -> a

class Functor' f where
  fmap' :: (a -> b) -> f a -> f b

(<$>) :: (Functor' f) => (a -> b) -> f a -> f b
(<$>) = fmap'

-- Functor laws
-- Identity: fmap' id == id
-- Composition: fmap' (f . g) == fmap' f . fmap' g

class Functor' f => Applicative' f where
  pure' :: a -> f a
  (<*>) :: f (a -> b) -> f a -> f b

class Applicative' f => Monad' f where
  return' :: a -> f a
  (>>=)   :: f a -> (a -> f b) -> f b


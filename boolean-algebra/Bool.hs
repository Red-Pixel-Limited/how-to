import Distribution.Parsec (Parsec(parsec))
(&&) :: Bool -> Bool -> Bool
True && b = b
False && _ = False

(||) :: Bool -> Bool -> Bool
True || _ = True
False || b = b

-- b || c
--   | b == c = b
--   | otherwise = True

-- b && c
--   | b == c = b
--   | otherwise = False

not :: Bool -> Bool
not True = False
not False = True

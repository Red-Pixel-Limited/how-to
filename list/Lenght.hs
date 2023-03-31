
length1 :: [a] -> Int
length1 xs = sum [1 | _ <- xs]

length2 :: [a] -> Int
length2 = sum . map (const 1)

length3 :: [a] -> Int
length3 [] = 0
length3 (_ : xs) = 1 + length3 xs


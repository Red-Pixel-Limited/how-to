-- Order in high oder functions --
-- (1+) = \y = 1 + y
-- (*2) = \x -> x * 2

-- divideByOne [1..3]
-- [1.0,2.0,3.0]
divideByOne :: [Double] -> [Double]
divideByOne = map (/ 1)

-- oneDivideByN [1..3]
-- [1.0,0.5,0.3333333333333333]
oneDivideByN :: [Double] -> [Double]
oneDivideByN = map (1 /)



doubleEverySecond :: [Integer] -> [Integer]
doubleEverySecond = zipWith (*) (cycle [1, 2])



doubleEverySecondElem :: [Integer] -> [Integer]
doubleEverySecondElem = zipWith (*) (cycle [1, 2])


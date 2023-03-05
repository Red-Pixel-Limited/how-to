testCharWithLenConstraint :: [Char] -> Bool
testCharWithLenConstraint ['a', _, _] = True
testCharWithLenConstraint _ = False

testCharWithNoLenConstraint :: [Char] -> Bool
testCharWithNoLenConstraint ('a' : _) = True 
testCharWithNoLenConstraint _ = False

maybeThird :: [a] -> Maybe a
maybeThird (_ : _ : x : _) = Just x
maybeThird _ = Nothing


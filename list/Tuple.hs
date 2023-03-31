firsts :: [(a, b)] -> [a]
firsts xs = [x | (x, _) <- xs]

fsts :: [(a, b)] -> [a]
fsts = map fst


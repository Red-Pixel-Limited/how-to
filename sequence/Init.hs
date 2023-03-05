-- collection without last item
init' :: [a] -> [a]
init' xs = take (length xs - 1) xs


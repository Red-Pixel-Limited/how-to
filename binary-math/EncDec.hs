-- test 88 "Hi!"
-- Encrypted: 1y
-- Decrypted: Hi!

import Data.Bits (Bits (xor))
import Data.Char (chr, ord)

encDec :: Int -> String -> String
encDec key = map $ chr . xor key . ord

test key text =
    let enc = encDec key text in do
        putStrLn $ "Encrypted: " ++ enc
        putStrLn $ "Decrypted: " ++ encDec key enc


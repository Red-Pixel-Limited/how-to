/*
  Enter a number: 8
  Even: 8
  Odd:  9
  Is even: true

  Enter a number: 5
  Even: 4
  Odd:  5
  Is even: false
*/

#include <iostream>

/* 0000 0100 = 4  0000 0111 = 7 *
 * 1111 1110      1111 1110     *
 * &_________     &________     *
 * 0000 0100 = 4  0000 0110 = 6 */

ushort make_even(ushort n) {
    return n & ~1; // 0xFFFE
}

/*  0000 0100 = 4  0000 0111 = 7 *
 *  0000 0001      0000 0001     *
 * |_________      |________     *
 *  0000 0101 = 5  0000 0111 = 7 */

ushort make_odd(ushort n) {
    return n | 1;
}

/*  0000 1010 = 10  0000 1001 = 9 *
 *  0000 0001       0000 0001     *
 * &_________      &_________     *
 *  0000 0000 Even  0000 0001 Odd */

bool is_even(ushort n) {
    return (n & 1) == 0;
}

int main(int argc, const char *argv[]) {
    std::cout << "Enter a number: ";
    int n;
    std::cin >> n;
        
    if (std::cin) {
        std::cout << "Even: " << make_even(n) << std::endl;
        std::cout << "Odd:  " << make_odd(n) << std::endl;
        std::cout << "Is even: " << std::boolalpha << is_even(n) << std::endl;
    }
    
    return 0;
}

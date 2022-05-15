// Enter number: 8
// Multiple by 2: 16
// Divide by 2: 4

#include <iostream>
using namespace std;

int main(int argc, const char* argv[]) {
    cout << "Enter number: ";
    int n;
    cin >> n;
    if (cin) {
        cout << "Multiple by 2: " << (n << 1) << endl;
        cout << "Divide by 2: " << (n >> 1) << endl;
    }
    return 0;
}

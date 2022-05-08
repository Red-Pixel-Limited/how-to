import static java.lang.String.format;

final class CharArithmeticDemo {

    public static void run() {
        char ch = 'X';
        System.out.println(format("Initial value: %c", ch));

        ch++;
        System.out.println(format("After increment: %c", ch));  // Z

        ch = 90;
        System.out.println(format("After setting 90: %c", ch)); // Z
    }
}

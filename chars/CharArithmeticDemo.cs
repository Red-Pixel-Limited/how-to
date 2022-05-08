using static System.Console;

public class CharArithmeticDemo
{
    public static void Run()
    {
        var ch = 'X';
        WriteLine($"Initial value: {ch}");

        ch++;
        WriteLine($"After increment: {ch}");

        ch = (char) 90;
        WriteLine($"After setting 90: {ch}");
    }
}

using System;

public sealed class LiteralsDemo
{
    public static void Run()
    {
        const int hex = 0xFF;
        var oct = Convert.ToInt32("011", 8);
        var bin = Convert.ToInt32("1100", 2);

        Console.WriteLine("Hexadecimal: {0}", hex);
        Console.WriteLine("Octal: {0}", oct);
        Console.WriteLine("Binary: {0}", bin);
    }
}


using static System.Console;

public static class EnumTraverse
{
    enum Apple
    {
        Jonathan,
        GoldenDel,
        RedDel,
        Winsap,
        Cortland,
        Mclntosh
    }

    public static void Run()
    {
        string[] color =
        {
            "red",
            "orange",
            "green",
            "indianred",
            "lightsalmon",
            "salmon"
        };

        // The color of Jonathan is red
        // The color of GoldenDel is orange
        // The color of RedDel is green
        // The color of Winsap is indianred
        // The color of Cortland is lightsalmon
        // The color of Mclntosh is salmon
        for (var current = Apple.Jonathan; current <= Apple.Mclntosh; current++)
        {
            WriteLine($"The color of {current} is {color[(int) current]}");
        }
    }
}

namespace ConsoleApp1.Flags
{
    using System;

    [Flags]
    public enum Currency
    {
        None = 0x0,
        Gbp = 0x1,
        Gbx = 0x2
    }
}

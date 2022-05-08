namespace ConsoleApp1.Flags
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading;
    using static Currency;

    public class CurrencyResolver
    {
        private readonly IDictionary<Currency, string> _map = new Dictionary<Currency, string>
        {
            {Gbp | Gbx, "Is official currency in Britain"}
        };

        private static readonly Lazy<CurrencyResolver> Constructor =
            new Lazy<CurrencyResolver>(() => new CurrencyResolver(), LazyThreadSafetyMode.ExecutionAndPublication);

        private CurrencyResolver() {}

        public static CurrencyResolver Instance => Constructor.Value;

        public string Resolve(Currency currency)
        {
            var result = _map.SingleOrDefault(pair => pair.Key.HasFlag(currency));
            return result.Key == None ? "Could not resolve" : result.Value;
        }
    }
}
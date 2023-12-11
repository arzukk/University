using System;

using static Glowacki.SOAP.Impl.EchoImpl;

namespace Glowacki.SOAP.Service
{
    internal static class Program
    {
        private static void Main(string[] arguments)
        {
            var host = new ServiceHost();
            host.Open();
            Console.WriteLine("{0} is running...", host.GetType());
            Console.ReadLine();
        }
    }
}

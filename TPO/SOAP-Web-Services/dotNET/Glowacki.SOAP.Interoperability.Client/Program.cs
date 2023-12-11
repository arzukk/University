using Glowacki.SOAP.Interoperability.Client.CompositeService;

using System;

namespace Glowacki.SOAP.Interoperability.Client
{
    internal class Program
    {
        internal static void Main(string[] arguments)
        {
            using (var client = new CompositeClient())
            {
                var request = AddRequest(1, 2);
                var response = client.add(request);
                Console.WriteLine("add result: {0}", response.result);
                Console.Read();
            }
        }

        private static AddRequestMessage AddRequest(int constituent1, int constituent2)
        {
            return new AddRequestMessage
            {
                constituent1 = constituent1,
                constituent2 = constituent2
            };
        }
    }
}

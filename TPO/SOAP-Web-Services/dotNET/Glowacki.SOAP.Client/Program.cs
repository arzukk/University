using Glowacki.SOAP.API;

using System;

namespace Glowacki.SOAP.Client
{
    internal class Program
    {
        private static void Main(string[] arguments)
        {
            var proxy = new EchoProxy();
            var channel = proxy.Channel();
            const string content = "message";
            var request = EchoRequest(content);
            var response = channel.Echo(request);
            Console.WriteLine("response: '{0}'", response.Content);
            Console.ReadLine();
        }

        private static EchoRequest EchoRequest(string content)
        {
            return new EchoRequest
            {
                Content = content
            };
        }
    }
}

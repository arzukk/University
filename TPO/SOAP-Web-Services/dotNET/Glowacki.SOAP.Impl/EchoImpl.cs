using Glowacki.SOAP.API;

using System;

namespace Glowacki.SOAP.Impl
{
    public sealed partial class EchoImpl : IEcho
    {
        public EchoResponse Echo(EchoRequest request)
        {
            Console.WriteLine($"request: '{request.Content}'");

            return new EchoResponse
            {
                Content = request.Content
            };
        }
    }
}

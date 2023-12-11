using Glowacki.SOAP.API;
using Glowacki.SOAP.Core;

namespace Glowacki.SOAP.Client
{
    public sealed class EchoProxy : ProxyBase<IEcho>
    {
        public EchoProxy()
            : base(Configuration.EndpointAddress, Configuration.Binding) { }
    }
}

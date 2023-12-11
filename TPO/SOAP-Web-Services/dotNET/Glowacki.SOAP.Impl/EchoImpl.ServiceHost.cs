using Glowacki.SOAP.API;
using Glowacki.SOAP.Core;
using Glowacki.SOAP.Host;

namespace Glowacki.SOAP.Impl
{
    partial class EchoImpl
    {
        public sealed class ServiceHost : ServiceHostBase<IEcho, EchoImpl>
        {
            public ServiceHost()
                : base(Configuration.Uri) { }
        }
    }
}

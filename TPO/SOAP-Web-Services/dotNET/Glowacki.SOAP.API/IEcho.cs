using Glowacki.SOAP.Core;

using System.ServiceModel;

namespace Glowacki.SOAP.API
{
    [ServiceContract(Namespace = Configuration.Namespace)]
    public interface IEcho : IService
    {
        [OperationContract]
        EchoResponse Echo(EchoRequest request);
    }
}

using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Glowacki.SOAP.Core
{
    public class BindingUtility
    {
        private const int MaxBufferSize = 0x01000000;
        private const int MaxReceivedMessageSize = MaxBufferSize;
        private static readonly TimeSpan Timeout = new TimeSpan(0, 10, 0);

        public static BasicHttpBinding BasicHttpBinding()
        {
            return new BasicHttpBinding
            {
                Namespace = Configuration.Namespace,
                MaxBufferSize = MaxBufferSize,
                MaxReceivedMessageSize = MaxReceivedMessageSize,
                ReceiveTimeout = Timeout,
                SendTimeout = Timeout
            };
        }

        public static ServiceMetadataBehavior ServiceMetadataBehaviorHttp()
        {
            var behaviour = new ServiceMetadataBehavior
            {
                HttpGetEnabled = true
            };
            behaviour.MetadataExporter.PolicyVersion = PolicyVersion.Policy15;
            return behaviour;
        }
    }
}

using System;
using System.ServiceModel;
using System.ServiceModel.Channels;

namespace Glowacki.SOAP.Core
{
    public static class Configuration
    {
        public const string Namespace = "http://glowacki.eu";

        private const string UriSpec = "http://localhost:20000";
        public static readonly Uri Uri = new Uri(UriSpec);

        private const string MetadataUriSpec = UriSpec + "?wsdl";
        public static readonly Uri MetadataUri = new Uri(MetadataUriSpec);

        public static readonly EndpointAddress EndpointAddress = new EndpointAddress(Uri);
        public static readonly Binding Binding = BindingUtility.BasicHttpBinding();
    }
}

using Glowacki.SOAP.API;

using System.ServiceModel;
using System.ServiceModel.Channels;

namespace Glowacki.SOAP.Client
{
    public abstract class ProxyBase<TService>
        where TService : IService
    {
        private readonly EndpointAddress _endpoint;
        private readonly ChannelFactory<TService> _factory;

        protected ProxyBase(EndpointAddress endpoint, Binding binding)
        {
            _endpoint = endpoint;
            _factory = new ChannelFactory<TService>(binding, _endpoint);
        }

        public TService Channel() => _factory.CreateChannel();
    }
}

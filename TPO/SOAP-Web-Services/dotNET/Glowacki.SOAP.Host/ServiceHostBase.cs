using Glowacki.SOAP.API;
using Glowacki.SOAP.Core;

using System;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.ServiceModel.Description;

namespace Glowacki.SOAP.Host
{
    public abstract class ServiceHostBase<TService, TServiceImpl> : ServiceHost
        where TService : IService
        where TServiceImpl : class, TService
    {
        protected ServiceHostBase(Uri uri)
            : base(typeof(TServiceImpl), uri)
        {
            ServiceMetadata();
            Binding(Configuration.Binding);
        }

        private void ServiceMetadata()
        {
            var behaviour = BindingUtility.ServiceMetadataBehaviorHttp();
            Description.Behaviors.Add(behaviour);
            AddServiceEndpoint(ServiceMetadataBehavior.MexContractName, MetadataExchangeBindings.CreateMexHttpBinding(), "mex");
        }

        private void Binding(Binding binding)
        {
            AddServiceEndpoint(typeof(TService), binding, string.Empty);
        }
    }
}

I. In order to enable interoperation between Microsoft .NET SOAP web service with Java client you need to do as follows:

1. Install maven locally
2. Add maven bin directory to PATH environment variable
3. Open console in 'jax-ws-interoperability-client' project

4. run 'mvn generate-sources'
   Unfortunately the generated sources are based on old API ('javax' prefix)

5. run 'mvn process-sources'
   We need to convert them into new API ('jakarta' prefix)

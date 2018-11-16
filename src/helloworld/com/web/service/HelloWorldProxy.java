package helloworld.com.web.service;

public class HelloWorldProxy implements helloworld.com.web.service.HelloWorld {
  private String _endpoint = null;
  private helloworld.com.web.service.HelloWorld helloWorld = null;
  
  public HelloWorldProxy() {
    _initHelloWorldProxy();
  }
  
  public HelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWorldProxy();
  }
  
  private void _initHelloWorldProxy() {
    try {
      helloWorld = (new helloworld.com.web.service.HelloWorldServiceLocator()).getHelloWorld();
      if (helloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWorld != null)
      ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public helloworld.com.web.service.HelloWorld getHelloWorld() {
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld;
  }
  
  public void main(java.lang.String[] args) throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    helloWorld.main(args);
  }
  
  public float addValue(float value) throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld.addValue(value);
  }
  
  public float subtractValue(float value) throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld.subtractValue(value);
  }
  
  
}
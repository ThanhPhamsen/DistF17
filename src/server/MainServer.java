package server;


import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.util.Scanner;
import interfaces.MainInterface;

public class MainServer {
    public static void main(String[] args) throws MalformedURLException {
        
        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
	QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
	Service service = Service.create(url, qname);

        
        System.out.println("Start server!");
        MainInterface i = new GameLogic();
        
        Endpoint.publish("http://[::]:9978/galgeleg", i);
       System.out.println("Bottom of the server code!");
}

}
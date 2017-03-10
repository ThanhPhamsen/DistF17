package server;


import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.util.Scanner;
import semesterprojektgalgeleg.MainInterface;
import javax.xml.ws.Endpoint;
import brugerAdmin.Brugerdatabase;
import server.BrugeradminImpl;

public class MainServer {
    public static void main(String[] args) throws MalformedURLException {
        
       // URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
	//QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
	//Service service = Service.create(url, qname);
        //Brugeradmin brugertjek = service.getPort(Brugeradmin.class);
        
         URL url2 = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
                QName qname2 = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
                Service service2 = Service.create(url2, qname2);
                    Brugeradmin ba = service2.getPort(Brugeradmin.class);
                    ba.hentBruger("s133968", "xxx");
        
        System.out.println("Start server!");
        MainInterface i = new GameLogic();
        /*
        Brugerdatabase db = Brugerdatabase.getInstans();
		System.out.println("Publicerer Brugeradmin over SOAP");
		BrugeradminImpl impl = new BrugeradminImpl();
		impl.db = db;
               
        Endpoint.publish("http://[::]:9901/brugeradmin", impl);
        System.out.println("Brugeradmin publiceret over SOAP");
        */
        Endpoint.publish("http://[::]:9978/galgeleg", i);
       System.out.println("Bottom of the server code!");
}

}
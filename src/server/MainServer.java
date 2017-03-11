package server;


import brugerautorisation.transport.soap.Brugeradmin;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.util.Scanner;
import semesterprojektgalgeleg.MainInterface;
import javax.xml.ws.Endpoint;

public class MainServer {
    public static void main(String[] args) throws MalformedURLException {
        
        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
	QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
	Service service = Service.create(url, qname);
        Brugeradmin brugertjek = service.getPort(Brugeradmin.class);
        boolean tjek = false;
        while(tjek == false){
        System.out.println("Enter username");
         Scanner scan = new Scanner(System.in);
         String username = scan.nextLine();
         
         System.out.println("Enter password");
         Scanner scan2 = new Scanner(System.in);
         String password = scan.nextLine();
         
        if(brugertjek.hentBruger(username, password)!=null){
            System.out.println("Du er logget ind!");
            tjek = true;
        }else{
            System.out.println("prøv igen!");
        }}
         
         
         
        
        
        System.out.println("Start server!");
        MainInterface i = new GameLogic();
        
        Endpoint.publish("http://[::]:9978/galgeleg", i);
       System.out.println("Bottom of the server code!");
}

}
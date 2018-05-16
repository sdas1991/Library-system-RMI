package ClientSide;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) {
		
		try {
			
			
		ServerImpl inputOutputImpl=new ServerImpl();  
		RemoteInterface stub=(RemoteInterface)UnicastRemoteObject.exportObject(inputOutputImpl,0);
		
		// Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("HistoryServer", stub);

        
			/*Naming.rebind("rmi://localhost:5000/RemoteInterface",inputOutputImpl);*/
			System.out.println("Server is ready for use... ");
			
		} catch (RemoteException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

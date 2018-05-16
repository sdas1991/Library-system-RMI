package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		try {
			
		/*String url=new String("rmi://localhost:5000/RemoteInterface");
		RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup(url);*/
			
			Registry registry = LocateRegistry.getRegistry(args[0]);
            RemoteInterface stub = (RemoteInterface) registry.lookup("HistoryServer");
		
		String passList2[]=new String[1];
		List<String> fetch=new ArrayList<String>();
		BufferedReader br2;
		
		
		
		//System Input
		System.out.println("enter month, date and event if add || enter month and date if query");
		br2=new BufferedReader(new InputStreamReader(System.in));
		
			passList2[0]=br2.readLine();
			String[] firstWord=passList2[0].split(" ");
			//System.out.println(passList2[i]);
		
			
		
		//String feedBack=stub.add(passList2);
		if(firstWord[0].equals("add")){
			String feedBack=stub.add(passList2);//add call
			System.out.println(feedBack);
		}else if(firstWord[0].equals("query")){
			fetch=stub.query(passList2);	//fetching by query
			System.out.println("query fetched");
			for(int i=0;i<fetch.size();i++){
				System.out.println(fetch.get(i));
			}
			
		}else{
			System.out.println("type in the form of add/query month date event");;
		}
					
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

package ClientSide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class ServerImpl implements RemoteInterface {
	private static final long serialVersionUID= 1L;
	
	


	

	@Override
	public List<String> query(String[] fetchList) throws RemoteException {
		String[] addList1=new String[15];
		List<String> fetchList2=new ArrayList<String>();
		
		addList1=fetchList[0].split(" ");
		

		try {
		
		FileInputStream fstream = new FileInputStream("History.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine,first,second;
		  
			while ((strLine = br.readLine()) != null)   {
				String[] delims = strLine.split(" ");
			       first = delims[0];
			      second=delims[1];
			      if(addList1[1].equals(first) && addList1[2].equals(second)) {
			    	  fetchList2.add(strLine);
				  }
			  }
			fstream.close();
			//return fetchList2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		if(fetchList2.size()==0){
			fetchList2.add("String not found");
			return fetchList2;
		}else{
			return fetchList2;
		}
		
	}

	@Override
	public String add(String[] addlist) throws RemoteException {
		
		
		try {
			/*System.out.println(1);
			writer = new BufferedWriter( new FileWriter("C:\\Users\\sdas1\\eclipse-workspace\\History\\bin\\ClientSide\\History.txt"));
			for (int i = 0; i < addlist.length; i++) {
				System.out.println(2);
				writer.write(addlist[i]);
				System.out.println(3);*/
			String[] add=new String[1];
			add=addlist.clone();
			//File newTextFile = new File("History.txt");
			String save= add[0].substring(4);
			
			File file=new File("History.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(save);
	        bw.newLine();
	        
			
		
		
		bw.close();
        fw.close();
        
	        return "success";
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return "failure";
	}
	

}

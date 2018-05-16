package ClientSide;
//Sourangshu Das
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface RemoteInterface extends Remote{
	public List<String> query(String[] fetchList) throws RemoteException;
	
	public String add(String[] addlist) throws RemoteException;

}


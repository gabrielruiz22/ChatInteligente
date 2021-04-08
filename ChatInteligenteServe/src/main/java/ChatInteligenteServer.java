import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ChatInteligenteServer {

    public ChatInteligenteServer() throws RemoteException {
        try {
            LocateRegistry.createRegistry(4200);
            Naming.rebind("rmi://localhost:4200/ChatInteligente", new ChatInteligente());
            System.out.println("Iniciando servidor...");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws RemoteException {
        new ChatInteligenteServer();
    }
}

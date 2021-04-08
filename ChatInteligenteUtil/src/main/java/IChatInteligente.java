import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatInteligente extends Remote {

    void sendMensagem(Mensagem msg) throws RemoteException;
    List<Mensagem> retrieveMensagem() throws RemoteException;
    void inserirProduto(Produto produto) throws RemoteException;
    void inserirPedido(Pedido p) throws RemoteException;
}

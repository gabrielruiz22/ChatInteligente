import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatInteligente extends UnicastRemoteObject implements IChatInteligente {

    private static List<Produto> lstProduto = new ArrayList<>();
    private static List<Pedido> lstPedido = new ArrayList<>();

    protected ChatInteligente() throws RemoteException {
    }
    
    @Override
    public void sendMensagem(Mensagem msg) throws RemoteException {
        Mensagem.setLstMessage(msg);
    }

    @Override
    public List<Mensagem> retrieveMensagem() throws RemoteException {
        return Mensagem.getLstMessage();
    }

    @Override
    public void inserirProduto(Produto produto) throws RemoteException {
        lstProduto.add(produto);
    }

    @Override
    public void inserirPedido(Pedido p) throws RemoteException {
        lstPedido.add(p);
    }
}

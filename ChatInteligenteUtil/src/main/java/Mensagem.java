import java.util.ArrayList;
import java.util.List;

public class Mensagem {
    private static final long serialVersionUID = -2723363051271966964L;

    private String user;
    private String mensagem;

    private static List<Mensagem> lstMessage = new ArrayList<Mensagem>();

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public static List<Mensagem> getLstMessage(){
        return lstMessage;
    }

    public static void setLstMessage(Mensagem msg) {
        lstMessage.add(msg);
    }

}

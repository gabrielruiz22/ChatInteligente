import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ChatTeste {
    public static void main(String[] args){

        String nome = "", msg = "", resposta = "", respostaChat = "";

        Produto produto = new Produto();
        produto.setId(1);
        produto.setDescricao("Refrigerador Electrolux DFX41 Frost Free");
        produto.setTipo("Refrigerador");

        Pedido pedido = new Pedido();
        pedido.setNPedido(1);
        pedido.setDescricao("compra via site");
        pedido.setProduto(produto);
        pedido.setStatus("Transportadora");
        pedido.setDataCompra("20/03/2021");

        try{
            new  ChatDB().inserirPedido(pedido);
            new  ChatDB().inserirProduto(produto);
        } catch (SQLException sql){
            sql.printStackTrace();
        }
        msg = JOptionPane.showInputDialog("Bem vindo ao ChatLojaX, sou atendente Virtual X! \nPosso ajuda-lo? Caso não digite '0' para sair!");
        try{
            while (msg != "0"){
                IChatInteligente objChat = (IChatInteligente) Naming.lookup("rmi://localhost:4200/chatInteligente");
                Mensagem mensagem = new Mensagem(msg);
                objChat.sendMensagem(mensagem);
                System.out.println(returnMensagem(objChat.retrieveMensagem()));
                new ChatDB().inserirMensagem(mensagem);

                if(msg.equals("0")){
                    System.out.println("Você fechou o chat!");
                    System.exit(1);

                } else if (msg.toUpperCase().contains("Pedido") || msg.toUpperCase().contains("Pedid")
                        || msg.toUpperCase().contains("P") || msg.toUpperCase().contains("Pedidos")){
                    resposta = JOptionPane.showInputDialog(
                            " você quer saber o número do seu pedido?" + "\nDigite SIM ou NÃO");
                    if (resposta.toUpperCase().contains("SIM") || resposta.toUpperCase().contains("S")) {
                        respostaChat = "Número do pedido: " + Integer.toString(pedido.getNPedido());
                    }
                   if (resposta.toUpperCase().contains("NÃO") || resposta.toUpperCase().contains("NAO")
                        || resposta.toUpperCase().contains("NÃO")){
                       msg = JOptionPane.showInputDialog("Informe em poucas palavras o que deseja, exemplo: Pedido, Nota, Status");
                   }
                    else
                        respostaChat = "Me desculpe, não entendi.";
                } else if (msg.toUpperCase().contains("NOTA") || msg.toUpperCase().contains("FISCAL")
                        || msg.toUpperCase().contains("NF")) {
                    resposta = JOptionPane.showInputDialog(
                             "você quer saber o número da nota fiscal?" + "\nDigite SIM ou NAO");
                    if (resposta.toUpperCase().contains("SIM") || resposta.toUpperCase().contains("S")) {
                        respostaChat = "Número da sua NF é: 54877878787887878";
                    }
                    if (resposta.toUpperCase().contains("NÃO") || resposta.toUpperCase().contains("NAO")
                            || resposta.toUpperCase().contains("NÃO")){
                        msg = JOptionPane.showInputDialog("Informe em poucas palavras o que deseja, exemplo: Pedido, Nota, Status");
                    }
                    else
                        respostaChat = "Me desculpe, não entendi.";
                } else if (msg.toUpperCase().contains("STATUS")) {
                    resposta = JOptionPane
                            .showInputDialog(nome + ", você quer saber o status do pedido?" + "\nDigite SIM ou NAO");
                    if (resposta.toUpperCase().contains("SIM")|| resposta.toUpperCase().contains("S")){
                        respostaChat = "Status do pedido: " + pedido.getStatus();
                    }
                    if (resposta.toUpperCase().contains("NÃO") || resposta.toUpperCase().contains("NAO")
                            || resposta.toUpperCase().contains("NÃO")){
                        msg = JOptionPane.showInputDialog("Informe em poucas palavras o que deseja, exemplo: Pedido, Nota, Status");
                    }
                    else
                        respostaChat = "Me desculpe, não entendi.";
                } else
                    respostaChat = "Me desculpe, não entendi.";

                Mensagem msgBot = new Mensagem(respostaChat);
                objChat.sendMensagem(msgBot);
                System.out.print(returnMensagem(objChat.retrieveMensagem()));
                new ChatDB().inserirMensagem(msgBot);
                }

            } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NotBoundException notBoundException) {
            notBoundException.printStackTrace();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }

     private static String returnMensagem(List<Mensagem> lst){

        String valor = "";
        for (Mensagem mensagem : lst) {
            valor = mensagem.getMensagem() + "\n";
        }
        return valor;
    }


}

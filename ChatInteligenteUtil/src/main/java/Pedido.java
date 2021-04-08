import java.io.Serializable;

public class Pedido implements Serializable {

    private static final long serialVersionUID = -8018531141678337588L;

    private int nPedido;
    private String descricao;
    private String dataCompra;
    private String status;
    private Produto produto;

    public int getNPedido() {
        return nPedido;
    }
    public void setNPedido(int nPedido) {
        this.nPedido = nPedido;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(String dtCompra) {
        this.dataCompra = dtCompra;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    @Override
    public String toString() {
        return "Pedido [nPedido=" + nPedido + ", descricao=" + descricao + ", dataCompra=" + dataCompra + ", status="
                + status + ", produto=" + produto + "]";

    }
}

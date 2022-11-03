package br.com.gvitor.antares.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_itemDoc")
public class ItemDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private Integer numSeq;

    @Column(name = "quantidade_item")
    private double quantidade;

    @Column(name = "preco_item")
    private double precoTotal;

    @Column(name= "concluido")
    private int concluido;

    @Column(name = "valor_total_item")
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "tbl_produto_id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "tbl_documento_id_documento")
    private Documento documento;

    //Getters and Setters


    public Integer getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(Integer numSeq) {
        this.numSeq = numSeq;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getConcluido() {
        return concluido;
    }

    public void setConcluido(int concluido) {
        this.concluido = concluido;
    }

    public double getValorTotal() { return valorTotal; }

    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) { this.produto = produto; }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}

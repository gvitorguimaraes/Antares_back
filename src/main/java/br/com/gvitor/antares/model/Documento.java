package br.com.gvitor.antares.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_documento")
public class Documento {

    @Id
    @Column(name = "id_documento", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "valor_total_documento")
    private double valorTotalDoc;

    @Column(name = "data_documento", nullable = false)
    private LocalDate data;

    @Column(name = "pagamento_documento", length = 45)
    private String pagamento;

    @Column(name = "obs_documento", length = 140)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tbl_cliente_id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
    private List<ItemDocumento> itens;

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer num) { this.id = num; }

    public double getValorTotalDoc() {
        return valorTotalDoc;
    }

    public void setValorTotalDoc(double valor) { this.valorTotalDoc = valor; }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getObservacoes() { return observacoes; }

    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<ItemDocumento> getItens() { return itens; }

    public void setItens(List<ItemDocumento> itens) { this.itens = itens; }
}

package br.com.gvitor.antares.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_documento")
public class Documento {

    @Id
    @Column(name = "num_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Column(name= "valor_documento")
    private double valor;

    @Column(name = "data_documento", nullable = false)
    private LocalDate data;

    @Column(name = "status_documento")
    private Integer status;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
    private List<ItemDocumento> itens;

    //Getters and Setters

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ItemDocumento> getItens() {
        return itens;
    }

    public void setItens(List<ItemDocumento> itens) {
        this.itens = itens;
    }
}

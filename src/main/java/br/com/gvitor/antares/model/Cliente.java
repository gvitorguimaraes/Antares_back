package br.com.gvitor.antares.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "cpf_cnpj", nullable = false, length = 11)
    private String cpf_cnpj;

    @Column(name = "endereco_cliente", length = 120)        // Verificar como fazer para armazenar o endereço
    private String endereco;

    @Column(name = "telefone_cliente")
    private int telefone;

    @Column(name = "email_cliente", length = 45)
    private String email;

    @Column(name = "cep_cliente")
    private int cep;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Documento> documentos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}

package br.com.fiap.petshop.domain.entity.servico;

import br.com.fiap.petshop.domain.entity.animal.Animal;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_SERVICO")
public abstract class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SERVICO")
    @Column(name = "ID_SERVICO")
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "ABERTURA")
    private LocalDateTime abertura;

    @Column(name = "AUTORIZACAO")
    private LocalDateTime autorizacao;

    @Column(name = "CONCLUSAO")
    private LocalDateTime conclusao;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "SERVICO_ID", referencedColumnName = "ID_SERVICO", foreignKey = @ForeignKey(name = "FK_SERVICO"))
    private Animal animal;


    public Servico() {
    }

    public Servico(Long id, BigDecimal valor, LocalDateTime abertura, LocalDateTime autorizacao, LocalDateTime conclusao, String descricao, String observacao, Animal animal) {
        this.id = id;
        this.valor = valor;
        this.abertura = abertura;
        this.autorizacao = autorizacao;
        this.conclusao = conclusao;
        this.descricao = descricao;
        this.observacao = observacao;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public Servico setId(Long id) {
        this.id = id;
        return this;
    }



    public BigDecimal getValor() {
        return valor;
    }

    public Servico setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public Servico setAbertura(LocalDateTime abertura) {
        this.abertura = abertura;
        return this;
    }

    public LocalDateTime getAutorizacao() {
        return autorizacao;
    }

    public Servico setAutorizacao(LocalDateTime autorizacao) {
        this.autorizacao = autorizacao;
        return this;
    }

    public LocalDateTime getConclusao() {
        return conclusao;
    }

    public Servico setConclusao(LocalDateTime conclusao) {
        this.conclusao = conclusao;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Servico setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public Servico setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Servico setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }


    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", valor=" + valor +
                ", abertura=" + abertura +
                ", autorizacao=" + autorizacao +
                ", conclusao=" + conclusao +
                ", descricao='" + descricao + '\'' +
                ", observacao='" + observacao + '\'' +
                ", animal=" + animal +
                '}';
    }
}
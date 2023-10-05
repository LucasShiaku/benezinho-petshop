package br.com.fiap.petshop.domain.entity.animal;

import br.com.fiap.petshop.domain.entity.Sexo;
import br.com.fiap.petshop.domain.entity.servico.Servico;
import br.com.fiap.petshop.infra.security.entity.Pessoa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TP_ANIMAL")
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ANIMAL")

    private Long id;
    @Column(name = "NOME")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", nullable = false)
    private Sexo sexo;

    @Column(name = "NASCIMENTO", nullable = false)
    private LocalDate nascimento;

    @Column(name = "RACA", nullable = false)
    private String raca;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "OBSERVACAO", nullable = false)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "dono_id",
                referencedColumnName = "ID_ANIMAL")
    private Pessoa dono;

    @ManyToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private Set<Servico> servicos = new LinkedHashSet<>();

    public Animal() {
    }

    public Animal(Long id, String nome, Sexo sexo, LocalDate nascimento, String raca, String descricao, String observacao, Pessoa dono, Set<Servico> servicos) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.raca = raca;
        this.descricao = descricao;
        this.observacao = observacao;
        this.dono = dono;
        this.servicos = Objects.nonNull( servicos ) ? servicos : new LinkedHashSet<>();
    }

    public Animal adicionaServico(Servico s) {
        this.servicos.add( s );
        s.setAnimal( this );
        return this;
    }

    public Animal removeaServico(Servico s) {
        this.servicos.remove( s );
        if (s.getAnimal().equals( this )) s.setAnimal( null );
        return this;
    }


    public Set<Servico> getServicos() {
        return Collections.unmodifiableSet( servicos );
    }

    public Long getId() {
        return id;
    }

    public Animal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Animal setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Animal setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Animal setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public String getRaca() {
        return raca;
    }

    public Animal setRaca(String raca) {
        this.raca = raca;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Animal setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public Animal setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public Pessoa getDono() {
        return dono;
    }

    public Animal setDono(Pessoa dono) {
        this.dono = dono;
        return this;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", nascimento=" + nascimento +
                ", raca='" + raca + '\'' +
                ", descricao='" + descricao + '\'' +
                ", observacao='" + observacao + '\'' +
                ", dono=" + dono +
                '}';
    }
}

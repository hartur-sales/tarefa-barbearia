package senai.aluno.Barbearia_API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CORTES")
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String nomeCliente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    @NotNull
    private Barbeiro barbeiro;

    @NotNull
    private LocalDateTime horario;

    @Enumerated(EnumType.STRING)
    private Servicos servico;

    public Corte() {
    }

    public Corte(UUID id, String nomeCliente, Barbeiro barbeiro, LocalDateTime horario, Servicos servico) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.barbeiro = barbeiro;
        this.horario = horario;
        this.servico = servico;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }
}
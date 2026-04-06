package senai.aluno.Barbearia_API.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "BARBEIROS")
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private Integer horaInicio;
    private Integer horaFim;

    @JsonManagedReference
    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    private List<Corte> cortes;

    public Barbeiro() {
    }

    public Barbeiro(UUID id, String nome, Integer horaInicio, Integer horaFim) {
        this.id = id;
        this.nome = nome;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Integer horaFim) {
        this.horaFim = horaFim;
    }

    public List<Corte> getCortes() {
        return cortes;
    }

    public void setCortes(List<Corte> cortes) {
        this.cortes = cortes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Barbeiro barbeiro = (Barbeiro) o;
        return Objects.equals(id, barbeiro.id) && Objects.equals(nome, barbeiro.nome) && Objects.equals(horaInicio, barbeiro.horaInicio) && Objects.equals(horaFim, barbeiro.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, horaInicio, horaFim);
    }

    @Override
    public String toString() {
        return "Barbeiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}
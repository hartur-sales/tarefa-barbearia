package senai.aluno.Barbearia_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.aluno.Barbearia_API.entity.Corte;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface CorteRepository extends JpaRepository<Corte, UUID> {
    boolean existsByBarbeiroIdAndHorario(UUID id, LocalDateTime horario);
}

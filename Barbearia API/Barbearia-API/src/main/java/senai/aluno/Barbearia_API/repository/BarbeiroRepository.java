package senai.aluno.Barbearia_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.aluno.Barbearia_API.entity.Barbeiro;

import java.util.UUID;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, UUID> {
}
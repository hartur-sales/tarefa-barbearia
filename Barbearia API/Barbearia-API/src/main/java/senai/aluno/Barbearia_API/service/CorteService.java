package senai.aluno.Barbearia_API.service;

import org.springframework.stereotype.Service;
import senai.aluno.Barbearia_API.entity.Corte;
import senai.aluno.Barbearia_API.repository.CorteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CorteService {

    private final CorteRepository repository;

    public CorteService(CorteRepository repository) {
        this.repository = repository;
    }

    public Corte criar(Corte corte) {

        if (corte.getHorario().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não pode agendar no passado");
        }

        boolean existe = repository.existsByBarbeiroIdAndHorario(
                corte.getBarbeiro().getId(),
                corte.getHorario()
        );

        if (existe) {
            throw new RuntimeException("Barbeiro já tem horário ocupado");
        }

        int hora = corte.getHorario().getHour();
        if (hora < corte.getBarbeiro().getHoraInicio() ||
                hora > corte.getBarbeiro().getHoraFim()) {
            throw new RuntimeException("Fora do horário de trabalho");
        }

        return repository.save(corte);
    }

    public List<Corte> listar() {
        return repository.findAll();
    }

    public Corte buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corte não encontrado"));
    }

    public Corte atualizar(UUID id, Corte corteAtualizado) {
        Corte corte = buscarPorId(id);

        if (corteAtualizado.getHorario().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não pode agendar no passado");
        }

        boolean existe = repository.existsByBarbeiroIdAndHorario(
                corteAtualizado.getBarbeiro().getId(),
                corteAtualizado.getHorario()
        );

        if (existe && !corteAtualizado.getHorario().equals(corte.getHorario())) {
            throw new RuntimeException("Barbeiro já tem horário ocupado");
        }

        int hora = corteAtualizado.getHorario().getHour();
        if (hora < corteAtualizado.getBarbeiro().getHoraInicio() ||
                hora > corteAtualizado.getBarbeiro().getHoraFim()) {
            throw new RuntimeException("Fora do horário de trabalho");
        }

        corte.setNomeCliente(corteAtualizado.getNomeCliente());
        corte.setBarbeiro(corteAtualizado.getBarbeiro());
        corte.setHorario(corteAtualizado.getHorario());
        corte.setServico(corteAtualizado.getServico());

        return repository.save(corte);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
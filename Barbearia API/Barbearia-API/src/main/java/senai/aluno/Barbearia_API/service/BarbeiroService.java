package senai.aluno.Barbearia_API.service;

import org.springframework.stereotype.Service;
import senai.aluno.Barbearia_API.entity.Barbeiro;
import senai.aluno.Barbearia_API.repository.BarbeiroRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BarbeiroService {

    private final BarbeiroRepository repository;

    public BarbeiroService(BarbeiroRepository repository) {
        this.repository = repository;
    }

    public Barbeiro criar(Barbeiro barbeiro) {
        return repository.save(barbeiro);
    }

    public List<Barbeiro> listar() {
        return repository.findAll();
    }

    public Barbeiro buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
    }

    public Barbeiro atualizar(UUID id, Barbeiro barbeiroAtualizado) {
        Barbeiro barbeiro = buscarPorId(id);

        barbeiro.setNome(barbeiroAtualizado.getNome());
        barbeiro.setHoraInicio(barbeiroAtualizado.getHoraInicio());
        barbeiro.setHoraFim(barbeiroAtualizado.getHoraFim());

        return repository.save(barbeiro);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
package akisselplayer.com.demo.domain.entity.service;

import akisselplayer.com.demo.domain.entity.Usuario;
import akisselplayer.com.demo.domain.entity.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
@Service
@Transactional //rollback para erros no meio de um pacote de transações
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        // implementar validação de login e email exclusivos
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorID(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

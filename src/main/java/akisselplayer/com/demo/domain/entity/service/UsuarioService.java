package akisselplayer.com.demo.domain.entity.service;

import akisselplayer.com.demo.domain.entity.Usuario;
import akisselplayer.com.demo.domain.entity.repository.UsuarioRepository;
import akisselplayer.com.demo.exception.BusinessException;
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
        boolean existeEmail = false;

        Optional<Usuario> optUsuario = repository.findByEmail(usuario.getEmail());
        if(optUsuario.isPresent()){
            if(!optUsuario.get().getId().equals(usuario.getId())){
                existeEmail = true;
            }
        }

        if(existeEmail){
            throw new BusinessException("Email já cadastrado");
        }
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

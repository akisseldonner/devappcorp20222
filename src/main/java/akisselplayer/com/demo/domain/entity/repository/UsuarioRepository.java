package akisselplayer.com.demo.domain.entity.repository;

import akisselplayer.com.demo.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //O spring faz em tempo de execução a implementação dos metodos.
}

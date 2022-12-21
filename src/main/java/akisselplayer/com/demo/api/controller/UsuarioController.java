package akisselplayer.com.demo.api.controller;

import akisselplayer.com.demo.domain.entity.Usuario;
import akisselplayer.com.demo.domain.entity.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;
   @PostMapping
   public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        Usuario salvarUsuario = service.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
       List<Usuario> usuarios = service.listarTodos();
       return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> optUsuario = service.buscarPorId(id);

        if(optUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(optUsuario.get());
    }

    @PutMapping
    public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = service.salvar(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

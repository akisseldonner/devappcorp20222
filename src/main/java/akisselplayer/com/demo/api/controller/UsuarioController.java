package akisselplayer.com.demo.api.controller;

import akisselplayer.com.demo.domain.entity.Usuario;
import akisselplayer.com.demo.domain.entity.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

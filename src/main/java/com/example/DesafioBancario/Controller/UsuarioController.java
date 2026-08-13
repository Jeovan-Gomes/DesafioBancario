package com.example.DesafioBancario.Controller;

import com.example.DesafioBancario.DTO.UsuarioDTO;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> findByCpf(@PathVariable String cpf){
        if(cpf.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.findByCpf(cpf));
    }

    @PostMapping("/CadastrarUser")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO dto){
        if(dto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usuarioService.CadastrarUsuario(dto));
    }
}

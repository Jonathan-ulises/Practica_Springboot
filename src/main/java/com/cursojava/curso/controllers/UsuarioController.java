package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.interfaces.UsuarioDAO;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Los controladores sirven para manejar las URL
 */
@RestController
public class UsuarioController {

    /*
    Ayuda para crear objetos de una clase, si se usa esta misma anotacion
    en otros objetos de la misma clase, comparten la misma referencia en memoria
    del objeto.
     */
    @Autowired
    private UsuarioDAO usuarioDAO;

    /*
    @RequestMapping(value = "prueba")
    public List<String> getUsuario() {
        return List.of("manzana", "kiwi", "banana");
    }*/

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    /*
    @PathVariable
    Permite usar parametros definidos por la URL
     */
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("JONATHAN");
        usuario.setApellido("SANCHEZ");
        usuario.setEmail("jonulisanpar@gmail.com");
        usuario.setTelefono("4773669966");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDAO.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDAO.registrar(usuario);
    }

    @RequestMapping(value = "api/editar")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("JONATHAN");
        usuario.setApellido("SANCHEZ");
        usuario.setEmail("jonulisanpar@gmail.com");
        usuario.setTelefono("4773669966");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDAO.eliminar(id);
    }

    @RequestMapping(value = "api/buscar")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("JONATHAN");
        usuario.setApellido("SANCHEZ");
        usuario.setEmail("jonulisanpar@gmail.com");
        usuario.setTelefono("4773669966");
        return usuario;
    }
}

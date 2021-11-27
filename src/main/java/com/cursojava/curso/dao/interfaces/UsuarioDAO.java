package com.cursojava.curso.dao.interfaces;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDAO {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);
}

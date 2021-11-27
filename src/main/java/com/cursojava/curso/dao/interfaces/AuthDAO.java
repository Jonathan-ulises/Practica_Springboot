package com.cursojava.curso.dao.interfaces;

import com.cursojava.curso.models.Usuario;

public interface AuthDAO {

    boolean verificarCredenciales(Usuario usuario);
}

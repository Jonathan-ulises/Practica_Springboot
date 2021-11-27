package com.cursojava.curso.dao;

import com.cursojava.curso.dao.interfaces.AuthDAO;
import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthDAOImp implements AuthDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        System.out.println(usuario);
        String query = "FROM Usuario WHERE email = :email AND pass_word = :pass_word";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .setParameter("pass_word", usuario.getPassword())
                .getResultList();

        return !lista.isEmpty();
    }
}

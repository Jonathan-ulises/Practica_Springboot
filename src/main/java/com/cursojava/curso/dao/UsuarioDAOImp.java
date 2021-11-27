package com.cursojava.curso.dao;

import com.cursojava.curso.dao.interfaces.UsuarioDAO;
import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
Hace referencia a la conexion con la base de datos.
Poder acceder a repositorio de la base de datos
 */
@Repository

/*
@Transactional
* Da la posiblidad de esta clase de realizar las consutlas a la base de datos.
la forma en como va a construir y ejecucion las consultas a BD
*/
@Transactional
public class UsuarioDAOImp implements UsuarioDAO {

    @PersistenceContext
    EntityManager entityManager; //Sirve para hacer la conexion con la BD

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        /*
        Consulta a la base de datos y retorno de la lista de resultados
         */
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        //BUSCAR EL USUARIO
        Usuario usuario = entityManager.find(Usuario.class, id);
        //ELIMINA EL USUARIO
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
}

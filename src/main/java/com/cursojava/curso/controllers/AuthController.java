package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.interfaces.AuthDAO;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthDAO authDAO;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        if (authDAO.verificarCredenciales(usuario)) {
            return "OK";
        }
        return "FAIL";
    }
}

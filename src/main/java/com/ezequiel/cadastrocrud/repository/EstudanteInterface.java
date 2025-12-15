package com.ezequiel.cadastrocrud.repository;

import com.ezequiel.cadastrocrud.domain.User;

import java.util.List;

public interface EstudanteInterface {

     void buscarId(long id);

     List<User> buscarTodos();

     void inserir(User user);

     void deletar(long id);
}

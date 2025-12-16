package com.ezequiel.cadastrocrud.repository;

import com.ezequiel.cadastrocrud.domain.User;

import java.util.List;

public interface UserInterface {

     void buscarId(long id);

     List<User> buscarTodos();

     void inserir(User user);

     void deletar(long id);

     void editar(User user, long id);
}

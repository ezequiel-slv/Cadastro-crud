package com.ezequiel.cadastrocrud.repository;

import com.ezequiel.cadastrocrud.domain.Estudante;

import java.util.List;

public interface EstudanteInterface {

     void buscarId(long id);

     List<Estudante> buscarTodos();

     void inserir(Estudante estudante);

     void deletar(long id);
}

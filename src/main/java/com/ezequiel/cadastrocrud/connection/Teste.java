package com.ezequiel.cadastrocrud.connection;

import com.ezequiel.cadastrocrud.domain.User;
import com.ezequiel.cadastrocrud.service.EstudanteService;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    static void main(String[] args) {

        User user = new User();
        user.setNome("Ezequiel");
        user.setSexo("M");
        user.setIdade(23);

        EstudanteService es = new EstudanteService();
        es.inserir(user);

        System.out.println("-----");

        EstudanteService es2 = new EstudanteService();
        List<User> users = new ArrayList<>();

        users = es2.buscarTodos();

        for (int i = 0; i < users.size(); i++) {

            System.out.println("Id: " + users.get(i).getId());
            System.out.println("Nome: " + users.get(i).getNome());
            System.out.println("Idade: " + users.get(i).getIdade());
            System.out.println("Sexo: " + users.get(i).getSexo());

        }

    }
}

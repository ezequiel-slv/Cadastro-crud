package com.ezequiel.cadastrocrud.connection;

import com.ezequiel.cadastrocrud.domain.User;
import com.ezequiel.cadastrocrud.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    static void main(String[] args) {

        User user = new User();
        user.setNome("Ezequiel");
        user.setSexo("M");
        user.setIdade(23);
        user.setId(1);

        User user2 = new User();
        user2.setNome("Julia");
        user2.setSexo("Feminino");
        user2.setIdade(23);
        user2.setId(2);

        UserService es = new UserService();
//        es.inserir(user);
//        es.inserir(user2);

//        user.setSexo("Masculino");
//        es.editar(user, 1);

//        System.out.println("-----");

//        UserService es2 = new UserService();
//        List<User> users = new ArrayList<>();
//
//        users = es2.buscarTodos();
//
//        for (int i = 0; i < users.size(); i++) {
//
//            System.out.println("Id: " + users.get(i).getId());
//            System.out.println("Nome: " + users.get(i).getNome());
//            System.out.println("Idade: " + users.get(i).getIdade());
//            System.out.println("Sexo: " + users.get(i).getSexo());
//
//        }


//        UserService us4 = new UserService();
//        User user4 = new User();
//
//        user4 = us4.buscarId(13);
//
//        System.out.println("nome: " + user4.getNome());
//        System.out.println("idade: " + user4.getIdade());

        UserService us5 = new UserService();
        us5.deletar(2);

    }
}

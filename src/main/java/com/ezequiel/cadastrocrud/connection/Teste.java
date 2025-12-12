package com.ezequiel.cadastrocrud.connection;

import com.ezequiel.cadastrocrud.domain.Estudante;
import com.ezequiel.cadastrocrud.service.EstudanteService;

public class Teste {
    static void main(String[] args) {

        Estudante estudante = new Estudante();
        estudante.setNome("Ezequiel");
        estudante.setIdade(23);
        estudante.setSexo("M");

        EstudanteService es = new EstudanteService();
        es.inserir(estudante);
    }
}

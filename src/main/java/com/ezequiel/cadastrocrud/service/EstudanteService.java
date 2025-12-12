package com.ezequiel.cadastrocrud.service;

import com.ezequiel.cadastrocrud.connection.ConnectionBD;
import com.ezequiel.cadastrocrud.domain.Estudante;
import com.ezequiel.cadastrocrud.repository.EstudanteInterface;

import java.sql.PreparedStatement;
import java.util.List;

public class EstudanteService implements EstudanteInterface {
    @Override
    public void buscarId(long id) {

    }

    @Override
    public List<Estudante> buscarTodos() {
        return List.of();
    }

    @Override
    public void inserir(Estudante estudante) {

        try {

            String sql = "INSERT INTO estudante(nome, sexo, idade) VALUES(?, ?, ?)";
            PreparedStatement ps = ConnectionBD.connectonDB().prepareStatement(sql);

            ps.setString(1, estudante.getNome());
            ps.setString(2, estudante.getSexo());
            ps.setInt(3, estudante.getIdade());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }

    }

    @Override
    public void deletar(long id) {

    }
}

package com.ezequiel.cadastrocrud.service;

import com.ezequiel.cadastrocrud.connection.ConnectionBD;
import com.ezequiel.cadastrocrud.domain.User;
import com.ezequiel.cadastrocrud.repository.UserInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface {
    @Override
    public void editar(User user, long id) {
        try{
            String sql = "UPDATE estudante SET nome=?, idade=?, sexo=?";
            PreparedStatement ps = ConnectionBD.connectonDB().prepareStatement(sql);

            ps.setString(1, user.getNome());
            ps.setInt(2, user.getIdade());
            ps.setString(3, user.getSexo());

            ps.executeUpdate();

        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public User buscarId(long id) {
        User user = null;

        try{

            String sql = "SELECT * from estudante where id=?";

            PreparedStatement ps = ConnectionBD.connectonDB().prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                user = new User();

                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setIdade(rs.getInt("idade"));
                user.setSexo(rs.getString("sexo"));

            }

        }catch (Exception e){

            System.out.println("Erro: " + e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> buscarTodos() {
        List<User> users = new ArrayList<>();

        try{

            ResultSet rs = null;

            String sql = "SELECT * from estudante";

            PreparedStatement ps = ConnectionBD.connectonDB().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){

                User user = new User();

                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setSexo(rs.getString("sexo"));
                user.setIdade(rs.getInt("idade"));

                users.add(user);
            }

        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

        return users;
    }

    @Override
    public void inserir(User user) {

        try {
            String sql = "INSERT INTO estudante(nome, sexo, idade) VALUES(?, ?, ?)";
            PreparedStatement ps = ConnectionBD.connectonDB().prepareStatement(sql);

            ps.setString(1, user.getNome());
            ps.setString(2, user.getSexo());
            ps.setInt(3, user.getIdade());
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

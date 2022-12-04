package org.implementation.gateways;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class OwnerGateway {

    public LinkedList<String> find(int id){
        LinkedList<String> data = new LinkedList<>();

        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement("SELECT `name` FROM `testdb`.`owner` WHERE `owner_id` = ?")){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){

                if(resultSet.next()) {
                    // Menu
                    String name = resultSet.getString(1);
                    data.add(String.valueOf(id));
                    data.add(name);
                }
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void create(int id, String name){

    }

    public void update(int id, String name){

    }

    public void delete(int id){

    }
}

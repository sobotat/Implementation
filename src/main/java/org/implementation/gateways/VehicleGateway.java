package org.implementation.gateways;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VehicleGateway {

    public LinkedList<String> find(int id){
        LinkedList<String> data = new LinkedList<>();

        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement("SELECT `name`, `km`, `owner`, `type`, `carry_weight`, `category` FROM `testdb`.`vehicle` WHERE `vehicle_id` = ?")){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){

                if(resultSet.next()) {
                    // Menu
                    String name = resultSet.getString(1);
                    String km = resultSet.getString(2);
                    String ownerId = resultSet.getString(3);
                    String type = resultSet.getString(4);
                    String carryWeight = resultSet.getString(5);
                    String category = resultSet.getString(6);

                    data.add(String.valueOf(id));
                    data.add(name);
                    data.add(km);
                    data.add(ownerId);
                    data.add(type);
                    data.add(carryWeight);
                    data.add(category);
                }
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void create(int id, String name, int km, int ownerId, Integer carryWeight, String category){

    }

    public void update(int id, String name, int km, int ownerId, Integer carryWeight, String category){

    }

    public void delete(int id){

    }
}

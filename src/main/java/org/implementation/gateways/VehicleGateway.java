package org.implementation.gateways;

import java.sql.*;
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

    public int create(int id, String name, double km, int ownerId, String type, Integer carryWeight, String category){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("INSERT INTO `testdb`.`vehicle` ( `name`, `km`, `owner`, `type`, `carry_weight`, `category`) VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString( 1, name);
            preparedStatement.setDouble( 2, km);
            preparedStatement.setInt(3, ownerId);
            preparedStatement.setString( 4, type);
            if(carryWeight == null)
                preparedStatement.setNull(5, Types.INTEGER);
            else
                preparedStatement.setInt( 5, carryWeight);
            preparedStatement.setString( 6, category);

            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){

                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }
                preparedStatement.close();
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void update(int id, String name, double km, int ownerId, String type, Integer carryWeight, String category){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("UPDATE `testdb`.`vehicle` SET `name` = ?, `km` = ?, `owner` = ?, `type` = ?, `carry_weight` = ?, `category` = ? WHERE `vehicle_id` = ?;")){
            preparedStatement.setString( 1, name);
            preparedStatement.setDouble( 2, km);
            preparedStatement.setInt(3, ownerId);
            preparedStatement.setString( 4, type);
            if(carryWeight == null)
                preparedStatement.setNull(5, Types.INTEGER);
            else
                preparedStatement.setInt( 5, carryWeight);
            preparedStatement.setString( 6, category);
            preparedStatement.setInt(7, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("DELETE FROM `testdb`.`vehicle` WHERE `vehicle_id` = ?")){
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

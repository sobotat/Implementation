package gateways;

import java.sql.*;
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

    public int create(int id, String name){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("INSERT INTO `testdb`.`owner` ( `name`) VALUES (?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString( 1, name);

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

    public void update(int id, String name){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("UPDATE `testdb`.`owner` SET `name` = ? WHERE `owner_id` = ?;")){
            preparedStatement.setString( 1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("DELETE FROM `testdb`.`owner` WHERE `owner_id` = ?")){
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

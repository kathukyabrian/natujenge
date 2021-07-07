package tech.kitucode.demo.repository;

import tech.kitucode.demo.domain.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {

    public void save(String accountNumber, DataSource dataSource){
        String query = "INSERT INTO javademo.customers( account_number, token_amount) VALUES (?, ?);";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,accountNumber);

            statement.setDouble(2,0);

            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public double getBalance(String accountNumber, DataSource dataSource){
        String query = "SELECT token_amount FROM javademo.customers WHERE account_number = ?;";

        double tokenAmount = 0.0;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,accountNumber);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                tokenAmount = resultSet.getDouble(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return tokenAmount;
    }
}

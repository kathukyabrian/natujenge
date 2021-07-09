package tech.kitucode.demo.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
    private final Logger logger = LogManager.getLogger(CustomerRepository.class);

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

            while (resultSet.next()){
                tokenAmount = resultSet.getDouble(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            return tokenAmount;
        }
    }

    public void updateBalance(String accountNumber, double amount, DataSource dataSource, double unitCost){

        String query = "UPDATE javademo.customers set token_amount = ? where account_number = ?;";

        double currentBalance = getBalance(accountNumber, dataSource);

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1, currentBalance + amount/unitCost);

            preparedStatement.setString(2,accountNumber);

            System.out.println(preparedStatement.toString());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

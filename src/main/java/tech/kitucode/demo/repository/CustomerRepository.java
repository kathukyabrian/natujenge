package tech.kitucode.demo.repository;

import tech.kitucode.demo.domain.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {

    public void save(String accountNumber, DataSource dataSource){
        String query = "INSERT INTO javademo.customers( account_number, token_amount) VALUES (?, ?);";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,accountNumber);

            statement.setDouble(2,0);

            System.out.println(statement.toString());

            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

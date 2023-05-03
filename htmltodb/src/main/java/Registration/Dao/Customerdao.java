package Registration.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Registration.module.Customer;


public class Customerdao {
	
	


	    public int registerCustomer(Customer customer) throws ClassNotFoundException {
	    	System.out.println("printdao");
	    	String INSERT_USERS_SQL = "INSERT INTO hostel" +
	            "  (Id,name, phno,adress,joindate,aadharnum) VALUES " +
	            " (?, ?, ?, ?, ?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/joiners?useSSL=false", "root", "Sairam@123");
	        	
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	           // preparedStatement.setInt(1, 1);
	            preparedStatement.setString(1, customer.getId());
	            preparedStatement.setString(2, customer.getName());
	            preparedStatement.setString(3, customer.getPhno());
	            preparedStatement.setString(4, customer.getAdress());
	            preparedStatement.setString(5, customer.getJoindate());
	            preparedStatement.setString(6, customer.getAadharnum());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}


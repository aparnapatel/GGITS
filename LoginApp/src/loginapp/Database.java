package loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Database {

	
	//Constants
	String DB_NAME="jdbc:mysql://localhost/ggits";
	String DB_USER="root";
	String DB_PASS="ggits";
	public String register(String user, String pass) {
		// TODO Auto-generated method stub
		String result="";
		
		//Database Connectivity
		try {
			//Create a Connection
		Connection con = (Connection) DriverManager.getConnection(DB_NAME, DB_USER,DB_PASS);
			//create statement
			java.sql.Statement st=con.createStatement();
			
			//create and excute query
			String query="Insert into login(user,pass)Values"+"('" +user + "', '" + pass +"')";
			  System.out.println(query);
			//Execute the query
			int rowAffected=st.executeUpdate(query);
			
			//Check if the execution is successfull
			if(rowAffected>0){
				result="Insert Success";
			
			}
			else{
				result="Insert Failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	public String Login(String user, String pass) {
		// TODO Auto-generated method stub
		String result="Login Failed";
		
		//get the database connection
		try{
			Connection con=(Connection)DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
			//create a statement 
			java.sql.Statement st=con.createStatement();
			//create query
			String query="SELECT user from login where user='"+user +"' and pass='"+pass +"'";
			//execute query
			ResultSet rs=st.executeQuery(query);
			System.out.println(result);
			//read result
			while(rs.next()){
				String c_user=rs.getString("user");
				if(c_user.matches(user))
				{
					result="Login Success";
				}
				else{
					result="Login Failed";
				}
			}
		}
		catch(SQLException e){
			//TOO Auto-generated catch b;lock 
			e.printStackTrace();
		}
		return result;
	
	}
}


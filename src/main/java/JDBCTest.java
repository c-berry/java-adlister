import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

//this class does it all =>
public class JDBCTest {
    //Test of Java Database Connectivity
    //going to need connection object, statement object and resultset object

    private static List<String> getAuthorNames() {

        List<String> authorNames = new ArrayList<>();
        try {
            Config config = new Config();
            //import driver into app
            DriverManager.registerDriver(new Driver());
            //create connection object
            Connection connection = DriverManager.getConnection(
                    config.getURL(),
                    config.getUser(),
                    config.getPassword()
            );
            //create statement object
            Statement statement = connection.createStatement();
            //execute statement and get results
            ResultSet resultSet = statement.executeQuery(
                    "SELECT author_name FROM  codeup_test_db.authors"
            );
            //loop through column
            while (resultSet.next()){
                authorNames.add(resultSet.getString("author_name"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return authorNames;
    }

    //output =>
    public static void main(String[] args) {
        List<String> authorNames = getAuthorNames();
        for (String name : authorNames){
            System.out.println(name);
        }
    }
} //end

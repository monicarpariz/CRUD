 
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Persistence {

    private static final String username = "root";
    private static final String password = "root";
    private static final String instance = "crud_java";
    private static final String database = "jdbc:mysql://localhost:3306/"+instance+"?useSSL=false";
    
    public static Connection createConnectionToMySql() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(database, username, password);
        return conn;
    }
    
    public static void main(String[] args) throws Exception{
        Connection conn = createConnectionToMySql();
        if (conn != null) {
            System.out.println("Conexao com banco de dados OK!");
            conn.close();
        }
    }  
}

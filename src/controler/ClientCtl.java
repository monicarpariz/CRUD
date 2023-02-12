
package controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import persistence.Persistence;
import model.ClientMdl;

public class ClientCtl { 

    public Boolean insert(ClientMdl client) {
        String sql = " INSERT INTO cliente (nome,idade) VALUES (?, ?) ";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try{
            conn = Persistence.createConnectionToMySql();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, client.getNome());
            pstmt.setInt(2, client.getIdade());
            
            exec = pstmt.executeUpdate();
            
            if (exec > 0) {
                msg = true;
            } else {
                msg = false;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                
                if (conn != null) {
                    conn.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return msg;  
    }
    
    public List<ClientMdl> getAll() throws SQLException{
        String sql = " SELECT * FROM cliente ";
        
        List<ClientMdl> clientArray = new ArrayList<ClientMdl>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            conn = persistence.Persistence.createConnectionToMySql();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while (rset.next()) {
                ClientMdl client = new ClientMdl();
                client.setId(rset.getInt("id") );
                client.setNome(rset.getString("nome"));
                client.setIdade(rset.getInt("idade"));
                clientArray.add(client);
            }  
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (rset != null) {
                rset.close();
            }
        }
        return clientArray;
    }
    
    public Boolean update(int id, String nome, int idade) throws Exception{
        String sql = " UPDATE cliente SET nome = ?, idade = ? WHERE id = ? ";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try{
            conn = persistence.Persistence.createConnectionToMySql();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setInt(2, idade);
            pstmt.setInt(3, id);
        
            exec = pstmt.executeUpdate();
            
            if (exec > 0) {
                msg = true;
            } else {
                msg = false;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn!= null) {
                conn.close();
            }
            if (pstmt!= null) {
                pstmt.close();
            }  
        }
        return msg;
    }
    
    public Boolean delete(int id) throws Exception{
        String sql = " DELETE FROM cliente WHERE id = ? ";
    
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try {
            conn = persistence.Persistence.createConnectionToMySql();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            exec = pstmt.executeUpdate();
            
            if (exec > 0) {
                msg = true;
            } else {
                msg = false;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn!= null) {
                conn.close();
            }
            if (pstmt!= null) {
                pstmt.close();
            }
        }
        return msg;
    }
}

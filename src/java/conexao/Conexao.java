/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author lcluc
 */
public class Conexao {
    
    private Connection conn;
    
    public void conectar()
    {
        System.out.println("Conectando ao banco");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "palmeiras");
            System.out.println("conectado");
        }catch(ClassNotFoundException e)
        {
            System.out.println("Classe nao encontrada adicione o drive as bibliotecas");
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    public Connection getConnection()
    {
        conectar();
        
        return conn;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class clsConexion {
     private  static  Connection cnx=null;
    private  static  Connection cnxSql=null;
    
    
    public Connection getConnection(){
        try {
                  
            //conexion SQL;
            SQLServerDataSource dsSql=new SQLServerDataSource();
            
            dsSql.setServerName("localhost");
            dsSql.setInstanceName("MSSQLSERVER");
            dsSql.setPortNumber(1433);
            dsSql.setDatabaseName("BD_Guimer3");
            cnx=dsSql.getConnection("sa","upt");
   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error","prueba", 2);
        }
        return cnx;
    }
    
}

package br.com.sgiv.dal;

import java.sql.*;

public class ModuloConexao {
    
    public static Connection conectar()throws SQLException{
        String url="jdbc:mysql://@monorail.proxy.rlwy.net:57293/railway";
        String user = "root";
        String senha = "2g4e12DbDgebf3degded12daaf5CDdeH";
        Connection conexao = null;
        
        conexao = DriverManager.getConnection(url,user,senha);
        return conexao;
    }
}

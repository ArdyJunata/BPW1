/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lab330-32
 */
public class AksesJdbcOdbc {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    private final String dsn = "jdbc:mysql://localhost:3306/db_ardybpw";
    private final String login = "root";
    private final String pwd = "";

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dsn, login, pwd);
        stmt = conn.createStatement();
        return conn;
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void disconnect() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public Statement getStatement() {
        return stmt;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        ps = conn.prepareStatement(query);
        return ps;
    }
}

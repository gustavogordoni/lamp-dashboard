/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dao;
import java.sql.*;

/**
 *
 * @author gustavo
 */
public class MySQLUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void verificarAplicarRoot() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT plugin FROM mysql.user WHERE user='root' AND host='%'");
            if (rs.next()) {
                String plugin = rs.getString("plugin");
                if (!"mysql_native_password".equals(plugin)) {
                    stmt.execute("ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root'");
                    stmt.execute("ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root'");
                    stmt.execute("FLUSH PRIVILEGES");
                    System.out.println("ALTER USER aplicado com sucesso!");
                } else {
                    System.out.println("ALTER USER já aplicado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

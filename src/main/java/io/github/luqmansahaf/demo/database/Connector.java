package io.github.luqmansahaf.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component
public class Connector {
    private static Connection conn;

    static {
        try {
            String url = "jdbc:h2:mem:testdb";
            conn = DriverManager.getConnection(url,"sa","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    @PreDestroy
    public void destroy() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

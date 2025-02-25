package com.example.todo.domain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

@WebServlet("/HealthCheck")
public class HealthCheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        try {

            BasicDataSource a = ApplicationContextHolder.getBean("dataSource", BasicDataSource.class);

            try (Connection conn = a.getConnection();
                    PreparedStatement stat = conn.prepareStatement("select 1")) {
                stat.executeQuery();
            }
            resp.setStatus(200);

        } catch (Exception e) {
            resp.setStatus(503);
        }
    }
}

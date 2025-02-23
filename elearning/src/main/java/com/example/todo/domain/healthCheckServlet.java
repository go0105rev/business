package com.example.todo.domain;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HealthCheck")
public class healthCheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
//            BasicDataSource a = (BasicDataSource)ApplicationContext.getBean("dataSource",BasicDataSource.class);
    }
}

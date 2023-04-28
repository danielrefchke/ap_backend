package com.ap_backend.apirest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() throws RuntimeException {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT 1");
            return "OK";
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleException(RuntimeException e) {}
}

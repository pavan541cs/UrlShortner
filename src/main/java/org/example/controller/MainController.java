package org.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }
    @GetMapping("/{id}")
    public void redirect(@PathVariable("id") String shortUrl,
                                           HttpServletResponse response) throws IOException {
        response.sendRedirect(mainService.redirect(shortUrl));
    }
}
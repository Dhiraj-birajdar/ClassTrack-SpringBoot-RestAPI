package edu.classtrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Welcome to ClassTrack</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; }" +
                ".container { max-width: 800px; margin: auto; padding: 20px; }" +
                "h1 { color: #333; }" +
                "h2 { color: #555; }" +
                "ul { list-style-type: none; padding: 0; }" +
                "li { margin: 10px 0; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Welcome to ClassTrack</h1>" +
                "<p>ClassTrack is a college management system that helps you manage your college activities.</p>" +
                "<p>It is a secure system that allows you to manage your college activities with ease.</p>" +
                "<h2>Features</h2>" +
                "<ul>" +
                "<li>Manage courses</li>" +
                "<li>Manage subjects</li>" +
                "<li>Manage faculty</li>" +
                "<li>Manage students</li>" +
                "<li>Manage class schedules</li>" +
                "<li>Manage faculty attendances</li>" +
                "</ul>" +
                "<h2>Roles</h2>" +
                "<ul>" +
                "<li><strong>ADMIN:</strong> Access to the whole system</li>" +
                "<li><strong>FACULTY:</strong> Can manage faculty attendances, class schedules, and courses</li>" +
                "<li><strong>STUDENT:</strong> Can view courses and subjects</li>" +
                "</ul>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}

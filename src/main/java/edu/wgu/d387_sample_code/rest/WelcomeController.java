package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@CrossOrigin
public class WelcomeController {

    @GetMapping("/welcome")
    public String getWelcomeMessage() {

        Locale enLocale = Locale.CANADA;
        Locale frLocale = Locale.CANADA_FRENCH;

        ResourceBundle message = ResourceBundle.getBundle("D387_sample_code", frLocale);

        return message.getString("welcome");
    }
}

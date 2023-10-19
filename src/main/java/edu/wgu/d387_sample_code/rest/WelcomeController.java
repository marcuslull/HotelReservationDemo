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

        WelcomeRunnable runnable1 = new WelcomeRunnable(enLocale);
        WelcomeRunnable runnable2 = new WelcomeRunnable(frLocale);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()) {
            // wait for both threads to complete
        }
        return thread1.getName() + ": " + runnable1.getWelcomeMessage() + " " + thread2.getName() + ": " + runnable2.getWelcomeMessage();
    }

    public static class WelcomeRunnable implements Runnable {

        Locale currentLocale;
        String welcomeMessage;

        public WelcomeRunnable(Locale currentLocale) {
            this.currentLocale = currentLocale;
        }

        public String getWelcomeMessage() {
            return welcomeMessage;
        }

        @Override
        public void run() {
            ResourceBundle message = ResourceBundle.getBundle("D387_sample_code", currentLocale);
            welcomeMessage = message.getString("welcome");
        }
    }
}


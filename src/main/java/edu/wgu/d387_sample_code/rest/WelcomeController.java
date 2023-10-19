package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@CrossOrigin
public class WelcomeController {

    @GetMapping("/presentation")
    public String[] getPresentationTime() {

        String[] presentationTimes = new String[3];

        // fictitious presentation time
        LocalDateTime localDateTime = LocalDateTime.of(2023,11,01,13,30);
        // setting local zone to US/pacific to illustrate zone differences
        ZoneId zoneId = ZoneId.of("US/Pacific");

        ZonedDateTime eastern = localDateTime.atZone(zoneId).withZoneSameInstant(ZoneId.of("US/Eastern"));
        ZonedDateTime mountain = localDateTime.atZone(zoneId).withZoneSameInstant(ZoneId.of("US/Mountain"));
        ZonedDateTime utc = localDateTime.atZone(zoneId).withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm z");

        presentationTimes[0] = eastern.format(dateTimeFormatter);
        presentationTimes[1] = mountain.format(dateTimeFormatter);
        presentationTimes[2] = utc.format(dateTimeFormatter);

        return presentationTimes;
    }

    @GetMapping("/welcome")
    public String[] getWelcomeMessage() {

        Locale enLocale = Locale.CANADA;
        Locale frLocale = Locale.CANADA_FRENCH;
        String[] welcomeMessages = new String[2];

        WelcomeRunnable runnable1 = new WelcomeRunnable(enLocale);
        WelcomeRunnable runnable2 = new WelcomeRunnable(frLocale);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()) {
            // wait for both threads to complete
        }
        welcomeMessages[0] = thread1.getName() + ": " + runnable1.getWelcomeMessage();
        welcomeMessages[1] = thread2.getName() + ": " + runnable2.getWelcomeMessage();
        return welcomeMessages;
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


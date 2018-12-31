package com.touraj.guavajava8;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class Java8Time {

    public static void main(String[] args) {
        System.out.println("Java 8 Date time ...");


        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
        System.out.println(legacyDate);

    }

}

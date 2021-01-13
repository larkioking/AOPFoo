package com.aopfoo;

import com.aopfoo.config.DemoConfig;
import com.aopfoo.dao.AccountDAO;
import com.aopfoo.dao.MembershipDAO;
import com.aopfoo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.logging.Logger;

public class DemoMain {
    private static Logger logger = Logger.getLogger(DemoMain.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain program!: @Around");
        logger.info("Calling getFortune()...");

        boolean TripWire = true;
        String data = fortuneService.getFortune(TripWire);

        logger.info("\nMy fortune is: " + data);
        logger.info("The end");

        context.close();
    }
}

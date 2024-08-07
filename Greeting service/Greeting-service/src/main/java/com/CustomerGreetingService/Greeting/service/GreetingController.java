package com.CustomerGreetingService.Greeting.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/shipturtle/employee")
public class GreetingController {

    //url = http://localhost:8081/shipturtle/employee/greetings?firstName=John&lastName=Doe
    @GetMapping("/greetings")
    public String getGreeting(@RequestParam String firstName, @RequestParam String lastName){
        LocalTime now= LocalTime.now();
        String greeting;

        if (now.isBefore(LocalTime.NOON)){
            greeting = "Good Morning";
        }else if (now.isBefore(LocalTime.of(18,0))){
            greeting = "Good Afternoon";
        }else{
            greeting = "Good Evening";
        }

        return String.format("%s %s %s",greeting,firstName,lastName);
    }
}

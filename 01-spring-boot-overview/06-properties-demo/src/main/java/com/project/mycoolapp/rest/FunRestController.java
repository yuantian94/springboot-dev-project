package com.project.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;


@RestController
public class FunRestController {

    // inject properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("teaminfo")
    public String getTeamInfo(){return "Coach: " + coachName + " , Team name: "+teamName;}
    // expose new endpoint for "teamname"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 4k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        ArrayList<String> fortuneList = new ArrayList<String>();
        fortuneList.add("上上签");
        fortuneList.add("中签");
        fortuneList.add("上签");
        fortuneList.add("下签");
        fortuneList.add("下下签");

        Random rn = new Random();
        int i = Math.abs(rn.nextInt())%5;
        return fortuneList.get(i);

    }
}

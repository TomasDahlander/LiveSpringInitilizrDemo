package com.example.demo.controllers;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 10:40 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "Hello world jao!";
    }

    @RequestMapping("/lucky")
    public String lucky(@RequestParam (defaultValue = "Orvar") String firstname,
                        @RequestParam (defaultValue = "Karlsson") String lastname){
        String animal = randomAnimal();
        int nr = randomNr();

        return "Hej " + firstname + " " + lastname + "! Ert favoritdjur är " + animal +
                " och er tursiffra är " + nr;
    }

    @RequestMapping("/random/{input}")
    public String getRandom(@PathVariable (required = false) String input){
        if(input.equalsIgnoreCase("animal")) return randomAnimal();
        else if(input.equalsIgnoreCase("number")) return randomNr()+"";
        else return "You need to enter either animal or number in the parameter to the site.";
    }

    @RequestMapping("/unlucky1")
    public String unlucky1(@RequestParam (required = false) List<String> l){
        while(true){
            boolean ok = true;
            String nr = randomNr()+"";
            for (String x:l){
                if(x.equals(nr)) {
                    ok = false;
                    break;
                }
            }
            if(ok) return "Ditt turnummer är: " + nr;
        }
    }

    @RequestMapping("/unlucky2")
    public String unlucky2(@RequestParam (required = false) List<String> l){ // ex    1,4,9
        List<String> okNr = new java.util.ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        for(int i = okNr.size()-1; i >= 0; i--){
            for(int j = l.size()-1; j >= 0; j--){
                if(l.get(j).equals(okNr.get(i))) okNr.remove(i);
            }
        }
        return "Your lucky numbers are then: " + okNr;
    }

    public int randomNr(){
        Random nr = new Random();
        return nr.nextInt(10)+1;
    }

    public String randomAnimal(){
        Random nr = new Random();
        String[] animals = {"Hund","Katt","Spindel","Skata"};
        int x = nr.nextInt(4);
        return animals[x];
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello " + name + " you old fuck";
    }

    @RequestMapping("/list")
    public String list(@RequestParam (required = false) List<String> item){
        return "<h2>I din lista finns följande:</h2> " +
                "<p>" + item + "</p>";
    }

    @RequestMapping("/counter")
    public String counter(@RequestParam (defaultValue = "Orvar Karlsson") String name){
        return "<html><body><h1>Counter</h1>" +
                "<h2>Hej " + name + "</h2>" +
                "<p id='count'>0</p>" +
                "<button id='btn' onclick='myFunction()'>Count</button>" +
                "<script>" +
                "let counter = 0;" +
                "function myFunction() {" +
                "counter++;" +
                "document.getElementById('count').innerHTML = counter;" +
                "}</script></body></html>";
    }

}

package org.launchcode.skills_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SkillsController {
    @GetMapping
    @ResponseBody
    public String renderHTML() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker" +
                "<h2>Lets learn some SKILLS!" +
                "<ol>" +
                "<li>Javascript" +
                "</li>" +
                "<li>Java" +
                "</li>" +
                "<li>C" +
                "</li>" +
                "</ol>" +
                "</h2>" +
                "</h1>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    @ResponseBody
    public String renderList() {
        return "<form method='post' action='/'>" +
                "<label>Name: " +
                "<input  type='text' name='name'/>" +
                "</label>" +
                "<br>" +
                "<label>Please select a format option: </label>" +
                "<select name='formatChoice' type='dropdown'>" +
                "<option value='table'>Table</option>" +
                "<option value='ordered list'>Ordered List</option>" +
                "</select>" +
                "<br>" +
                "<label>Please Select a language</label>" +
                "<br>" +
                "<label>My Favorite Language" +
                "<select type='dropdown' name='firstChoice'>" +
                "<option value='javascript'>Javascript" +
                "</option>" +
                "<option value='java'>Java" +
                "</option>" +
                "<option value='C'>C" +
                "</option>" +
                "</select>" +
                "</label>" +
                "<br>" +
                "<label>My Second Language" +
                "<select type='dropdown' name='secondChoice'>" +
                "<option value='Javascript'>Javascript" +
                "</option>" +
                "<option value='java'>Java" +
                "</option>" +
                "<option value='c'>C" +
                "</option>" +
                "</select>" +
                "</label>" +
                "<br>" +
                "<label>My Third Language" +
                "<select type='dropdown' name='thirdChoice'>" +
                "<option value='javascript'>Javascript" +
                "</option>" +
                "<option value='java'>Java" +
                "</option>" +
                "<option value='c'>C" +
                "</option>" +
                "</select>" +
                "</label>" +
                "<br>" +
                "<label> Click Submit: " +
                "<input type='submit'/>" +
                "</label>" +
                "</form>";
    }

    @PostMapping
    @ResponseBody
    public String formProcess(@RequestParam String name,
                              @RequestParam String firstChoice,
                              @RequestParam String secondChoice,
                              @RequestParam String thirdChoice){
        return "hello " + name + "<br>" +
                "1stChoice: " + firstChoice + "<br>" +
                "2nd Choice: " + secondChoice + "<br>" +
                "3rd Choice: " + thirdChoice;
    }


    @PostMapping("form")
    @ResponseBody
    public String choices(@RequestParam String name,
                          @RequestParam String formatChoice,
                          @RequestParam String firstChoice,
                          @RequestParam String secondChoice,
                          @RequestParam String thirdChoice) {
        if (formatChoice.equals("table")) {
            return "<html>" +
                    "<h1>" + name + "</h1>" +
                    "<table border='1'>" +
                    "<thead>" +
                    "<th>First Choice</th>" +
                    "<th>Second Choice</th>" +
                    "<th>Third Choice</th>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr>" +
                    "<td>" + firstChoice + "</td>" +
                    "<td>" + secondChoice + "</td>" +
                    "<td>" + thirdChoice + "</td>" +
                    "<tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</html>";
        } else if (formatChoice.equals("ordered list")) {
            return "<html>" +
                    "<body>" +
                    "<h1>" + name +
                    "</h1>" +
                    "<ol>" +
                    "<li>" + firstChoice +
                    "</li>" +
                    "<li>" + secondChoice +
                    "</li>" +
                    "<li>" + thirdChoice +
                    "</li>" +
                    "</ol>" +
                    "</body>" +
                    "<html>";
        }
        else {
            return "Wrong choice";
        }
    }
}




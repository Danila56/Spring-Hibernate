package com.controller;

import com.model.TimeEx;
import com.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@org.springframework.stereotype.Controller
public class Controller {
    private TimeService timeService;
    @Autowired(required = true)
    @Qualifier("timeService")
    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("time", new TimeEx());
        model.addAttribute("timeList", timeService.time());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(TimeEx timeEx, Model model){
        timeService.addTime(timeEx);
        model.addAttribute("timeList", timeService.time());
        return "index";
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String showTime(@ModelAttribute("time") TimeEx timeEx, Model model){
        model.addAttribute("time", timeEx.getTime());
        model.addAttribute("t", new TimeEx());
        timeService.addTime(timeEx);
        return "time";
    }

    @ModelAttribute("boxTimeList")
    public List<String> boxTime(){
        List<TimeEx> listTime = timeService.time();
        List<String> list = new ArrayList<String>();
        for (TimeEx t: listTime){
            list.add(String.valueOf(t.getTime()));
        }
        return list;
    }

    @ModelAttribute("downTimeList")
    public Map<String, String> getDownTimeList(){
        Map<String, String> map = new HashMap<>();
        List<TimeEx> list = timeService.time();
        for (TimeEx t: list){
            map.put(String.valueOf(t.getTime()), String.valueOf(t.getTime()));
        }
        return map;
    }

//    @RequestMapping(value = "/action", params = "add", method = RequestMethod.GET)
//    public String addTime(TimeEx timeEx){
//        timeService.addTime(timeEx);
//        return "redirect:/";
//    }
//    @RequestMapping(value = "/action", params = "delete", method = RequestMethod.GET)
//    public String deleteTime(@ModelAttribute("time") TimeEx timeEx){
//        timeService.deleteTime(timeEx);
//        return "redirect:/";
//    }
//    @RequestMapping(value = "/action", params = "update", method = RequestMethod.GET)
//    public String searchTime(@ModelAttribute("time") TimeEx timeEx){
//        timeService.searchTime(timeEx);
//        return "time";
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    public String updateTime(@ModelAttribute("time") TimeEx timeEx){
//        timeService.updateTime(timeEx);
//        return "redirect:/";
//    }
}
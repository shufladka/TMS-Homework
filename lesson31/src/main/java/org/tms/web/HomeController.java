package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tms.domain.Car;
import org.tms.service.CarService;

@RequiredArgsConstructor

@Controller
@RequestMapping("/home")
public class HomeController {

    private final CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCar(Car car) {
        //carService.save(car);
        return "home";
    }
}
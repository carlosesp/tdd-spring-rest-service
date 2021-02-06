package pe.carlosesp.demo.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.carlosesp.demo.tdd.domain.Car;
import pe.carlosesp.demo.tdd.exception.CarNotFoundException;
import pe.carlosesp.demo.tdd.service.CarService;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {

    }

}

package pe.carlosesp.demo.tdd.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.carlosesp.demo.tdd.domain.Car;
import pe.carlosesp.demo.tdd.exception.CarNotFoundException;
import pe.carlosesp.demo.tdd.repository.CarRepository;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}

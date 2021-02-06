package pe.carlosesp.demo.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.carlosesp.demo.tdd.domain.Car;
import pe.carlosesp.demo.tdd.exception.CarNotFoundException;
import pe.carlosesp.demo.tdd.repository.CarRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void getCarDetails_returnsCarInfo() throws Exception {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");

        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test
    void getCarDetails_whenCarNotFound() throws Exception {
        given(carRepository.findByName("prius")).willReturn(null);

        Assertions.assertThrows(CarNotFoundException.class, () ->
                carService.getCarDetails("prius"));
    }
}
package pe.carlosesp.demo.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pe.carlosesp.demo.tdd.domain.Car;
import pe.carlosesp.demo.tdd.repository.CarRepository;
import pe.carlosesp.demo.tdd.service.CarService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CachingTest {

    @Autowired
    private CarService service;

    @MockBean
    private CarRepository carRepository;

    @Test
    void caching() throws Exception {
        given(carRepository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));

        service.getCarDetails("prius");
        service.getCarDetails("prius");

        verify(carRepository, times(1)).findByName("prius");
    }

}

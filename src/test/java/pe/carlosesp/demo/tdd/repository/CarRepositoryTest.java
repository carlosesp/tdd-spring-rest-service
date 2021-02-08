package pe.carlosesp.demo.tdd.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pe.carlosesp.demo.tdd.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void getCar_returnsCarDetails() throws Exception {
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
        assertThat(savedCar.getId()).isNotNull();
        assertThat(savedCar.getId()).isEqualTo(car.getId());
    }
}
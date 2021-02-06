package pe.carlosesp.demo.tdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.carlosesp.demo.tdd.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByName(String name);
}

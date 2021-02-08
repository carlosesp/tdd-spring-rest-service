package pe.carlosesp.demo.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.carlosesp.demo.tdd.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByName(String name);
}

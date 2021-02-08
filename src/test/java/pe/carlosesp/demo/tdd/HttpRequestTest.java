package pe.carlosesp.demo.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.carlosesp.demo.tdd.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCar_returnsCarDetails() throws Exception {
        //arrange

        //act
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/volt", Car.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("volt");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }

}

# TDD Spring REST Service

Spring Boot project created with Outside-in TDD approach.

## Steps

- Integration level
  - **HttpRequestTest** with **TestRestTemplate**
  

- Controller level
  - **CarControllerTest** with **@WebMvcTest**, **MockMvc** and **@MockBean**
  

- Service level
  - **CarServiceTest** with **MockitoExtension**, **@Mock** and **@InjectMocks**
  

- Repository level
  - **CarRepositoryTest** with **@DataJpaTest**
  

- Caching
  - **CachingTest** with **@AutoConfigureTestDatabase**, **@AutoConfigureCache**, **@MockBean**
  

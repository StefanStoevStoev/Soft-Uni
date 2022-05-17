package bg.softuni.lection2.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnimalConfig {
    @Bean
    public Animal createCat(){
        return new Cat();
    }
    @Primary
    @Bean
    public Animal createDog(){
        return new Dog();
    }
}

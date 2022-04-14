package ru.javaops.voting;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.voting.repository.UserRepository;

@SpringBootApplication
public class RestaurantVotingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }
}

//@SpringBootApplication
//@AllArgsConstructor
//public class RestaurantVotingApplication implements ApplicationRunner {
//    private final UserRepository userRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(RestaurantVotingApplication.class, args);
//    }
//
//    @Override
//    public void run(ApplicationArguments args) {
//        System.out.println(userRepository.findAll());
//    }
//}
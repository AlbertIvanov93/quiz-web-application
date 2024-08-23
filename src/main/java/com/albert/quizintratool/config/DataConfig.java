package com.albert.quizintratool.config;

import com.albert.quizintratool.model.Role;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataConfig {

    @Bean
    public CommandLineRunner userLoader(UserRepository userRepository, PasswordEncoder encoder) {
        User hayrulin = new User("artur","Артур", "Хайрулин", encoder.encode("1234"), Role.USER);
        User admin = new User("admin","admin", "admin", encoder.encode("password"), Role.ADMIN);
        User test = new User("test","test", "test", encoder.encode("1234"), Role.USER);
        test.getRoles().add(Role.ADMIN);

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.save(hayrulin);
                userRepository.save(admin);
                userRepository.save(test);
            }
        };

    }
}

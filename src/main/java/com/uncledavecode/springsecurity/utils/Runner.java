package com.uncledavecode.springsecurity.utils;

import com.uncledavecode.springsecurity.model.entity.Authority;
import com.uncledavecode.springsecurity.model.entity.User;
import com.uncledavecode.springsecurity.model.enums.AuthorityName;
import com.uncledavecode.springsecurity.repositories.AuthorityRespository;
import com.uncledavecode.springsecurity.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    // Inyectar los repositorios
    private final UserRepository userRepository;
    private final AuthorityRespository authorityRespository;

    public Runner(UserRepository userRepository, AuthorityRespository authorityRespository) {
        this.userRepository = userRepository;
        this.authorityRespository = authorityRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.authorityRespository.count()==0){ //Si no hay autoridades en la base de datos crea las 3
            this.authorityRespository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }

        // Si no hay usuarios en la base de datos crea el usuario admin
        if(this.userRepository.count()==0){
            this.userRepository.saveAll(List.of(
                    new User("uncledave",new BCryptPasswordEncoder().encode("UncleDave123"),
                    List.of(
                            this.authorityRespository.findByName(AuthorityName.ADMIN).get())),
                    new User("user01","User01123",
                    List.of(
                            this.authorityRespository.findByName(AuthorityName.READ).get())),
                    new User("user02","User02123",
                    List.of(
                            this.authorityRespository.findByName(AuthorityName.WRITE).get()))
            ));
        }
    }
}

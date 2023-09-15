package com.uncledavecode.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(){ //un objeto de este tipo spring lo entiende como el admin de credenciales de usuario.
//        //para implementar la interfas necesita recibir un usuario
//        var user = User.withUsername("uncledave") //con esto ya creamos el userDetails
//                .password("pasword123")
//                .roles("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(user); //implementación de UserDetailsService
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){ //esto hace que ya no se generen las contraseñas sinó que toma el userdetails creado anteriormente.
        //return NoOpPasswordEncoder.getInstance(); //no apto para producción
        //esto permite retornar el usuario y contraseña codificado en base 64
        return new BCryptPasswordEncoder();
    }
}

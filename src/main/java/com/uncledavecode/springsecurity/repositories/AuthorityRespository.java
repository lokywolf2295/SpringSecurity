package com.uncledavecode.springsecurity.repositories;

import com.uncledavecode.springsecurity.model.entity.Authority;
import com.uncledavecode.springsecurity.model.enums.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRespository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(AuthorityName name); //Retorna una autoridad por su nombre
}

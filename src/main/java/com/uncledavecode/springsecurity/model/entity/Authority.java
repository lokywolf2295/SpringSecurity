package com.uncledavecode.springsecurity.model.entity;

import com.uncledavecode.springsecurity.model.enums.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    public Authority(AuthorityName authorityName){
        this.name = authorityName;
    }
}

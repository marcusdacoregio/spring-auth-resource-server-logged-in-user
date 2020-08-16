package com.marcusdacoregio.authserver.domain.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities implements GrantedAuthority {

    @EmbeddedId
    private AuthoritiesId id;

    @Column(name = "authority")
    private String authority;

    public AuthoritiesId getId() {
        return id;
    }

    public void setId(AuthoritiesId id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

package com.marcusdacoregio.authserver.persistence.repository;

import com.marcusdacoregio.authserver.domain.entity.Authorities;
import com.marcusdacoregio.authserver.domain.entity.AuthoritiesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId> {
}

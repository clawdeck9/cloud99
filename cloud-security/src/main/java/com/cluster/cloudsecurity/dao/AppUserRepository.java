package com.cluster.cloudsecurity.dao;

import com.cluster.cloudsecurity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public AppUser findAppUserByName(String name);

}

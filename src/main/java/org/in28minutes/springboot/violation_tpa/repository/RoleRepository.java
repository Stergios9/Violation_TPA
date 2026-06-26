package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findByName(String superAdmin);
}

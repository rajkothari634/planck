package com.lifegadget.planck.repositories.sql;

import com.lifegadget.planck.database.sqlModels.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

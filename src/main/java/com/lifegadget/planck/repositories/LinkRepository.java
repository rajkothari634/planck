package com.lifegadget.planck.repositories;

import com.lifegadget.planck.database.sqlModels.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository  extends JpaRepository<Link, Long> {

}

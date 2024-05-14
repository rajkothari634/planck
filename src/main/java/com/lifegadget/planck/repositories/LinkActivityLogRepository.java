package com.lifegadget.planck.repositories;

import com.lifegadget.planck.database.sqlModels.LinkActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkActivityLogRepository extends JpaRepository<LinkActivityLog, Long> {
}
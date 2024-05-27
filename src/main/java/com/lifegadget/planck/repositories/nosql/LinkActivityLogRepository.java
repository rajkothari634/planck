package com.lifegadget.planck.repositories.nosql;

import com.lifegadget.planck.database.noSQLModels.LinkActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkActivityLogRepository  extends MongoRepository<LinkActivityLog, String> {
}

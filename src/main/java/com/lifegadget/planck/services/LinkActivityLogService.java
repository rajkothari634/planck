package com.lifegadget.planck.services;

import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.database.noSQLModels.LinkActivityLog;
import com.lifegadget.planck.repositories.nosql.LinkActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkActivityLogService {

    @Autowired
    private LinkActivityLogRepository linkActivityLogRepository;

    public LinkActivityLog createLinkActivityLog(LinkActivityLog linkActivityLog){
        try{
            return linkActivityLogRepository.save(linkActivityLog);
        }catch (Exception e){
            throw new DatabaseException("error in creation of link activity log" + e.getMessage());
       }
    }
}

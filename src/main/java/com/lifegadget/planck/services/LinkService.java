package com.lifegadget.planck.services;

import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.core.lib.Helper;
import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private Helper helper;

    public Link createLink(Long link){
//        Link linkDb = linkRepository.save(link);
//        Long linkId = linkDb.getId();
        for(long i=0;i<10;i++){
            String tt = helper.createSortCode(i);
            System.out.println("number - " + i + " - code - " + tt);
            System.out.println("code - " + tt + " - number - " + helper.linkIdFromCode(tt));
        }
        throw new DatabaseException("dataabse error");

    }
}

package com.lifegadget.planck.services;


import com.lifegadget.planck.core.errors.ValidationException;
import com.lifegadget.planck.core.lib.Helper;
import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private Helper helper;

    public Link createLink(Link link){
        Link linkDb = linkRepository.save(link);
        Long linkId = linkDb.getId();
        String shortCode = helper.createSortCode(linkId);
        linkDb.setShortCode(shortCode);
        return linkRepository.save(linkDb);
    }
    public Link getLink(String shortCode){
        Long linkId = helper.linkIdFromCode(shortCode);
        Optional<Link> linkOptional = linkRepository.findById(linkId);
        if(linkOptional.isEmpty()){
            throw new ValidationException("short code not found");
        }
        return linkOptional.get();
    }
}

package org.example.repository;

import org.example.model.ShortLink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ShortLinkRepository extends CrudRepository<ShortLink, Integer> {
    @Query("SELECT sl FROM ShortLink sl WHERE sl.user.id = ?1")
    Collection<ShortLink> getAllLinksForUser(Integer userId);

    @Query("SELECT sl.originalUrl FROM ShortLink sl WHERE sl.shortUrl = ?1")
    String getOriginalUrlGivenShortLink(String shortLink);
}

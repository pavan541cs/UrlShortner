package org.example.service;

import org.example.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private ShortLinkRepository shortLinkRepository;

    @Autowired
    public MainService(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }

    public String redirect(String shortUrl) {
        return shortLinkRepository.getOriginalUrlGivenShortLink(shortUrl);
    }
}

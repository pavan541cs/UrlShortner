package org.example.service;

import org.example.model.CreateShortLinkRequest;
import org.example.model.ShortLink;
import org.example.repository.ShortLinkRepository;
import org.example.repository.UserRepository;
import org.example.utils.ShortLinkUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {
    private ShortLinkRepository shortLinkRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ShortLinkUtils shortLinkUtils;

    @Autowired
    public ShortLinkService(ShortLinkRepository shortLinkRepository, ModelMapper modelMapper,
                            ShortLinkUtils shortLinkUtils, UserRepository userRepository) {
        this.shortLinkRepository = shortLinkRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.shortLinkUtils = shortLinkUtils;
    }

    public Iterable<ShortLink> getAllLinksForUser(Integer userId) {
        return shortLinkRepository.getAllLinksForUser(userId);
    }

    public ShortLink createShortLink(CreateShortLinkRequest createShortLinkRequest) {
        ShortLink shortLink = modelMapper.map(createShortLinkRequest, ShortLink.class);
        shortLink.setOriginalUrl(createShortLinkRequest.getUrl());
        shortLink.setUser(userRepository.findById(createShortLinkRequest.getUserId()).get());
        shortLink.setShortUrl(shortLinkUtils.createShortLink(shortLink.getOriginalUrl()));
        shortLinkRepository.save(shortLink);
        return shortLink;
    }
}
package com.dandd.breshop.service.impl;

import com.dandd.breshop.entity.Wishlist;
import com.dandd.breshop.repository.WishlistRepository;
import com.dandd.breshop.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> readAll(UUID userId) {
        return wishlistRepository.findAllByUserIdOrderByCreatedDate(userId);
    }

    @Override
    public void delete(Wishlist wishlist) {
        wishlistRepository.delete(wishlist);
    }
}

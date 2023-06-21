package com.dandd.breshop.service;

import com.dandd.breshop.entity.Wishlist;

import java.util.List;
import java.util.UUID;

public interface WishlistService {
    Wishlist create(Wishlist wishlist);
    List<Wishlist> readAll(UUID userId);
    void delete(Wishlist wishlist);
}

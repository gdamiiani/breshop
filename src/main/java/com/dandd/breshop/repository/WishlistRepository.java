package com.dandd.breshop.repository;

import com.dandd.breshop.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {
    List<Wishlist> findAllByUserIdOrderByCreatedDate(UUID userId);
}

package com.dandd.breshop.dto;

import com.dandd.breshop.entity.Wishlist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDTO {
    private UUID itemId;
    private String itemName;
    private String itemImagePath;

    private UUID userId;
    private String userEmail;

    public static WishlistDTO map(Wishlist wishlist) {
        return WishlistDTO.builder()
                .itemId(wishlist.getItem().getId())
                .itemName(wishlist.getItem().getName())
                .itemImagePath(wishlist.getItem().getImagePath())
                .userId(wishlist.getUser().getId())
                .userEmail(wishlist.getUser().getEmail())
                .build();
    }
}

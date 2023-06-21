package com.dandd.breshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishlistId {
    private Item item;
    private User user;
}

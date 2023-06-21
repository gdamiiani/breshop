package com.dandd.breshop.entity;

import com.dandd.breshop.dto.ItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Item {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private Timestamp lastChange;
    @Column(nullable = false)
    private boolean available;

    private String imagePath;

    @ManyToOne @JoinColumn(nullable = false)
    private User seller;
    @ManyToOne
    private User buyer;

    public static Item map(ItemDTO itemDTO, User seller, User buyer) {
        return Item.builder()
                .name(itemDTO.getName())
                .description(itemDTO.getDescription())
                .category(itemDTO.getCategory())
                .price(itemDTO.getPrice())
                .lastChange(Timestamp.from(Instant.now()))
                .available(itemDTO.isAvailable())
                .seller(seller)
                .buyer(buyer)
                .build();
    }
}

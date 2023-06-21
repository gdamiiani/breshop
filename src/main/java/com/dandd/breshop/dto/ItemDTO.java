package com.dandd.breshop.dto;

import com.dandd.breshop.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private UUID id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Timestamp lastChange;
    private boolean available;
    private String imagePath;

    private UUID sellerId;
    private String sellerName;
    private String sellerEmail;
    private String sellerPhoneNumber;
    private String sellerCep;
    private String sellerNeighborhood;
    private String sellerCity;
    private String sellerUf;

    public static ItemDTO map(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .category(item.getCategory())
                .price(item.getPrice())
                .lastChange(item.getLastChange())
                .available(item.isAvailable())
                .imagePath(item.getImagePath())

                .sellerId(item.getSeller().getId())
                .sellerName(item.getSeller().getName())
                .sellerEmail(item.getSeller().getEmail())
                .sellerPhoneNumber(item.getSeller().getPhoneNumber())
                .sellerCep(item.getSeller().getCep())
                .sellerCity(item.getSeller().getCity())
                .sellerUf(item.getSeller().getUf())
                .build();
    }
}

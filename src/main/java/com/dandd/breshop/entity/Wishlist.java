package com.dandd.breshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlist {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne @JoinColumn(nullable = false)
    private Item item;
    @ManyToOne @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private Timestamp createdDate;
}

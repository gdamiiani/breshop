package com.dandd.breshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Rating {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private int stars;
}

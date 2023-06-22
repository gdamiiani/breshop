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
public class Category {
    @Id @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
}

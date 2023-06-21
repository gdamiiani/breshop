package com.dandd.breshop.repository;

import com.dandd.breshop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Page<Item> findAllByNameContainingAndCategoryContainingAllIgnoreCaseOrderByLastChangeDesc(String name, String category, Pageable pageable);
}

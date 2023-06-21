package com.dandd.breshop.service;

import com.dandd.breshop.dto.ItemDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ItemService {
    Optional<ItemDTO> create(ItemDTO request, String token);
    Page<ItemDTO> readAll(int page, String name, String category);
    Optional<ItemDTO> readOneById(UUID id);
    Optional<ItemDTO> update(UUID id, ItemDTO request, String token);
    void delete(UUID id, String token);
}

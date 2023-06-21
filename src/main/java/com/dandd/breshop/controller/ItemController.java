package com.dandd.breshop.controller;

import com.dandd.breshop.dto.ItemDTO;
import com.dandd.breshop.service.ItemService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Optional<ItemDTO>> create(
            @RequestBody ItemDTO request,
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(itemService.create(request, token));
    }

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String category
    ) {
        return ResponseEntity.ok(itemService.readAll(page, name, category));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemDTO>> findById(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity.ok(itemService.readOneById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ItemDTO>> update(
            @PathVariable UUID id,
            @RequestBody ItemDTO request,
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(itemService.update(id, request, token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable UUID id,
            @RequestHeader("Authorization") String token
    ) {
        itemService.delete(id, token);
        return ResponseEntity.noContent().build();
    }
}

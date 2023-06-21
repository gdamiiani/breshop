package com.dandd.breshop.service.impl;

import com.dandd.breshop.dto.ItemDTO;
import com.dandd.breshop.entity.Item;
import com.dandd.breshop.repository.ItemRepository;
import com.dandd.breshop.service.ItemService;
import com.dandd.breshop.repository.UserRepository;
import com.dandd.breshop.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final JWTService jwtService;

    @Override
    public Optional<ItemDTO> create(ItemDTO request, String token) {
        var sellerEmail = jwtService.extractUsername(token.substring(7));
        var findSeller = userRepository.findByEmail(sellerEmail);

        if (findSeller.isEmpty()) {
            return Optional.empty();
        }

        var seller = findSeller.get();

        request.setAvailable(true);

        var item = itemRepository.save(Item.map(request, seller, null));

        return Optional.of(ItemDTO.map(item));
    }

    @Override
    public Optional<ItemDTO> readOneById(UUID id) {
        var item = itemRepository.findById(id);

        return item.map(ItemDTO::map);
    }

    @Override
    public Page<ItemDTO> readAll(int page, String name, String category) {
        var findItems = itemRepository.findAllByNameContainingAndCategoryContainingAllIgnoreCaseOrderByLastChangeDesc(
                name, category, PageRequest.of(Math.max(0, page - 1), 4
        ));

        return findItems.map(ItemDTO::map);
    }

    @Override
    public Optional<ItemDTO> update(UUID id, ItemDTO request, String token) {
        var sellerEmail = jwtService.extractUsername(token.substring(7));
        var findSeller = userRepository.findByEmail(sellerEmail);
        var findItem = itemRepository.findById(id);

        if (findSeller.isEmpty() || findItem.isEmpty() ||
                !findItem.get().getSeller().equals(findSeller.get())
        ) {
            return Optional.empty();
        }

        var seller = findSeller.get();
        var item = itemRepository.save(Item.map(request, seller, null));

        return Optional.of(ItemDTO.map(item));
    }
    @Override
    public void delete(UUID id, String token) {
        var sellerEmail = jwtService.extractUsername(token.substring(7));
        var findSeller = userRepository.findByEmail(sellerEmail);
        var findItem = itemRepository.findById(id);

        if (findSeller.isEmpty() || findItem.isEmpty() ||
                !findItem.get().getSeller().equals(findSeller.get())
        ) {
            return;
        }

        itemRepository.deleteById(id);
    }
}

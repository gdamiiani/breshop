package com.dandd.breshop.config;

import com.dandd.breshop.entity.Item;
import com.dandd.breshop.repository.ItemRepository;
import com.dandd.breshop.utils.Role;
import com.dandd.breshop.entity.User;
import com.dandd.breshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public void initDatabase() {
        List<User> users = List.of(
                User.builder()
                        .name("Gustavo")
                        .email("gustavo@mail.com")
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build(),
                User.builder()
                        .name("Michael")
                        .email("michael@mail.com")
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build(),
                User.builder()
                        .name("Vinícius")
                        .email("vinicius@mail.com")
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build(),
                User.builder()
                        .name("John")
                        .email("john@mail.com")
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build(),
                User.builder()
                        .name("Carlos")
                        .email("carlos@mail.com")
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build()
        );

        userRepository.saveAll(users);

        List<Item> items = List.of(
                Item.builder()
                        .name("Camiseta")
                        .description("")
                        .category("1")
                        .price(BigDecimal.valueOf(100))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build(),
                Item.builder()
                        .name("Shorts")
                        .description("")
                        .category("2")
                        .price(BigDecimal.valueOf(10))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build(),
                Item.builder()
                        .name("Blusa de moletom")
                        .description("")
                        .category("1")
                        .price(BigDecimal.valueOf(50))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build(),
                Item.builder()
                        .name("Calça jeans")
                        .description("")
                        .category("2")
                        .price(BigDecimal.valueOf(90))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build(),
                Item.builder()
                        .name("Sapato")
                        .description("")
                        .category("3")
                        .price(BigDecimal.valueOf(200))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build(),
                Item.builder()
                        .name("Calça social")
                        .description("")
                        .category("2")
                        .price(BigDecimal.valueOf(150))
                        .lastChange(Timestamp.from(Instant.now()))
                        .available(true)
                        .seller(users.get(0))
                        .build()
        );

        itemRepository.saveAll(items);
    }
}

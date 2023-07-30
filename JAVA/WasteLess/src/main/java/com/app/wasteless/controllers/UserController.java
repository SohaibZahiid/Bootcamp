package com.app.wasteless.controllers;

import com.app.wasteless.models.Product;
import com.app.wasteless.models.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private JdbcTemplate jdbcTemplate;

    UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("stores")
    public List<User> getUsers() {
        final String q = "SELECT id, name, email, address FROM users";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(q);

        List<User> userList = new ArrayList<>();

        for (Map<String, Object> row : results) {
            User user = new User();
            user.setId(((Number) row.get("id")).longValue());
            user.setName((String) row.get("name"));
            user.setEmail((String) row.get("email"));
            user.setAddress((String) row.get("address"));
            userList.add(user);
        }

        return userList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("products")
    public List<Product> getProducts() {
        final String q = "SELECT p.id, p.user_id, p.name, p.description, p.quantity, p.price, u.name AS store_name, u.address AS store_address " +
                "FROM products p " +
                "JOIN users u ON p.user_id = u.id";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(q);

        List<Product> productList = new ArrayList<>();

        for (Map<String, Object> row : results) {
            Product product = new Product();
            product.setId(((Number) row.get("id")).longValue());
            product.setUser(((Number) row.get("user_id")).longValue());
            product.setFoodName((String) row.get("name"));
            product.setDescription((String) row.get("description"));
            product.setQuantity((int) row.get("quantity"));
            BigDecimal priceBigDecimal = (BigDecimal) row.get("price");
            product.setPrice(priceBigDecimal.doubleValue());
            product.setStoreName((String) row.get("store_name"));
            product.setStoreAddress((String) row.get("store_address"));
            productList.add(product);
        }

        return productList;
    }











    /*@GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        final String q = "SELECT * FROM Users WHERE user_id = ?";

        User user = jdbcTemplate.queryForObject(q, new BeanPropertyRowMapper<>(User.class), id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        final String addressQuery = "INSERT INTO UserAddresses (street_address, city, postal_code, country) " +
                "VALUES (?, ?, ?, ?)";

        final String userQuery = "INSERT INTO Users (username, email, password, user_type, address_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        KeyHolder addressKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(addressQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getAddress().getStreetAddress());
            ps.setString(2, user.getAddress().getCity());
            ps.setString(3, user.getAddress().getPostalCode());
            ps.setString(4, user.getAddress().getCountry());
            return ps;
        }, addressKeyHolder);

        int addressId = addressKeyHolder.getKey().intValue();

        int userInserted = jdbcTemplate.update(
                userQuery,
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getUserType(),
                addressId
        );

        if (userInserted == 1) {
            return ResponseEntity.ok("User registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed.");
        }
    }*/
}

package com.ecommerce.cart.repository;

import com.ecommerce.cart.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
}
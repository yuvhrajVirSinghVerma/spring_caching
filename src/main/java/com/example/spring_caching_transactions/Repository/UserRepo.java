package com.example.spring_caching_transactions.Repository;

import com.example.spring_caching_transactions.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}

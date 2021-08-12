package com.h2.demo.domain.repository;


import com.h2.demo.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
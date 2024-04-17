package com.walterverse.bankingApp.repository;

import com.walterverse.bankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


}

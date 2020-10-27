package com.pismo.paymentService.accounts;

import com.pismo.paymentService.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** The interface Account repository. */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {}

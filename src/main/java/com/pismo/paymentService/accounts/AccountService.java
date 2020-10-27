package com.pismo.paymentService.accounts;

import com.pismo.paymentService.accounts.api.NewAccountRequest;
import com.pismo.paymentService.accounts.domain.Account;

/** The interface Account service. */
public interface AccountService {
  /**
   * Create account account.
   *
   * @param request the request
   * @return the account
   */
  Account createAccount(NewAccountRequest request);

  /**
   * Gets account by id.
   *
   * @param accountId the account id
   * @return the account by id
   */
  Account getAccountById(Long accountId);
}

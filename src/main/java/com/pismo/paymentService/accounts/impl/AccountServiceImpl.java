package com.pismo.paymentService.accounts.impl;

import com.pismo.paymentService.accounts.AccountRepository;
import com.pismo.paymentService.accounts.AccountService;
import com.pismo.paymentService.accounts.api.NewAccountRequest;
import com.pismo.paymentService.accounts.domain.Account;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** The type Account service. */
@Service
public class AccountServiceImpl implements AccountService {
  private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
  private final AccountRepository accountRepository;

  /**
   * Instantiates a new Account service.
   *
   * @param accountRepository the account repository
   */
  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  /**
   * Create account account.
   *
   * @param request the request
   * @return the account
   */
  @Override
  public Account createAccount(NewAccountRequest request) {
    Account accountSaved = this.accountRepository.save(this.createNewAccount(request));
    log.debug("New account: {}, was saved successfully.", accountSaved);
    return accountSaved;
  }

  /**
   * Gets account by id.
   *
   * @param accountId the account id
   * @return the account by id
   */
  @Override
  public Account getAccountById(Long accountId) {
    log.debug("Getting account by id: {}", accountId);
    Optional<Account> optionalAccount = this.accountRepository.findById(accountId);
    if (optionalAccount.isEmpty()) {
      log.warn("Account with ID: {} not found.", accountId);
      throw new EntityNotFoundException();
    }
    return optionalAccount.get();
  }

  private Account createNewAccount(NewAccountRequest request) {
    log.debug("Creating new account from request: {}", request);
    Account account = new Account();
    account.setDocumentNumber(request.getDocumentNumber());
    return account;
  }


}

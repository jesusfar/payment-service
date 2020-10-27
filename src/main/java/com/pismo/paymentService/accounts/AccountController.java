package com.pismo.paymentService.accounts;

import com.pismo.paymentService.accounts.api.AccountResponse;
import com.pismo.paymentService.accounts.api.NewAccountRequest;
import com.pismo.paymentService.accounts.domain.Account;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The type Account controller. */
@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts", description = "Accounts domain")
public class AccountController {
  private final AccountService accountService;

  /**
   * Instantiates a new Account controller.
   *
   * @param accountService the account service
   */
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  /**
   * Create account response entity.
   *
   * @param request the request
   * @return the response entity
   */
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody NewAccountRequest request) {
    Account account = this.accountService.createAccount(request);
    return new ResponseEntity<>(this.toResponse(account), HttpStatus.CREATED);
  }

  /**
   * Gets account by id.
   *
   * @param accountId the account id
   * @return the account by id
   */
  @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long accountId) {
    Account account = this.accountService.getAccountById(accountId);
    return new ResponseEntity<>(this.toResponse(account), HttpStatus.OK);
  }

  private AccountResponse toResponse(Account account) {
    AccountResponse response = new AccountResponse();
    response.setAccountId(account.getAccountId());
    response.setDocumentNumber(account.getDocumentNumber());
    return response;
  }
}

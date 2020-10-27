package com.pismo.paymentService.accounts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pismo.paymentService.SpringContextIntegrationTest;
import com.pismo.paymentService.accounts.api.AccountResponse;
import com.pismo.paymentService.accounts.api.NewAccountRequest;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

class AccountControllerTest extends SpringContextIntegrationTest {
  @Test
  void createAccount() throws Exception {
    MvcResult mvcResult =
        super.mockMvc
            .perform(
                post("/accounts")
                    .content(generateNewAccount())
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isCreated())
            .andDo(print())
            .andReturn();
    AccountResponse accountResponse =
        super.objectMapper.readValue(
            mvcResult.getResponse().getContentAsString(), AccountResponse.class);
    Assertions.assertNotNull(accountResponse);
    Assertions.assertNotNull(accountResponse.getAccountId());
    Assertions.assertNotNull(accountResponse.getDocumentNumber());

    // Assert get by id
    Assertions.assertEquals(accountResponse, this.getAccountById(accountResponse.getAccountId()));
  }

  private AccountResponse getAccountById(Long accountId) throws Exception {
    MvcResult mvcResult =
        super.mockMvc
            .perform(get("/accounts/{accountId}", accountId))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn();
    return super.objectMapper.readValue(
        mvcResult.getResponse().getContentAsString(), AccountResponse.class);
  }

  private String generateNewAccount() throws JsonProcessingException {
    NewAccountRequest request = new NewAccountRequest();
    request.setDocumentNumber(UUID.randomUUID().toString());
    return super.objectMapper.writeValueAsString(request);
  }

  @Test
  void getAccountByIdNotFound() throws Exception {
    Long accountNotFound = 10000L;
    super.mockMvc
        .perform(get("/accounts/{accountId}", accountNotFound))
        .andExpect(status().isNotFound())
        .andDo(print());
  }
}

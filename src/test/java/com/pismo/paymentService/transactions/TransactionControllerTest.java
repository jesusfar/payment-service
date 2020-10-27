package com.pismo.paymentService.transactions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pismo.paymentService.SpringContextIntegrationTest;
import com.pismo.paymentService.transactions.api.NewTransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class TransactionControllerTest extends SpringContextIntegrationTest {

  @Test
  void createTransaction() throws Exception {
    super.mockMvc
        .perform(
            post("/transactions")
                .content(this.generateNewTransaction(1L, 1, 0.50))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated())
        .andDo(print())
        .andReturn();
  }

  @Test
  void createTransactionInvalidOperationBadRequest() throws Exception {
    // Test invalid operation type
    super.mockMvc
        .perform(
            post("/transactions")
                .content(this.generateNewTransaction(1L, 100, 2.5))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("error.invalid-operation-type"))
        .andDo(print());
  }

  @Test
  void createTransactionInvalidAccountBadRequest() throws Exception {
    // Test invalid operation type
    super.mockMvc
        .perform(
            post("/transactions")
                .content(this.generateNewTransaction(100L, 2, 2.5))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("error.invalid-account"))
        .andDo(print());
  }

  @Test
  void createTransactionInvalidAmountBadRequest() throws Exception {
    // Test invalid operation type
    super.mockMvc
        .perform(
            post("/transactions")
                .content(this.generateNewTransaction(1L, 2, 0.000))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("error.invalid-amount"))
        .andDo(print());
  }

  private String generateNewTransaction(Long accountId, Integer operationTypeId, Double amount) throws JsonProcessingException {
    NewTransactionRequest request = new NewTransactionRequest();
    request.setAccountId(accountId);
    request.setOperationTypeId(operationTypeId);
    request.setAmount(amount);
    return super.objectMapper.writeValueAsString(request);
  }
}

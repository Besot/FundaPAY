package com.besot.fundapay.service;

import com.besot.fundapay.dto.BankResponse;
import com.besot.fundapay.dto.UserRequest;

public interface UserService {
    BankResponse createUserAccount(UserRequest userRequest);
}

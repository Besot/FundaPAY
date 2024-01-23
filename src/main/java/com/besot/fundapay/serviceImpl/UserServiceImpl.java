package com.besot.fundapay.serviceImpl;

import com.besot.fundapay.dto.AccountInfo;
import com.besot.fundapay.dto.BankResponse;
import com.besot.fundapay.dto.UserRequest;
import com.besot.fundapay.model.User;
import com.besot.fundapay.repository.UserRepository;
import com.besot.fundapay.service.UserService;
import com.besot.fundapay.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BankResponse createUserAccount(UserRequest userRequest) {
    if (userRepository.existsByEmail(userRequest.getEmail())){
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                .accountInfo(null)
                .build();
    }
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .alternativePhoneNO(userRequest.getAlternativePhoneNO())
                .dateOfBirth(userRequest.getDateOfBirth())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .nationality(userRequest.getNationality())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .Status("Active")
                .build();
        User savedUser = userRepository.save(newUser);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountName(savedUser.getFirstName() + " " + savedUser.getOtherName() + " " + savedUser.getLastName())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountBalance(savedUser.getAccountBalance()).build()).build();
    }
}

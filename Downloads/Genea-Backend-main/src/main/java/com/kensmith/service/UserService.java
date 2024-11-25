package com.kensmith.service;

import com.kensmith.dto.request.ForgotPasswordRequest;
import com.kensmith.dto.request.LoginRequest;
import com.kensmith.dto.request.RegistrationRequestDto;
import com.kensmith.dto.request.ResetPasswordRequest;
import com.kensmith.dto.response.ApiResponse;
import com.kensmith.dto.response.LoginResponse;
import com.kensmith.dto.response.UserResponseDto;
import com.kensmith.exception.UserNotFoundException;

public interface UserService {
    ApiResponse<UserResponseDto> createCustomer(RegistrationRequestDto request) throws InterruptedException, UserNotFoundException;



    ApiResponse<String> verifyEmail(String confirmationToken);

    ApiResponse<String> resendVerificationToken(String email) throws InterruptedException;


    ApiResponse<String> forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws InterruptedException;

    ApiResponse<String> resetPassword( String confirmationToken, ResetPasswordRequest resetPasswordRequest);

    ApiResponse<String> createAdmin(RegistrationRequestDto registrationRequestDto) throws InterruptedException;

    ApiResponse<LoginResponse> loginUser(LoginRequest loginRequest) throws UserNotFoundException;
}

package com.kensmith.service.serviceImpl;

import com.kensmith.dto.request.AddressRequest;
import com.kensmith.dto.response.ApiResponse;
import com.kensmith.entity.Address;
import com.kensmith.entity.User;
import com.kensmith.exception.CustomException;
import com.kensmith.exception.UserNotFoundException;
import com.kensmith.repository.AddressRepository;
import com.kensmith.repository.UserRepository;
import com.kensmith.service.AddressService;
import com.kensmith.utils.LoggedInUserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final UserRepository userRepository;

    private final LoggedInUserUtils utils;
    private final AddressRepository addressRepository;

    private User getUser() {
        String loggedInUsername = utils.getLoggedInUser();
        if (loggedInUsername == null) {
            throw new CustomException("User not logged in");
        }
        return userRepository.findByEmail(loggedInUsername)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    @Override
    public String saveAddress(AddressRequest addressRequest) {
        User loggedInUser = getUser();
        Address existingAddress = loggedInUser.getAddress();

        if (existingAddress != null) {
            existingAddress.setAddressLine(addressRequest.getAddressLine());
            existingAddress.setCity(addressRequest.getCity());
            existingAddress.setState(addressRequest.getState());
            existingAddress.setPhoneNumber(addressRequest.getPhoneNumber());
            addressRepository.save(existingAddress);
            return "Address updated successfully";
        } else {
            Address newAddress = new Address();
            newAddress.setAddressLine(addressRequest.getAddressLine());
            newAddress.setCity(addressRequest.getCity());
            newAddress.setState(addressRequest.getState());
            newAddress.setPhoneNumber(addressRequest.getPhoneNumber());
            newAddress.setUser(loggedInUser);
            loggedInUser.setAddress(newAddress);
            addressRepository.save(newAddress);
            return "Address saved successfully";
        }
    }


    @Override
    public ApiResponse <String>deleteAddress(Long addressId) {
        if (addressId == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        Optional<Address> addressToDelete = addressRepository.findById(addressId);
        if (addressToDelete.isEmpty()) {

            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Address not found", null, HttpStatus.NOT_FOUND);
        }
        addressRepository.delete(addressToDelete.get());
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted", null, HttpStatus.OK);

    }



}



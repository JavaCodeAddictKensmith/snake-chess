package com.kensmith.controller;

import com.kensmith.dto.request.AddressRequest;
import com.kensmith.dto.response.ApiResponse;
import com.kensmith.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.saveAddress(addressRequest));
    }


    @PreAuthorize("hasRole('CUSTOMER')")
    @DeleteMapping("/deleteAddress/{addressId}")
    public ResponseEntity<ApiResponse<String>> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok(new ApiResponse<>("Address deleted successfully"));
    }
}
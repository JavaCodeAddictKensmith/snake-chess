package com.kensmith.service;

import com.kensmith.dto.request.AddressRequest;
import com.kensmith.dto.response.ApiResponse;

public interface AddressService {
    String saveAddress(AddressRequest addressRequest);

     ApiResponse<String> deleteAddress(Long addressId);
}

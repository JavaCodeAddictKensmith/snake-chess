package com.kensmith.service;

import com.kensmith.dto.request.AddressRequest;
import com.kensmith.dto.response.AddressResponse;
import com.kensmith.entity.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

        void addShippingAddress(AddressRequest addressRequest);
        String updateShippingAddress(AddressRequest addressRequest);
        String deleteShippingAddress(Long id);
        AddressResponse  getShippingAddress(Long id);


        void setDefaultShippingAddress(Long addressId) throws Exception;

        ShippingAddress getDefaultShippingAddress();

    List<AddressResponse> getAllShippingAddresses();
}

package com.kensmith.repository;

import com.kensmith.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long>{

    Optional<ShippingAddress> findByIsDefaultShippingAddress(boolean isDefaultShippingAddress);
}

package com.kensmith.repository;

import com.kensmith.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long>{




    Optional<Address> findById(Long addressId);
}

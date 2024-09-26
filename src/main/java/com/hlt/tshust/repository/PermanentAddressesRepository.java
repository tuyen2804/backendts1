package com.hlt.tshust.repository;

import com.hlt.tshust.model.PermanentAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermanentAddressesRepository extends JpaRepository<PermanentAddresses, Integer> {
    // Repository để thao tác với bảng permanent_addresses
}


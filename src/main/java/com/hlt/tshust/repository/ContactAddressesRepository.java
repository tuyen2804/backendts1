package com.hlt.tshust.repository;

import com.hlt.tshust.model.ContactAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactAddressesRepository extends JpaRepository<ContactAddresses, Integer> {
    // Repository để thao tác với bảng contact_addresses
}


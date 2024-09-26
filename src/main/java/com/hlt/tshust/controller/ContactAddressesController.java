package com.hlt.tshust.controller;

import com.hlt.tshust.model.ContactAddresses;
import com.hlt.tshust.service.ContactAddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact-addresses")
public class ContactAddressesController {

    @Autowired
    private ContactAddressesService contactAddressesService;

    // Endpoint thêm mới hoặc cập nhật địa chỉ liên lạc
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateContactAddress(@RequestBody ContactAddresses contactAddress) {
        contactAddressesService.saveOrUpdateContactAddress(contactAddress);
        return "Contact address has been saved/updated successfully.";
    }
}


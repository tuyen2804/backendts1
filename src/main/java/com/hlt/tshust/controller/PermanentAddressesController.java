package com.hlt.tshust.controller;

import com.hlt.tshust.model.PermanentAddresses;
import com.hlt.tshust.service.PermanentAddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class PermanentAddressesController {

    @Autowired
    private PermanentAddressesService permanentAddressesService;

    // Endpoint thêm mới hoặc cập nhật địa chỉ thường trú
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdatePermanentAddress(@RequestBody PermanentAddresses permanentAddress) {
        permanentAddressesService.saveOrUpdatePermanentAddress(permanentAddress);
        return "Permanent address has been saved/updated successfully.";
    }
}


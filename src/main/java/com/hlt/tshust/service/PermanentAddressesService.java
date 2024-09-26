package com.hlt.tshust.service;

import com.hlt.tshust.model.PermanentAddresses;
import com.hlt.tshust.repository.PermanentAddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermanentAddressesService {

    @Autowired
    private PermanentAddressesRepository permanentAddressesRepository;

    // Thêm mới hoặc cập nhật địa chỉ thường trú
    public PermanentAddresses saveOrUpdatePermanentAddress(PermanentAddresses permanentAddress) {
        Optional<PermanentAddresses> existingAddress = permanentAddressesRepository.findById(permanentAddress.getAccountId());

        if (existingAddress.isPresent()) {
            // Nếu địa chỉ tồn tại, cập nhật thông tin
            PermanentAddresses updateAddress = existingAddress.get();
            updateAddress.setCity(permanentAddress.getCity());
            updateAddress.setDistrict(permanentAddress.getDistrict());
            updateAddress.setWard(permanentAddress.getWard());
            updateAddress.setStreetAddress(permanentAddress.getStreetAddress());
            return permanentAddressesRepository.save(updateAddress);
        } else {
            // Nếu địa chỉ không tồn tại, thêm mới
            return permanentAddressesRepository.save(permanentAddress);
        }
    }
}


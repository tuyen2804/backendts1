package com.hlt.tshust.service;

import com.hlt.tshust.model.ContactAddresses;
import com.hlt.tshust.repository.ContactAddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactAddressesService {

    @Autowired
    private ContactAddressesRepository contactAddressesRepository;

    // Thêm mới hoặc cập nhật địa chỉ liên lạc
    public ContactAddresses saveOrUpdateContactAddress(ContactAddresses contactAddress) {
        Optional<ContactAddresses> existingAddress = contactAddressesRepository.findById(contactAddress.getAccountId());

        if (existingAddress.isPresent()) {
            // Nếu địa chỉ tồn tại, cập nhật thông tin
            ContactAddresses updateAddress = existingAddress.get();
            updateAddress.setCity(contactAddress.getCity());
            updateAddress.setDistrict(contactAddress.getDistrict());
            updateAddress.setWard(contactAddress.getWard());
            updateAddress.setStreetAddress(contactAddress.getStreetAddress());
            return contactAddressesRepository.save(updateAddress);
        } else {
            // Nếu địa chỉ không tồn tại, thêm mới
            return contactAddressesRepository.save(contactAddress);
        }
    }
}

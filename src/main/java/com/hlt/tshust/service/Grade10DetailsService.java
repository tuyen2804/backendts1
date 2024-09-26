package com.hlt.tshust.service;

import com.hlt.tshust.model.Grade10Details;
import com.hlt.tshust.repository.Grade10DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Grade10DetailsService {

    @Autowired
    private Grade10DetailsRepository grade10DetailsRepository;

    // Thêm mới hoặc cập nhật chi tiết điểm lớp 10
    public Grade10Details saveOrUpdateGrade10Details(Grade10Details grade10Details) {
        Optional<Grade10Details> existingDetails = grade10DetailsRepository.findById(grade10Details.getAccountId());

        if (existingDetails.isPresent()) {
            // Nếu chi tiết điểm đã tồn tại, cập nhật thông tin
            Grade10Details updateDetails = existingDetails.get();
            updateDetails.setMathSem1(grade10Details.getMathSem1());
            updateDetails.setMathSem2(grade10Details.getMathSem2());
            updateDetails.setPhysicsSem1(grade10Details.getPhysicsSem1());
            updateDetails.setPhysicsSem2(grade10Details.getPhysicsSem2());
            updateDetails.setChemistrySem1(grade10Details.getChemistrySem1());
            updateDetails.setChemistrySem2(grade10Details.getChemistrySem2());
            updateDetails.setLiteratureSem1(grade10Details.getLiteratureSem1());
            updateDetails.setLiteratureSem2(grade10Details.getLiteratureSem2());
            updateDetails.setEnglishSem1(grade10Details.getEnglishSem1());
            updateDetails.setEnglishSem2(grade10Details.getEnglishSem2());
            updateDetails.setBiologySem1(grade10Details.getBiologySem1());
            updateDetails.setBiologySem2(grade10Details.getBiologySem2());
            updateDetails.setHistorySem1(grade10Details.getHistorySem1());
            updateDetails.setHistorySem2(grade10Details.getHistorySem2());
            updateDetails.setGeographySem1(grade10Details.getGeographySem1());
            updateDetails.setGeographySem2(grade10Details.getGeographySem2());
            updateDetails.setProofImageUrl(grade10Details.getProofImageUrl());
            return grade10DetailsRepository.save(updateDetails);
        } else {
            // Nếu chưa có, thêm mới
            return grade10DetailsRepository.save(grade10Details);
        }
    }
}


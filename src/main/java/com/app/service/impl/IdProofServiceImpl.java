package com.app.service.impl;

import com.app.dao.IdProofRepository;
import com.app.dto.IdProofDTO;
import com.app.entity.IdProof;
import com.app.service.IdProofService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class IdProofServiceImpl implements IdProofService {
    private IdProofRepository idProofRepository;
    public IdProofServiceImpl(IdProofRepository idProofRepository){
        this.idProofRepository=idProofRepository;
    }
    private static final Logger log = LoggerFactory.getLogger(IdProofServiceImpl.class);

    @Override
    public int saveIdProof(IdProofDTO idProofDTO) {
        IdProof savedIdProof = null;
        try{
            log.info("Saving Id proof with name {} ",idProofDTO.getProofName());
            UUID proofId= UUID.randomUUID();
            IdProof idProof=new IdProof();
            idProof.setProofId(proofId);
            BeanUtils.copyProperties(idProofDTO,idProof);
            savedIdProof =idProofRepository.save(idProof);

        }
        catch (Exception exception){
            log.error("Exception occurred while saving IdProof with name {} ",idProofDTO.getProofName());
        }
        return savedIdProof.getId();
    }

    @Override
    public IdProofDTO getIdProofByName(String proofName) {
        return null;
    }

    @Override
    public Set<IdProofDTO> getAllIdProofs() {
        return null;
    }

    @Override
    public IdProofDTO updateIdProof(IdProofDTO idProofDTO) {
        return null;
    }

    @Override
    public void deleteIdProofByName(String proofName) {

    }
}

package com.app.service.impl;

import com.app.dao.IdProofRepository;
import com.app.dto.IdProofDTO;
import com.app.entity.IdProof;
import com.app.entity.Person;
import com.app.exception.BaseExcepiton;
import com.app.exception.IdProofNotFoundException;
import com.app.service.IdProofService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.rmi.UnexpectedException;
import java.util.*;

@Service
public class IdProofServiceImpl implements IdProofService {
    private IdProofRepository idProofRepository;
    public IdProofServiceImpl(IdProofRepository idProofRepository){
        this.idProofRepository=idProofRepository;
    }
    private static final Logger log = LoggerFactory.getLogger(IdProofServiceImpl.class);

    @Override
    public int saveIdProof(IdProofDTO idProofDTO) throws UnexpectedException, BaseExcepiton {
        IdProof savedIdProof = null;
        try{
            log.info("Saving Id proof with name {} ",idProofDTO.getProofName());
            UUID proofId= UUID.randomUUID();
            IdProof idProof=new IdProof();
            Person person=new Person();
            person.setPersonId(UUID.randomUUID());
            person.setPersonName(idProofDTO.getPerson().getPersonName());
            person.setGender(idProofDTO.getPerson().getGender());
            person.setMobileNumber(idProofDTO.getPerson().getMobileNumber());
            idProof.setPerson(person);
            idProof.setProofId(proofId);
            idProof.setProofName(idProofDTO.getProofName());

            savedIdProof =idProofRepository.save(idProof);
        }
        catch (Exception exception){
            log.error("Exception occurred while saving IdProof with name {} ",idProofDTO.getProofName());
            throw new BaseExcepiton("Exception occurred while saving the IdProof with name "+idProofDTO.getProofName()+" : "+exception.getMessage());
        }
        return savedIdProof.getId();
    }

    @Override
    public IdProofDTO getIdProofByName(String proofName) throws BaseExcepiton {
        IdProofDTO idProofDTO=null;
        try {
            log.info("Fetching the IdProof with name {}",proofName);
            IdProof idProof=idProofRepository.findByProofName(proofName);
            if(Objects.nonNull(idProof)){
                log.info("Fetched IdProof : {}",idProofDTO.toString());
                idProofDTO=new IdProofDTO();
                BeanUtils.copyProperties(idProof,idProofDTO);
            }
            else {
                log.error("Exception occurred while fetching IdProof with name {} ",proofName);
                throw new IdProofNotFoundException("IdProof not found with name "+proofName);
            }

        } catch (IdProofNotFoundException e) {
            throw new BaseExcepiton("Unable to get IdProof with Id "+proofName);
        }
        return idProofDTO;
    }

    @Override
    public Set<IdProofDTO> getAllIdProofs() throws BaseExcepiton {
        Set<IdProofDTO> idProofDTOS=null;
        try {
            log.info("Fetching all IdProofs");
            List<IdProof> idProofList=idProofRepository.findAll();
            if(idProofList.isEmpty()){
                throw new IdProofNotFoundException("No IdProofs Found");
            }
            idProofDTOS=new HashSet<>();
            for(IdProof idProof:idProofList){
                IdProofDTO idProofDTO=new IdProofDTO();
                BeanUtils.copyProperties(idProof,idProofDTO);
                idProofDTOS.add(idProofDTO);
            }
        }
        catch (IdProofNotFoundException idProofNotFoundException){
            log.warn("No IdProof records found.");
            throw new BaseExcepiton("No IdProofs found ");
        }
        catch (Exception exception){
            log.error("Exception occurred while fetching IdProofs ");
            throw new BaseExcepiton("Unable to get IdProofs");
        }
        return idProofDTOS;
    }

    @Override
    public IdProofDTO updateIdProof(IdProofDTO idProofDTO) {
        return null;
    }

    @Override
    public void deleteIdProofByName(String proofName) {

    }
}

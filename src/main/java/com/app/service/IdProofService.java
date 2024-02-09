package com.app.service;

import com.app.dto.IdProofDTO;
import com.app.exception.BaseExcepiton;

import java.rmi.UnexpectedException;
import java.util.Set;

public interface IdProofService {

    int saveIdProof(IdProofDTO idProofDTO) throws UnexpectedException, BaseExcepiton;
    IdProofDTO getIdProofByName(String proofName) throws BaseExcepiton;
    Set<IdProofDTO> getAllIdProofs() throws BaseExcepiton;
    IdProofDTO updateIdProof(IdProofDTO idProofDTO);
    void deleteIdProofByName(String proofName);

}

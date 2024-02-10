package com.app.service;

import com.app.dto.IdProofDTO;
import com.app.exception.BaseExcepiton;
import com.app.exception.IdProofNotFoundException;
import com.app.exception.PersonNotFoundException;

import java.rmi.UnexpectedException;
import java.util.Set;

public interface IdProofService {

    int saveIdProof(IdProofDTO idProofDTO) throws UnexpectedException, BaseExcepiton, PersonNotFoundException;
    IdProofDTO getIdProofByName(String proofName) throws BaseExcepiton;
    Set<IdProofDTO> getAllIdProofs() throws BaseExcepiton;
    int updateIdProof(IdProofDTO idProofDTO) throws PersonNotFoundException, BaseExcepiton, IdProofNotFoundException;
    void deleteIdProofByName(String proofName);

}

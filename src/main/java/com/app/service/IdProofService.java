package com.app.service;

import com.app.dto.IdProofDTO;

import java.util.Set;

public interface IdProofService {

    int saveIdProof(IdProofDTO idProofDTO);
    IdProofDTO getIdProofByName(String proofName);
    Set<IdProofDTO> getAllIdProofs();
    IdProofDTO updateIdProof(IdProofDTO idProofDTO);
    void deleteIdProofByName(String proofName);

}

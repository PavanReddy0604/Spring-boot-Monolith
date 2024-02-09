package com.app.controller;

import com.app.dto.IdProofDTO;
import com.app.entity.IdProof;
import com.app.exception.BaseExcepiton;
import com.app.service.IdProofService;
import com.app.service.impl.IdProofServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.UnexpectedException;
import java.util.Set;

@RestController
@RequestMapping("/idProof")
public class IdProofController {

    private IdProofService idProofService;
    public IdProofController(IdProofServiceImpl idProofService){
        this.idProofService=idProofService;
    }

    @GetMapping("/")
    public ResponseEntity<Set<IdProofDTO>> getAllIdProofs() throws BaseExcepiton {
        Set<IdProofDTO> idProofDTOSet=idProofService.getAllIdProofs();
        return new ResponseEntity<>(idProofDTOSet, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Integer> saveIDProof(@RequestBody() IdProofDTO idProofDTO) throws UnexpectedException, BaseExcepiton {
        int idProofId =idProofService.saveIdProof(idProofDTO);
        return new ResponseEntity<>(idProofId,HttpStatus.CREATED);


    }
}

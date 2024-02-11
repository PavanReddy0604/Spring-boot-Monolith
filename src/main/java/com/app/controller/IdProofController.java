package com.app.controller;

import com.app.dto.IdProofDTO;
import com.app.entity.IdProof;
import com.app.exception.BaseExcepiton;
import com.app.exception.IdProofNotFoundException;
import com.app.exception.PersonNotFoundException;
import com.app.service.IdProofService;
import com.app.service.impl.IdProofServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    public ResponseEntity<Integer> saveIDProof(@RequestBody() IdProofDTO idProofDTO) throws UnexpectedException, BaseExcepiton, PersonNotFoundException {
        int idProofId =idProofService.saveIdProof(idProofDTO);
        return new ResponseEntity<>(idProofId,HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Integer> updateIdProof(@RequestBody() IdProofDTO idProofDTO) throws PersonNotFoundException, BaseExcepiton, IdProofNotFoundException {
        int idProofId=idProofService.updateIdProof(idProofDTO);
        return new ResponseEntity<>(idProofId,HttpStatus.OK);
    }
    @GetMapping("/proofName/{name}")
    public ResponseEntity<List<IdProofDTO>> getIdProofByName(@PathVariable("name") String name) throws BaseExcepiton {
        List<IdProofDTO> idProofDTO= idProofService.getIdProofByName(name);
        return new ResponseEntity<>(idProofDTO,HttpStatus.OK);
    }
    @DeleteMapping("/{proofId}")
    public ResponseEntity<Void> deleteByProofId(@PathVariable("proofId")UUID proofId) throws IdProofNotFoundException, BaseExcepiton {
        idProofService.deleteIdProofByProofId(proofId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

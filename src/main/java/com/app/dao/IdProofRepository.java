package com.app.dao;

import com.app.entity.IdProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof,Integer> {
}

package com.app.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Entity
@Table(name="id_proof")
public class IdProof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID proofId;
    @Column(unique = true,nullable = false)
    @NonNull
    private String proofName;

    public IdProof(int id, UUID proofId, String proofName) {
        this.id = id;
        this.proofId = proofId;
        this.proofName = proofName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getProofId() {
        return proofId;
    }

    public void setProofId(UUID proofId) {
        this.proofId = proofId;
    }

    public String getProofName() {
        return proofName;
    }

    public void setProofName(String proofName) {
        this.proofName = proofName;
    }
}

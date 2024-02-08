package com.app.dto;

import com.app.entity.Person;

public class IdProofDTO {
    public String proofName;
    public Person person;

    public String getProofName() {
        return proofName;
    }

    public void setProofName(String proofName) {
        this.proofName = proofName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

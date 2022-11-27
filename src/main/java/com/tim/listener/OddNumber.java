package com.tim.listener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "odd_numbers")
public class OddNumber {
    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "value")
    Integer value;
}

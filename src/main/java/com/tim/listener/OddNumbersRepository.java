package com.tim.listener;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OddNumbersRepository extends CrudRepository<OddNumber, UUID> {

}

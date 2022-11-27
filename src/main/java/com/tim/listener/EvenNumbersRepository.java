package com.tim.listener;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EvenNumbersRepository extends CrudRepository<EvenNumber, UUID> {

}

package com.tim.listener;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@EnableRabbit
@Component
public class Listener {

    private final OddNumbersRepository oddNumbersRepository;
    private final EvenNumbersRepository evenNumbersRepository;

    public Listener(OddNumbersRepository oddNumbersRepository, EvenNumbersRepository evenNumbersRepository) {
        this.oddNumbersRepository = oddNumbersRepository;
        this.evenNumbersRepository = evenNumbersRepository;
    }

    @RabbitListener(queues = "${queueName}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        int number = Integer.parseInt(message);

        if (number % 2 == 0) {
            EvenNumber entity = new EvenNumber();
            entity.value = number;
            entity.id = UUID.randomUUID();
            evenNumbersRepository.save(entity);
        } else {
            OddNumber entity = new OddNumber();
            entity.value = number;
            entity.id = UUID.randomUUID();
            oddNumbersRepository.save(entity);
        }
    }
}

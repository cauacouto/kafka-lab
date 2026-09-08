package consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {



    @KafkaListener(
            topics = "rota-recebimento-produtos",
            groupId = "consumer-group-v1",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void receiverProducts(String message){
        System.out.println("received product menssage: " + message);
    }
}

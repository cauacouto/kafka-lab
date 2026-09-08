package producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import producer.dto.ProdutoDto;

@Service
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void producer(ProdutoDto produtoDto){

        ProducerRecord<String,String> record = new ProducerRecord<>(produtoDto.route(),produtoDto.content());

        try {
           var result = kafkaTemplate.send(record);
            System.out.println("mensagem enviado com sucesso");
            System.out.println("topico: " + result.get().getRecordMetadata().topic());
            System.out.println("partition" + result.get().getRecordMetadata().partition());
        }
        catch (Exception e){
            System.out.println("Erro ao enviar mensagem para o kafka");
            e.printStackTrace();
        }
    }
}

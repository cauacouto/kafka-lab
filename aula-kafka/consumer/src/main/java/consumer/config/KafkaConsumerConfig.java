package consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String,Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:19092");

        /**
         * define o grupo de consumidores
         * consumers com o mesmo groupId -> dividem as mensagemns
         * consumerns com o groupId diferentes -> recebem tudo (indepedentes)
         */

        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group-teste");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        /**
         * em producao colocar false
         */
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);


        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
         return factory;
    }
}

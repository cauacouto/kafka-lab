package producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import producer.dto.ProdutoDto;
import producer.service.ProducerService;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class produtoController {


    private final ProducerService producerService;


    @PostMapping
    public ResponseEntity<String> send(@RequestBody ProdutoDto dto){
        producerService.producer(dto);
        return ResponseEntity.accepted().body(String.format("produto enviado '%s' com sucesso na roota '%s' ",dto.content(),dto.route()));
    }




}

package com.fag.giovanna.auladlq;
import org.springframework.stereotype.Component;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsPedidoDlqAdapter {

    @SqsListener("${queue.order-events-dlq}")
    public void listen(DTO dto) {

        System.out.println("Mensagem DLQ");
        System.out.println("ID do evento: " + dto.getEventId());
        System.out.println("Tipo do evento: " + dto.getEventType());
        System.out.println("ID do pedido: " + dto.getOrderId());
        System.out.println("ID do cliente: " + dto.getCustomerId());
        System.out.println("Valor total: " + dto.getTotal());
        System.out.println("Moeda: " + dto.getCurrency());
    }
}


package com.giovanna.aulaseda;

import org.springframework.stereotype.Component;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsPedidoAdapter {

    @SqsListener("${queue.order-events}")
    public void listen(DTO dto) {

        System.out.println("Mensagem recebida: " + dto.getCustomerId());

        if ("ERRO".equals(dto.getCustomerId())) {
            System.out.println("Erro ao processar a mensagem!");

            throw new RuntimeException("Erro no processamento do pedido.");
        }

        System.out.println("Mensagem consumida com sucesso.");
    }
}

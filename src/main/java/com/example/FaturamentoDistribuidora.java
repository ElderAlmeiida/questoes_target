package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDistribuidora {

    public static void executar() {
        try {
            // Lendo o arquivo JSON a partir do classpath
            InputStream inputStream = FaturamentoDistribuidora.class.getClassLoader().getResourceAsStream("faturamento.json");
            if (inputStream == null) {
                System.err.println("Arquivo JSON não encontrado.");
                return;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(inputStream);
            
            // Armazena os valores de faturamento
            List<Double> faturamentos = new ArrayList<>();
            
            for (JsonNode node : rootNode) {
                double valor = node.path("valor").asDouble();
                if (valor > 0) {
                    faturamentos.add(valor);
                }
            }

            // Calculando o menor e maior valor de faturamento
            double menorValor = faturamentos.stream().min(Double::compare).orElse(0.0);
            double maiorValor = faturamentos.stream().max(Double::compare).orElse(0.0);

            // Calculando a média mensal
            double somaTotal = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
            double mediaMensal = somaTotal / faturamentos.size();

            // Calculando o número de dias com faturamento superior à média
            long diasAcimaDaMedia = faturamentos.stream().filter(valor -> valor > mediaMensal).count();

            // Exibindo os resultados
            System.out.println("Menor valor de faturamento: R$ " + menorValor);
            System.out.println("Maior valor de faturamento: R$ " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}

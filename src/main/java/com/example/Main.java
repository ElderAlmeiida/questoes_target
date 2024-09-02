package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
        int opcao = -1; // Inicializa com um valor inválido

        while (opcao != 0) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha após o número

                if (opcao == 1) {
                    Questao_1.executar();
                } else if (opcao == 2) {
                    FaturamentoDistribuidora.executar();
                } else if (opcao == 3) {
                    FaturamentoEstados.executar();
                } else if (opcao == 4) {
                    InverterString.executar();
                } else if (opcao != 0) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Limpar o buffer de entrada
            }
        }

        System.out.println("Saindo...");
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Questão 1 - Questao 1");
        System.out.println("2. Questão 2 - Faturamento Distribuidora");
        System.out.println("3. Questão 3 - Percentual de Faturamento por Estado");
        System.out.println("4. Questão 4 - Inverter String");
        System.out.println("0. Sair");
    }
}

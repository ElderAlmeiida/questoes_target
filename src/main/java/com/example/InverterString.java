
package com.example;

import java.util.Scanner;

public class InverterString {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a string para inverter: ");
        String input = scanner.nextLine();

        // Inverte a string
        String invertedString = inverterString(input);

        // Exibe a string invertida
        System.out.println("String invertida: " + invertedString);
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        return new String(caracteres);
    }
}

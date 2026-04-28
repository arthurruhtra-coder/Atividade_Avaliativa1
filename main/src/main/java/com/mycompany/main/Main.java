/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.Scanner;

class Cinema {

    int[][] sala = new int[6][8];

    public void reservar(int fileira, int assento) {
        if (sala[fileira][assento] == 0) {
            sala[fileira][assento] = 1;
            System.out.println("Assento reservado com sucesso!");
        } else {
            System.out.println("Esse assento já está ocupado!");
        }
    }

    public void cancelar(int fileira, int assento) {
        if (sala[fileira][assento] == 1) {
            sala[fileira][assento] = 0;
            System.out.println("Reserva cancelada!");
        } else {
            System.out.println("Esse assento já está livre!");
        }
    }

    public void mostrarMapa() {
        for (int i = 0; i < 6; i++) {
            System.out.print("Fileira " + (i + 1) + ": ");
            for (int j = 0; j < 8; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mostrarEstatisticas() {
        int livres = 0;
        int ocupados = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                if (sala[i][j] == 0) livres++;
                else ocupados++;
            }
        }

        int total = livres + ocupados;
        double percentual = (ocupados * 100.0) / total;

        System.out.println("Assentos livres: " + livres);
        System.out.println("Assentos ocupados: " + ocupados);
        System.out.printf("Percentual de ocupação: %.2f%%\n", percentual);
    }
}

public class Main { // <- nome do arquivo deve ser Main.java

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema();

        int opcao;

        do {
            System.out.println("\n*** MENU ***");
            System.out.println("1: Reservar assento");
            System.out.println("2: Cancelar reserva");
            System.out.println("3: Exibir mapa da sala");
            System.out.println("4: Exibir estatísticas");
            System.out.println("5: Encerrar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.print("Fileira (1 a 6): ");
        int f = sc.nextInt() - 1;
        int a = sc.nextInt() - 1;

        if (f < 0 || f >= 6 || a < 0 || a >= 8) {
            System.out.println("Fileira ou assento inválido!");
        } else {
            cinema.reservar(f, a);
        }

        } else if (opcao == 2) {
            System.out.print("Fileira (1 a 6): ");
        int f = sc.nextInt() - 1;

            System.out.print("Assento (1 a 8): ");
        int a = sc.nextInt() - 1;

            cinema.cancelar(f, a);

        } else if (opcao == 3) {
            cinema.mostrarMapa();

        } else if (opcao == 4) {
            cinema.mostrarEstatisticas();

        } else if (opcao == 5) {
                System.out.println("Encerrando...");

        } else {
                System.out.println("Opção inválida!");
        }

        } while (opcao != 5);

        sc.close();
    }
        
}

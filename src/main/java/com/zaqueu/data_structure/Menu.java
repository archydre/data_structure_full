package com.zaqueu.data_structure;

import com.zaqueu.data_structure.listas.Fila;
import com.zaqueu.data_structure.listas.Lista;
import com.zaqueu.data_structure.listas.ListaCircular;
import com.zaqueu.data_structure.listas.ListaRecursiva;
import com.zaqueu.data_structure.listas.Pilha;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n## MENU PRINCIPAL ##");
            System.out.println("1 - Lista");
            System.out.println("2 - Lista Circular");
            System.out.println("3 - Lista Recursiva");
            System.out.println("4 - Fila");
            System.out.println("5 - Pilha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuLista(scanner);
                    break;
                case 2:
                    menuListaCircular(scanner);
                    break;
                case 3:
                    menuListaRecursiva(scanner);
                    break;
                case 4:
                    menuFila(scanner);
                    break;
                case 5:
                    menuPilha(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void menuLista(Scanner scanner) {
        Lista<Integer> lista = new Lista<>();
        int escolha;

        do {
            System.out.println("\n## LISTA ##");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Adicionar em uma posição");
            System.out.println("3 - Remover");
            System.out.println("4 - Remover de uma posição");
            System.out.println("5 - Mostrar");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    lista.add(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int pos = scanner.nextInt();
                    lista.add(valor, pos);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser removido: ");
                    lista.remove(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Digite a posição a ser removida: ");
                    lista.removeAt(scanner.nextInt());
                    break;
                case 5:
                    lista.show();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private static void menuListaCircular(Scanner scanner) {
        ListaCircular<Integer> lista = new ListaCircular<>();
        int escolha;
        do {
            System.out.println("\n## LISTA CIRCULAR ##");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Adicionar em uma posição");
            System.out.println("3 - Remover de uma posição");
            System.out.println("4 - Imprimir");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    lista.add(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int pos = scanner.nextInt();
                    lista.add(valor, pos);
                    break;
                case 3:
                    System.out.print("Digite a posição a ser removida: ");
                    lista.remove(scanner.nextInt());
                    break;
                case 4:
                    lista.imprimir();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private static void menuListaRecursiva(Scanner scanner) {
        ListaRecursiva<Integer> lista = new ListaRecursiva<>();
        int escolha;
        do {
            System.out.println("\n## LISTA RECURSIVA ##");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Buscar");
            System.out.println("4 - Mostrar");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    lista.add(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    lista.remove(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Digite o valor a ser buscado: ");
                    if (lista.search(scanner.nextInt()) == 1) {
                        System.out.println("\nElemento encontrado!");
                    } else {
                        System.out.println("\nElemento não encontrado!");
                    }
                    break;
                case 4:
                    lista.show();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private static void menuFila(Scanner scanner) {
        Fila<Integer> fila = new Fila<>();
        int escolha;
        do {
            System.out.println("\n## FILA ##");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Verificar se existe");
            System.out.println("4 - Mostrar");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    fila.add(scanner.nextInt());
                    break;
                case 2:
                    fila.remove();
                    break;
                case 3:
                    System.out.print("Digite o valor a ser verificado: ");
                    fila.isThere(scanner.nextInt());
                    break;
                case 4:
                    fila.show();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private static void menuPilha(Scanner scanner) {
        Pilha pilha = new Pilha();
        int escolha;
        do {
            System.out.println("\n## PILHA ##");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Verificar item");
            System.out.println("4 - Mostrar");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    pilha.add(scanner.nextInt());
                    break;
                case 2:
                    pilha.remove();
                    break;
                case 3:
                    System.out.print("Digite o valor a ser verificado: ");
                    pilha.verificarItem(scanner.nextInt());
                    break;
                case 4:
                    pilha.show();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }
}
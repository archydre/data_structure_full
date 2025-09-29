/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *
 * @author zaqueu
 */
public class ListaCircular<T> extends Lista<T>{
    
    public ListaCircular(){
        super();
        
    }
    
    public void add(T val) {
        // Simplesmente chama o outro método add, passando o tamanho atual como posição
        // para que o novo elemento seja inserido no final.
        this.add(val, this.size);
    }
    
    @Override
    public void add(T val, int pos) {
        if (pos < 0 || pos > this.size) {
            // Lançar uma exceção seria melhor, mas return funciona.
            return;
        }

        Node<T> novo = new Node<>(val);

        if (this.size == 0) { // Caso especial: lista vazia
            this.inicio = novo;
            this.fim = novo;
            novo.next = this.inicio; // Aponta para si mesmo
            novo.prev = this.fim;   // Aponta para si mesmo
        } else if (pos == 0) { // Inserção no início
            novo.next = this.inicio;
            novo.prev = this.fim;
            this.inicio.prev = novo;
            this.fim.next = novo;
            this.inicio = novo;
        } else if (pos == this.size) { // Inserção no final (é mais simples que pos == size - 1)
            novo.next = this.inicio;
            novo.prev = this.fim;
            this.fim.next = novo;
            this.inicio.prev = novo;
            this.fim = novo;
        } else { // Inserção no meio
            Node<T> atual = this.inicio;
            for (int i = 0; i < pos; i++) {
                atual = atual.next;
            }
            Node<T> anterior = atual.prev;

            // Conecta o novo nó
            novo.next = atual;
            novo.prev = anterior;

            // Atualiza os vizinhos para apontarem para o novo nó
            anterior.next = novo;
            atual.prev = novo;
        }

        this.size++;
        System.out.println("Elemento " + val + " adicionado com sucesso na posição " + pos);
    }
    
    public void imprimir() {
        // Caso 1: A lista está vazia
        if (this.inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        // Caso 2: A lista não está vazia
        Node<T> atual = this.inicio;
        System.out.print("Lista: ");

        // Usamos do-while para garantir que o primeiro elemento seja impresso
        // antes da verificação da condição de parada.
        do {
            System.out.print(atual.info + " -> ");
            atual = atual.next;
        } while (atual != this.inicio);

        System.out.println("(início)"); // Para indicar que voltou ao começo
    }
    
    public T remove(int pos) {
        // CASO 1: Lista vazia ou posição inválida
        if (this.size == 0 || pos < 0 || pos >= this.size) {
            // Lançar uma exceção seria o ideal, mas vamos retornar null por simplicidade
            return null;
        }

        Node<T> nodeParaRemover;

        // CASO 2: A lista tem apenas um elemento
        if (this.size == 1) {
            nodeParaRemover = this.inicio;
            this.inicio = null;
            this.fim = null;
        } else if (pos == 0) { // CASO 3: Removendo o primeiro elemento
            nodeParaRemover = this.inicio;
            this.inicio = this.inicio.next; // O segundo elemento vira o novo início
            // Agora, reconectamos o novo início com o fim para fechar o círculo
            this.inicio.prev = this.fim;
            this.fim.next = this.inicio;
        } else if (pos == this.size - 1) { // CASO 4: Removendo o último elemento
            nodeParaRemover = this.fim;
            this.fim = this.fim.prev; // O penúltimo elemento vira o novo fim
            // Reconectamos o novo fim com o início para fechar o círculo
            this.fim.next = this.inicio;
            this.inicio.prev = this.fim;
        } else { // CASO 5: Removendo um elemento do meio
            // Encontramos o nó a ser removido
            Node<T> atual = this.inicio;
            for (int i = 0; i < pos; i++) {
                atual = atual.next;
            }
            nodeParaRemover = atual;

            // Pegamos os vizinhos dele
            Node<T> anterior = nodeParaRemover.prev;
            Node<T> proximo = nodeParaRemover.next;

            // Fazemos os vizinhos "se enxergarem", ignorando o nó a ser removido
            // Antes: [anterior] <--> [nodeParaRemover] <--> [proximo]
            anterior.next = proximo;
            proximo.prev = anterior;
            // Depois: [anterior] <----------------------> [proximo]
        }

        this.size--;
        System.out.println("Elemento " + nodeParaRemover.info + " removido da posição " + pos);
        return nodeParaRemover.info;
    }
    
    public static void main(String[] args){
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.add(12);
        lista.add(13);
        lista.add(14);
        lista.add(15);
        lista.add(16);
        
        lista.imprimir();
        
        lista.remove(2);
        
        lista.imprimir();
    }
}

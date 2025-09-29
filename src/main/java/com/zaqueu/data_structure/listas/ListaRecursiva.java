/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *  questao a4
 * @author zaqueu
 */
public class ListaRecursiva<T> extends Lista<T>{
    
    @Override
    public void show() {
        showRecursivo(inicio); // Começa a partir do início da lista
        System.out.println(); // Pula uma linha no final
    }
    
    private void showRecursivo(Node<T> atual){
        if(atual == null){
            return;
        }else{
            System.out.print(atual.info + " ");
            showRecursivo(atual.next);
        }
    }
    
    public int search(T val){
        int found = searchRecursivo(inicio ,val);
        
        if(found == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    private int searchRecursivo(Node<T> atual, T value){
        if(atual != null){
            if(value.equals(atual.info)){
                System.out.print("'" + atual.info + "' ");
                return 1;
            }else{
                System.out.print(atual.info + " ");
                return searchRecursivo(atual.next, value);
            }
        }else{
            return 0;
        }
    }
    
    
    @Override
    public void remove(T value) {
        // A chamada inicial começa a busca a partir do início da lista.
        // O resultado da função (o novo início da lista) é atribuído de volta a 'this.inicio'.
        // Isso é crucial caso o primeiro elemento seja removido.
        this.inicio = removeRecursivo(this.inicio, value);
    }

   
    private Node<T> removeRecursivo(Node<T> atual, T value) {
        if (atual == null) {
            return null;
        }

        // Se o nó atual contém o valor a ser removido...
        if (atual.info.equals(value)) {
            size--; // Decrementa o tamanho.

            // ...então este nó deve ser "pulado".
            // A recursão continua a partir do PRÓXIMO nó.
            // O que quer que essa chamada retorne será o novo "próximo" do nó ANTERIOR.
            return removeRecursivo(atual.next, value);

        } else {
            // Se o nó atual NÃO for removido...

            // ...seu 'next' será o resultado da chamada recursiva para o resto da lista.
            Node<T> proximoCorreto = removeRecursivo(atual.next, value);
            atual.next = proximoCorreto;

            // ...e precisamos garantir que o ponteiro 'prev' do nó seguinte aponte de volta para 'atual'.
            if (proximoCorreto != null) {
                proximoCorreto.prev = atual;
            } else {
                // Se não há um próximo, 'atual' se torna o novo fim da lista.
                this.fim = atual;
            }
            
            // Retorna o próprio nó atual, pois ele não foi removido.
            return atual;
        }
    }
}

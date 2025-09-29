/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *
 * @author zaqueu
 */

class NodeFila<T> {
    T info;
    NodeFila<T> prox;
    
    NodeFila(T val){
        this.info = val;
    }
}

public class Fila<T> {
    NodeFila<T> inicio;
    NodeFila<T> fim;
    
    public Fila(){
        this.inicio = null;
        this.fim = null;
    }
    
    public void add(T val){
        NodeFila<T> novo = new NodeFila<>(val);
        if(inicio == null){
            inicio = novo;
            fim = novo;
        }else{
            fim.prox = novo;
            fim = novo;
        }
    }
    
    public void show(){
        
        if (this.inicio == null) {
            System.out.println("A fila está vazia.");
            return; 
        }
        NodeFila<T> dex = this.inicio;
        
        while(dex != null){
            System.out.print(dex.info + " ");
            dex = dex.prox;
        }
        
        System.out.println("");
    }
    
    public void remove(){
        
        if (this.inicio == null) {
            System.out.println("A fila está vazia.");
            return; 
        }
        
        this.inicio = this.inicio.prox;
        
    }
    
    public void isThere(T val){
        if (this.inicio == null) {
            System.out.println("A fila está vazia.");
            return; 
        }
        
        NodeFila<T> dex = this.inicio;
        
        while(dex != null){
            if(dex.info.equals(val)){
                System.out.println("o elemento está na lista");
                return;
            }
            
            dex = dex.prox;
        }
        
        System.out.println("o elemento nao esta na lista");
    }
    
    public static void main(String[] args){
        Fila<Integer> fila = new Fila<>();
        
        fila.add(12);
        fila.add(15);
        fila.add(3);
        fila.add(9);
        fila.add(45);
        
        fila.show();
        
        fila.isThere(15);
        
        fila.remove();
        
        fila.show();
        
        fila.isThere(15);
        
        fila.remove();
        
        fila.show();
        
        fila.isThere(15);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *
 * @author zaqueu
 */

class NodePilha {
    int info;
    NodePilha prox;
}


public class Pilha {
    NodePilha topo;
    int tamanho;
    
    public void add(int info){
        NodePilha novo = new NodePilha();
        novo.info = info;
        novo.prox = topo;
        topo = novo;
    }
    
    public void remove(){
        if(topo == null){
            return;
        }else{
            topo = topo.prox;
        }
        
    }
    
    public void show(){
        NodePilha aux = topo;
        
        while(aux != null){
            System.out.print(aux.info + " ");
            aux = aux.prox;
        }
        System.out.println("");
    }
    
    public void verificarItem(int val){
        if(topo == null){
            return;
        }else{
            NodePilha aux = topo;
            while(aux != null){
                if(aux.info == val){
                    System.out.println("elemento existe na pilha");
                    return;
                }else{
                    aux = aux.prox;
                }
            }
            System.out.println("elemento NAO existe na pilha");
            return;
        }
    }
    
    public static void main(String[] args){
        Pilha pilha = new Pilha();
        
        pilha.add(1);
        pilha.add(4);
        pilha.add(5);
        pilha.add(12);
        pilha.add(20);
        
        pilha.show();
        
        pilha.remove();
        
        pilha.show();
        
        pilha.remove();
        
        pilha.show();
        
        pilha.verificarItem(5);
        
        pilha.verificarItem(12);
        
        
        
    }
}

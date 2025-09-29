/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *
 * @author zaqueu
 */
public class Lista<T> {
  Node<T> inicio; 
  Node<T> fim;
  int size;
  public Lista() {
    inicio = null;
    fim = null;
    size = 0;
  }
  
  public int getSize(){
      return this.size;
  }


  public void add(T val) {
    Node<T> novo = new Node(val);
    if (inicio == null) {
      inicio = novo;
      fim = novo;
    } else {
      fim.next = novo;
      novo.prev = fim;
      fim = novo;
    }
    size++;
  }
  
  public void add(T val, int pos) {
    if (pos < 0 || pos > this.size) {
        System.out.println("Posição inválida. A lista tem " + this.size + " elementos.");
        return; // Sai do método se a posição for inválida
    }
    
    if (pos == 0) {
        Node<T> novo = new Node<>(val);
        if (inicio == null) { // Se a lista estiver vazia
            inicio = novo;
            fim = novo;
        } else {
            novo.next = this.inicio;
            this.inicio.prev = novo;
            this.inicio = novo;
        }
        size++;
        return;
    }
    
    if (pos == this.size) {
        add(val); // Reutiliza o método add() que já funciona!
        return;
    }
    
    Node<T> atual = this.inicio;
    for (int i = 0; i < pos; i++) {
        atual = atual.next;
    }
    
    Node<T> anterior = atual.prev;
    Node<T> novo = new Node<>(val);
    
    // a) novo -> atual
    novo.next = atual;
    // b) anterior -> novo
    anterior.next = novo;
    // c) novo <- atual
    atual.prev = novo;
    // d) anterior <- novo
    novo.prev = anterior;
    
    size++;
    System.out.println("Elemento " + val + " adicionado com sucesso na posição " + pos);
  }

  public void remove(T val){
    Node<T> item = inicio;
    while(item != null){
      if(item.info.equals(val)){
        if(item.prev != null){
          item.prev.next = item.next;
          item.next.prev = item.prev;
          item = item.next;
        }else{
          inicio = item.next;
          item = item.next;
        }

        size--;
      }else{
        item = item.next;
      }
    }
  }
  
  public void removeAt(int pos){
      if(pos < 0 || pos > this.size){
          return;
      }
      
      if(pos == 0){
          remove(this.inicio.info);
      }
      
      if(pos == this.size){
          remove(this.fim.info);
      }
      
      Node<T> dex = this.inicio;
      
      for(int i = 0; i < pos; i++){
          dex = dex.next;
      }
      
      dex.prev.next = dex.next;
      dex.next.prev = dex.prev;
      
      this.size--;
      
      System.out.println("removido com sucesso");
  }

  public void show(){
    Node<T> item = inicio;
    while(item != null){
      System.out.print(item.info + " ");
      item = item.next;
    }

    System.out.println("-- " + this.size + " itens");
  }
  
  public void showRec() {
        showRecursivo(inicio);
        System.out.println(); 
        System.out.println(this.size + " itensssss"); 
    }
  
  private void showRecursivo(Node<T> atual){
        if(atual == null){
            return;
        }else{
            System.out.print(atual.info + " ");
            showRecursivo(atual.next);
        }
    }
  
  public void addUnique(T val){
      Node<T> dex = this.inicio;
      Node<T> novo = new Node<>(val);
      
      while(dex != null){
          if(dex.info.equals(val)){
              System.out.println("ja existe esse elemento na lista");
              return;
          }
          
          dex = dex.next;
      }
      
      this.inicio.prev = novo;
      novo.next = this.inicio;
      inicio = novo;
      
      this.size++;
      
      
  }

  public static void main(String[] args) {
      Lista<Integer> list = new Lista<>();
      list.add(42);
      list.add(53);
      list.add(74);
      list.add(65);
      list.add(12);
      list.add(3);

      

      list.show();
      list.remove(65);
      System.out.println("remove 65");
      list.show();
      System.out.println("remove 42");
      list.remove(42);
      list.show();
      
      System.out.println("------------- qualquer posicao ---------------");
      
      list.add(56, 2);
      
      list.showRec();
      
      list.removeAt(2);
      
      list.show();
      
      list.removeAt(2);
      
      list.show();
      
      list.addUnique(3);
      
      list.show();
      
      list.addUnique(102);
      
      list.show();
  }
    
}

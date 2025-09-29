/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.listas;

/**
 *
 * @author zaqueu
 */
public class Node <T> {
  Node prev;
  Node next;
  T info;
  public Node(T val) {
    this.info = val;
  }
}

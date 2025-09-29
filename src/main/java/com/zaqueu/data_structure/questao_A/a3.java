/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.questao_A;

/**
 *
 * @author zaqueu
 */
public class a3 {

  static int multiply(int a, int b){
    if(a > b){
      if(b == 1){
        return a;
      }else{
        return a + multiply(a, b-1);
      }
    }else{
      if(a == 1){
        return b;
      }else{
        return b + multiply(a-1, b);
      }
    }
  }

  public static void main(String[] args) {
      System.out.println("5 x 3 = " + multiply(5, 3));
      System.out.println("6 x 7 = " + multiply(6, 7));
  }
}

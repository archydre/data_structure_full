package com.zaqueu.data_structure.questao_A;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zaqueu
 */
public class a2 {

    static int somaPares(int n){
        if(n == 1 || n == 0){
            return 0;
        }

        if(n % 2 != 0){
            return somaPares(n-1);

        }else{
            return n + somaPares(n-2);
        }
    }
    

    public static void main(String[] args) {
        
        System.out.println("Hello from A2!");
        System.out.println("soma pares: " + somaPares(2));
    }

}

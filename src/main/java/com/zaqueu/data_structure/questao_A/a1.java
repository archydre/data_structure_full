/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaqueu.data_structure.questao_A;

/**
 *
 * @author zaqueu
 */
public class a1 {
    public static int f1(int n){
        if(n == 0){
            return 1;
        }else{
            return (n * f1(n-1));
        }
    }
    
    public static int f2(int n){
        if(n == 0 || n == 1){
            return 1;
        }else{
            return(f2(n-1)+ 2 * f2(n-2));
        }
    }
    
    public static void f3(int n){
        if(n == 0){
            System.out.print("Zero ");
        }else{
            System.out.print(n + " ");
            System.out.print(n + " ");
            f3(n-1);
        }
    }
    
    public static void main(String[] args){
        System.out.println("f1(0)" + f1(0));
        System.out.println("f1(1)" + f1(1));
        System.out.println("f1(5)" + f1(5));
        
        System.out.println("--------------------------------------");
        
        System.out.println("f2(0)" + f2(0));
        System.out.println("f2(1)" + f2(1));
        System.out.println("f2(5)" + f2(5));
        
        System.out.println("--------------------------------------");
        
        f3(0);
        f3(1);
        f3(5);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ndhlt
 */
public class Test {

    public static void main(String[] args) {
//        Academics.switchCaseAll(true, () -> {
//            System.out.println("test run over");
//        }, new Arguments( 2>1 , () -> {
//            System.out.println("2 is greater than 1");
//        }), new Arguments( 1>2 , () -> {
//            System.out.println("1 is greater than 2");
//        }));
        Integer[] numbs = {1,1,1,2,2,3,3,3,3,4,4,5,5,5,5,5,6,7,7,7,8,8,9,9,9,9};
        System.out.println(XArray.count(numbs).toString());
    }

}

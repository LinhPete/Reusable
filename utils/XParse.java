/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ndhlt
 */
public class XParse {
    public static List<Object> ArrayToList(Object...objects){
        return Arrays.asList(objects);
    }
    
    public static Object[] ListToArray(List<Object> list){
        Object[] objects = new Object[list.size()];
        for(int i = 0; i<list.size(); i++){
            objects[i] = list.get(i);
        }
        return objects;
    }

}

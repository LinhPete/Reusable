/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author ndhlt
 */
public class XArray {
    public static void forEach(Object[] objs, Consumer<? super Object> action){
        XParse.ArrayToList(objs).forEach(action);
    }
    
    public static <Thing> Map<Thing, Integer> count(Thing... things){
        Map<Thing, Integer> map = new HashMap<>();
        for(int i = 0; i < things.length - 1 ; i++){
            if(map.containsKey(things[i])){
                map.put(things[i], map.get(things[i])+1);
            }else{
                map.put(things[i], 1);
            }
        }
        return map;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ndhlt
 */
public class XMath {
    public static double sum(double ... a){
        double sum = 0;
        for(double x : a){
            sum+=x;
        }
        return sum;
    }
    
    public static int sum(int ... a){
        int sum = 0;
        for(int x : a){
            sum+=x;
        }
        return sum;
    }
    
    public static double multiply(double ... a){
        double mul = 1;
        for(double x : a){
            mul*=x;
        }
        return mul;
    }
    
    public static long multiply(int ... a){
        long mul = 1;
        for(int x : a){
            mul*=x;
        }
        return mul;
    }
    
    public static int max(int ...a){
        int max = a[0];
        for(int x:a){
            if(max<=x){
                max=x;
            }
        }
        return max;
    }
    
    public static double max(double ...a){
        double max = a[0];
        for(double x:a){
            if(max<=x){
                max=x;
            }
        }
        return max;
    }
    
    public static int min(int ...a){
        int min = a[0];
        for(int x:a){
            if(min>=x){
                min=x;
            }
        }
        return min;
    }
    
    public static double min(double ...a){
        double min = a[0];
        for(double x:a){
            if(min>=x){
                min=x;
            }
        }
        return min;
    }
    
    public static double avg(double...a){
        double sum=0,count=0;
        for(double x:a){
            sum+=x;
            count++;
        }
        return sum/count;
    }
    
    public static double avg(int...a){
        double sum=0,count=0;
        for(double x:a){
            sum+=x;
            count++;
        }
        return sum/count;
    }
    
    public static int UCLN(int...a){ 
        int min = min(a);
        int ucln = min;
        for(int i = min;i>=1;i--){
            boolean check = true;
            for(int x:a){
                if(x%i!=0){
                    check = false;
                }
            }
            if(check){
                ucln = i;
                break;
            }
        }
        return ucln;
    }
    
    public static int BCNN(int...a){ 
        int max = max(a);
        int bcnn = max;
        for(int i = max;i<=multiply(a);i++){
            boolean check = true;
            for(int x:a){
                if(i%x!=0){
                    check = false;
                }
            }
            if(check){
                bcnn = i;
                break;
            }
        }
        return bcnn;
    }
    
}

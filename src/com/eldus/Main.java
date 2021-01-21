package com.eldus;

public class Main {
    public static void doSomething(String s1, String s2) throws IllegalArgumentException{
        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
            throw new IllegalArgumentException(Character.toString(s1.charAt(s1.length()-1)));
        }
    }

    public static int dividing(int d1, int d2) throws DivideByZeroException{
        if(d2 == 0){
            throw new DivideByZeroException();
        }
        return d1/d2;
    }

    public static void main(String[] args) {
        String s1 = "House";
        String s2 = "Horse";
        try{
            doSomething(s1,s2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        int [] arr = new int[6];
        arr[0] = 6;
        arr[1] = 2;
        arr[2] = 6;
        arr[3] = 0;
        arr[4] = 6;
        arr[5] = 0;

        for(int i = 0;i < 6; i += 2){
            try{
                System.out.println(dividing(arr[i],arr[i+1]));
            }catch (DivideByZeroException e1){
                try{
                    i += 2;
                    System.out.println(dividing(arr[i],arr[i+1]));
                }catch (DivideByZeroException e2){
                    System.out.println("Деление на ноль");
                }catch (ArrayIndexOutOfBoundsException indexException){
                    System.out.println("Array Index Out Of Bounds Exception 2");
                }
            }catch (ArrayIndexOutOfBoundsException indexException){
                System.out.println("Array Index Out Of Bounds Exception 1");
            }
        }
    }
}

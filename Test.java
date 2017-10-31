package crestaltest;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(invertByLoop("12345"));
        System.out.println(invertNonLoop("12345dfgdfg"));

        List<Integer> l = new ArrayList<Integer>(); l.add(1); l.add(2); l.add(3); l.add(4); l.add(5); l.add(6); l.add(8);
        System.out.println(evenNumbers(l));

        System.out.println("1 mod 10 = " + 1 % 10);
        System.out.println(digitSum(1234));
    }

    public static String invertByLoop(String input){
        if (input == null || input.isEmpty())
            return input;
        char[] sourceChars = input.toCharArray();
        int size =sourceChars.length;
        char[] destChars = new char[size];
        for(int i = size; i>0; i--){
            destChars[size - i] = sourceChars[i-1];
        }
        return  new String(destChars);
    }

    public static String invertNonLoop(String input){
        if (input == null || input.isEmpty())
            return input;
        char[] chars = input.toCharArray();
        invertChars(chars, 0);
        return new String(chars);
    }

    private static void invertChars(char[] input, int position){
        if (position >= (input.length / 2)) {
            return;
        }
        char tmp = input[position];
        input[position] = input[input.length - 1 - position];
        input[input.length - 1 - position] = tmp;
        invertChars(input, ++position);
    }

    public static List<Integer> evenNumbers(List<Integer> input){
        if (input == null || input.isEmpty())
            return input;
        List<Integer> dest = new ArrayList<>(input.size());
        deleteNonEven(input,dest,0);
        return dest;
    }

    private static void deleteNonEven(List<Integer> source, List<Integer> dest, int position){
        if (source.size()-1<position)
            return;
        Integer i = source.get(position);
        if (i.intValue()%2 == 0)
            dest.add(i);
        deleteNonEven(source,dest,++position);
    }

    public static int digitSum(int value){
        if (value <=0)
            return 0;
        int i = value % 10;
        return i + digitSum((value - i)/10);
    }


}

package OldTest;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-21
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Demo {
    public static void main(String[] args) {
        String string = "PAYTMPVTA";
        char[] ch = new char[26];
        for(int i=0; i < string.length(); i++ ){
            ch[(int)string.charAt(i)-(int)'A']++;
        }
        for(int i=0; i < string.length(); i++ ){
            if(ch[(int)string.charAt(i)-'A'] == 1){
                System.out.println(string.charAt(i));
                break;
            }
        }
    }
}

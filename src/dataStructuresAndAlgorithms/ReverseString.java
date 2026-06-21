package dataStructuresAndAlgorithms;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdef";
        reverseStr(0,str);
    }

    public static void reverseStr(int stringLength,String str){
        if(stringLength == str.length()){
            return;
        }
        reverseStr(stringLength + 1,str);
        System.out.print(str.charAt(stringLength));
    }
}

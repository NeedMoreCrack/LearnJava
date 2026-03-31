package test;


public class Q5 {
    public static void main(String[] args) {
        String str = "Hello World";
        strReverse(str);
    }
    public static void strReverse(String str){
        String[] strArr = str.split(" ");
        String[] strReverseArr = new String[strArr.length];
        String strReverse = "";
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            strReverseArr[i] = sb.append(strArr[i]).reverse().toString();
        }
        for (int i = 0; i < strReverseArr.length; i++) {
            strReverse += strReverseArr[i];
            if (i != strReverseArr.length - 1) {
                strReverse += " ";
            }
        }
        System.out.println(strReverse);
    }
}

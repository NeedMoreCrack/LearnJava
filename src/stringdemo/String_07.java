package stringdemo;

public class String_07 {
    public static void main(String[] args) {
        int[] numArr = {1,2,3};
        intToSting(numArr);
    }
    public static void intToSting(int[] numArr){
        String[] strArr = new String[numArr.length];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numArr.length; i++) {
            int temp = numArr[i];
            strArr[i] = Integer.toString(temp);
        }
        sb.append("[");
        for (int i = 0; i < strArr.length; i++) {
            if(i == strArr.length-1){
                sb.append(strArr[i]);
            }else {
                sb.append(strArr[i]).append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}

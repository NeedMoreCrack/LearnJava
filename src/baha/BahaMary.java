package baha;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BahaMary {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String strArr;
        BahaUserInfo user = new BahaUserInfo();
        while(true){
//            System.out.println("Enter text: ");
//            strArr = sc.nextLine();
            strArr = "/mary all 99";
            BahaUserInfo result = lottery(strArr,user);
            System.out.println("第"+ count++ +"次抽獎");
            System.out.println(result != null ? result : "");
            if(result != null && result.getUserCoin() < 0){
                System.out.println("破產了...");
                break;
            }
        }
    }

    public static BahaUserInfo lottery(String strArr,BahaUserInfo user) {
        int randomNum = new Random().nextInt(8);
        List<Map<String, Integer>> prizeList = new ArrayList<>();

        // LinkedHashMap保持順序
        Map<String, Integer> prize = prizeOption();
        for (Map.Entry<String, Integer> entry : prize.entrySet()) {
            Map<String, Integer> single = new LinkedHashMap<>();
            single.put(entry.getKey(), entry.getValue());
            prizeList.add(single);
        }

        String prizeStr = "";
        int prizeValue = 0;
        int useTotalCoin = 0;

        Map<String, Integer> getPrize = prizeList.get(randomNum);
        Set<Map.Entry<String, Integer>> entries = getPrize.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            prizeStr = entry.getKey();
            prizeValue = entry.getValue();
        }
        int userCoin = user.getUserCoin();
        int getSaveNumArrValue = 0;
        if (strArr.startsWith("/mary all")) {
            String[] s = strArr.trim().split("\\s+");
            int num = Integer.parseInt(s[2]);
            if(num > 99 || num < 1){
                System.out.println("只能輸入1 ~ 99的數字");
                return null;
            } else if (s.length > 3){
                System.out.println("格式不正確 請輸入: /mary all 數字");
                return null;
            }
            int[] allNum = new int[9];
            Arrays.fill(allNum,num);
            for (int i : allNum) {
                useTotalCoin += i;
            }

            user.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            user.setPrizeListMap(prizeOptionUserValue(allNum));
            user.setResult(prizeStr);
            user.setPay(useTotalCoin);
            user.setGetCoin(prizeValue * num);
            user.setUserCoin(userCoin - useTotalCoin + (prizeValue * num));
            return user;
        } else if (strArr.startsWith("/mary")){
            String[] s = strArr.trim().split("\\s+");

            if (s.length > 10) {
                System.out.println("數字輸入上限 9 組");
            }

            int[] saveNumArr = new int[9];

            for (int i = 0; i < saveNumArr.length && (i + 1) < s.length; i++) {
                int num = Integer.parseInt(s[i + 1]);
                if (num < 1 || num > 99) {
                    System.out.println("每組數字限制 1 ~ 99");
                    return null;
                }
                saveNumArr[i] = num;
            }

            useTotalCoin = 0;
            for (int i : saveNumArr) {
                useTotalCoin += i;
            }

            getSaveNumArrValue = saveNumArr[randomNum];
            int result = getSaveNumArrValue != 0 ? getSaveNumArrValue * prizeValue : 0;


            user.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            user.setPrizeListMap(prizeOptionUserValue(saveNumArr));
            user.setResult(prizeStr);
            user.setPay(useTotalCoin);
            user.setGetCoin(result);
            user.setUserCoin(userCoin-useTotalCoin+result);
        } else {
            System.out.println("格式錯誤");
            return null;
        }

        return user;
    }

    public static Map<String, Integer> prizeOption() {
        // LinkedHashMap 保持插入順序
        Map<String, Integer> prize = new LinkedHashMap<>();
        prize.put("櫻桃 (2)", 2);
        prize.put("蘋果 (5)", 5);
        prize.put("橘子 (10)", 10);
        prize.put("葡萄 (15)", 15);
        prize.put("西瓜 (20)", 20);
        prize.put("鈴鐺 (20)", 20);
        prize.put("星星 (30)", 30);
        prize.put("7 (40)", 40);
        prize.put("777 (100)", 100);
        return prize;
    }

    public static Map<String, Integer> prizeOptionUserValue(int[] saveNumArr) {
        Map<String, Integer> prize = new LinkedHashMap<>();
        prize.put("櫻桃 (2)", saveNumArr[0]);
        prize.put("蘋果 (5)", saveNumArr[1]);
        prize.put("橘子 (10)", saveNumArr[2]);
        prize.put("葡萄 (15)", saveNumArr[3]);
        prize.put("西瓜 (20)", saveNumArr[4]);
        prize.put("鈴鐺 (20)", saveNumArr[5]);
        prize.put("星星 (30)", saveNumArr[6]);
        prize.put("7 (40)", saveNumArr[7]);
        prize.put("777 (100)", saveNumArr[8]);
        return prize;
    }
}

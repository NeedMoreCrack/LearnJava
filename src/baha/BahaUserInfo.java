package baha;

import java.util.Map;

public class BahaUserInfo {
    private String userName = "Mary";
    private String dateTime;
    private Map<String,Integer> prizeListMap;
    private String result;
    private int pay;
    private int getCoin;
    private int userCoin = 10000;

    public BahaUserInfo (){};

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : prizeListMap.entrySet()) {
            sb.append(entry.getKey())
                .append(" = ")
                .append(entry.getValue())
                .append("\n");
        }
        return
            "\n" + userName + "\n" +
            dateTime + "\n\n" +
            sb + "\n" +
            "開獎結果：" + result + "\n" +
            "付出 " + pay + " 巴幣" + "，獲得 " + getCoin + " 巴幣" + "\n" +
            "剩餘巴幣：" + userCoin + "\n"
            ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Map<String, Integer> getPrizeListMap() {
        return prizeListMap;
    }

    public void setPrizeListMap(Map<String, Integer> prizeListMap) {
        this.prizeListMap = prizeListMap;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getGetCoin() {
        return getCoin;
    }

    public void setGetCoin(int getCoin) {
        this.getCoin = getCoin;
    }

    public int getUserCoin() {
        return userCoin;
    }

    public void setUserCoin(int userCoin) {
        this.userCoin = userCoin;
    }

    public BahaUserInfo(String userName, String dateTime, Map<String, Integer> prizeListMap, String result, int pay, int getCoin, int userCoin) {
        this.userName = userName;
        this.dateTime = dateTime;
        this.prizeListMap = prizeListMap;
        this.result = result;
        this.pay = pay;
        this.getCoin = getCoin;
        this.userCoin = userCoin;
    }
}

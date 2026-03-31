package sports;

public class Test {
    public static void main(String[] args) {
       BasketballCoach bc = new BasketballCoach();
       bc.setName("Tom");
       bc.setAge(40);
       System.out.println("籃球教練："+bc.getName()+"\n年齡："+bc.getAge());
       bc.teachBasketball();
       bc.speakEng();
    }
}

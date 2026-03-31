package sports;

public class BasketballCoach extends People implements English{
    public void teachBasketball(){
        System.out.println("教打籃球");
    }
    @Override
    public void speakEng(){
        System.out.println("說英語");
    }
}

package sports;

public class PingPongCoach extends People implements English{
    public void teachPingPong(){
        System.out.println("教打乒乓球");
    }
    @Override
    public void speakEng(){
        System.out.println("說英語");
    }
}

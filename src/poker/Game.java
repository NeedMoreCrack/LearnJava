package poker;

import javax.swing.*;

public class Game extends JFrame {

    Game(Login login){
        initJFrame();
    }

    public void initJFrame(){
        this.setSize(500,500);
        this.setTitle("Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setVisible(true);
    }
}

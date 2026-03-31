package poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Login extends JFrame {
    List<Users> userInfoArr = new ArrayList<>();
    JLabel errorInfo = new JLabel();
    JLabel captchaShow = new JLabel();
    String captchaReturnText = "";

    Login() throws IOException {
        getUserInfo();//get userinfo.txt content
        userInfoArr.forEach(System.out::println);
        captcha();
        initJFrame();
        loginPage();
        this.setVisible(true);
//        showMouseXY();
    }

    public void getUserInfo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/poker/userinfo.txt"));
        String line;
        while((line=br.readLine()) != null){
            Users users;
            String[] userInfo = line.split("&");
            users = new Users(
                userInfo[0].split("=")[1],//user name
                userInfo[1].split("=")[1],//user password
                Integer.parseInt(userInfo[2].split("=")[1])//error count
            );
            userInfoArr.add(users);
        }
    }

    public void captcha(){
        captchaShow.setBounds(240,300,100,35);
        captchaShow.setFont(new Font(null, Font.BOLD,24));
        StringBuilder eng = new StringBuilder();
        StringBuilder num = new StringBuilder();
        Random r = new Random();
        StringBuilder captcha = new StringBuilder();
        for(char i=65;i<91;i++){
            eng.append(i);
        }
        for(char i=97;i<123;i++){
            eng.append(i);
        }
        for (int i = 0; i < 10; i++) {
            num.append(i);
        }
        while(captcha.length() < 5){
            if(captcha.length() < 4){
                captcha.append(eng.charAt(r.nextInt(52)));
            }else{
                captcha.append(num.charAt(r.nextInt(10)));
            }
        }
        captchaShow.setText("");
        captchaReturnText = captcha.toString();
        captchaShow.setText(captchaReturnText);
        this.add(captchaShow);
    }

    public void checkLogin(String account,char[] password,String captcha,String captchaText,List<Users> userInfoArr){
        if(!captcha.equals(captchaText)){
            showError(1);
        }else{
            if(userInfoArr.isEmpty()){
                showError(-1);
            }else{
                Users nowUser = null;
                for (Users users : userInfoArr) {
                    if(account.equals(users.getAccount())){
                        nowUser = users;
                        break;
                    }
                }
                if(nowUser != null){
                    if(!account.equals(nowUser.getAccount()) && !new String(password).equals(nowUser.getPassword())){
                        showError(2);
                    } else if (account.equals(nowUser.getAccount()) && !new String(password).equals(nowUser.getPassword())) {
                        if(nowUser.getErrorCount() >= 3){
                            showError(4);
                        }else{
                            showError(3);
                            int errorCount = nowUser.getErrorCount();
                            nowUser.setErrorCount(++errorCount);
                            System.out.println(nowUser);
                        }
                    } else if (account.equals(nowUser.getAccount()) && new String(password).equals(nowUser.getPassword())) {
                        showError(0);
                        nowUser.setErrorCount(0);
                        javax.swing.Timer timer = new javax.swing.Timer(1500,e -> {
                            new Game(Login.this);
                            setVisible(false);
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }else{
                    showError(-1);
                }
            }
        }
    }

    public void showError(int errorNum){
        //Show error
        if(errorNum == -1) {
            showErrorOrSuccess("Account does not exist");
        } else if (errorNum == 1){
            showErrorOrSuccess("Error captcha");
        } else if (errorNum == 2) {
            showErrorOrSuccess("Account or password error");
        } else if (errorNum == 3) {
            showErrorOrSuccess("Password error");
        } else if(errorNum == 4){
            showErrorOrSuccess("Account is locked!");
        } else if (errorNum == 0) {
            showErrorOrSuccess("Success");
        }
    }

    public void showErrorOrSuccess(String errorText){
        errorInfo.setText("");
        errorInfo.setText(errorText);
        errorInfo.setBounds(70,50,350,50);
        errorInfo.setFont(new Font(null, Font.BOLD,24));
        errorInfo.setHorizontalAlignment(JLabel.CENTER);
    }

    public void loginPage(){
        //Top bar icon
        ImageIcon i = new ImageIcon("src/poker/image/images.png");
        this.setIconImage(i.getImage());

        //Left text
        JLabel account = new JLabel("Account:");
        JLabel password = new JLabel("Password:");
        JLabel captcha = new JLabel("Captcha:");
        account.setBounds(120,150,75,25);
        password.setBounds(110,200,75,25);
        captcha.setBounds(120,250,75,25);

        //right input
        JTextField accountEnter = new JTextField("");
        JPasswordField passwordEnter = new JPasswordField("");
        JTextField captchaEnter = new JTextField("");
        accountEnter.setBounds(200,150,150,25);
        passwordEnter.setBounds(200,200,150,25);
        captchaEnter.setBounds(200,250,150,25);

        //Button
        JButton refreshCaptcha = new JButton("refresh");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        refreshCaptcha.setBounds(110,300,85,35);
        loginButton.setBounds(110,370,100,35);
        registerButton.setBounds(250,370,100,35);

        //refresh captcha
        refreshCaptcha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                captcha();
            }
        });

        //press login button
        loginButton.addActionListener(e->checkLogin(
            accountEnter.getText().trim().isEmpty()  ? "" : accountEnter.getText(),
            passwordEnter.getPassword(),
            captchaEnter.getText().trim().isEmpty() ? "" : captchaEnter.getText(),
            captchaReturnText,
            userInfoArr
        ));

        //press register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                accountEnter.setText("");
                passwordEnter.setText("");
                captchaEnter.setText("");
                new Register(Login.this);
            }
        });

        //add to JFrame
        this.getContentPane();
        this.add(errorInfo);
        this.add(account);
        this.add(password);
        this.add(captchaEnter);
        this.add(captcha);
        this.add(accountEnter);
        this.add(passwordEnter);
        this.add(refreshCaptcha);
        this.add(loginButton);
        this.add(registerButton);
    }

    public void initJFrame(){
        this.setSize(500,500);
        this.setTitle("Login");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
    }



    public void showMouseXY(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login_Page extends JFrame {
    /*final private Font mainFont = new Font("serif", Font.BOLD, 15);

    JLabel welcome,dontHaveAccount;
    JTextField tfName, tfSurname;

    Login_Page(){
        //NAME LABEL
        JLabel name = new JLabel("Name");
        name.setFont(mainFont); 
        //name.setForeground(Color.BLUE);
        tfName = new JTextField();
        tfName.setFont(mainFont);

        //SURNAME LABEL
        JLabel surname = new JLabel("Surname");
        surname.setFont(mainFont); 
        //surname.setForeground(Color.BLUE);
        tfSurname = new JTextField();
        tfSurname.setFont(mainFont);

        // LOGIN INFO PANEL
        JPanel loginInfo = new JPanel();
        loginInfo.setLayout(new GridLayout(8, 8, 5, 5));
        loginInfo.setOpaque(false);
        loginInfo.add(name);
        loginInfo.add(tfName);
        loginInfo.add(surname);
        loginInfo.add(tfSurname);

        //WELCOME LABEL
        welcome = new JLabel("Welcome to CEPVET");
        welcome.setForeground(Color.RED);
        welcome.setFont(mainFont);

        ImageIcon welcomeSymbol = new ImageIcon(ClassLoader.getSystemResource("welcome_image.png"));
        Image welcomeScaled = welcomeSymbol.getImage().getScaledInstance(450, 200, Image.SCALE_DEFAULT);
        ImageIcon welcomeImageIcon = new ImageIcon(welcomeScaled);
        JLabel welcomeImage = new JLabel(welcomeImageIcon);

        //LOGIN BUTTON
        JButton loginButton = new JButton("Login");
        loginButton.setFont(mainFont);
        /*loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = tfName.getText();
                String surname = tfSurname.getText();
                welcome.setText("Hello " + name.toUpperCase() + " " + surname.toUpperCase());
            }
        });

        //SIGN UP BUTTON
        JButton signupButton = new JButton("Sign Up");                  //go to the next page to sign up
        signupButton.setFont(mainFont);

        // BUTTON PANEL
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(loginButton);
        buttonsPanel.add(signupButton);
        buttonsPanel.setOpaque(false);

        //IMAGE
        ImageIcon cattleSymbol = new ImageIcon(ClassLoader.getSystemResource("cattle.png"));
        Image cattleScaled = cattleSymbol.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon cattlImageIcon = new ImageIcon(cattleScaled);
        JLabel image = new JLabel(cattlImageIcon);

        //DONT HAVE AN ACCOUNT?
        dontHaveAccount = new JLabel("Don't have an account? Plese sign up.");
        dontHaveAccount.setFont(mainFont);
        
        // BACKGROUND IMAGE
        ImageIcon backgroundSymbol = new ImageIcon(ClassLoader.getSystemResource("cow_background.jpeg"));
        Image backgroundScaled = backgroundSymbol.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon backgroundImageIcon = new ImageIcon(backgroundScaled);

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(image, gbc);

        gbc.gridy = 1;
        mainPanel.add(welcomeImage, gbc);

        gbc.gridy = 2;
        mainPanel.add(loginInfo, gbc);

        gbc.gridy = 3;
        mainPanel.add(buttonsPanel, gbc);

        gbc.gridy = 4;
        mainPanel.add(dontHaveAccount, gbc);

        // ADD MAIN PANEL TO FRAME
        add(mainPanel);

        //SIZES
        setTitle("Login");
        //setSize(600,1200);
        //setLocation(200,50);
        setMinimumSize(new Dimension(500,850));
        setMaximumSize(new Dimension(500,850));                     //make it not changable
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new Login_Page();
    }*/
}

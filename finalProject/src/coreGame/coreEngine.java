package coreGame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class coreEngine extends JFrame {

    public static int index = 0; //max 22
    public static int scorePlayerOne = 0;
    public static int scorePlayerTwo = 0;
    private JPanel contentPane;
    private JTextField txtAnswerOne;
    private JTextField txtAnswerTwo;
    private JLabel lblPlayerOneName;
    private JLabel lblPlayerTwoName;
    private JButton btnAnswerOne;
    private JLabel lblScorePlayerOne;
    private JLabel lblTurnTwo;
    private JLabel lblTurnOne;
    private JLabel lblResult;
    private JButton btnAnswerTwo;
    private JLabel lblNameOfCountry;
    private JLabel lblPlayerTwoScore;
    private JLabel lblEnd;
    private JButton btnInfo;
    private JLabel lblPicture;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    coreEngine frame = new coreEngine("", "", true, true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public coreEngine(String playerOneName, String playerTwoName, boolean playerOneTurn, boolean playerTwoTurn) {
        String[][] countriesAndCapitals = {
                {"България", "Англия", "Русия", "Белгия", "Бразилия", "Канада", "Чили", "Китай", "Гърция", "Унгария",
                        "Италия", "Япония", "Саудитска арабия", "Швейцария", "САЩ", "Мексико",
                        "Малта", "Люксембург", "Македония", "Либия", "Монако", "Германия", "Сърбия"},
                {"София", "Лондон", "Москва", "Брюсел", "Бразилия", "Отава", "Сантяго", "Пекин", "Атина",
                        "Будапеща", "Рим", "Токио", "Рияд", "Берн", "Вашингтон", "Мексико",
                        "Валета", "Люксембург", "Скопие", "Триполи", "Монако", "Берлин", "Белград"}
        };
        String[] iconicPicture = {
                "src/images/picOne.jpg", "src/images/picTwo.jpg", "src/images/picThree.jpg", "src/images/picFour.jpg",
                "src/images/picFive.jpg",
                "src/images/picSix.jpg", "src/images/picSeven.jpg", "src/images/picEight.jpg", "src/images/picNine.jpg",
                "src/images/picTen.jpg", "src/images/picEleven.jpg", "src/images/picTwelve.jpg", "src/images/picThirTeen.jpg",
                "src/images/picFourTeen.jpg", "src/images/picFifTeen.jpg", "src/images/picSixTeen.jpg",
                "src/images/picSevenTeen.jpg", "src/images/picEightTeen.jpeg", "src/images/picNineTeen.jpg",
                "src/images/picTwenty.jpg", "src/images/picTwentyOne.jpg", "src/images/picTwentyTwo.jpg",
                "src/images/picTwentyThree.jpg",
        };
        setTitle("Познай столицата!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 533);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(211, 211, 211));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPicture = new JLabel("");
        lblPicture.setBounds(211, 146, 222, 148);
        contentPane.add(lblPicture);

        lblPlayerOneName = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
        lblPlayerOneName.setBounds(10, 108, 92, 14);
        contentPane.add(lblPlayerOneName);

        lblPlayerTwoName = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
        lblPlayerTwoName.setBounds(509, 108, 92, 14);
        contentPane.add(lblPlayerTwoName);

        txtAnswerOne = new JTextField();
        txtAnswerOne.setBounds(10, 204, 155, 30);
        contentPane.add(txtAnswerOne);
        txtAnswerOne.setColumns(10);

        txtAnswerTwo = new JTextField();
        txtAnswerTwo.setColumns(10);
        txtAnswerTwo.setBounds(483, 204, 155, 30);
        contentPane.add(txtAnswerTwo);

        JLabel lblScore = new JLabel("Точки:");
        lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblScore.setBounds(10, 434, 69, 14);
        contentPane.add(lblScore);

        lblScorePlayerOne = new JLabel("0");
        lblScorePlayerOne.setForeground(new Color(0, 0, 205));
        lblScorePlayerOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblScorePlayerOne.setBounds(102, 430, 89, 20);
        contentPane.add(lblScorePlayerOne);

        JLabel lblScore_1 = new JLabel("Точки:");
        lblScore_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblScore_1.setBounds(483, 434, 69, 14);
        contentPane.add(lblScore_1);

        lblPlayerTwoScore = new JLabel("0");
        lblPlayerTwoScore.setForeground(new Color(0, 0, 205));
        lblPlayerTwoScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPlayerTwoScore.setBounds(548, 430, 111, 20);
        contentPane.add(lblPlayerTwoScore);

        JLabel lblYourAnwser = new JLabel("Вашия отговор:");
        lblYourAnwser.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblYourAnwser.setBounds(10, 146, 162, 20);
        contentPane.add(lblYourAnwser);

        JLabel lblYourAnwser_1 = new JLabel("Вашия отговор:");
        lblYourAnwser_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblYourAnwser_1.setBounds(497, 146, 162, 20);
        contentPane.add(lblYourAnwser_1);

        JLabel lblNameOfThe = new JLabel("Име на държавата:");
        lblNameOfThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNameOfThe.setBounds(211, 56, 194, 33);
        contentPane.add(lblNameOfThe);

        lblNameOfCountry = new JLabel("\u0412\u0440\u0430\u0446\u0430");
        lblNameOfCountry.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNameOfCountry.setForeground(new Color(255, 0, 0));
        lblNameOfCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNameOfCountry.setBounds(251, 101, 218, 22);
        contentPane.add(lblNameOfCountry);

        btnAnswerOne = new JButton("Провери");
        btnAnswerOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!(scorePlayerOne == 8)) {
                    if (index == countriesAndCapitals[1].length - 1) {
                        index = 0;
                    } else {
                        System.out.println();
                    }
                    hideLblOneShowLblTwo();
                    String answerPlayerOne = txtAnswerOne.getText();
                    if (answerPlayerOne.equalsIgnoreCase(countriesAndCapitals[1][index])) {
                        lblResult.setText("Правилно! " + playerOneName);
                        scorePlayerOne += 1;
                        index += 1;
                        lblNameOfCountry.setText(countriesAndCapitals[0][index]);
                        lblPicture.setIcon(new ImageIcon(iconicPicture[index]));
                        disableButtonOneEnableButtonTwo();
                        lblScorePlayerOne.setText(Integer.toString(scorePlayerOne));
                        resetTheTextFields();
                    } else {

                        lblResult.setText("Грешно! " + playerOneName);
                        disableButtonOneEnableButtonTwo();
                        index += 1;
                        lblNameOfCountry.setText(countriesAndCapitals[0][index]);
                        lblPicture.setIcon(new ImageIcon(iconicPicture[index]));
                        lblScorePlayerOne.setText(Integer.toString(scorePlayerOne));
                        resetTheTextFields();

                    }
                } else {
                    showLblOneHideLblTwo();
                    lblTurnOne.setText("Вие Печелите!");
                    lblTurnTwo.setForeground(Color.GREEN);
                    disableBothButtons();
                }

            }
        });
        btnAnswerOne.setBackground(new Color(144, 238, 144));
        btnAnswerOne.setBounds(13, 277, 152, 116);
        contentPane.add(btnAnswerOne);

        lblPlayerOneName.setText(playerOneName);
        lblPlayerTwoName.setText(playerTwoName);

        lblTurnOne = new JLabel("Ваш Ред!");
        lblTurnOne.setForeground(Color.RED);
        lblTurnOne.setVisible(false);
        lblTurnOne.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTurnOne.setBounds(10, 11, 371, 34);
        contentPane.add(lblTurnOne);

        lblTurnTwo = new JLabel("Ваш Ред!");
        lblTurnTwo.setForeground(Color.RED);
        lblTurnTwo.setVisible(false);
        lblTurnTwo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTurnTwo.setBounds(477, 7, 182, 43);
        contentPane.add(lblTurnTwo);

        lblResult = new JLabel("");
        lblResult.setForeground(new Color(72, 209, 204));
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblResult.setBounds(187, 282, 282, 137);
        contentPane.add(lblResult);

        btnAnswerTwo = new JButton("Провери");
        btnAnswerTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent args0) {
                if (!(scorePlayerTwo == 8)) {
                    if (index == countriesAndCapitals[1].length - 1) {
                        index = 0;
                    } else {
                    }
                    showLblOneHideLblTwo();
                    String answerPlayerTwo = txtAnswerTwo.getText();
                    if (answerPlayerTwo.equalsIgnoreCase(countriesAndCapitals[1][index])) {
                        lblResult.setText("Правилно! " + playerTwoName);
                        scorePlayerTwo += 1;
                        index += 1;
                        lblNameOfCountry.setText(countriesAndCapitals[0][index]);
                        lblPicture.setIcon(new ImageIcon(iconicPicture[index]));
                        enableButtonOneDisableButtonTwo();
                        lblPlayerTwoScore.setText(Integer.toString(scorePlayerTwo));
                        resetTheTextFields();
                    } else {
                        lblResult.setText("Грешно! " + playerTwoName);
                        index += 1;
                        lblNameOfCountry.setText(countriesAndCapitals[0][index]);
                        lblPicture.setIcon(new ImageIcon(iconicPicture[index]));
                        enableButtonOneDisableButtonTwo();
                        lblPlayerTwoScore.setText(Integer.toString(scorePlayerTwo));
                        resetTheTextFields();
                    }
                } else {
                    hideLblOneShowLblTwo();
                    lblTurnTwo.setText("Вие Печелите!");
                    lblTurnTwo.setForeground(Color.GREEN);
                    disableBothButtons();
                }
            }
        });
        btnAnswerTwo.setBackground(new Color(144, 238, 144));
        btnAnswerTwo.setBounds(487, 277, 152, 116);
        contentPane.add(btnAnswerTwo);
        if (playerOneTurn) {
            enableButtonOneDisableButtonTwo();
        } else {
            disableButtonOneEnableButtonTwo();
        }
        lblNameOfCountry.setText(countriesAndCapitals[0][index]);
        lblPicture.setIcon(new ImageIcon(iconicPicture[index]));

        lblEnd = new JLabel("");
        lblEnd.setForeground(Color.GREEN);
        lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblEnd.setBounds(180, 11, 243, 44);
        contentPane.add(lblEnd);

        btnInfo = new JButton("Инфо!");
        btnInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Играчите се редуват да познаят столицата на дадената държава! \n Общо 15 рунда!");
            }
        });
        btnInfo.setForeground(new Color(255, 255, 255));
        btnInfo.setBackground(new Color(0, 0, 255));
        btnInfo.setBounds(163, 461, 306, 23);
        contentPane.add(btnInfo);


    }

    public void resetTheTextFields() {
        txtAnswerTwo.setText("");
        txtAnswerOne.setText("");
    }

    public void enableButtonOneDisableButtonTwo() {
        btnAnswerOne.setEnabled(true);
        btnAnswerTwo.setEnabled(false);
    }

    public void disableButtonOneEnableButtonTwo() {
        btnAnswerOne.setEnabled(false);
        btnAnswerTwo.setEnabled(true);
    }

    public void disableBothButtons() {
        btnAnswerOne.setEnabled(false);
        btnAnswerTwo.setEnabled(false);
    }

    public void hideLblOneShowLblTwo() {
        lblTurnOne.setVisible(false);
        lblTurnTwo.setVisible(true);
    }

    public void showLblOneHideLblTwo() {
        lblTurnOne.setVisible(true);
        lblTurnTwo.setVisible(false);
    }
}
	
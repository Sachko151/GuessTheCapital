package coreGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class playerPart extends JFrame {

    String playerOneName;
    String playerTwoName;
    private JPanel contentPane;
    private JTextField txtPlayerOneName;
    private JTextField txtPlayerTwoName;
    private JLabel lblResult;
    private JLabel lblError;
    private JButton btnStart;
    private JComboBox cBPlayerOneChoice;
    private JComboBox cBPlayerTwoChoice;
    Thread thread = new Thread();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    playerPart frame = new playerPart();
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
    public playerPart() {
        setTitle("Начало!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 485);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(211, 211, 211));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblChooseYourNickname = new JLabel("Изберете свой прякор!");
        lblChooseYourNickname.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblChooseYourNickname.setBounds(123, 11, 338, 27);
        contentPane.add(lblChooseYourNickname);

        JLabel lblNameOfPlayer = new JLabel("Име на Играч 1:");
        lblNameOfPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNameOfPlayer.setBounds(21, 84, 149, 14);
        contentPane.add(lblNameOfPlayer);

        txtPlayerOneName = new JTextField();
        txtPlayerOneName.setBounds(21, 125, 86, 20);
        contentPane.add(txtPlayerOneName);
        txtPlayerOneName.setColumns(10);

        txtPlayerTwoName = new JTextField();
        txtPlayerTwoName.setColumns(10);
        txtPlayerTwoName.setBounds(528, 125, 86, 20);
        contentPane.add(txtPlayerTwoName);

        JLabel lblHeadsOrTails = new JLabel("Избор:");
        lblHeadsOrTails.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHeadsOrTails.setBounds(21, 206, 149, 17);
        contentPane.add(lblHeadsOrTails);

        JLabel lblNameOfPlayer_1 = new JLabel("Име на Играч 2:");
        lblNameOfPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNameOfPlayer_1.setBounds(495, 87, 149, 14);
        contentPane.add(lblNameOfPlayer_1);

        JLabel lblPlayerChoice = new JLabel("Избор:");
        lblPlayerChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPlayerChoice.setBounds(495, 209, 149, 14);
        contentPane.add(lblPlayerChoice);

        cBPlayerOneChoice = new JComboBox();
        cBPlayerOneChoice.setBounds(11, 266, 96, 20);
        cBPlayerOneChoice.addItem("---");
        cBPlayerOneChoice.addItem("ези");
        cBPlayerOneChoice.addItem("тура");
        contentPane.add(cBPlayerOneChoice);

        cBPlayerTwoChoice = new JComboBox();
        cBPlayerTwoChoice.setBounds(518, 266, 96, 20);
        cBPlayerTwoChoice.addItem("---");
        cBPlayerTwoChoice.addItem("ези");
        cBPlayerTwoChoice.addItem("тура");
        contentPane.add(cBPlayerTwoChoice);

        btnStart = new JButton("Започни Играта!");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String playerOneName = txtPlayerOneName.getText();
                String playerTwoName = txtPlayerTwoName.getText();
                String playerOneChoice = cBPlayerOneChoice.getSelectedItem().toString();
                String playerTwoChoice = cBPlayerTwoChoice.getSelectedItem().toString();
                boolean playerOneTurn = false;
                boolean playerTwoTurn = false;
                Random rand = new Random();
                int tailsOrHeads = rand.nextInt(2);
                if (checkIfChoicesAreCorrect(playerOneChoice, playerTwoChoice)) {
                    switch (tailsOrHeads) {
                        case 0:
                            lblResult.setText("Тура!");
                            lblResult.setIcon(new ImageIcon("src/images/heads.jpg"));
                            break;
                        default:
                            lblResult.setText("Ези!");
                            lblResult.setIcon(new ImageIcon("src/images/tails.jpg"));
                            break;
                    }
                    if ((playerOneChoice.equalsIgnoreCase("тура") && tailsOrHeads == 0) ||
                            (playerOneChoice.equalsIgnoreCase("ези") && tailsOrHeads == 1)) {
                        playerOneTurn = true;
                    } else {
                        playerTwoTurn = true;
                    }
                    if (playerOneTurn) {
                        lblError.setText("Първи ще е: " + playerOneName);
                        lblError.setForeground(Color.GREEN);
                        new coreEngine(playerOneName, playerTwoName, playerOneTurn, playerTwoTurn).setVisible(true);
                        btnStart.setEnabled(false);
                    } else {
                        lblError.setText("Първи ще е: " + playerTwoName);
                        lblError.setForeground(Color.GREEN);

                        new coreEngine(playerOneName, playerTwoName, playerOneTurn, playerTwoTurn).setVisible(true);
                        btnStart.setEnabled(false);
                    }
                } else {
                    lblError.setText("Неправилни данни!");
                    lblError.setForeground(Color.RED);
                }
            }

        });


        btnStart.setBounds(247, 367, 144, 44);
        contentPane.add(btnStart);

        lblResult = new JLabel("");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblResult.setBounds(247, 125, 173, 161);
        contentPane.add(lblResult);

        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblError.setBounds(136, 266, 325, 83);
        contentPane.add(lblError);

        JButton btnNewButton = new JButton("Инфо");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Изберете прякор и ези или тура!" +
                        "\nОт избора зависи кой ще бъде първи във играта!");
            }
        });
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(570, 388, 89, 23);
        contentPane.add(btnNewButton);


    }

    public static boolean checkIfChoicesAreCorrect(String playerOneChoice, String playerTwoChoice) {
        if ((!(playerOneChoice.equalsIgnoreCase("тура") ||
                playerOneChoice.equalsIgnoreCase("ези"))) ||
                (!(playerTwoChoice.equalsIgnoreCase("тура") ||
                        playerTwoChoice.equalsIgnoreCase("ези"))) ||
                (playerOneChoice.equalsIgnoreCase("тура") &&
                        playerTwoChoice.equalsIgnoreCase("тура")) ||
                (playerOneChoice.equalsIgnoreCase("ези") &&
                        playerTwoChoice.equalsIgnoreCase("ези"))) {
            return false;
        } else {
            return true;
        }

    }
}

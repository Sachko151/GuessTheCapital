package withInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Random;

import javax.swing.SwingConstants;
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
                {"Bulgaria", "England", "Russia", "Belgium", "Brazil", "Canada", "Chile", "China", "Greece", "Hungary",
                        "Italy", "Japan", "Saudi Arabia", "Switzerland", "United States of America", "Mexico",
                        "Malta", "Luxembourg", "Macedonia", "Libya", "Monaco", "Germany", "Serbia"},
                {"Sofia", "London", "Moscow", "Brussels", "Brasilia", "Ottawa", "Santiago", "Beijing", "Athens",
                        "Budapest", "Rome", "Tokyo", "Riyadh", "Bern", "Washington", "Mexico",
                        "Valletta", "Luxembourg", "Skopje", "Tripoli", "Monaco", "Berlin", "Belgrade"}
        };
		setTitle("Guess the Capital!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayerOneName = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
		lblPlayerOneName.setBounds(10, 65, 92, 14);
		contentPane.add(lblPlayerOneName);
		
		lblPlayerTwoName = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
		lblPlayerTwoName.setBounds(567, 65, 92, 14);
		contentPane.add(lblPlayerTwoName);
		
		txtAnswerOne = new JTextField();
		txtAnswerOne.setBounds(10, 144, 155, 30);
		contentPane.add(txtAnswerOne);
		txtAnswerOne.setColumns(10);
		
		txtAnswerTwo = new JTextField();
		txtAnswerTwo.setColumns(10);
		txtAnswerTwo.setBounds(504, 144, 155, 30);
		contentPane.add(txtAnswerTwo);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setBounds(23, 397, 69, 14);
		contentPane.add(lblScore);
		
		lblScorePlayerOne = new JLabel("0");
		lblScorePlayerOne.setForeground(new Color(0, 0, 205));
		lblScorePlayerOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblScorePlayerOne.setBounds(108, 393, 89, 20);
		contentPane.add(lblScorePlayerOne);
		
		JLabel lblScore_1 = new JLabel("Score:");
		lblScore_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore_1.setBounds(482, 397, 69, 14);
		contentPane.add(lblScore_1);
		
		lblPlayerTwoScore = new JLabel("0");
		lblPlayerTwoScore.setForeground(new Color(0, 0, 205));
		lblPlayerTwoScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerTwoScore.setBounds(548, 393, 111, 20);
		contentPane.add(lblPlayerTwoScore);
		
		JLabel lblYourAnwser = new JLabel("Your anwser:");
		lblYourAnwser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourAnwser.setBounds(10, 102, 162, 20);
		contentPane.add(lblYourAnwser);
		
		JLabel lblYourAnwser_1 = new JLabel("Your anwser:");
		lblYourAnwser_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourAnwser_1.setBounds(507, 102, 162, 20);
		contentPane.add(lblYourAnwser_1);
		
		JLabel lblNameOfThe = new JLabel("Name Of The Country:");
		lblNameOfThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameOfThe.setBounds(229, 111, 194, 33);
		contentPane.add(lblNameOfThe);
		
		lblNameOfCountry = new JLabel("\u0412\u0440\u0430\u0446\u0430");
		lblNameOfCountry.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNameOfCountry.setForeground(new Color(255, 0, 0));
		lblNameOfCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameOfCountry.setBounds(276, 145, 105, 22);
		contentPane.add(lblNameOfCountry);
		
		btnAnswerOne = new JButton("Submit");
		btnAnswerOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(scorePlayerOne == 9)){
				if(index == 22){
					index = 0;
				} else{}
		                lblTurnOne.setVisible(false);
		                lblTurnTwo.setVisible(true);
		                String answerPlayerOne = txtAnswerOne.getText();
		                if (answerPlayerOne.equalsIgnoreCase(countriesAndCapitals[1][index])) {
		                    lblResult.setText("Correct! " + playerOneName);
		                    scorePlayerOne+=1;
		                    index+=1;
		                    lblNameOfCountry.setText(countriesAndCapitals[0][index]);
		                    btnAnswerOne.setEnabled(false);
		                	btnAnswerTwo.setEnabled(true);
		                    lblScorePlayerOne.setText(Integer.toString(scorePlayerOne));
		                    txtAnswerTwo.setText("");
		                	txtAnswerOne.setText("");
		                } else {
		                	
		                    lblResult.setText("Not Correct!" + playerOneName);
		                    btnAnswerOne.setEnabled(false);
		                	btnAnswerTwo.setEnabled(true);
		                	index+=1;
		                	lblNameOfCountry.setText(countriesAndCapitals[0][index]);
		                    lblScorePlayerOne.setText(Integer.toString(scorePlayerOne));
		                    txtAnswerTwo.setText("");
		                	txtAnswerOne.setText("");
		                }
				}   else {
					lblTurnOne.setVisible(true);
	                lblTurnTwo.setVisible(false);
	                lblTurnOne.setText("You Are The Winner!");
	                lblTurnTwo.setForeground(Color.GREEN);
	                btnAnswerTwo.setEnabled(false);
	                btnAnswerOne.setEnabled(false);
				}
			
				}
		});
		btnAnswerOne.setBackground(new Color(144, 238, 144));
		btnAnswerOne.setBounds(13, 209, 152, 116);
		contentPane.add(btnAnswerOne);
		
		lblPlayerOneName.setText(playerOneName);
		lblPlayerTwoName.setText(playerTwoName);
		
		lblTurnOne = new JLabel("Your Turn:");
		lblTurnOne.setForeground(Color.RED);
		lblTurnOne.setVisible(false);
		lblTurnOne.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTurnOne.setBounds(10, 11, 371, 34);
		contentPane.add(lblTurnOne);
		
		lblTurnTwo = new JLabel("Your Turn:");
		lblTurnTwo.setForeground(Color.RED);
		lblTurnTwo.setVisible(false);
		lblTurnTwo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTurnTwo.setBounds(477, 11, 182, 43);
		contentPane.add(lblTurnTwo);
		
		lblResult = new JLabel("");
		lblResult.setForeground(new Color(72, 209, 204));
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResult.setBounds(187, 224, 282, 137);
		contentPane.add(lblResult);
		
		btnAnswerTwo = new JButton("Submit");
		btnAnswerTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0 ) {
				if(!(scorePlayerTwo == 9)){
				if(index == 22){
					index = 0;
				} else{}
		                lblTurnOne.setVisible(true);
		                lblTurnTwo.setVisible(false);
		                String answerPlayerTwo = txtAnswerTwo.getText();
		                if (answerPlayerTwo.equalsIgnoreCase(countriesAndCapitals[1][index])) {
		                    lblResult.setText("Correct! " + playerTwoName);
		                    scorePlayerTwo+=1;
		                    btnAnswerTwo.setEnabled(false);
		                    index+=1;
		                    lblNameOfCountry.setText(countriesAndCapitals[0][index]);
		                	btnAnswerOne.setEnabled(true);
		                	lblPlayerTwoScore.setText(Integer.toString(scorePlayerTwo));
		                	txtAnswerTwo.setText("");
		                	txtAnswerOne.setText("");
		                } else {
		                    lblResult.setText("Not Correct!" + playerTwoName);
		                    index+=1;
		                    lblNameOfCountry.setText(countriesAndCapitals[0][index]);
		                    btnAnswerTwo.setEnabled(false);
		                	btnAnswerOne.setEnabled(true);
		                	lblPlayerTwoScore.setText(Integer.toString(scorePlayerTwo));
		                	txtAnswerTwo.setText("");
		                	txtAnswerOne.setText("");
		                }
			} else{
				lblTurnOne.setVisible(false);
                lblTurnTwo.setVisible(true);
                lblTurnTwo.setText("You Are The Winner!");
                lblTurnTwo.setForeground(Color.GREEN);
                btnAnswerTwo.setEnabled(false);
                btnAnswerOne.setEnabled(false);
			}
			}
		});
		btnAnswerTwo.setBackground(new Color(144, 238, 144));
		btnAnswerTwo.setBounds(497, 209, 152, 116);
		contentPane.add(btnAnswerTwo);
        if (playerOneTurn) {
        	btnAnswerOne.setEnabled(true);
        	btnAnswerTwo.setEnabled(false);
        } else {
        	btnAnswerOne.setEnabled(false);
        	btnAnswerTwo.setEnabled(true);
        }
		System.out.println();
		lblNameOfCountry.setText(countriesAndCapitals[0][index]);
		
		lblEnd = new JLabel("");
		lblEnd.setForeground(Color.GREEN);
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEnd.setBounds(180, 11, 243, 44);
		contentPane.add(lblEnd);
		
		btnInfo = new JButton("About The Game!");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Simple Game In Which The Players Have To Guess The Capital Of The Given Country! \n Best Out Of 15 Rounds!");
			}
		});
		btnInfo.setForeground(new Color(255, 255, 255));
		btnInfo.setBackground(new Color(0, 0, 255));
		btnInfo.setBounds(163, 461, 306, 23);
		contentPane.add(btnInfo);
	  }
	}
	
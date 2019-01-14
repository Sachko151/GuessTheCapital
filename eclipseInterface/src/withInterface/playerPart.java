package withInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class playerPart extends JFrame {

	String playerOneName;
	String playerTwoName;
	private JPanel contentPane;
	private JTextField txtPlayerOneName;
	private JTextField txtPlayerTwoName;
	private JTextField txtPlayerOneChoice;
	private JTextField txtPlayerTwoChoice;
	private JLabel lblResult;
	private JLabel lblError;
	private JButton btnStart;

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
	public  playerPart() {
		//static double rosen = 15.5;
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseYourNickname = new JLabel("Choose your nickname and choice!");
		lblChooseYourNickname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourNickname.setBounds(123, 11, 338, 27);
		contentPane.add(lblChooseYourNickname);
		
		JLabel lblNameOfPlayer = new JLabel("Name of Player 1:");
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
		
		JLabel lblHeadsOrTails = new JLabel("Player Choice:");
		lblHeadsOrTails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeadsOrTails.setBounds(21, 206, 149, 17);
		contentPane.add(lblHeadsOrTails);
		
		txtPlayerOneChoice = new JTextField();
		txtPlayerOneChoice.setColumns(10);
		txtPlayerOneChoice.setBounds(21, 266, 86, 20);
		contentPane.add(txtPlayerOneChoice);
		
		txtPlayerTwoChoice = new JTextField();
		txtPlayerTwoChoice.setColumns(10);
		txtPlayerTwoChoice.setBounds(528, 266, 86, 20);
		contentPane.add(txtPlayerTwoChoice);
		
		JLabel lblNameOfPlayer_1 = new JLabel("Name of Player 2:");
		lblNameOfPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameOfPlayer_1.setBounds(495, 87, 149, 14);
		contentPane.add(lblNameOfPlayer_1);
		
		JLabel lblPlayerChoice = new JLabel("Player Choice:");
		lblPlayerChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerChoice.setBounds(495, 209, 149, 14);
		contentPane.add(lblPlayerChoice);
		
		btnStart = new JButton("Start game!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//heads = 0 tails = 1      
		        String playerOneName = txtPlayerOneName.getText(); 
		        String playerTwoName = txtPlayerTwoName.getText();
		        Data data = new Data(playerOneName, playerTwoName);
		        String playerOneChoice = txtPlayerOneChoice.getText();
		        String playerTwoChoice = txtPlayerTwoChoice.getText();
		        boolean playerOneTurn = false;
		        boolean playerTwoTurn = false;
		        Random rand = new Random();
		        int tailsOrHeads = rand.nextInt(2);
		        switch (tailsOrHeads){
		        	case 0:
		        		lblResult.setText("Heads");
		        		break;
		        	default:
		        		lblResult.setText("Tails");
		        		break;
		        }
		        if (checkIfChoicesAreCorrect(playerOneChoice, playerTwoChoice)) {
		            if ((playerOneChoice.equalsIgnoreCase("heads") && tailsOrHeads == 0) ||
		                    (playerOneChoice.equalsIgnoreCase("tails") && tailsOrHeads == 1)) {
		                playerOneTurn = true;
		            } else {
		                playerTwoTurn = true;
		            }
		            if (playerOneTurn) {
		                lblError.setText("Ïתנגט שו ו: " + playerOneName);
		                lblError.setForeground(Color.GREEN);
		                new coreEngine(playerOneName, playerTwoName, playerOneTurn, playerTwoTurn).setVisible(true);
		                btnStart.setEnabled(false);

		            } else {
		            	lblError.setText("Ïתנגט שו ו: " + playerTwoName);
		            	lblError.setForeground(Color.GREEN);
		            	new coreEngine(playerOneName, playerTwoName, playerOneTurn, playerTwoTurn).setVisible(true);
		            	btnStart.setEnabled(false);
		            }
		        } else {
		            lblError.setText("The entered choices weren't correct!");
		            lblError.setForeground(Color.RED);
		        }
			}
			
		});

		btnStart.setBounds(247, 367, 144, 44);
		contentPane.add(btnStart);
		
		lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResult.setBounds(247, 138, 173, 117);
		contentPane.add(lblResult);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblError.setBounds(136, 266, 325, 83);
		contentPane.add(lblError);
	}
	
	public static boolean checkIfChoicesAreCorrect(String playerOneChoice, String playerTwoChoice) {
        if ((!(playerOneChoice.equalsIgnoreCase("heads") ||
                playerOneChoice.equalsIgnoreCase("tails"))) || (!(playerTwoChoice.equalsIgnoreCase("heads") ||
                playerTwoChoice.equalsIgnoreCase("tails"))) || (playerOneChoice.equalsIgnoreCase("heads") &&
                playerTwoChoice.equalsIgnoreCase("heads")) || (playerOneChoice.equalsIgnoreCase("tails") &&
                playerTwoChoice.equalsIgnoreCase("tails"))) {
            return false;
        } else {
            return true;
        }

    }
}

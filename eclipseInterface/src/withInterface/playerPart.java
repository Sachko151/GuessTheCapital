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
import java.awt.event.ActionEvent;

public class playerPart extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(21, 125, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(528, 125, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblHeadsOrTails = new JLabel("Heads or tails:");
		lblHeadsOrTails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeadsOrTails.setBounds(21, 206, 149, 14);
		contentPane.add(lblHeadsOrTails);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(21, 266, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(528, 266, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblNameOfPlayer_1 = new JLabel("Name of Player 2:");
		lblNameOfPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameOfPlayer_1.setBounds(495, 87, 149, 14);
		contentPane.add(lblNameOfPlayer_1);
		
		JLabel label_1 = new JLabel("Heads or tails:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(495, 209, 149, 14);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Start game!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(247, 367, 144, 44);
		contentPane.add(btnNewButton);
	}
}

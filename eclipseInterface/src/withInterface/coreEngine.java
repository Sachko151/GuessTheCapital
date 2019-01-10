package withInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class coreEngine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coreEngine frame = new coreEngine();
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
	public coreEngine() {
		setTitle("Guess the Capital!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
		label.setBounds(10, 65, 92, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0438\u043C\u0435 \u043D\u0430 \u0438\u0433\u0440\u0430\u0447\u0430");
		label_1.setBounds(567, 65, 92, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(10, 144, 155, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(504, 144, 155, 30);
		contentPane.add(textField_1);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setBounds(23, 397, 69, 14);
		contentPane.add(lblScore);
		
		JLabel label_3 = new JLabel("0");
		label_3.setForeground(new Color(0, 0, 205));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(108, 393, 89, 20);
		contentPane.add(label_3);
		
		JLabel lblScore_1 = new JLabel("Score:");
		lblScore_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore_1.setBounds(482, 397, 69, 14);
		contentPane.add(lblScore_1);
		
		JLabel label_5 = new JLabel("0");
		label_5.setForeground(new Color(0, 0, 205));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(548, 393, 111, 20);
		contentPane.add(label_5);
		
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
		
		JLabel label_9 = new JLabel("\u0412\u0440\u0430\u0446\u0430");
		label_9.setVerticalAlignment(SwingConstants.BOTTOM);
		label_9.setForeground(new Color(255, 0, 0));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_9.setBounds(276, 145, 105, 22);
		contentPane.add(label_9);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.setBounds(13, 209, 152, 116);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Submit");
		button.setBackground(new Color(144, 238, 144));
		button.setBounds(507, 209, 152, 116);
		contentPane.add(button);
	}

}

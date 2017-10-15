package asgAP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class addTF {

	private JFrame frame;
	private JTextField question;
	private JTextField ans;

	/**
	 * Launch the application.
	 */
	public static void true_false() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTF window = new addTF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addTF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddTrueOr = new JLabel("Add True or False question");
		lblAddTrueOr.setBounds(104, 0, 240, 30);
		lblAddTrueOr.setForeground(Color.BLUE);
		lblAddTrueOr.setBackground(Color.MAGENTA);
		lblAddTrueOr.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblAddTrueOr);
		
		JLabel lblWriteQuestion = new JLabel("write question ");
		lblWriteQuestion.setBounds(10, 35, 144, 14);
		lblWriteQuestion.setForeground(Color.BLUE);
		lblWriteQuestion.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lblWriteQuestion);
		
		question = new JTextField();
		question.setBounds(40, 60, 281, 56);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JRadioButton rdbtnTrue = new JRadioButton("TRUE");
		rdbtnTrue.setBounds(6, 143, 109, 23);
		rdbtnTrue.setBackground(Color.ORANGE);
		rdbtnTrue.setForeground(Color.BLUE);
		rdbtnTrue.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(rdbtnTrue);
		
		JRadioButton rdbtnFalse = new JRadioButton("FALSE");
		rdbtnFalse.setBounds(6, 180, 109, 23);
		rdbtnFalse.setBackground(Color.ORANGE);
		rdbtnFalse.setForeground(Color.BLUE);
		rdbtnFalse.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(rdbtnFalse);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(145, 215, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String quest=question.getText();        //get the text and assign to string
				String answer=ans.getText();
				 FileOutputStream as = null;
					try {
						as = new FileOutputStream("TrueFalse.txt",true);  // opens file 
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					      ObjectOutputStream os = null;   //create output stream object
						try {
							os = new ObjectOutputStream(as);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							os.writeObject(quest);   // write to file 
							os.writeObject(answer);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				
				
				
				QuizFormat obj = new QuizFormat();
  				obj.asad();
			}
		});
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.RED);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(btnSubmit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(92, 0, 246, 30);
		textArea.setBackground(Color.PINK);
		frame.getContentPane().add(textArea);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setForeground(Color.BLUE);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnswer.setBounds(131, 149, 68, 43);
		frame.getContentPane().add(lblAnswer);
		
		ans = new JTextField();
		ans.setBounds(209, 157, 86, 30);
		frame.getContentPane().add(ans);
		ans.setColumns(10);
	}
}

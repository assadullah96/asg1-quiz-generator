package asgAP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class NumericQuiz {

	private JFrame frame;
	private JTextField question;
	private JTextField ans;

	/**
	 * Launch the application.
	 */
	public static void numeric() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumericQuiz window = new NumericQuiz();
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
	public NumericQuiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 15));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddNumericQuiz = new JLabel("Add numeric quiz");
		lblAddNumericQuiz.setBounds(130, 11, 166, 29);
		lblAddNumericQuiz.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lblAddNumericQuiz);
		
		JLabel lblDescriptionOfQuestion = new JLabel("Description of question");
		lblDescriptionOfQuestion.setBounds(10, 49, 166, 29);
		lblDescriptionOfQuestion.setForeground(Color.BLUE);
		lblDescriptionOfQuestion.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lblDescriptionOfQuestion);
		
		question = new JTextField();
		question.setBounds(48, 81, 281, 61);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JLabel lblAnswer = new JLabel("answer");
		lblAnswer.setBounds(70, 175, 80, 41);
		lblAnswer.setForeground(Color.BLUE);
		lblAnswer.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lblAnswer);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String quest=question.getText();
				String answer=ans.getText();  //get text from field 
				 FileOutputStream fs = null;
					try {
						fs = new FileOutputStream("numerical.txt",true);  //open file 
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					      ObjectOutputStream os = null;
						try {
							os = new ObjectOutputStream(fs); //create new object
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							os.writeObject(quest);
							os.writeObject(answer);     //write to file 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				
				
				QuizFormat obj = new QuizFormat();
  				obj.asad();
			}
		});
		btnSubmit.setBackground(Color.YELLOW);
		btnSubmit.setForeground(Color.RED);
		btnSubmit.setBounds(135, 227, 89, 23);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(btnSubmit);
		
		ans = new JTextField();
		ans.setBounds(130, 177, 121, 35);
		frame.getContentPane().add(ans);
		ans.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.PINK);
		textArea.setBounds(99, 11, 177, 29);
		frame.getContentPane().add(textArea);
	}

}

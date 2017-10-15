package asgAP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMcqs {

	private JFrame frame;
	private JTextField question;
	private JTextField opt1;
	private JTextField opt2;
	private JTextField opt3;
	private JTextField opt4;
	private JButton btnAdd;
	private JLabel lblA;
	private JLabel lblA_1;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;
	private JTextArea textArea;
	private JLabel lblAnswer;
	private JTextField ans;

	/**
	 * Launch the application.
	 */
	public static void addmcqs() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMcqs window = new AddMcqs();
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
	public AddMcqs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 490, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddMcqs = new JLabel("ADD MCQS");
		lblAddMcqs.setBounds(164, 10, 113, 20);
		lblAddMcqs.setBackground(Color.GREEN);
		lblAddMcqs.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblAddMcqs);
		
		JLabel lblWriteYourQuestion = new JLabel("write your question below");
		lblWriteYourQuestion.setBounds(33, 41, 255, 19);
		lblWriteYourQuestion.setForeground(Color.BLUE);
		lblWriteYourQuestion.setBackground(Color.YELLOW);
		lblWriteYourQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblWriteYourQuestion);
		
		question = new JTextField();
		question.setBounds(10, 71, 365, 56);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JLabel lblOptions = new JLabel("Write options");
		lblOptions.setBounds(33, 138, 142, 20);
		lblOptions.setForeground(Color.BLUE);
		lblOptions.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lblOptions);
		
		opt1 = new JTextField();
		opt1.setBounds(123, 169, 86, 20);
		frame.getContentPane().add(opt1);
		opt1.setColumns(10);
		
		opt2 = new JTextField();
		opt2.setBounds(123, 200, 86, 20);
		frame.getContentPane().add(opt2);
		opt2.setColumns(10);
		
		opt3 = new JTextField();
		opt3.setBounds(123, 228, 86, 20);
		frame.getContentPane().add(opt3);
		opt3.setColumns(10);
		
		opt4 = new JTextField();
		opt4.setBounds(123, 259, 86, 20);
		frame.getContentPane().add(opt4);
		opt4.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(174, 308, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// to create different questions of differente types
				//file handling
				
				
				String quest = question.getText();
				String a = opt1.getText();
				String b = opt2.getText();
				String c = opt3.getText();
				String d = opt4.getText();
				String answer = ans.getText();
				
				System.out.println(quest);
				// store in the file of asad
				
				FileOutputStream as = null;
				
				try{
					
					as = new FileOutputStream("asad.txt", true);  // to open the file
				}
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					ObjectOutputStream os = null;
					try {
						os = new ObjectOutputStream(as);   //create a object
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					try {
						os.writeObject(quest);
						os.writeObject(a);
						os.writeObject(b);    //write to file 
						os.writeObject(c);
						os.writeObject(d);
						os.writeObject(answer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
					
  				QuizFormat obj = new QuizFormat();
  				obj.asad();
			
			}
		});
		
	/*	btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
					JOptionPane.showMessageDialog(null, "successfull connection");
					
					//we have 5 entries in sql data base
					// first create query
					
					String query = "INSERT INTO assad" + " VALUES(?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
				
				    statement.setString(1,question.getText());
				    statement.setString(2,opt1.getText());
				    statement.setString(3,opt2.getText());
				    statement.setString(4,opt3.getText());
				    statement.setString(5,opt4.getText());
				    
				    statement.execute();
				    
				    // display message when data is entered successfully
				    
				    JOptionPane.showMessageDialog(null, "Data is inserted successfully"); 
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
			
			}
			
			
		});
		*/
		/*
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//create connection
				
				try {
					Class.forName("org.h2.Driver");
					Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
					JOptionPane.showMessageDialog(null, "successfull connection");
					
					//we have 5 entries in sql data base
					// first create query
					
					String query = "INSERT INTO TABLE" + " VALUES('asad','a','s','f','s')";
					PreparedStatement statement = connection.prepareStatement(query);
				//	statement.setString(arg0, arg1);
				    statement.setString(1,question.getText());
				    statement.setString(2,opt1.getText());
				    statement.setString(3,opt2.getText());
				    statement.setString(4,opt3.getText());
				    statement.setString(5,opt4.getText());
				    
				    statement.execute();
				    
				    // display message when data is entered successfully
				    
				    JOptionPane.showMessageDialog(null, "Data is inserted successfully"); 
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
			
			}
			
		});
		*/
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(btnAdd);
		
		lblA = new JLabel("a");
		lblA.setBounds(-6, 172, 46, 14);
		frame.getContentPane().add(lblA);
		
		lblA_1 = new JLabel("a)");
		lblA_1.setBounds(68, 172, 46, 14);
		lblA_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblA_1.setForeground(Color.BLUE);
		frame.getContentPane().add(lblA_1);
		
		lblB = new JLabel("b)");
		lblB.setBounds(67, 203, 46, 14);
		lblB.setFont(new Font("Dialog", Font.BOLD, 15));
		lblB.setForeground(Color.BLUE);
		frame.getContentPane().add(lblB);
		
		lblC = new JLabel("c)");
		lblC.setBounds(67, 231, 46, 14);
		lblC.setFont(new Font("Dialog", Font.BOLD, 15));
		lblC.setForeground(Color.BLUE);
		frame.getContentPane().add(lblC);
		
		lblD = new JLabel("d)");
		lblD.setBounds(67, 262, 46, 14);
		lblD.setFont(new Font("Dialog", Font.BOLD, 15));
		lblD.setForeground(Color.BLUE);
		frame.getContentPane().add(lblD);
		
		textArea = new JTextArea();
		textArea.setBounds(150, 10, 113, 20);
		textArea.setBackground(Color.YELLOW);
		frame.getContentPane().add(textArea);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnswer.setForeground(Color.BLUE);
		lblAnswer.setBounds(247, 205, 71, 15);
		frame.getContentPane().add(lblAnswer);
		
		ans = new JTextField();
		ans.setBounds(318, 204, 86, 20);
		frame.getContentPane().add(ans);
		ans.setColumns(10);
	
		}
		
		}
		
		

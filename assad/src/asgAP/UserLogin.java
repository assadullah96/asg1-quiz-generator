package asgAP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class UserLogin {

	private JFrame frame;
	private JPasswordField pwdPassword;
	private JTextField txtUsername;
	private JLabel lblRole;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 * 
	 */
	private  String possword;               //two attributes of role 
    private String name;
	/**
	 * Launch the application.
	 */
    public void setname(String user_name)       //setter function
    {
    	name=user_name;
    	
    }
    public void setpossword(String user_password)
    {
    	possword=user_password;
    	
    }
    public boolean checkLogin()         //check weather string is null or not 
    {
    	if(name==null && possword==null)
		return true;
    	else
    		return false;
    	
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
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
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Welcome to the quiz generator");
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 453, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(46, 71, 75, 22);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(131, 73, 173, 29);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(46, 104, 131, 57);
		frame.getContentPane().add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(Color.BLACK);
		pwdPassword.setBounds(131, 122, 171, 29);
		frame.getContentPane().add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setForeground(Color.RED);
		btnLogin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				String user_name=txtUsername.getText();
				String paswd=pwdPassword.getText();
				
				if(user_name.equals("asad") && paswd.equals("1234"))
				{
					
				JOptionPane.showMessageDialog(frame, "you have logined successfully");
				
				QuizFormat q = new QuizFormat();
				q.asad();
				
				}
				else
				{
					
					JOptionPane.showMessageDialog(frame, "Invalid username or password please try again");
				}
			}
		});
		btnLogin.setBounds(150, 219, 131, 37);
		frame.getContentPane().add(btnLogin);
		
		lblRole = new JLabel("Role");
		lblRole.setForeground(Color.BLUE);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(56, 170, 75, 29);
		frame.getContentPane().add(lblRole);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.addItem("");
		comboBox.addItem("Instructor");
		comboBox.addItem("Student");
		comboBox.setBounds(131, 172, 173, 29);
		frame.getContentPane().add(comboBox);
		
		
	}
}

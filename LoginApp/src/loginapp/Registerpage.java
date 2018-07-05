package loginapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registerpage {

	private JFrame frmMyDatabaseApp;
	private JTextField tf_user;
	private JTextField tf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerpage window = new Registerpage();
					window.frmMyDatabaseApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registerpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyDatabaseApp = new JFrame();
		frmMyDatabaseApp.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Loginpage window = new Loginpage();
				window.frmLoginPage.setVisible(true);
			}
		});
		frmMyDatabaseApp.setTitle("My Database App");
		frmMyDatabaseApp.setBounds(100, 100, 450, 300);
		frmMyDatabaseApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyDatabaseApp.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(10, 22, 99, 14);
		frmMyDatabaseApp.getContentPane().add(lblEnterUsername);
		
		tf_user = new JTextField();
		tf_user.setBounds(130, 19, 86, 20);
		frmMyDatabaseApp.getContentPane().add(tf_user);
		tf_user.setColumns(10);
		
		JLabel label = new JLabel("Enter Password");
		label.setBounds(10, 80, 99, 14);
		frmMyDatabaseApp.getContentPane().add(label);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(130, 77, 86, 20);
		frmMyDatabaseApp.getContentPane().add(tf_pass);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		//Get the text values for user and pass
				String user= tf_user.getText();
				String pass=tf_pass.getText();
				
				
				//Register user by sending info to database
				Database db=new Database();
				String result=db.register(user,pass);
			//Display response to the user
				JOptionPane.showMessageDialog(null,result);
			}
		
		});
		btnNewButton.setBounds(20, 140, 89, 23);
		frmMyDatabaseApp.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Loginpage lgn=new Loginpage();
				lgn.frmLoginPage.setVisible(true);
			}
		});
		btnLogin.setBounds(153, 140, 89, 23);
		frmMyDatabaseApp.getContentPane().add(btnLogin);
	}
}

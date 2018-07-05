package loginapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginpage {

	public JFrame frmLoginPage;
	private JTextField tf_user;
	private JLabel label;
	private JTextField tf_pass;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login page");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter username");
		lblNewLabel.setBounds(30, 26, 95, 14);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		tf_user = new JTextField();
		tf_user.setBounds(184, 23, 86, 20);
		frmLoginPage.getContentPane().add(tf_user);
		tf_user.setColumns(10);
		
		label = new JLabel("Enter password");
		label.setBounds(30, 82, 95, 14);
		frmLoginPage.getContentPane().add(label);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(184, 79, 86, 20);
		frmLoginPage.getContentPane().add(tf_pass);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpage lgn=new Loginpage();
				lgn.frmLoginPage.setVisible(true);
			}
			
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String user=tf_user.getText();
				String pass=tf_pass.getText();
				Database db=new Database();
				String result =db.Login(user, pass);
				JOptionPane.showMessageDialog(null,result);
			}
		});
		btnLogin.setBounds(130, 151, 89, 23);
		frmLoginPage.getContentPane().add(btnLogin);
	}

}

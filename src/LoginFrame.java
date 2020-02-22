package negozio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	Control TheController;
	UtenteDAO U;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Creazione del frame.
	 */
	public LoginFrame(Control C) {
		TheController = C;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		/**
		 * Bottone di submit.
		 */
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username;
				username = textFieldUsername.getText();
				char[] a;
				a = passwordField.getPassword();
				String password = new StringBuilder().append(a).toString();
				try {
					TheController.LoginButton(username, password);
				}catch(NullPointerException e1) {
					e1.printStackTrace();
					
				}

		}});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 38));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(96, 228, 227, 89);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 24));
		lblUsername.setBounds(139, 84, 149, 52);
		contentPane.add(lblUsername);
		
		JLabel lblPursha = new JLabel("PURSHKA'S");
		lblPursha.setBackground(Color.BLACK);
		lblPursha.setFont(new Font("Dialog", Font.BOLD, 65));
		lblPursha.setForeground(Color.BLACK);
		lblPursha.setBounds(22, 12, 384, 83);
		contentPane.add(lblPursha);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPassword.setBounds(139, 147, 149, 52);
		contentPane.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(118, 125, 181, 25);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 191, 181, 25);
		contentPane.add(passwordField);
	}
	

	public void ErroreLogIn() {
		JOptionPane.showMessageDialog(null, "CREDENZIALI INVALIDE", "INSERIRE CREDENZIALI", JOptionPane.ERROR_MESSAGE);
		textFieldUsername.setText(null);
		textFieldUsername.requestFocus();
	}
}

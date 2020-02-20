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
	private JPasswordField textFieldPassword;
	private JTextField textFieldUsername;
	
	Control TheController;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username;
				char[] password;
				username = textFieldUsername.getText();
				password = textFieldPassword.getPassword();
				String s = new StringBuilder().append(password).toString();
				if(TheController.LoginButton(username, s)==false) {
					JOptionPane.showMessageDialog(null, "CREDENZIALI INVALIDE", "INSERIRE CREDENZIALI", JOptionPane.ERROR_MESSAGE);
					textFieldPassword.setText(null);
					textFieldUsername.setText(null);
					textFieldUsername.requestFocus();
				}else {
					
				}
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 38));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(103, 424, 227, 89);
		contentPane.add(btnLogin);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(69, 357, 301, 34);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(72, 267, 298, 34);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("USERNAME");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPassword.setBounds(140, 215, 149, 52);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("PASSWORD");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(140, 301, 149, 52);
		contentPane.add(label);
		
		JLabel lblPursha = new JLabel("PURSHKA'S");
		lblPursha.setBackground(Color.BLACK);
		lblPursha.setFont(new Font("Dialog", Font.BOLD, 65));
		lblPursha.setForeground(Color.BLACK);
		lblPursha.setBounds(24, 38, 405, 136);
		contentPane.add(lblPursha);
	}
}

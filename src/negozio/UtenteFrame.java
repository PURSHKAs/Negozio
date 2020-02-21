package negozio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class UtenteFrame extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtBoxCerca;
	private Control TheController;
	private JButton btnNewButton;
	private JButton btnRimuoviUtente;
	private JTextField textFieldIDUtente;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldCellulare;
	private JTextField textFieldStatus;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	@SuppressWarnings("serial")
	public UtenteFrame(Control c) {
		setBackground(Color.GRAY);
		
		TheController = c;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnModificaUtente = new JButton("Modifica Utente");
		btnModificaUtente.setForeground(Color.WHITE);
		btnModificaUtente.setBackground(Color.BLACK);
		btnModificaUtente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificaUtente.setEnabled(false);
		btnModificaUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				String s =textFieldStatus.getText();
				boolean a = Boolean.parseBoolean(s);
				TheController.ModificaUtente(textFieldNome.getText(), textFieldCognome.getText(), 
						textFieldCellulare.getText(),  a, textFieldUsername.getText(), textFieldPassword.getText());
				model.setRowCount(0);
				TheController.MostraUtenti();
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCellulare.setText("");
				textFieldStatus.setText("");
				textFieldUsername.setText("");
				textFieldPassword.setText("");
			}
		});
		
		JButton btnRimuoviUtente = new JButton("Rimuovi Utente");
		btnRimuoviUtente.setForeground(Color.WHITE);
		btnRimuoviUtente.setBackground(Color.BLACK);
		btnRimuoviUtente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRimuoviUtente.setEnabled(false);
		btnRimuoviUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				TheController.RimuoviUtente(Integer.parseInt( model.getValueAt(selectedRowIndex, 0).toString() ));
				model.setRowCount(0);
				TheController.MostraUtenti();
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCellulare.setText("");
				textFieldStatus.setText("");
				textFieldUsername.setText("");
				textFieldPassword.setText("");
				btnRimuoviUtente.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Utente eliminato");
			}
		});
		
		JButton btnAggiungiUtente = new JButton("Aggiungi Utente");
		btnAggiungiUtente.setForeground(Color.WHITE);
		btnAggiungiUtente.setBackground(Color.BLACK);
		btnAggiungiUtente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAggiungiUtente.setEnabled(false);
		btnAggiungiUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)getTable().getModel();
				String s =textFieldStatus.getText();
				boolean a = Boolean.parseBoolean(s);
				TheController.AggiungiUtentiLista(textFieldNome.getText(), textFieldCognome.getText(), 
						textFieldCellulare.getText(),  a, textFieldUsername.getText(), textFieldPassword.getText());
				model.setRowCount(0);
				TheController.MostraUtenti();
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCellulare.setText("");
				textFieldStatus.setText("");
				textFieldUsername.setText("");
				textFieldPassword.setText("");
			}
		});
		btnAggiungiUtente.setBounds(23, 590, 126, 43);
		contentPane.add(btnAggiungiUtente);
		btnRimuoviUtente.setBounds(184, 590, 126, 43);
		contentPane.add(btnRimuoviUtente);
		btnModificaUtente.setBounds(340, 590, 126, 43);
		contentPane.add(btnModificaUtente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 131, 333, 370);
		contentPane.add(scrollPane);
///////////////////////////////////////////////////////////////////////////////////////////////////////		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				textFieldNome.setText(model.getValueAt(selectedRowIndex, 1).toString());
				textFieldCognome.setText(model.getValueAt(selectedRowIndex, 2).toString());
				textFieldCellulare.setText(model.getValueAt(selectedRowIndex, 3).toString());
				textFieldStatus.setText(model.getValueAt(selectedRowIndex, 4).toString());
				textFieldUsername.setText(model.getValueAt(selectedRowIndex, 5).toString());
				textFieldPassword.setText(model.getValueAt(selectedRowIndex, 6).toString());
				btnRimuoviUtente.setEnabled(true);
				btnAggiungiUtente.setEnabled(false);
			}
		});
		table.setName("ShowContacsTableModel");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDUtente", "Nome", "Cognome", "Cellulare", "Status", "Username", "Password"
			}
		)
		{public boolean isCellEditable(int row, int column) {return false;}});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		txtBoxCerca = new JTextField();
		txtBoxCerca.setToolTipText("");
		txtBoxCerca.setBounds(23, 67, 287, 27);
		contentPane.add(txtBoxCerca);
		txtBoxCerca.setColumns(10);
		
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setBackground(Color.GRAY);
		rdbtnNome.setForeground(Color.BLACK);
		rdbtnNome.setBounds(141, 101, 71, 23);
		contentPane.add(rdbtnNome);
		radioGroup.add(rdbtnNome);
		rdbtnNome.setSelected(true);
		
		JRadioButton rdbtnid = new JRadioButton("ID");
		rdbtnid.setBackground(Color.GRAY);
		rdbtnid.setForeground(Color.BLACK);
		rdbtnid.setBounds(217, 101, 82, 23);
		contentPane.add(rdbtnid);
		radioGroup.add(rdbtnid);
		
		btnNewButton = new JButton("Cerca");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNome.isSelected()) {
					DefaultTableModel model = (DefaultTableModel)getTable().getModel();
					model.setRowCount(0);
					TheController.MostraUtentiByNome(txtBoxCerca.getText());
				}
				if(rdbtnid.isSelected()) {
					DefaultTableModel model = (DefaultTableModel)getTable().getModel();
					model.setRowCount(0);
					TheController.MostraUtentiByID(txtBoxCerca.getText());
				}
				if(txtBoxCerca.getText().equals(""))
					TheController.MostraUtenti();
			}
		});
		btnNewButton.setBounds(330, 69, 82, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRicercaPer = new JLabel("Ricerca per: ");
		lblRicercaPer.setForeground(Color.BLACK);
		lblRicercaPer.setBounds(46, 105, 83, 14);
		contentPane.add(lblRicercaPer);
		
		JButton btnTermina = new JButton("Termina");
		btnTermina.setForeground(Color.WHITE);
		btnTermina.setBackground(Color.BLACK);
		btnTermina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTermina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TheController.MainframeAccess();
			}
		});
		btnTermina.setBounds(573, 590, 126, 43);
		contentPane.add(btnTermina);
		
		JButton btnRefresh = new JButton("Indietro");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)getTable().getModel();
				model.setRowCount(0);
				TheController.MostraUtenti();
			}
		});
		btnRefresh.setBounds(23, 524, 89, 23);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(443, 150, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setForeground(Color.BLACK);
		lblCognome.setBounds(443, 204, 118, 14);
		contentPane.add(lblCognome);
		
		JLabel lblCellulare = new JLabel("Cellulare");
		lblCellulare.setForeground(Color.BLACK);
		lblCellulare.setBounds(443, 258, 118, 14);
		contentPane.add(lblCellulare);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setBounds(443, 313, 118, 14);
		contentPane.add(lblStatus);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(603, 150, 96, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(603, 201, 96, 20);
		contentPane.add(textFieldCognome);
			
		textFieldCellulare = new JTextField();
		textFieldCellulare.setColumns(10);
		textFieldCellulare.setBounds(603, 255, 96, 20);
		contentPane.add(textFieldCellulare);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(603, 310, 96, 20);
		contentPane.add(textFieldStatus);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(443, 365, 48, 14);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldStatus.setColumns(10);
		textFieldUsername.setBounds(603, 362, 96, 20);
		contentPane.add(textFieldUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(443, 419, 48, 14);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(603, 416, 96, 20);
		contentPane.add(textFieldPassword);
		
		
		
		DocumentListener docListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();				
			}
			
			public void changed() {
				if((textFieldNome.getText()).length()<3 || (textFieldStatus.getText()).length()<2) {
					btnModificaUtente.setEnabled(false);
					btnAggiungiUtente.setEnabled(false);
				}
				else {
					btnModificaUtente.setEnabled(true);
					btnAggiungiUtente.setEnabled(true);
				}
			}
		};
		
		textFieldNome.getDocument().addDocumentListener(docListener);
		textFieldStatus.getDocument().addDocumentListener(docListener);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCellulare.setText("");
				textFieldStatus.setText("");
				textFieldUsername.setText("");
				btnRimuoviUtente.setEnabled(false);
			}
		});
	}
	
	public JTable getTable() {
		return table;
	}
}
package negozioFrame;
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

import negozio.Control;

import java.awt.Font;
import java.awt.Color;

public class StoreFrame extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtBoxCerca;
	private Control TheController;
	private JButton btnNewButton;
	private JButton btnRimuoviArticolo;
	private JTextField textFieldIDArticolo;
	private JTextField textFieldNome;
	private JTextField textFieldTaglia;
	private JTextField textFieldColore;
	private JTextField textFieldScorte;
	private JTextField textFieldPrezzo;
	private JTextField textField_1;

	
	/**
	 * Creazione del frame.
	 */
	@SuppressWarnings("serial")
	public StoreFrame(Control c) {
		setBackground(Color.GRAY);
		
		TheController = c;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		/**
		 * Bottone di modifica dell'articolo.
		 */
		JButton btnModificaArticolo = new JButton("Modifica Articolo");
		btnModificaArticolo.setForeground(Color.WHITE);
		btnModificaArticolo.setBackground(Color.BLACK);
		btnModificaArticolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificaArticolo.setEnabled(false);
		btnModificaArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				TheController.ModificaArticolo(textFieldNome.getText(), textFieldTaglia.getText(), 
						textFieldColore.getText(), textFieldScorte.getText(), textFieldPrezzo.getText(), (String) ( model.getValueAt(selectedRowIndex, 0) ));
				model.setRowCount(0);
				TheController.MostraArticoli();
				textFieldNome.setText("");
				textFieldTaglia.setText("");
				textFieldColore.setText("");
				textFieldScorte.setText("");
				JOptionPane.showMessageDialog(null, "Articolo modificato!!","", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		/**
		 * Bottone per la rimozione dell'articolo.
		 */
		JButton btnRimuoviArticolo = new JButton("Rimuovi Articolo");
		btnRimuoviArticolo.setForeground(Color.WHITE);
		btnRimuoviArticolo.setBackground(Color.BLACK);
		btnRimuoviArticolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRimuoviArticolo.setEnabled(false);
		btnRimuoviArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				TheController.RimuoviArticolo((String) ( model.getValueAt(selectedRowIndex, 0) ));
				model.setRowCount(0);
				TheController.MostraArticoli();
				textFieldNome.setText("");
				textFieldTaglia.setText("");
				textFieldColore.setText("");
				textFieldScorte.setText("");
				btnRimuoviArticolo.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Articolo eliminato");
			}
		});
		
		/**
		 * Bottone per l'aggiuta di articoli.
		 */
		JButton btnAggiungiArticolo = new JButton("Aggiungi Articolo");
		btnAggiungiArticolo.setForeground(Color.WHITE);
		btnAggiungiArticolo.setBackground(Color.BLACK);
		btnAggiungiArticolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAggiungiArticolo.setEnabled(false);
		btnAggiungiArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)getTable().getModel();
				TheController.AggiungiArticoliaLista(textFieldNome.getText(), textFieldTaglia.getText(), 
						textFieldColore.getText(), textFieldScorte.getText(), textFieldPrezzo.getText());
				model.setRowCount(0);
				TheController.MostraArticoli();
				JOptionPane.showMessageDialog(null, "Articolo aggiunto!!","", JOptionPane.ERROR_MESSAGE);
				textFieldNome.setText("");
				textFieldTaglia.setText("");
				textFieldColore.setText("");
				textFieldScorte.setText("");
				textFieldPrezzo.setText("");
			}
		});
		btnAggiungiArticolo.setBounds(295, 416, 126, 43);
		contentPane.add(btnAggiungiArticolo);
		btnRimuoviArticolo.setBounds(157, 416, 126, 43);
		contentPane.add(btnRimuoviArticolo);
		btnModificaArticolo.setBounds(19, 416, 126, 43);
		contentPane.add(btnModificaArticolo);
		
		
		/**
		 * Tabella.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 76, 389, 296);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				textFieldNome.setText(model.getValueAt(selectedRowIndex, 1).toString());
				textFieldTaglia.setText(model.getValueAt(selectedRowIndex, 2).toString());
				textFieldColore.setText(model.getValueAt(selectedRowIndex, 3).toString());
				textFieldScorte.setText(model.getValueAt(selectedRowIndex, 4).toString());
				textFieldPrezzo.setText(model.getValueAt(selectedRowIndex, 5).toString());
				btnRimuoviArticolo.setEnabled(true);
				btnAggiungiArticolo.setEnabled(false);
			}
		});
		table.setName("ShowContacsTableModel");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDArticolo", "Nome", "Taglia", "Colore", "Scorte", "Prezzo"
			}
		)
		{public boolean isCellEditable(int row, int column) {return false;}});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		
		
		/**
		 * Box di ricerca + Radio.
		 */
		
		
		txtBoxCerca = new JTextField();
		txtBoxCerca.setToolTipText("");
		txtBoxCerca.setBounds(23, 12, 287, 27);
		contentPane.add(txtBoxCerca);
		txtBoxCerca.setColumns(10);
		
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setBackground(Color.GRAY);
		rdbtnNome.setForeground(Color.BLACK);
		rdbtnNome.setBounds(98, 45, 71, 23);
		contentPane.add(rdbtnNome);
		radioGroup.add(rdbtnNome);
		rdbtnNome.setSelected(true);
		
		JRadioButton rdbtnid = new JRadioButton("ID");
		rdbtnid.setBackground(Color.GRAY);
		rdbtnid.setForeground(Color.BLACK);
		rdbtnid.setBounds(159, 45, 82, 23);
		contentPane.add(rdbtnid);
		radioGroup.add(rdbtnid);
		
		/**
		 * Bottone di ricerca.
		 */
		btnNewButton = new JButton("Cerca");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNome.isSelected()) {
					DefaultTableModel model = (DefaultTableModel)getTable().getModel();
					model.setRowCount(0);
					TheController.MostraArticoliByNome(txtBoxCerca.getText());
				}
				if(rdbtnid.isSelected()) {
					DefaultTableModel model = (DefaultTableModel)getTable().getModel();
					model.setRowCount(0);
					TheController.MostraArticoliByID(txtBoxCerca.getText());
				}
				if(txtBoxCerca.getText().equals(""))
					TheController.MostraArticoli();
			}
		});
		btnNewButton.setBounds(330, 14, 82, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRicercaPer = new JLabel("Ricerca per: ");
		lblRicercaPer.setForeground(Color.BLACK);
		lblRicercaPer.setBounds(19, 51, 83, 14);
		contentPane.add(lblRicercaPer);
		
		
		/**
		 * Bottone per terminare il programma.
		 */
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
		btnTermina.setBounds(473, 401, 126, 58);
		contentPane.add(btnTermina);
		
		/**
		 * Bottone per il refresh della tabella.
		 */
		JButton btnRefresh = new JButton("Indietro");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)getTable().getModel();
				model.setRowCount(0);
				TheController.MostraArticoli();
			}
		});
		btnRefresh.setBounds(330, 46, 82, 23);
		contentPane.add(btnRefresh);
		
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(426, 76, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTaglia = new JLabel("Taglia");
		lblTaglia.setForeground(Color.BLACK);
		lblTaglia.setBounds(426, 130, 118, 14);
		contentPane.add(lblTaglia);
		
		JLabel lblColore = new JLabel("Colore");
		lblColore.setForeground(Color.BLACK);
		lblColore.setBounds(424, 184, 118, 14);
		contentPane.add(lblColore);
		
		JLabel lblScorta = new JLabel("Scorta");
		lblScorta.setForeground(Color.BLACK);
		lblScorta.setBounds(424, 239, 118, 14);
		contentPane.add(lblScorta);
		
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(492, 76, 96, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTaglia = new JTextField();
		textFieldTaglia.setColumns(10);
		textFieldTaglia.setBounds(490, 127, 96, 20);
		contentPane.add(textFieldTaglia);
			
		textFieldColore = new JTextField();
		textFieldColore.setColumns(10);
		textFieldColore.setBounds(490, 184, 96, 20);
		contentPane.add(textFieldColore);
		
		textFieldScorte = new JTextField();
		textFieldScorte.setColumns(10);
		textFieldScorte.setBounds(490, 239, 96, 20);
		contentPane.add(textFieldScorte);
		
		
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setForeground(Color.BLACK);
		lblPrezzo.setBounds(424, 291, 48, 14);
		contentPane.add(lblPrezzo);
		
		textFieldPrezzo = new JTextField();
		textFieldScorte.setColumns(10);
		textFieldPrezzo.setBounds(488, 291, 96, 20);
		contentPane.add(textFieldPrezzo);
		
		JLabel label = new JLabel("PURSHKA's");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 35));
		label.setBounds(424, 17, 183, 58);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 384, 98, 20);
		contentPane.add(textField_1);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setBounds(141, 386, 54, 16);
		contentPane.add(lblQuantit);
		
		JButton btnVenduto = new JButton("Vendi");
		btnVenduto.setForeground(Color.BLACK);
		btnVenduto.setBackground(Color.RED);
		btnVenduto.setBounds(306, 381, 99, 26);
		btnVenduto.setEnabled(false);
		btnVenduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				int tmp=0;
				int tmp1=0;
				try {
					tmp =Integer.parseInt(textFieldScorte.getText());
				 	tmp1=Integer.parseInt(textField_1.getText());
				 	TheController.VendiArticolo(tmp, (String) ( model.getValueAt(selectedRowIndex, 0) ), tmp1);
				 	JOptionPane.showMessageDialog(null, "Articolo venduto!!","", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException eq) 
					{ 
						Errore();
					}
				
				model.setRowCount(0);
				TheController.MostraArticoli();
				textField_1.setText("");
				btnVenduto.setEnabled(false);
				
			}
		});

		contentPane.add(btnVenduto);
		
		
		/**
		 * docListener per l'aggiornamento dei bottoni.
		 */
		
		
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
				if((textFieldNome.getText()).length()<3 || (textFieldScorte.getText()).length()<1) {
					btnModificaArticolo.setEnabled(false);
					btnAggiungiArticolo.setEnabled(false);
				}	
				else {
					btnModificaArticolo.setEnabled(true);
					btnAggiungiArticolo.setEnabled(true);
				}
			}
		};
		
		DocumentListener docListener1 = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				changed1();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				changed1();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed1();				
			}
			
			public void changed1() {
				if(textField_1.getText().length()<1 ) {
					btnVenduto.setEnabled(false);
				}	
				else {
					btnVenduto.setEnabled(true);
				}
			}
		};
		
		textField_1.getDocument().addDocumentListener(docListener1);
		textFieldNome.getDocument().addDocumentListener(docListener);
		textFieldScorte.getDocument().addDocumentListener(docListener);
		
		/**
		 * Listener per la tabella.
		 */
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
				textFieldNome.setText("");
				textFieldTaglia.setText("");
				textFieldColore.setText("");
				textFieldScorte.setText("");
				textFieldPrezzo.setText("");
				btnRimuoviArticolo.setEnabled(false);
				btnVenduto.setEnabled(false);
			}
		});
	}
	
	public void Errore() {
		JOptionPane.showMessageDialog(null, "INSERIRE VALORI CORRETTI","ERRORE", JOptionPane.ERROR_MESSAGE);
	}
	public JTable getTable() {
		return table;
	}
}
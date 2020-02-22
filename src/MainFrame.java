package negozio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Control TheController;

	/**
	 * Crazione del frame.
	 */
	public MainFrame(Control c) {		
		setType(Type.UTILITY);
		TheController = c;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 314);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PURSHKA's");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(22, 0, 311, 74);
		contentPane.add(lblNewLabel);
		
		
		/**
		 * Bottone per lo StoreFrame.
		 */
		JButton btnStore = new JButton("STORE");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TheController.StoreButton();
			}
		});
		btnStore.setFont(new Font("Dialog", Font.BOLD, 34));
		btnStore.setBackground(Color.BLACK);
		btnStore.setForeground(Color.WHITE);
		btnStore.setBounds(45, 82, 242, 74);
		contentPane.add(btnStore);
		
		/**
		 * Bottone per UtentiFrame.
		 */
		JButton btnUtenti = new JButton("UTENTI");
		btnUtenti.setFont(new Font("Dialog", Font.BOLD, 34));
		btnUtenti.setBackground(Color.BLACK);
		btnUtenti.setForeground(Color.WHITE);
		btnUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TheController.UtenteFrame();
			}
		});
		btnUtenti.setBounds(45, 168, 242, 74);
		contentPane.add(btnUtenti);
		
	}
}

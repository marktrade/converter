import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Converter extends JFrame {

	private JPanel contentPane;
	private JTextField txtToto;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JComboBox comboBox_1;
	private JButton btnConvertir;
	private JTextField txtErrorlabel;
	private String s="";
	private String[] listeUnite = { "yrd", "km", "Ml" ,"m", "ft"};
	private String[] listeUnite1=new String[listeUnite.length-1];
	private JLabel label;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converter frame = new Converter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Converter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 440);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(10, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txtToto = new JTextField();
		txtToto.setText("");
		contentPane.add(txtToto);
		txtToto.setColumns(10);

		// quand on selectionne une valeur dans combobox,
		// elle ne doit plus apparaître en choix possible dans
		// combobox_1
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(listeUnite));
		contentPane.add(comboBox);

		lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("E:\\crp\\bdd\\Converter\\fleche.png"));
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		contentPane.add(label);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\crp\\bdd\\Converter\\fleche.png"));
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox_1 = new JComboBox();
		
		comboBox_1.setModel(new DefaultComboBoxModel(listeUnite));
		contentPane.add(comboBox_1);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboBoxModel cbm=comboBox_1.getModel();
				comboBox_1.removeItem(cbm);
				s = (String) comboBox.getSelectedItem();
				System.out.println("s="+s);
				int j = 0;
				for (int i=0; i < listeUnite.length; i++) {
					System.out.println("listeUnite="+listeUnite[i]);
					if (!listeUnite[i].equals(s)) {
						listeUnite1[j] = listeUnite[i];
						j++;
					}
				}
				//comboBox_1 = new JComboBox();
				
				comboBox_1.setModel(new DefaultComboBoxModel(listeUnite1));
				//contentPane.add(comboBox_1);
				System.out.println("length="+listeUnite1.length);
			}
		});


		txtErrorlabel = new JTextField();
		btnConvertir = new JButton("Convertir!");
		txtErrorlabel.setText("");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtToto.getText().isEmpty()) {
					txtErrorlabel.setText("Empty input");
				}
			}
		});
		contentPane.add(btnConvertir);

		contentPane.add(txtErrorlabel);
		txtErrorlabel.setColumns(10);
	}

	public JPanel getContentPane() {
		return contentPane;
	}
}

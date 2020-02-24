import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoLogowania {
	private UI uI;
	private JTextField textField;
	private JPasswordField passwordField;

	public OknoLogowania(UI uI) {
		this.uI = uI;
		JFrame frame = new JFrame("Okno logowania");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(30);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 50, 5);
		panel_1.setLayout(fl_panel_1);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblLogin);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(16);

		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JLabel lblHaslo = new JLabel("Haslo");
		lblHaslo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblHaslo);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setColumns(16);
		panel_2.add(passwordField);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 15));

		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uI.wyswietlOknoGlowne();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnZaloguj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(btnZaloguj);
		frame.setVisible(true);
	}
}

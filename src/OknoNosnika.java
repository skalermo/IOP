import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class OknoNosnika {
	private JTextField nazwaNosnika;
	private JTextField rozmiarNosnika;

	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private UI uI;
	private ButtonGroup przyciski;
	private JRadioButton wybranyPrzyciskOpcji;
	private JFrame mainFrame;
	private Nosnik edytowanyNosnik;
	private ElementZawartosci wybranyElement;
	private DefaultListModel<ElementZawartosci> widokListaElementow;

	public OknoNosnika(UI uI, Nosnik edytowanyNosnik, DefaultListModel<ElementZawartosci> widokListaElementow) {
		this.uI = uI;
		this.edytowanyNosnik = edytowanyNosnik;
		this.widokListaElementow = widokListaElementow;
		wybranyElement = null;
		przyciski = new ButtonGroup();
		wybranyPrzyciskOpcji = null;

		JList<ElementZawartosci> listaElementow = new JList<>();
		stworzMainFrame(listaElementow);
		stworzPrzyciski(listaElementow);
	}

	public void dodajElementDoListy(ElementZawartosci element) {
		widokListaElementow.addElement(element);
	}

	private void stworzMainFrame(JList<ElementZawartosci> listaElementow) {
		mainFrame = new JFrame("Okno nosnika");
		mainFrame.setResizable(false);
		mainFrame.setBounds(0, 0, 800, 600);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_obszarInformacyjny = new JPanel();
		panel_obszarInformacyjny.setLayout(null);
		mainFrame.getContentPane().add(panel_obszarInformacyjny, BorderLayout.CENTER);

		stworzPanelParametrowNosnika(panel_obszarInformacyjny);
		stworzListeElementow(panel_obszarInformacyjny, listaElementow);
		mainFrame.setVisible(true);
	}


	private void stworzPrzyciski(JList<ElementZawartosci> listaElementow) {
		JPanel buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(240, 10));
		buttons.setMinimumSize(new Dimension(100, 10));
		mainFrame.getContentPane().add(buttons, BorderLayout.WEST);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(120, 120));
		buttons.add(separator);

		JButton btnDodajElement = new JButton("Dodaj element");
		btnDodajElement.addActionListener(actionEvent -> {
			uI.wyswietlOknoElementu(this, edytowanyNosnik, null);
		});
		btnDodajElement.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnDodajElement);

		JButton btnEdytujElement = new JButton("Edytuj element");
		btnEdytujElement.addActionListener(actionEvent -> {
			if (wybranyElement != null)
				uI.wyswietlOknoElementu(this, edytowanyNosnik, wybranyElement);
		});
		btnEdytujElement.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnEdytujElement);

		JButton btnUsunElement = new JButton("Usun element");
		btnUsunElement.addActionListener(e -> {
			if (wybranyElement != null) {
				KontrolerNosnika.usunElement(edytowanyNosnik, wybranyElement);
				widokListaElementow.removeElement(wybranyElement);
				if (widokListaElementow.size() == 0) {
					btnEdytujElement.setEnabled(false);
					btnUsunElement.setEnabled(false);
				}
				listaElementow.clearSelection();
			}
		});
		btnUsunElement.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnUsunElement);

		if (edytowanyNosnik == null) {
			btnDodajElement.setEnabled(false);
			btnEdytujElement.setEnabled(false);
			btnUsunElement.setEnabled(false);
		}

		JButton btnAkceptuj = new JButton("Akceptuj");
		btnAkceptuj.addActionListener(e -> {
			if (nazwaNosnika.getText().isEmpty()) {
				System.out.println("pusta nazwa");
				return;
			}
			if (rozmiarNosnika.getText().isEmpty()) {
				System.out.println("pusty rozmiar");
				return;
			}
			if (wybranyPrzyciskOpcji == null) {
				System.out.println("nie wybrano typ nosnika");
				return;
			}

			String nazwa = nazwaNosnika.getText();
			int rozmiar = 0;
			try {
				rozmiar = Integer.parseInt(rozmiarNosnika.getText());
			} catch (NumberFormatException exception) {
				System.out.println("Niepoprawny rozmiar");
			}
			TypNosnika typ = null;
			switch (wybranyPrzyciskOpcji.getText()) {
				case "Dysk twardy":
					typ = TypNosnika.DyskTwardy;
					break;
				case "Pamiec USB":
					typ = TypNosnika.PamiecUSB;
					break;
				case "Dysk optyczny":
					typ = TypNosnika.DyskOptyczny;
					break;
			}

			if (edytowanyNosnik != null) {
				KontrolerNosnika.edytujNosnik(edytowanyNosnik, nazwa);
			} else {
				Nosnik nosnik = KontrolerNosnika.stworzNosnik(nazwa, rozmiar, typ);
				uI.getOknoGlowne().dodajNosnikDoListy(nosnik);
			}
			mainFrame.setVisible(false);
			mainFrame.dispose();
		});

		btnAkceptuj.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnAkceptuj);

		listaElementow.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!listaElementow.isSelectionEmpty()) {
					wybranyElement = listaElementow.getSelectedValue();
					btnEdytujElement.setEnabled(true);
					btnUsunElement.setEnabled(true);
				}

			}
		});

		listaElementow.addListSelectionListener(e -> {

			if (!listaElementow.isSelectionEmpty()) {
				wybranyElement = listaElementow.getSelectedValue();
			}
			else {
				wybranyElement = null;
				btnEdytujElement.setEnabled(true);
				btnUsunElement.setEnabled(true);
			}

		});
	}

	private JPanel stworzPrzyciskiOpcji() {
		JPanel panel_typuNosnika = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_typuNosnika.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setAlignment(FlowLayout.LEFT);

		JLabel lblTypNosnika = new JLabel("Typ nosnika");
		panel_typuNosnika.add(lblTypNosnika);

		JRadioButton hdd = new JRadioButton("Dysk twardy");
		hdd.addActionListener(e -> wybranyPrzyciskOpcji = hdd);
		panel_typuNosnika.add(hdd);

		JRadioButton usb = new JRadioButton("Pamiec USB");
		usb.addActionListener(e -> wybranyPrzyciskOpcji = usb);
		panel_typuNosnika.add(usb);

		JRadioButton optical = new JRadioButton("Dysk optyczny");
		optical.addActionListener(e -> wybranyPrzyciskOpcji = optical);
		panel_typuNosnika.add(optical);

		przyciski.add(hdd);
		przyciski.add(usb);
		przyciski.add(optical);

		if (edytowanyNosnik != null) {
			hdd.setEnabled(false);
			usb.setEnabled(false);
			optical.setEnabled(false);
		}

		if (edytowanyNosnik != null) {
			switch (edytowanyNosnik.getClass().toString()) {
				case "class DyskTwardy":
					hdd.setSelected(true);
					wybranyPrzyciskOpcji = hdd;
					break;
				case "class PamiecUSB":
					usb.setSelected(true);
					wybranyPrzyciskOpcji = usb;
					break;
				case "class DyskOptyczny":
					optical.setSelected(true);
					wybranyPrzyciskOpcji = optical;
					break;
			}
		}

		return panel_typuNosnika;
	}

	private void stworzListeElementow(JPanel panelNadrzedny, JList<ElementZawartosci> listaElementow) {
		JPanel panel_listaElementow = new JPanel();
		panel_listaElementow.setBounds(280, 16, 250, 500);
		panelNadrzedny.add(panel_listaElementow);
		panel_listaElementow.setLayout(new BoxLayout(panel_listaElementow, BoxLayout.Y_AXIS));

		JLabel lblListaElementow = new JLabel("Lista elementow");
		lblListaElementow.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_listaElementow.add(lblListaElementow);

		JScrollPane scrollPane_listaElementow = new JScrollPane();
		panel_listaElementow.add(scrollPane_listaElementow);

		scrollPane_listaElementow.setViewportView(listaElementow);
		listaElementow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaElementow.setModel(widokListaElementow);
	}

	private JPanel dodajPolaNosnika() {
		JPanel panel_polaNosnika = new JPanel();
		panel_polaNosnika.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNazwa = new JLabel("Nazwa");
		JLabel lblRozmiar = new JLabel("Rozmiar");
		nazwaNosnika = new JTextField();
		rozmiarNosnika = new JTextField();
		if (edytowanyNosnik != null)
			nazwaNosnika.setText(edytowanyNosnik.getNazwa());
		if (edytowanyNosnik != null) {
			rozmiarNosnika.setText(Integer.toString(edytowanyNosnik.getRozmiar()));
			rozmiarNosnika.setEditable(false);
		}

		panel_polaNosnika.add(lblNazwa);
		panel_polaNosnika.add(nazwaNosnika);
		panel_polaNosnika.add(lblRozmiar);
		panel_polaNosnika.add(rozmiarNosnika);
		nazwaNosnika.setColumns(10);
		rozmiarNosnika.setColumns(10);
		return panel_polaNosnika;
	}

	private void stworzPanelParametrowNosnika(JPanel panelNadrzedny) {
		JPanel panel_parametryNosnika = new JPanel();
		panel_parametryNosnika.setPreferredSize(new Dimension(250, 500));
		panel_parametryNosnika.setBounds(15, 137, 250, 300);
		panelNadrzedny.add(panel_parametryNosnika);
		panel_parametryNosnika.setLayout(new BoxLayout(panel_parametryNosnika, BoxLayout.Y_AXIS));

		panel_parametryNosnika.add(dodajPolaNosnika());
		panel_parametryNosnika.add(stworzPrzyciskiOpcji());
	}
}
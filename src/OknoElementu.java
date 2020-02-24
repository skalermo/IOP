import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class OknoElementu {
	private JFrame mainFrame;
	private Nosnik edytowanyNosnik;
	private ElementZawartosci edytowanyElement;
	private JTextField nazwaElementu;
	private JTextField rozmiarElementu;
	private JTextField kodowanie;
	private JTextField bitowNaPiksel;
	private JTextField wykonawca;
	private ButtonGroup grupaPrzyciskowOpcji;
	private JRadioButton wybranyPrzyciskOpcji;
	private OknoNosnika oknoNosnika;

	public OknoElementu(OknoNosnika oknoNosnika, Nosnik edytowanyNosnik, ElementZawartosci edytowanyElement) {
		this.oknoNosnika = oknoNosnika;
		this.edytowanyNosnik = edytowanyNosnik;
		this.edytowanyElement = edytowanyElement;
		grupaPrzyciskowOpcji = new ButtonGroup();
		wybranyPrzyciskOpcji = null;

		stworzMainFrame();
		stworzPrzyciski();
	}


	private void stworzMainFrame() {
		mainFrame = new JFrame("Okno elementu");
		mainFrame.setResizable(false);
		mainFrame.setBounds(0, 0, 640, 400);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_ObszarInformacyjny = new JPanel();
		mainFrame.getContentPane().add(panel_ObszarInformacyjny, BorderLayout.CENTER);
		panel_ObszarInformacyjny.setLayout(null);

		stworzParametrySzczegolneElementu(panel_ObszarInformacyjny);
		stworzParametryGlowneElementu(panel_ObszarInformacyjny);

		mainFrame.setVisible(true);
	}

	private void stworzPrzyciski() {
		JPanel panel_buttons = new JPanel();
		panel_buttons.setPreferredSize(new Dimension(240, 10));
		panel_buttons.setMinimumSize(new Dimension(100, 10));
		mainFrame.getContentPane().add(panel_buttons, BorderLayout.WEST);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

		JButton btnAkceptuj = new JButton("Akceptuj");
		btnAkceptuj.addActionListener(e -> {
			if (nazwaElementu.getText().isEmpty()) {
				System.out.println("pusta nazwa");
				return;
			}
			if (rozmiarElementu.getText().isEmpty()) {
				System.out.println("pusty rozmiar");
				return;
			}

			if (wybranyPrzyciskOpcji == null) {
				System.out.println("nie wybrano typ elementu");
				return;
			}

			String nazwa = nazwaElementu.getText();
			int rozmiar = 0;
			try {
				rozmiar = Integer.parseInt(rozmiarElementu.getText());
			} catch (NumberFormatException exception) {
				System.out.println("Niepoprawny rozmiar");
			}

			Object dodatkowyParametr = null;
			TypElementu typ = null;
			switch (wybranyPrzyciskOpcji.getText()) {
				case "plik tekstowy":
					typ = TypElementu.PlikTekstowy;
					dodatkowyParametr = kodowanie.getText();
					break;
				case "obraz":
					typ = TypElementu.Obrazek;
					try {
						dodatkowyParametr = Integer.parseInt(bitowNaPiksel.getText());
					} catch (NumberFormatException exception) {
						System.out.println("Niepoprawny rozmiar");
					}
					break;
				case "utwor muzyczny":
					typ = TypElementu.UtworMuzyczny;
					dodatkowyParametr = wykonawca.getText();
					break;
			}

			if (edytowanyElement != null) {
				KontrolerElementu.edytujElement(edytowanyElement, nazwa);
			} else {
				ElementZawartosci element = KontrolerElementu.stworzElement(nazwa, rozmiar, typ, dodatkowyParametr);
				KontrolerNosnika.dodajElementDoNosnika(edytowanyNosnik, element);
				oknoNosnika.dodajElementDoListy(element);
			}
			mainFrame.setVisible(false);
			mainFrame.dispose();
		});
		btnAkceptuj.setPreferredSize(new Dimension(200, 29));
		panel_buttons.add(btnAkceptuj);
	}

	private void stworzParametryGlowneElementu(JPanel panelNadrzedny) {
		JPanel panel_parametryGlowneElementu = new JPanel();
		panel_parametryGlowneElementu.setPreferredSize(new Dimension(200, 300));
		panel_parametryGlowneElementu.setBounds(9, 16, 175, 300);
		panelNadrzedny.add(panel_parametryGlowneElementu);
		panel_parametryGlowneElementu.setLayout(new BoxLayout(panel_parametryGlowneElementu, BoxLayout.Y_AXIS));

		stworzPolaElementu(panel_parametryGlowneElementu);
		stworzWyborTypuElementu(panel_parametryGlowneElementu);
	}

	private void stworzParametrySzczegolneElementu(JPanel panelNadrzedny) {
		JPanel panel_parametrySzczegolne = new JPanel();
		panel_parametrySzczegolne.setBounds(199, 16, 180, 300);
		panelNadrzedny.add(panel_parametrySzczegolne);
		panel_parametrySzczegolne.setLayout(new BoxLayout(panel_parametrySzczegolne, BoxLayout.Y_AXIS));

		stworzPanelKodowania(panel_parametrySzczegolne);
		stworzPanelBitowNaPiksel(panel_parametrySzczegolne);
		stworzPanelWykonawcy(panel_parametrySzczegolne);
	}

	private void stworzPanelKodowania(JPanel panelNadrzedny) {
		JPanel panel_kodowanie = new JPanel();
		panelNadrzedny.add(panel_kodowanie);
		panel_kodowanie.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel lblKodowanie = new JLabel("Kodowanie");
		panel_kodowanie.add(lblKodowanie);
		kodowanie = new JTextField();
		kodowanie.setColumns(10);
		panel_kodowanie.add(kodowanie);
		kodowanie.setEditable(false);
	}

	private void stworzPanelBitowNaPiksel(JPanel panelNadrzedny) {
		JPanel panel_bnapx = new JPanel();
		panelNadrzedny.add(panel_bnapx);
		panel_bnapx.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel lblBitowNaPiksel = new JLabel("Bitow na piksel");
		panel_bnapx.add(lblBitowNaPiksel);
		bitowNaPiksel = new JTextField();
		bitowNaPiksel.setColumns(10);
		panel_bnapx.add(bitowNaPiksel);
		bitowNaPiksel.setEditable(false);
	}

	private void stworzPanelWykonawcy(JPanel panelNadrzedny) {
		JPanel panel_wykonawca = new JPanel();
		panelNadrzedny.add(panel_wykonawca);
		panel_wykonawca.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel lblWykonawca = new JLabel("Wykonawca");
		panel_wykonawca.add(lblWykonawca);
		wykonawca = new JTextField();
		wykonawca.setColumns(10);
		panel_wykonawca.add(wykonawca);
		wykonawca.setEditable(false);
	}

	private void stworzPolaElementu(JPanel panelNadrzedny) {
		JPanel panel_polaElementu = new JPanel();
		panelNadrzedny.add(panel_polaElementu);
		panel_polaElementu.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		JLabel lblNazwa = new JLabel("Nazwa");
		panel_polaElementu.add(lblNazwa);

		nazwaElementu = new JTextField();
		panel_polaElementu.add(nazwaElementu);
		nazwaElementu.setColumns(10);

		JLabel lblRozmiar = new JLabel("Rozmiar");
		panel_polaElementu.add(lblRozmiar);

		rozmiarElementu = new JTextField();
		if (edytowanyElement != null) {
			nazwaElementu.setText(edytowanyElement.zwrocNazwe());
			rozmiarElementu.setText(Integer.toString(edytowanyElement.zwrocRozmiar()));
		}
		panel_polaElementu.add(rozmiarElementu);
		rozmiarElementu.setColumns(10);
	}

	private void stworzWyborTypuElementu(JPanel panelNadrzedny) {
		JPanel panel_typuElementu = new JPanel();
		FlowLayout fl_panel_typuElementu = (FlowLayout) panel_typuElementu.getLayout();
		fl_panel_typuElementu.setHgap(20);
		fl_panel_typuElementu.setAlignment(FlowLayout.LEFT);
		panelNadrzedny.add(panel_typuElementu);

		JLabel lblTypElementu = new JLabel("Typ elementu");
		panel_typuElementu.add(lblTypElementu);
		stworzPrzyciskiOpcji(panel_typuElementu);

	}

	private void stworzPrzyciskiOpcji(JPanel panelNadrzedny) {
		JRadioButton txt = new JRadioButton("plik tekstowy");
		txt.addActionListener(e -> {
			wybranyPrzyciskOpcji = txt;
			kodowanie.setEditable(true);
			bitowNaPiksel.setEditable(false);
			wykonawca.setEditable(false);

		});
		JRadioButton img = new JRadioButton("obraz");
		img.addActionListener(e -> {
			wybranyPrzyciskOpcji = img;
			kodowanie.setEditable(false);
			bitowNaPiksel.setEditable(true);
			wykonawca.setEditable(false);
		});
		JRadioButton mp3 = new JRadioButton("utwor muzyczny");
		mp3.addActionListener(e -> {
			wybranyPrzyciskOpcji = mp3;
			kodowanie.setEditable(false);
			bitowNaPiksel.setEditable(false);
			wykonawca.setEditable(true);
		});
		panelNadrzedny.add(txt);
		panelNadrzedny.add(img);
		panelNadrzedny.add(mp3);
		grupaPrzyciskowOpcji.add(txt);
		grupaPrzyciskowOpcji.add(img);
		grupaPrzyciskowOpcji.add(mp3);
		if (edytowanyElement != null) {
			switch (edytowanyElement.getClass().toString()) {
				case "class PlikTekstowy":
					txt.setSelected(true);
					wybranyPrzyciskOpcji = txt;
					kodowanie.setText(edytowanyElement.zwrocDodatkowyParametr().toString());
					kodowanie.setEditable(false);
					bitowNaPiksel.setEnabled(false);
					wykonawca.setEnabled(false);
					break;
				case "class Obrazek":
					img.setSelected(true);
					wybranyPrzyciskOpcji = img;
					bitowNaPiksel.setText(edytowanyElement.zwrocDodatkowyParametr().toString());
					kodowanie.setEnabled(false);
					bitowNaPiksel.setEditable(false);
					wykonawca.setEnabled(false);
					break;
				case "class UtworMuzyczny":
					mp3.setSelected(true);
					wybranyPrzyciskOpcji = mp3;
					wykonawca.setText(edytowanyElement.zwrocDodatkowyParametr().toString());
					kodowanie.setEnabled(false);
					bitowNaPiksel.setEnabled(false);
					wykonawca.setEditable(false);
					break;
			}
			txt.setEnabled(false);
			img.setEnabled(false);
			mp3.setEnabled(false);
		}

	}
}

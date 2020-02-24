import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class OknoGlowne {
	private UI uI;
	private Aplikacja aplikacja;
	private DefaultListModel<Nosnik> widokListaNosnikow;
	private DefaultListModel<ElementZawartosci> widokListaElementow;
	private Nosnik wybranyNosnik;
	private JFrame mainFrame;

	public OknoGlowne(UI uI, Aplikacja aplikacja) {
		this.uI = uI;
		this.aplikacja = aplikacja;
		widokListaNosnikow = new DefaultListModel<>();
		widokListaElementow = new DefaultListModel<>();

		stworzMainFrame();
	}


	public void dodajNosnikDoListy(Nosnik nosnik) {
		widokListaNosnikow.addElement(nosnik);
		aplikacja.dodajNosnik(nosnik);
	}

	private void stworzMainFrame() {
		mainFrame = new JFrame("Okno glowne");
		mainFrame.setResizable(false);
		mainFrame.setBounds(0, 0, 800, 600);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_obszarInformacyjny = new JPanel();
		mainFrame.getContentPane().add(panel_obszarInformacyjny, BorderLayout.CENTER);
		panel_obszarInformacyjny.setLayout(null);

		JList<Nosnik> listaNosnikow = new JList<>();
		JList<ElementZawartosci> listaElementow = new JList<>();
		stworzPrzyciski(listaNosnikow, listaElementow);
		stworzListeNosnikow(panel_obszarInformacyjny, listaNosnikow);
		stworzListeElementow(panel_obszarInformacyjny, listaElementow);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	private void stworzPrzyciski(JList<Nosnik> listaNosnikow, JList<ElementZawartosci> listaElementow) {
		JPanel buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(240, 10));
		buttons.setMinimumSize(new Dimension(100, 10));
		mainFrame.getContentPane().add(buttons, BorderLayout.WEST);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(90, 90));
		buttons.add(separator);

		JButton btnWczytajStan = new JButton("Wczytaj stan");
		btnWczytajStan.addActionListener(e -> {
			aplikacja.wczytajStan(mainFrame);
			widokListaNosnikow.addAll(aplikacja.getNosniki());
		});
		btnWczytajStan.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnWczytajStan);

		JButton btnZapiszStan = new JButton("Zapisz stan");
		btnZapiszStan.addActionListener(e -> aplikacja.zapiszStan(mainFrame));
		btnZapiszStan.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnZapiszStan);

		JButton btnDodajNosnik = new JButton("Dodaj nosnik");
		btnDodajNosnik.addActionListener(e -> {
			if (KontrolerNosnika.czyMoznaDodacNosnik())
				uI.wyswietlOknoNosnika(null, widokListaElementow);
			else
				System.out.println("Nie udalo sie dodac nosnik: osiagnieto limit na liczbe nosnikow");
		});
		btnDodajNosnik.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnDodajNosnik);

		JButton btnEdytujNosnik = new JButton("Edytuj nosnik");
		btnEdytujNosnik.addActionListener(e -> {
			if (wybranyNosnik != null)
				uI.wyswietlOknoNosnika(wybranyNosnik, widokListaElementow);
		});
		btnEdytujNosnik.setEnabled(false);
		btnEdytujNosnik.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnEdytujNosnik);

		JButton btnUsunNosnik = new JButton("Usun nosnik");
		btnUsunNosnik.addActionListener(e -> {
			if (wybranyNosnik != null) {
				aplikacja.usunNosnik(wybranyNosnik);
				widokListaNosnikow.removeElement(wybranyNosnik);
				if (widokListaNosnikow.size() == 0) {
					btnEdytujNosnik.setEnabled(false);
					btnUsunNosnik.setEnabled(false);
				}
				widokListaElementow.clear();
				listaNosnikow.clearSelection();
			}
		});
		btnUsunNosnik.setEnabled(false);
		btnUsunNosnik.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnUsunNosnik);

		JButton btnOknoUzytkownikow = new JButton("Okno uzytkownikow");
		btnOknoUzytkownikow.setEnabled(false);
		btnOknoUzytkownikow.setPreferredSize(new Dimension(200, 29));
		buttons.add(btnOknoUzytkownikow);

		listaNosnikow.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!listaNosnikow.isSelectionEmpty()) {
					btnEdytujNosnik.setEnabled(true);
					btnUsunNosnik.setEnabled(true);
				}
			}
		});

		listaNosnikow.addListSelectionListener(e -> {
			if (!listaNosnikow.isSelectionEmpty()) {
				wybranyNosnik = listaNosnikow.getSelectedValue();
				widokListaElementow.clear();
				widokListaElementow.addAll(wybranyNosnik.zwrocElementyZawartosci());
			}
			else {
				wybranyNosnik = null;
				btnEdytujNosnik.setEnabled(true);
				btnUsunNosnik.setEnabled(true);
			}
		});
	}

	private void stworzListeNosnikow(JPanel panelNadrzedny, JList<Nosnik> listaNosnikow) {

		JPanel panel_listaNosnikow = new JPanel();
		panel_listaNosnikow.setBounds(15, 16, 250, 500);
		panelNadrzedny.add(panel_listaNosnikow);
		panel_listaNosnikow.setLayout(new BoxLayout(panel_listaNosnikow, BoxLayout.Y_AXIS));

		JLabel lblListaNosnikow = new JLabel("Lista nosnikow");
		lblListaNosnikow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListaNosnikow.setHorizontalAlignment(SwingConstants.CENTER);
		panel_listaNosnikow.add(lblListaNosnikow);

		JScrollPane spListaNosnikow = new JScrollPane();
		panel_listaNosnikow.add(spListaNosnikow);


		spListaNosnikow.setViewportView(listaNosnikow);
		listaNosnikow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaNosnikow.setModel(widokListaNosnikow);
	}

	private void stworzListeElementow(JPanel panelNadrzedny, JList<ElementZawartosci> listaElementow) {
		JPanel panel_listaElementow = new JPanel();
		panel_listaElementow.setBounds(280, 16, 250, 500);
		panelNadrzedny.add(panel_listaElementow);
		panel_listaElementow.setLayout(new BoxLayout(panel_listaElementow, BoxLayout.Y_AXIS));

		JLabel lblListaElementow = new JLabel("Lista elementow");
		lblListaElementow.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_listaElementow.add(lblListaElementow);

		JScrollPane spListaElementow = new JScrollPane();
		panel_listaElementow.add(spListaElementow);

		spListaElementow.setViewportView(listaElementow);
		listaElementow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaElementow.setModel(widokListaElementow);
	}
}

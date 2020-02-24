
/**
 * 
 */
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.GroupLayout.Alignment;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class UI {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private KontrolerElementu kontrolerElementu;
	private Aplikacja aplikacja;
	private OknoLogowania oknoLogowania;
	private OknoGlowne oknoGlowne;
	private OknoNosnika oknoNosnika;
	private OknoElementu oknoElementu;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField textField;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPasswordField passwordField;

	public UI(Aplikacja aplikacja) {
		this.aplikacja = aplikacja;

		wyswietlOknoLogowania();
	}

	public OknoGlowne getOknoGlowne() {
		return oknoGlowne;
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wybierzOpcjeDodaniaNosnika() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wybierzOpcjeDodanieElementu() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wyswietlOknoNosnika(Nosnik nosnik, DefaultListModel<ElementZawartosci> widokListaElementow) {
		oknoNosnika = new OknoNosnika(this, nosnik, widokListaElementow);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wyswietlOknoElementu(OknoNosnika oknoNosnika, Nosnik nosnik, ElementZawartosci edytowanyElement) {
		oknoElementu = new OknoElementu(oknoNosnika, nosnik, edytowanyElement);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wybierzOpcjeZalogowania() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wyswietlOknoLogowania() {
		oknoLogowania = new OknoLogowania(this);
	}

	public void wyswietlOknoGlowne() {
		oknoGlowne = new OknoGlowne(this, aplikacja);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wybierzOpcjeWczytajStanZRepozytorium() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wyswietlListeNosnikow() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}
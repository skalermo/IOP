/**
 * 
 */

import javax.swing.*;
import java.util.List;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Aplikacja {
	private static final int MAX_LICZBA_NOSNIKOW = 10;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private KontrolerNosnika kontrolerNosnika;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private KontrolerElementu kontrolerElementu;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Repozytorium repozytorium;
	
	public Aplikacja() {
		repozytorium = new Repozytorium();
	}
	
	public boolean czyMoznaDodacNosnik() {
		return repozytorium.getLiczbaNosnikow() < MAX_LICZBA_NOSNIKOW;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nosnik
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void dodajNosnik(Nosnik nosnik) {
		repozytorium.dodajNosnik(nosnik);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void sprawdzLoginiHaslo() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void zapiszStan(JFrame frame) {
		repozytorium.zapiszStan(frame);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wczytajStan(JFrame frame) {
		repozytorium.wczytajStan(frame);
	}

	public List<Nosnik> getNosniki() {
		return repozytorium.getNosniki();
	}

	public void usunNosnik(Nosnik nosnik) {
		repozytorium.getNosniki().removeIf(nosnik::equals);
	}
}
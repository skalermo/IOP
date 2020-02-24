/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class KontrolerNosnika {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
//	private Nosnik nosnik;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static UI uI;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static Aplikacja aplikacja;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nazwa
	* @param rozmiar
	* @param typ
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static Nosnik stworzNosnik(String nazwa, int rozmiar, TypNosnika typ) {
		return FabrykaNosnikow.zbuduj(nazwa, rozmiar, typ);
	}

	public static void usunNosnik(Nosnik nosnik) {
		aplikacja.usunNosnik(nosnik);
	}

	public static void edytujNosnik(Nosnik nosnik, String nazwa) {
		nosnik.setNazwa(nazwa);
	}

	public static void usunElement(Nosnik nosnik, ElementZawartosci elementZawartosci) {
		nosnik.usunElement(elementZawartosci);
	}

	public static boolean czyMoznaDodacNosnik() {
		return aplikacja.czyMoznaDodacNosnik();
	}

	public static void setuI(UI uIobj) {
		uI = uIobj;
	}

	public static void setAplikacja(Aplikacja aplikacjaobj) {
		aplikacja = aplikacjaobj;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static void dodajElementDoNosnika(Nosnik nosnik, ElementZawartosci element) {
		nosnik.dodajElement(element);
	}

	public static List<ElementZawartosci> zwrocElementy(Nosnik nosnik) {
		return nosnik.zwrocElementyZawartosci();
	}
}
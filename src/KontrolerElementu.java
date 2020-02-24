/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class KontrolerElementu {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private UI uI;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Aplikacja aplikacja;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static ElementZawartosci stworzElement(String nazwa, int rozmiar, TypElementu typ, Object dodatkowyParametr) {
		return FabrykaElementow.zbuduj(nazwa, rozmiar, typ, dodatkowyParametr);
	}

	public static void edytujElement(ElementZawartosci elementZawartosci, String nazwa) {
		elementZawartosci.ustawNazwe(nazwa);
	}
}
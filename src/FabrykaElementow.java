/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FabrykaElementow {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static ElementZawartosci zbuduj(String nazwa, int rozmiar, TypElementu typ, Object dodatkowyParametr) {
		switch (typ) {
			case PlikTekstowy:
				return new PlikTekstowy(nazwa, rozmiar, dodatkowyParametr);
			case Obrazek:
				return new Obrazek(nazwa, rozmiar, dodatkowyParametr);
			case UtworMuzyczny:
				return new UtworMuzyczny(nazwa, rozmiar, dodatkowyParametr);
			default:
				return null;
		}
	}
}
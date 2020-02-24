/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FabrykaNosnikow {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param Parameter1
	* @param nazwa
	* @param rozmiar
	* @param typ
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static Nosnik zbuduj(String nazwa, int rozmiar, TypNosnika typ) {
		switch (typ) {
		case DyskTwardy:
			return new DyskTwardy(nazwa, rozmiar);
		case PamiecUSB:
			return new PamiecUSB(nazwa, rozmiar);
		case DyskOptyczny:
			return new DyskOptyczny(nazwa, rozmiar);
		default:
			return null;
		}
	}

}
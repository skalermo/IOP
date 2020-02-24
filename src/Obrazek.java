/**
 * 
 */

import java.io.Serializable;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Obrazek extends ElementZawartosci implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private int bitownapiksel;

	public Obrazek(String nazwa, int rozmiar, Object dodatkowyParametr) {
		super(nazwa, rozmiar);
		bitownapiksel = Integer.parseInt(dodatkowyParametr.toString());
	}

	@Override
	public Object zwrocDodatkowyParametr() {
		return bitownapiksel;
	}

	public String toString() {
		return "Obraz " + super.toString();
	}
}
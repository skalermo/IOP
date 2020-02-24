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
public class PlikTekstowy extends ElementZawartosci implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String kodowanie;

	public PlikTekstowy(String nazwa, int rozmiar, Object dodatkowyParametr) {
		super(nazwa, rozmiar);
		kodowanie = dodatkowyParametr.toString();
	}

	@Override
	public Object zwrocDodatkowyParametr() {
		return kodowanie;
	}

	public String toString() {
		return "Plik tekstowy " + super.toString();
	}
}
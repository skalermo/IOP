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
public class UtworMuzyczny extends ElementZawartosci implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String wykonawca;

	public UtworMuzyczny(String nazwa, int rozmiar, Object dodatkowyParametr) {
		super(nazwa, rozmiar);
		wykonawca = dodatkowyParametr.toString();
	}

	@Override
	public Object zwrocDodatkowyParametr() {
		return wykonawca;
	}

	public String toString() {
		return "Utwor muzyczy " + super.toString();
	}
}
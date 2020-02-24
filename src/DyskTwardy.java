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
public class DyskTwardy extends Nosnik implements Serializable {

	public DyskTwardy(String nazwa, int rozmiar) {
		super(nazwa, rozmiar);
	}
	
	public String toString() {
		return "Dysk twardy " + super.toString();
	}
}

/**
 * 
 */

import java.io.Serializable;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class ElementZawartosci implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected String nazwa;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected int rozmiar;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ElementZawartosci(String nazwa, int rozmiar) {
		this.nazwa = nazwa;
		this.rozmiar = rozmiar;
	}

	public void ustawNazwe(String nazwa) {
		this.nazwa = nazwa;
	}

	public String zwrocNazwe() {
		return nazwa;
	}

	public int zwrocRozmiar() {
		return rozmiar;
	}

	public abstract Object zwrocDodatkowyParametr();

	public String toString() {
		return nazwa;
	}
}
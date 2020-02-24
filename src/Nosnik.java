/**
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Nosnik implements Serializable {
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private List<ElementZawartosci> elementyZawartosci;
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected float wolnaPrzestrzen;
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected String nazwa;
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected int rozmiar;

	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected String opis;
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TypPartycjonowania typPartycjonowania;
	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private SystemPlikow systemPlikow;

	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public Nosnik(String nazwa, int rozmiar) {
		elementyZawartosci = new ArrayList<>();
		this.nazwa = nazwa;
		this.rozmiar = rozmiar;
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 *
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void dodajElement(ElementZawartosci elementZawartosci) {
		elementyZawartosci.add(elementZawartosci);
	}

	public String getNazwa() {
		return nazwa;
	}

	public int getRozmiar() {
		return rozmiar;
	}

	public String toString() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<ElementZawartosci> zwrocElementyZawartosci() {
		return elementyZawartosci;
	}

	public void usunElement(ElementZawartosci elementZawartosci) {
		elementyZawartosci.remove(elementZawartosci);
	}
}
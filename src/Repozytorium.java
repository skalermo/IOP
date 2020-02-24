
/**
 * 
 */

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author skalermo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Repozytorium {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private List<Nosnik> nosniki = null;

	public Repozytorium() {
		nosniki = new ArrayList();
	}
	
	public int getLiczbaNosnikow() {
		return nosniki.size();
	}

	public List<Nosnik> getNosniki() {
		return nosniki;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void wczytajStan(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Zaladuj z");
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {

				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				nosniki = (List<Nosnik>) ois.readObject();
				ois.close();

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NullPointerException ignored) {
			}
		}
	}

	public void zapiszStan(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Zachowaj w");

		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {

				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(nosniki);
				oos.close();

			} catch (NullPointerException ignored) {
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void dodajNosnik(Nosnik nosnik) {
		this.nosniki.add(nosnik);
	}
}
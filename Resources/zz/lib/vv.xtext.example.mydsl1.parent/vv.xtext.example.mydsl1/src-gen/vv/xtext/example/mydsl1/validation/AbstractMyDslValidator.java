/*
 * generated by Xtext 2.30.0
 */
package vv.xtext.example.mydsl1.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractMyDslValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(vv.xtext.example.mydsl1.myDsl.MyDslPackage.eINSTANCE);
		return result;
	}
}
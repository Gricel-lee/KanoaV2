package example1;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import zzz.example.mydsl1.MyDslStandaloneSetup;
import zzz.example.mydsl1.myDsl.Greeting;
import zzz.example.mydsl1.myDsl.Model;

public class run {
	public static void main(String[] args) {
		
		System.out.println("Hi");
		
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		Resource resource = resourceSet.getResource(URI.createFileURI("./example.mydsl"), true);

		Model model = (Model) resource.getContents().get(0);
		
		@SuppressWarnings("unchecked")
		EList<Greeting> gs = (EList<Greeting>) new ArrayList();
		
		for (Greeting g : gs) {
			System.out.println(g.toString());
		}
		
		//g= model.getGreetings();
		
		//model.getGreetings().forEach(System.out::println);
	}
	
}



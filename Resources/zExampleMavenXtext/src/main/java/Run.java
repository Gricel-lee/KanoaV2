import org.xtext.example.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

public class Run{
	public static void main(String[] args) {
		System.out.print("Hello Worldd");
		
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(
		    URI.createURI("platform:/resource/org.xtext.example.mydsl/src/example.mydsl"), true);
		Model model = (Model) resource.getContents().get(0);
	}
	
}


//Check it later

//Source 1:
//How to integrate Xtext with Maven:
//https://www.nikostotz.de/blog/combine-xcore-xtend-ecore-and-maven/#generateGenModel.mwe2


//Cource2:
//https://thomas.trocha.com/blog/xtext---export-dsl-as-runnable-jar/
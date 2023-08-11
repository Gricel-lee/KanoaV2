package zExampleMavenXtext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.example.mydsl1.*;  //t.example1.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

public class Ma {
	
	public static void main(String[] args) {
		System.out.print("Hello Worldd");
		//new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		
		
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		//Resource resource = resourceSet.getResource(URI.createFileURI("./hospitalScenario.mydsl"), true);
		Resource resource = resourceSet.getResource(URI.createFileURI("hospitalScenario.mydsl"), true);
		
		
		
		//Resource resource = resourceSet.createResource(URI.createURI("file:./hospitalScenario.mydsl"),true);
		Model Model = (Model) resource.getContents().get(0);
		
		for(Greeting e:Model.getGreeting()){
			System.out.println(e);
		}
		
		
	}

}


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.example.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

import dsl.Location;
import dsl.ProblemSpecification;
import dsl.WorldModel;

public class Run{
	public static void main(String[] args){
		System.out.print("Hello Worldd");
		
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		Resource resource = resourceSet.createResource(URI.createURI("file:/example.mydsl"));
		InputStream in = new ByteArrayInputStream("Hello World".getBytes());
		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ProblemSpecification problemSpecification = (ProblemSpecification) resource.getContents().get(0);
		
		for(WorldModel e:problemSpecification.getWorldModel()){
			System.out.println(e);
		}
	}
	
}


//Check it later

//Source 1:
//How to integrate Xtext with Maven:
//https://www.nikostotz.de/blog/combine-xcore-xtend-ecore-and-maven/#generateGenModel.mwe2


//Cource2:
//https://thomas.trocha.com/blog/xtext---export-dsl-as-runnable-jar/
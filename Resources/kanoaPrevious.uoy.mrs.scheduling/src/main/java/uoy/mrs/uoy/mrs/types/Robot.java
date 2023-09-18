package uoy.mrs.uoy.mrs.types;

import java.util.List;

public interface Robot {
	
	String getID();
	
	LocationImpl getLoc();
	
	List<CapabilityImpl> getCap();
}

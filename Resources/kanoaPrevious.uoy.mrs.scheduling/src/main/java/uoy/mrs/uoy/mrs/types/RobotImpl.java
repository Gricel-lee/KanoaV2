package uoy.mrs.uoy.mrs.types;

import java.util.List;

public class RobotImpl implements Robot{
	
	private String id;
	private LocationImpl loc;
	private List<CapabilityImpl> capabilities;
	
	
	//constructor
		public RobotImpl(String id, LocationImpl loc, String capabString) {
			this.id = id;
			this.loc = loc;
			this.capabilities = capabilitiesFromString();
		}
		
	
	private List<CapabilityImpl> capabilitiesFromString() {
			return null;
		}

	@Override
	public String getID() {
		return id;
	}
	
	@Override
	public LocationImpl getLoc() {
		return loc;
	}
	
	@Override
	public List<CapabilityImpl> getCap() {
		return capabilities;
	}
}

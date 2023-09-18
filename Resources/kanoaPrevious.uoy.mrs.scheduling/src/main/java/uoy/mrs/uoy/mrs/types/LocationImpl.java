package uoy.mrs.uoy.mrs.types;

public class LocationImpl implements Location {
	
	private String id;
	private String x;
	private String y;
	
	public LocationImpl(String id, String x, String y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getx() {
		return x;
	}

	@Override
	public String gety() {
		return y;
	}

}

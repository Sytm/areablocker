package de.sytm.areablocker.util;

public class AreaRestriction {

	private Region region;
	private String permission, id;
	
	public AreaRestriction(Region region, String permission, String id) {
		this.region = region;
		this.permission = permission;
		this.id = id;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public String getPermission() {
		return permission;
	}
	
	public String getID() {
		return id;
	}
}

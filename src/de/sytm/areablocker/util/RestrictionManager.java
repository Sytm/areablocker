package de.sytm.areablocker.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestrictionManager {

	private static List<AreaRestriction> restrictions = new ArrayList<AreaRestriction>();

	public static void add(AreaRestriction restriction) {
		restrictions.add(restriction);
	}

	public static boolean remove(String id) {
		for (AreaRestriction restr : restrictions) {
			if (restr.getID().equalsIgnoreCase(id)) {
				restrictions.remove(restr);
				return true;
			}
		}
		return false;
	}

	public static List<AreaRestriction> restrictions() {
		return Collections.unmodifiableList(restrictions);
	}
}

package util;

import java.util.Comparator;
import model.Chanel;

public class ChanelCompare implements Comparator {

	public int compare(Object o1, Object o2) {
		Chanel s1 = (Chanel) o1;
		Chanel s2 = (Chanel) o2;
		int result = s1.getReq() > s2.getReq() ? 1 : (s1.getReq() == s2
				.getReq() ? 0 : -1);
		return result;
	}

	public String toString() {
		return this.hashCode() + "";
	}
}

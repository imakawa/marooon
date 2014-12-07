package util;

import java.util.Comparator;

import model.Product;

public class ProductCompare  implements Comparator {

	public ProductCompare() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Object o1, Object o2) {
		Product s1 = (Product) o1;
		Product s2 = (Product) o2;
		int result = s1.getCode().compareTo(s2.getCode())>0 ? 1 : (s1.getCode() == s2
				.getCode() ? 0 : -1);
		return result;
	}

	public String toString() {
		return this.hashCode() + "";
	}
}

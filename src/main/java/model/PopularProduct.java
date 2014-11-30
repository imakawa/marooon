package model;

public class PopularProduct {

	private String id;
	private String indexProduct;
	private String hotProduct;
	private String productId;
	/*
	private String chanelName;
	private String productName;
	private String productPrice;*/
	
	private Chanel chanel;
	private Product product;
	
	public PopularProduct() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndexProduct() {
		return indexProduct;
	}

	public void setIndexProduct(String indexProduct) {
		this.indexProduct = indexProduct;
	}

	public String getHotProduct() {
		return hotProduct;
	}

	public void setHotProduct(String hotProduct) {
		this.hotProduct = hotProduct;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Chanel getChanel() {
		return chanel;
	}

	public void setChanel(Chanel chanel) {
		this.chanel = chanel;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	
}

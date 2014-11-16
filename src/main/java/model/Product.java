package model;

import java.util.List;

public class Product {

	private String id;
	
	private String name;
	
	private CommentInfo descripe1;
	
	private CommentInfo descripe2;
	
	private CommentInfo descripe3;
	
	private CommentInfo descripe4;
	
	private PriceInfo price;
	
	private String imageView;
	
	private List<String> images;
	
	private String shippingCode;
	
	private String weightInfo;
	
	private String isInStock;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommentInfo getDescripe1() {
		return descripe1;
	}

	public void setDescripe1(CommentInfo descripe1) {
		this.descripe1 = descripe1;
	}

	public CommentInfo getDescripe2() {
		return descripe2;
	}

	public void setDescripe2(CommentInfo descripe2) {
		this.descripe2 = descripe2;
	}

	public CommentInfo getDescripe3() {
		return descripe3;
	}

	public void setDescripe3(CommentInfo descripe3) {
		this.descripe3 = descripe3;
	}

	public CommentInfo getDescripe4() {
		return descripe4;
	}

	public void setDescripe4(CommentInfo descripe4) {
		this.descripe4 = descripe4;
	}

	public PriceInfo getPrice() {
		return price;
	}

	public void setPrice(PriceInfo price) {
		this.price = price;
	}

	public String getImageView() {
		return imageView;
	}

	public void setImageView(String imageView) {
		this.imageView = imageView;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getWeightInfo() {
		return weightInfo;
	}

	public void setWeightInfo(String weightInfo) {
		this.weightInfo = weightInfo;
	}

	public String getIsInStock() {
		return isInStock;
	}

	public void setIsInStock(String isInStock) {
		this.isInStock = isInStock;
	}

}

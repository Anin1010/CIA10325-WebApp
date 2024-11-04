package com.product.model;
import java.sql.Date;
import java.sql.Timestamp;

public class ProductVO implements java.io.Serializable{
	private Integer prod_no;
	private Integer ft_id;
	private String prod_name;
	private String prod_desc;
	private Integer price;
	private Integer available_quantity;
	private Integer sold_quantity;
	private Integer rating;
	private Integer rating_count;
	private Integer view_count;
	private Timestamp listed_time;
	private Byte status;
	
	
	public ProductVO() {
		super();
		
	}


	


	public ProductVO(Integer prod_no, Integer ft_id, String prod_name, String prod_desc, Integer price,
			Integer available_quantity, Integer sold_quantity, Integer rating, Integer rating_count, Integer view_count,
			Timestamp listed_time, Byte status) {
		super();
		this.prod_no = prod_no;
		this.ft_id = ft_id;
		this.prod_name = prod_name;
		this.prod_desc = prod_desc;
		this.price = price;
		this.available_quantity = available_quantity;
		this.sold_quantity = sold_quantity;
		this.rating = rating;
		this.rating_count = rating_count;
		this.view_count = view_count;
		this.listed_time = listed_time;
		this.status = status;
	}





	public Integer getProd_no() {
		return prod_no;
	}


	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}


	public Integer getFt_id() {
		return ft_id;
	}


	public void setFt_id(Integer ft_id) {
		this.ft_id = ft_id;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public String getProd_desc() {
		return prod_desc;
	}


	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getAvailable_quantity() {
		return available_quantity;
	}


	public void setAvailable_quantity(Integer available_quantity) {
		this.available_quantity = available_quantity;
	}


	public Integer getSold_quantity() {
		return sold_quantity;
	}


	public void setSold_quantity(Integer sold_quantity) {
		this.sold_quantity = sold_quantity;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Integer getRating_count() {
		return rating_count;
	}


	public void setRating_count(Integer rating_count) {
		this.rating_count = rating_count;
	}


	public Integer getView_count() {
		return view_count;
	}


	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}


	public Timestamp getListed_time() {
		return listed_time;
	}


	public void setListed_time(Timestamp listed_time) {
		this.listed_time = listed_time;
	}


	public Byte getStatus() {
		return status;
	}


	public void setStatus(Byte status) {
		this.status = status;
	}





	@Override
	public String toString() {
		return "ProductVO [prod_no=" + prod_no + ", ft_id=" + ft_id + ", prod_name=" + prod_name + ", prod_desc="
				+ prod_desc + ", price=" + price + ", available_quantity=" + available_quantity + ", sold_quantity="
				+ sold_quantity + ", rating=" + rating + ", rating_count=" + rating_count + ", view_count=" + view_count
				+ ", listed_time=" + listed_time + ", status=" + status + "]";
	}
	
	
	
	
	
	
}

package com.product.model;

import java.sql.Timestamp;
import java.util.List;

public class ProductService {

	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductJDBCDAO();
	}

	public ProductVO addProduct(Integer prod_no, Integer ft_id, String prod_name, String prod_desc, Integer price,
			Integer available_quantity, Integer sold_quantity, Integer rating, Integer rating_count, Integer view_count,
			Timestamp listed_time, Byte status) {

		ProductVO productVO = new ProductVO();

		productVO.setProd_no(prod_no);
        productVO.setFt_id(ft_id);
        productVO.setProd_name(prod_name);
        productVO.setProd_desc(prod_desc);
        productVO.setPrice(price);
        productVO.setAvailable_quantity(available_quantity);
        productVO.setSold_quantity(sold_quantity);
        productVO.setRating(rating);
        productVO.setRating_count(rating_count);
        productVO.setView_count(view_count);
        productVO.setListed_time(listed_time);
        productVO.setStatus(status);

        return productVO;
	}

	public ProductVO updateProduct(Integer prod_no, Integer ft_id, String prod_name, String prod_desc, Integer price,
			Integer available_quantity, Integer sold_quantity, Integer rating, Integer rating_count, Integer view_count,
			Timestamp listed_time, Byte status) {

		ProductVO productVO = new ProductVO();

		productVO.setProd_no(prod_no);
        productVO.setFt_id(ft_id);
        productVO.setProd_name(prod_name);
        productVO.setProd_desc(prod_desc);
        productVO.setPrice(price);
        productVO.setAvailable_quantity(available_quantity);
        productVO.setSold_quantity(sold_quantity);
        productVO.setRating(rating);
        productVO.setRating_count(rating_count);
        productVO.setView_count(view_count);
        productVO.setListed_time(listed_time);
        productVO.setStatus(status);

		dao.update(productVO);

		return productVO;
	}

	public void deleteProduct(Integer prod_no) {
		dao.delete(prod_no);
	}

	public ProductVO getOneEmp(Integer prod_no) {
		return dao.findByPrimaryKey(prod_no);
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}
}

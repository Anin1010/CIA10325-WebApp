package com.product.model;

import java.sql.Timestamp;
import java.util.List;

public class Product_reportService {

	private Product_reportDAO_interface dao;

	public Product_reportService() {
		dao = new Product_reportJDBCDAO();
	}

	public Product_reportVO addProductReport(Integer report_no, Integer mem_id, Integer prod_no, Integer admin_id, String admin_desc,
			String report_content, String report_desc, Byte status, Timestamp create_time,
			Timestamp case_closing_time) {

		Product_reportVO product_reportVO = new Product_reportVO();

		product_reportVO.setMem_id(mem_id);
		product_reportVO.setProd_no(prod_no);
		product_reportVO.setAdmin_id(admin_id);
		product_reportVO.setAdmin_desc(admin_desc);
		product_reportVO.setReport_content(report_content);
		product_reportVO.setReport_desc(report_desc);
		product_reportVO.setStatus(status);
		product_reportVO.setCreate_time(create_time);
		product_reportVO.setCase_closing_time(case_closing_time);

        return product_reportVO;
	}

	public Product_reportVO updateProductReport(Integer report_no, Integer mem_id, Integer prod_no, Integer admin_id, String admin_desc,
			String report_content, String report_desc, Byte status, Timestamp create_time,
			Timestamp case_closing_time) {

		Product_reportVO product_reportVO = new Product_reportVO();

		product_reportVO.setMem_id(mem_id);
		product_reportVO.setProd_no(prod_no);
		product_reportVO.setAdmin_id(admin_id);
		product_reportVO.setAdmin_desc(admin_desc);
		product_reportVO.setReport_content(report_content);
		product_reportVO.setReport_desc(report_desc);
		product_reportVO.setStatus(status);
		product_reportVO.setCreate_time(create_time);
		product_reportVO.setCase_closing_time(case_closing_time);

      
		dao.update(product_reportVO);

		return product_reportVO;
	}

//	public void deleteProduct(Integer prod_no) {
//		dao.delete(prod_no);
//	}

	public Product_reportVO getOneEmp(Integer report_no) {
		return dao.findByPrimaryKey(report_no);
	}

	public List<Product_reportVO> getAll() {
		return dao.getAll();
	}
}

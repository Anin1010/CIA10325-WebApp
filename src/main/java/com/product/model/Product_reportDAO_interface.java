package com.product.model;

import java.util.*;

public interface Product_reportDAO_interface {
          public void insert(Product_reportVO product_reportVO);
          public void update(Product_reportVO product_reportVO);
         // public void delete(Integer prod_no);
          public Product_reportVO findByPrimaryKey(Integer report_no);
          public List<Product_reportVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}

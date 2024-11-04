package com.product.model;

import java.util.*;

import com.mysql.cj.util.Util;

import java.sql.*;
import java.sql.Date;

public class Product_reportJDBCDAO implements Product_reportDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/divinationplatform?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "domo32515157";

	private static final String INSERT_STMT = "INSERT INTO prod_report (mem_id, prod_no, admin_id, admin_desc, report_content, report_desc, status, create_time, case_closing_time) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )";
	private static final String GET_ALL_STMT = "SELECT * FROM prod_report ORDER BY report_no ";
	private static final String GET_ONE_STMT = "SELECT * FROM prod_report WHERE report_no = ?";
	// private static final String DELETE = "UPDATE product SET status = 1 WHERE
	// prod_no = ?";
	private static final String UPDATE = "UPDATE prod_report SET mem_id = ?, prod_no = ?, admin_id = ?, admin_desc = ?, report_content = ?, report_desc = ?, status = ?, case_closing_time = ? WHERE report_no = ?";

	@Override
	public void insert(Product_reportVO product_reportVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			
			String[] cols = { "report_no" };
			
		    pstmt = con.prepareStatement(INSERT_STMT, cols);
			pstmt.setInt(1, product_reportVO.getMem_id());
			pstmt.setInt(2, product_reportVO.getProd_no());
			pstmt.setInt(3, product_reportVO.getAdmin_id());
			pstmt.setString(4, product_reportVO.getAdmin_desc());
			pstmt.setString(5, product_reportVO.getReport_content());
			pstmt.setString(6, product_reportVO.getReport_desc());
			pstmt.setByte(7, product_reportVO.getStatus());
			pstmt.setTimestamp(8, product_reportVO.getCreate_time());
			pstmt.setTimestamp(9, product_reportVO.getCase_closing_time());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Product_reportVO product_reportVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, product_reportVO.getMem_id());
            pstmt.setInt(2, product_reportVO.getProd_no());
            pstmt.setInt(3, product_reportVO.getAdmin_id());
            pstmt.setString(4, product_reportVO.getAdmin_desc());
            pstmt.setString(5, product_reportVO.getReport_content());
            pstmt.setString(6, product_reportVO.getReport_desc());
            pstmt.setByte(7, product_reportVO.getStatus());
            
            pstmt.setTimestamp(8, product_reportVO.getCase_closing_time());
            pstmt.setInt(9, product_reportVO.getReport_no()); // Primary Key

            pstmt.executeUpdate();

			

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	// @Override
//	public void delete(Integer prod_no) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, prod_no);
//
//			int removedRows = pstmt.executeUpdate();
//			
//			System.out.println(removedRows+"筆商品已下架成功");
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}

	@Override
	public Product_reportVO findByPrimaryKey(Integer report_no) {

		 Product_reportVO product_reportVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, report_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				product_reportVO = new Product_reportVO();
                product_reportVO.setReport_no(rs.getInt("report_no"));
                product_reportVO.setMem_id(rs.getInt("mem_id"));
                product_reportVO.setProd_no(rs.getInt("prod_no"));
                product_reportVO.setAdmin_id(rs.getInt("admin_id"));
                product_reportVO.setAdmin_desc(rs.getString("admin_desc"));
                product_reportVO.setReport_content(rs.getString("report_content"));
                product_reportVO.setReport_desc(rs.getString("report_desc"));
                product_reportVO.setStatus(rs.getByte("status"));
                product_reportVO.setCreate_time(rs.getTimestamp("create_time"));
                product_reportVO.setCase_closing_time(rs.getTimestamp("case_closing_time"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return product_reportVO;
	}

	@Override
	public List<Product_reportVO> getAll() {
		List<Product_reportVO> list = new ArrayList<Product_reportVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				 Product_reportVO product_reportVO = new Product_reportVO();
	                product_reportVO.setReport_no(rs.getInt("report_no"));
	                product_reportVO.setMem_id(rs.getInt("mem_id"));
	                product_reportVO.setProd_no(rs.getInt("prod_no"));
	                product_reportVO.setAdmin_id(rs.getInt("admin_id"));
	                product_reportVO.setAdmin_desc(rs.getString("admin_desc"));
	                product_reportVO.setReport_content(rs.getString("report_content"));
	                product_reportVO.setReport_desc(rs.getString("report_desc"));
	                product_reportVO.setStatus(rs.getByte("status"));
	                product_reportVO.setCreate_time(rs.getTimestamp("create_time"));
	                product_reportVO.setCase_closing_time(rs.getTimestamp("case_closing_time"));
	                list.add(product_reportVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		Product_reportJDBCDAO dao = new Product_reportJDBCDAO();
		java.util.Date utilDate = new Date(System.currentTimeMillis());
		Timestamp sqlDate = new Timestamp(utilDate.getTime()); 
		// 新增
//		Product_reportVO product_reportVO1 = new Product_reportVO();
//		product_reportVO1.setMem_id(10);
//		product_reportVO1.setProd_no(11);
//		product_reportVO1.setAdmin_id(2);
//		product_reportVO1.setAdmin_desc("處理完成");
//		product_reportVO1.setReport_content("重複檢舉");
//		product_reportVO1.setReport_desc("問題已解決");
//		product_reportVO1.setStatus((byte)0);
//		product_reportVO1.setCreate_time(sqlDate);
//		product_reportVO1.setCase_closing_time(null);
//		dao.insert(product_reportVO1);

		// 修改
//		Product_reportVO product_reportVO2 = new Product_reportVO();
//		product_reportVO2.setMem_id(11);
//		product_reportVO2.setProd_no(11);
//		product_reportVO2.setAdmin_id(2);
//		product_reportVO2.setAdmin_desc("處理完成");
//		product_reportVO2.setReport_content("重複檢舉");
//		product_reportVO2.setReport_desc("問題已解決");
//		product_reportVO2.setStatus((byte)0);
//		product_reportVO2.setCase_closing_time(sqlDate);
//		product_reportVO2.setReport_no(10);
//		dao.update(product_reportVO2);

//		// 刪除
//		dao.delete(12);
//
//		// 查詢
		Product_reportVO product_reportVO2 = dao.findByPrimaryKey(9);
		System.out.print(product_reportVO2.getMem_id() + ",");
		System.out.print(product_reportVO2.getProd_no() + ",");
		System.out.print(product_reportVO2.getAdmin_id() + ",");
		System.out.print(product_reportVO2.getAdmin_desc() + ",");
		System.out.print(product_reportVO2.getReport_content() + ",");
		System.out.print(product_reportVO2.getReport_desc() + ",");
		System.out.println(product_reportVO2.getStatus());
		System.out.println(product_reportVO2.getCreate_time());
		System.out.println(product_reportVO2.getCase_closing_time());
		System.out.println("---------------------");

		// 查詢

		test();
	}

	public static void test() {
		Product_reportJDBCDAO product_reportJDBCDAO = new Product_reportJDBCDAO();
		List<Product_reportVO> sEs = product_reportJDBCDAO.getAll();
		for (Product_reportVO product_reportVO : sEs) {
			System.out.println(product_reportVO.toString());
		}
	}

}
package com.product.model;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/divinationplatform?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "domo32515157";

	private static final String INSERT_STMT = "INSERT INTO product (prod_no, ft_id, prod_name, prod_desc, price, available_quantity, sold_quantity, rating, rating_count, view_count, listed_time, status) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT prod_no, ft_id, prod_name, prod_desc, price, available_quantity, sold_quantity, rating, rating_count, view_count, listed_time, status FROM product ORDER BY prod_no";
	private static final String GET_ONE_STMT = "SELECT prod_no, ft_id, prod_name, prod_desc, price, available_quantity, sold_quantity, rating, rating_count, view_count, listed_time, status FROM product WHERE prod_no = ?";
	private static final String DELETE = "UPDATE product SET status = 1 WHERE prod_no = ?";
	private static final String UPDATE = "UPDATE product SET ft_id = ?, prod_name = ?, prod_desc = ?, price = ?, available_quantity = ?, sold_quantity = ?, rating = ?, rating_count = ?, view_count = ?, listed_time = ?, status = ? WHERE prod_no = ?";

	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productVO.getProd_no());
			pstmt.setInt(2, productVO.getFt_id());
			pstmt.setString(3, productVO.getProd_name());
			pstmt.setString(4, productVO.getProd_desc());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setInt(6, productVO.getAvailable_quantity());
			pstmt.setInt(7, productVO.getSold_quantity());
			pstmt.setInt(8, productVO.getRating());
			pstmt.setInt(9, productVO.getRating_count());
			pstmt.setInt(10, productVO.getView_count());
			pstmt.setTimestamp(11, productVO.getListed_time());
			pstmt.setByte(12, productVO.getStatus());

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
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productVO.getFt_id());
			pstmt.setString(2, productVO.getProd_name());
			pstmt.setString(3, productVO.getProd_desc());
			pstmt.setInt(4, productVO.getPrice());
			pstmt.setInt(5, productVO.getAvailable_quantity());
			pstmt.setInt(6, productVO.getSold_quantity());
			pstmt.setInt(7, productVO.getRating());
			pstmt.setInt(8, productVO.getRating_count());
			pstmt.setInt(9, productVO.getView_count());
			pstmt.setTimestamp(10, productVO.getListed_time());
			pstmt.setByte(11, productVO.getStatus());
			pstmt.setInt(12, productVO.getProd_no());

			int updatedRows = pstmt.executeUpdate();

			System.out.println(updatedRows + "筆商品資訊更新成功!!");

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
	public void delete(Integer prod_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prod_no);

			int removedRows = pstmt.executeUpdate();
			
			System.out.println(removedRows+"筆商品已下架成功");

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
	public ProductVO findByPrimaryKey(Integer prod_no) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prod_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				productVO.setProd_no(rs.getInt("prod_no"));
                productVO.setFt_id(rs.getInt("ft_id"));
                productVO.setProd_name(rs.getString("prod_name"));
                productVO.setProd_desc(rs.getString("prod_desc"));
                productVO.setPrice(rs.getInt("price"));
                productVO.setAvailable_quantity(rs.getInt("available_quantity"));
                productVO.setSold_quantity(rs.getInt("sold_quantity"));
                productVO.setRating(rs.getInt("rating"));
                productVO.setRating_count(rs.getInt("rating_count"));
                productVO.setView_count(rs.getInt("view_count"));
                productVO.setListed_time(rs.getTimestamp("listed_time"));
                productVO.setStatus(rs.getByte("status"));
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
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
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
				productVO = new ProductVO();
				productVO.setProd_no(rs.getInt("prod_no"));
                productVO.setFt_id(rs.getInt("ft_id"));
                productVO.setProd_name(rs.getString("prod_name"));
                productVO.setProd_desc(rs.getString("prod_desc"));
                productVO.setPrice(rs.getInt("price"));
                productVO.setAvailable_quantity(rs.getInt("available_quantity"));
                productVO.setSold_quantity(rs.getInt("sold_quantity"));
                productVO.setRating(rs.getInt("rating"));
                productVO.setRating_count(rs.getInt("rating_count"));
                productVO.setView_count(rs.getInt("view_count"));
                productVO.setListed_time(rs.getTimestamp("listed_time"));
                productVO.setStatus(rs.getByte("status"));
				list.add(productVO); // Store the row in the list
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

		ProductJDBCDAO dao = new ProductJDBCDAO();

		// 新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

//		// 刪除
//		dao.delete(7014);
//
//		// 查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");

		// 查詢
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
		test();
	}
	
	public static void test() {
		ProductJDBCDAO productJDBCDAO = new ProductJDBCDAO();
		List<ProductVO> sEs =  productJDBCDAO.getAll();
		for(ProductVO productVO : sEs) {
			System.out.println(productVO.toString());
		}
	}
}
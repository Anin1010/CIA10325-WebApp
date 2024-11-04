package com.product.model;
import java.sql.Date;
import java.sql.Timestamp;

public class Product_reportVO implements java.io.Serializable{
	private Integer report_no;
	private Integer mem_id;
	private Integer prod_no;
	private Integer admin_id;
	private String admin_desc;
	private String report_content;
	private String report_desc;
	private Byte status;
	private Timestamp create_time;
	private Timestamp case_closing_time;
	
	
	public Product_reportVO() {
		super();
		
	}


	public Product_reportVO(Integer report_no, Integer mem_id, Integer prod_no, Integer admin_id, String admin_desc,
			String report_content, String report_desc, Byte status, Timestamp create_time,
			Timestamp case_closing_time) {
		super();
		this.report_no = report_no;
		this.mem_id = mem_id;
		this.prod_no = prod_no;
		this.admin_id = admin_id;
		this.admin_desc = admin_desc;
		this.report_content = report_content;
		this.report_desc = report_desc;
		this.status = status;
		this.create_time = create_time;
		this.case_closing_time = case_closing_time;
	}


	public Integer getReport_no() {
		return report_no;
	}


	public void setReport_no(Integer report_no) {
		this.report_no = report_no;
	}


	public Integer getMem_id() {
		return mem_id;
	}


	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}


	public Integer getProd_no() {
		return prod_no;
	}


	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}


	public Integer getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}


	public String getAdmin_desc() {
		return admin_desc;
	}


	public void setAdmin_desc(String admin_desc) {
		this.admin_desc = admin_desc;
	}


	public String getReport_content() {
		return report_content;
	}


	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}


	public String getReport_desc() {
		return report_desc;
	}


	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}


	public Byte getStatus() {
		return status;
	}


	public void setStatus(Byte status) {
		this.status = status;
	}


	public Timestamp getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}


	public Timestamp getCase_closing_time() {
		return case_closing_time;
	}


	public void setCase_closing_time(Timestamp case_closing_time) {
		this.case_closing_time = case_closing_time;
	}


	@Override
	public String toString() {
		return "Product_reportVO [report_no=" + report_no + ", mem_id=" + mem_id + ", prod_no=" + prod_no
				+ ", admin_id=" + admin_id + ", admin_desc=" + admin_desc + ", report_content=" + report_content
				+ ", report_desc=" + report_desc + ", status=" + status + ", create_time=" + create_time
				+ ", case_closing_time=" + case_closing_time + "]";
	}

	
	

	


	
	
}

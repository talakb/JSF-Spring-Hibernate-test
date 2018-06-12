package me.selfstdy.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 7976097987447721551L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deptId")
	private String deptId;
	
	@Column(name="deptName")
	private String deptName;
	
	
	public Department(){
		
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	

}

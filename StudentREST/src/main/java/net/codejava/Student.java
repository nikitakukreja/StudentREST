package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Student {

	private int no;
	private String name;
	private int DOB;
	private int DOJ;

	public Student() {

		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDOB() {
		return DOB;
	}

	public void setDOB(int dOB) {
		DOB = dOB;
	}

	public int getDOJ() {
		return DOJ;
	}

	public void setDOJ(int dOJ) {
		DOJ = dOJ;
	}

}

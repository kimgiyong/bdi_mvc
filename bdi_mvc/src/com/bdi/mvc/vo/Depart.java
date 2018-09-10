package com.bdi.mvc.vo;

public class Depart {
	private int diNo;
	private String diName;
	private String diDesc;
	private int diCnt;
	public int getDiNo() {
		return diNo;
	}
	public void setDiNo(int diNo) {
		this.diNo = diNo;
	}
	public String getDiName() {
		return diName;
	}
	public void setDiName(String diName) {
		this.diName = diName;
	}
	public String getDiDesc() {
		return diDesc;
	}
	public void setDiDesc(String diDesc) {
		this.diDesc = diDesc;
	}
	public int getDiCnt() {
		return diCnt;
	}
	public void setDiCnt(int diCnt) {
		this.diCnt = diCnt;
	}
	@Override
	public String toString() {
		return "Depart [diNo=" + diNo + ", diName=" + diName + ", diDesc=" + diDesc + ", diCnt=" + diCnt + "]";
	}
	public Depart(int diNo, String diName, String diDesc, int diCnt) {
		super();
		this.diNo = diNo;
		this.diName = diName;
		this.diDesc = diDesc;
		this.diCnt = diCnt;
	}
	public Depart() {
		super();
	}
}

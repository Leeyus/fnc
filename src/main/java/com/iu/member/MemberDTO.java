package com.iu.member;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private int num_address;
	private String main_address;
	private String sub_address;
	private String phone1;
	private String phone2;
	private String email;
	private String kind;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum_address() {
		return num_address;
	}
	public void setNum_address(int num_address) {
		this.num_address = num_address;
	}
	public String getMain_address() {
		return main_address;
	}
	public void setMain_address(String main_address) {
		this.main_address = main_address;
	}
	public String getSub_address() {
		return sub_address;
	}
	public void setSub_address(String sub_address) {
		this.sub_address = sub_address;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	

}

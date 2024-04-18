package com.prowings.Unidirectional.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	private int pid;
	private String name;
	private long phone;

	public int getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}

package com.pritam.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

@Entity
public class Data {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    //@Column( nullable = false )
	@Column
	@NotNull
    @Length(min = 4, message = "These field must be at least 4 characters")
    @Length(max = 10, message = "These field must be less than 10 characters") 
    private String title;
    @Column
    //@JsonIgnore
    private String descp;
    @Column(length = 10)
    private long phone;
    @Column()
    @Nullable
    private int pin;

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}

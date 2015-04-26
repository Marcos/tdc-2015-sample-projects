package org.gujavasc.entities;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gujavasc_user")
public class User {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	private String name;
	private String email;
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static User builder() {
		return new User();
	}

	public User id(Long id) {
		setId(id);
		return this;
	}

	public User name(String name) {
		setName(name);
		return this;
	}

	public User email(String email) {
		setEmail(email);
		return this;
	}

	public User age(Integer age) {
		setAge(age);
		return this;
	}

	public User build() {
		return this;
	}

}

package com.gemini.employ.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
	@Column(name="id")
	private long id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="salary")
	private double salary;
}

package com.demo.cicd.pojo;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@SequenceGenerator(name = "customer_id_sequence",sequenceName = "customer_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
	@Column(name="id",updatable = false)
	private Integer id;
	
	@NotNull(message = "Enter the customer name")
	@Column(name="name",columnDefinition = "character varying",length = 255)
	private String name;

	@NotNull(message = "Enter the customers age between 18 and 99")
	@Range(min = 18,max = 99)
	@Column(name = "age",columnDefinition = "integer",length = 2)
	private Integer age;
	
	@NotNull(message = "Enter a valid customer E-mail Id")
	@Email
	@Column(name="email", columnDefinition = "character varying", length = 255)
	private String email;
	
}
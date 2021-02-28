/**
 * 
 */
package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joe
 *
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Approved_category")
public class CategoryEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="DESCRIPTION")
	private String description; 
	
	public CategoryEntity(String categoryName,String description){
		this.categoryName=categoryName;
		this.description=description;
		
	}

}

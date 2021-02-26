package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgramEntity implements Serializable {
	@Id
	@Column(name="PROGRAM_ID")
	public Integer programId;
	
	@Column(name="PROGRAM_NAME")
	public String programName;
	
	@Column(name="ACTIVE_IND")
	public String activeInd;


}

package com.joe.homeexercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Program")
public class ProgramEntity implements Serializable {
	@Id
	@Column(name="PROGRAM_ID")
	public Integer programId;
	
	@Column(name="PROGRAM_NAME")
	public String programName;
	
	@Column(name="ACTIVE_IND")
	public String activeInd;


}

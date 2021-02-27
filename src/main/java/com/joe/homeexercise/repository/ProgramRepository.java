/**
 * 
 */
package com.joe.homeexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.homeexercise.model.ProgramEntity;

/**
 * @author Joe
 *
 */
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {
	ProgramEntity findByProgramName(String programName);
	//String activeInd = "Y";
	ProgramEntity findByProgramNameAndActiveInd(String programName,String activeInd);

}

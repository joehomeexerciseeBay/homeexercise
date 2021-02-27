package com.joe.homeexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joe.homeexercise.model.ProgramEntity;
import com.joe.homeexercise.repository.ProgramRepository;
import com.joe.homeexercise.repository.SellerRepository;

@RestController
public class ItemEligibilityController {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ProgramRepository programRepository;
	@GetMapping("/seller")
	public boolean isSellerEligible(@RequestParam(value = "sellername", defaultValue = "World") String sellerName,
			@RequestParam(value = "programname", defaultValue = "remote location shipping program") String programName)
	{
		ProgramEntity program = programRepository.findByProgramNameAndActiveInd(programName,"Y");
		if(null!=program)
		return sellerRepository.findBySellerNameAndProgramId(sellerName,program.programId)==null?false:true;
		return false;
	}

}

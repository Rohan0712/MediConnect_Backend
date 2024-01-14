package com.pharmacy.mediconnect.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Support;
import com.pharmacy.mediconnect.enitity.SupportModel;
import com.pharmacy.mediconnect.repository.SupportRepository;

@Service
public class SupportService{

	@Autowired
	SupportRepository supportRepository;

	public String saveSupportData(SupportModel supportModel) {
		Support support = new Support();
		support.setName(supportModel.getName());
		support.setEmail(supportModel.getEmail());
		support.setMessage(supportModel.getMessage());
		Random random = new Random();
		Integer response = extracted(support, random);
		if(response !=0) {
			support.setSupportId(response);
		}else {
			Integer response1 = extracted(support, random);
			if(response1 !=0) {
				support.setSupportId(response1);
			}else {
				Integer response2 = extracted(support, random);
				if(response1 !=0) {
					support.setSupportId(response1);
				}
			}
		}
		if(supportRepository.save(support)!= null) {
			return "Success";
		}else {
			return "Failed";
		}
	}

	private Integer extracted(Support support, Random random) {
		int randomWithNextInt = random.nextInt();
		if(randomWithNextInt <0) {
			randomWithNextInt = randomWithNextInt * (-1);
		}
		if(supportRepository.findBySupportId(randomWithNextInt) != null) {			
			return 0;
		}else {
			return randomWithNextInt;
		}
	}
	
}

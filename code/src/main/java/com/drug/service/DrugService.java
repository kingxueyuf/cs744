package com.drug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.service.CustomUserDetailsService;
import com.drug.dao.DrugDao;
import com.drug.data.Drug;
import com.drug.data.DrugFromPharmacy;

@Service
public class DrugService {

	@Autowired
	DrugDao drugDao;
	
	public List<Drug> searchWithInput( String input ){
		return drugDao.searchWithInput(input);
	}

	public List<DrugFromPharmacy> search(String input, String nameType) {
		// TODO Auto-generated method stub
		if(CustomUserDetailsService.isPhysician()){
			return drugDao.search(input,nameType);
		}else{
			return drugDao.searchForMedicalStaff(input,nameType);
		}	
	}

	public String update(DrugFromPharmacy drug) {
		// TODO Auto-generated method stub
		return drugDao.update(drug);
	}
}

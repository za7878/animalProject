package com.human.app.web.Pet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.app.web.Pet.DAO.PetDAO;
import com.human.app.web.Pet.Model.PetModel;
import com.human.app.web.Pet.Service.PetService;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetDAO petDAO;
	

	@Override
	public List<PetModel> Animal(PetModel model) {
		List<PetModel> Animal = petDAO.Animal(model);
		return Animal;
	}

}

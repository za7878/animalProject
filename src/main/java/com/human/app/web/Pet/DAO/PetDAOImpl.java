package com.human.app.web.Pet.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.app.web.Pet.DAO.PetDAO;
import com.human.app.web.Pet.Model.PetModel;

@Repository
public class PetDAOImpl implements PetDAO{

	@Autowired
    private SqlSessionTemplate sqlSession; //SqlSessionTemplate은 sqlSession 구현 코드를 대체하는 역할.
	
	@Override
	public List<PetModel> Animal(PetModel model) {
		return sqlSession.selectList("mapper.PetMapper.Animal");
	}

}

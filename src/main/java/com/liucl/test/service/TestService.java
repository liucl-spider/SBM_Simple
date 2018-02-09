package com.liucl.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liucl.test.dao.ActcompanyMapper;
import com.liucl.test.domain.Actcompany;

@Service
public class TestService {
	@Autowired
	private ActcompanyMapper mapper;
	
	@Transactional
	public void getData(){
		mapper.selectByPrimaryKey(1);
		Actcompany record = new Actcompany();
		record.setCompanyID(3);
		mapper.insert(record);
		
		Actcompany record2 = new Actcompany();
		record2.setCompanyID(4);
		mapper.insert(record2);
		
		throw new RuntimeException();
	}
}

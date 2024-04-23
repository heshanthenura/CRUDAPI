package com.heshanthenura.crudapi;

import com.heshanthenura.crudapi.database.DBServices;
import com.heshanthenura.crudapi.database.PersonEntity;
import com.heshanthenura.crudapi.database.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class CrudapiApplicationTests {

	@Autowired
	DBServices  dbServices;

	Logger logger = Logger.getLogger("info");

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUsers(){
		for(PersonEntity p: dbServices.getAllPeople()){
			logger.info(p.toString());
		}
	}

	@Test
	void getUserByID(){
		dbServices.getPersonById(20L);
	}

}

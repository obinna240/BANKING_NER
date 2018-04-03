package com.object.repositories;

import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.WriteResult;
import com.object.DBDoc;


public class DBDocDAOImpl implements Repository<DBDoc>
{

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	public List<DBDoc> getAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}


	public void saveObject(DBDoc object) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(object);
	}

	
	public DBDoc getObject(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public WriteResult updateObject(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteObject(String id) {
		// TODO Auto-generated method stub
		
	}

	public void createCollection() {
		if (!mongoTemplate.collectionExists(DBDoc.class)) {
			mongoTemplate.createCollection(DBDoc.class);
		}
	}


	public void dropCollection()
	{
		if (mongoTemplate.collectionExists(DBDoc.class))
		{
			mongoTemplate.dropCollection(DBDoc.class);
		}
	}
	
	
}
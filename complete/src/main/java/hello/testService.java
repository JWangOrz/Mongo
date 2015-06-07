package hello;

import java.util.List;
import java.util.UUID;
import hello.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class testService 
{	     
	    @Autowired
	    private MongoTemplate mongoTemplate;
	     
	    public static final String COLLECTION_NAME = "visitor";
	     
	    public void addVisitor(Test visitor) 
	    {
	        if (!mongoTemplate.collectionExists(Test.class)) 
	        {
	            mongoTemplate.createCollection(Test.class);
	        }       
	        visitor.setId(UUID.randomUUID().toString());
	        mongoTemplate.insert(visitor, COLLECTION_NAME);
	    }
	     
	    public List<Test> listVisitor() {
	        return mongoTemplate.findAll(Test.class, COLLECTION_NAME);
	    }
	     
	    public void deletePerson(Test visitor) {
	        mongoTemplate.remove(visitor, COLLECTION_NAME);
	    }
	     
	    public void updatePerson(Test visitor) {
	        mongoTemplate.insert(visitor, COLLECTION_NAME);      
	    }
	
}

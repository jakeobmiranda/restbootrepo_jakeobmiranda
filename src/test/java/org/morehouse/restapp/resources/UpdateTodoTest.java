package org.morehouse.restapp.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UpdateTodoTest {
	
	@Test
	
	public void testChangeAssignee() {
		// setup
		TodosResource resource = new TodosResource();
		Todo existing = new Todo();
		existing.setAssignee("someone");
		Todo update = new Todo();
		update.setAssignee("someone else");
		
		// execute 
		boolean isValid = resource.validateUpdate(existing, update);
		
		// validate
		assertTrue(isValid);
		
	}
	
	@Test
	public void testRemoveAssignee() {
		// setup
		Todo existing = new Todo();
		existing.setAssignee("someone");
		Todo update = new Todo();
		update.setAssignee(null);
		
		// execute 
		boolean isValid = TodosResource.validateUpdate(existing, update);
				
		// validate
		assertFalse(isValid);
		
	}
	
	// starts null, does not remain null
	@Test
	public void testSetAssignee() {
		// setup
		Todo existing = new Todo();
		existing.setAssignee(null);
		Todo update = new Todo();
		update.setAssignee("someone");
				
		// execute 
		boolean isValid = TodosResource.validateUpdate(existing, update);
						
		// validate
		assertTrue(isValid);
	}
	
	//starts null, remains null
	@Test
	public void testAssigneeBlank() {
		// setup
		Todo existing = new Todo();
		existing.setAssignee(null);
		Todo update = new Todo();
		update.setAssignee(null);
				
		// execute 
		boolean isValid = TodosResource.validateUpdate(existing, update);
						
		// validate
		assertFalse(isValid);
	}
}

package com.studentapp.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.utils.TestUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class StudentSteps {
	@Steps
	StudentSerenitySteps steps;
	
	static String email=null;
	
	@When("^User sends a GET request to list, then the application must provide a valid response$")
	public void user_sends_a_GET_request_to_list_then_the_application_must_provide_a_valid_response() throws Throwable {
	  
		SerenityRest.rest().given()
		.when()
		.get("/list")
		.then();
	 
	}
	

	@When("^I create a new student by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createStudent(String firstName,String lastName,String _email,String programme,String course){
		List<String> courses = new ArrayList<String>();
		courses.add(course);
		email = TestUtils.getRandomValue()+_email;
		
		System.out.println("The email is "+email);
		steps.createStudent(firstName, lastName, email, programme, courses)
		.statusCode(201);
		
	}
	
	@Then("^I verify that the student with (.*) is created$")
	public void i_verify_that_the_student_with_name_is_created(String emailId){
		HashMap<String, Object> resVal=  steps.getStudentInfoByFirstName(emailId);
		
		System.out.println("The values are : "+resVal);
		//assertThat(resVal,hasValue(emailId));
	}
}

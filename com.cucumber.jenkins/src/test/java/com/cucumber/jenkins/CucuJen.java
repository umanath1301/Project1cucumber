package com.cucumber.jenkins;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CucuJen {

@Given("^print name$")
public void print_name() throws Throwable {
   System.out.println("Name is :: S.UMANATH");
}

@Then("^print age$")
public void print_age() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Age is :: 25");
}

@Then("^print favoritr$")
public void print_favoritr() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 System.out.println("Favourite player is :: MSDHONI");
}


}

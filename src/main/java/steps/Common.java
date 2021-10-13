package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Driver;

public class Common extends Driver {

    @Before
    public void start(){initDriver();}

    @After
    public void kill(){teardown();}

    @Given("I navigate to {}")
    public void navigate(String url){driver.get("https://"+url);}

    @Then("I wait for {} seconds")
    public void waitFor(int duration){
        try {Thread.sleep(duration*1000L);}
        catch (InterruptedException e) {e.printStackTrace();}
    }

}

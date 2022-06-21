package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import com.edsoft.framework.base.api.RestAssuredExtension;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;


public class GetPostSteps2 {

	public static ResponseOptions<Response> response;
	public static String token;
	

    public static void main(String [] args) {
		

		response = RestAssuredExtension.GetOps("https://webservice.toscacloud.com/training/swagger/docs/v1");
		//	Posts posts = response.getBody().as(Posts.class);
		// assertThat(posts.getAuthor(), equalTo(authorName));
		
		System.out.println(response.getBody());
       assertThat(response.getBody().jsonPath().get("operationId"), hasItem("Coffees_GetById"));
	}

	
}


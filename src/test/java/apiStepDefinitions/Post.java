package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.Util;

public class Post {

	private DataManager dataManager = DataManager.getInstance();

	@Then("[API] user can create a post")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String uniqueContent = data.get("content") + Util.get6DigitCode();
		pojo.Post post = BoraAPI.createPost(dataManager.getToken(), uniqueContent);
		assertEquals(uniqueContent, post.text);
	}

	@Given("[API] user can create a post with random content")
	public void api_user_can_create_a_post_with_random_content() {
		String content = Util.get6DigitCode() + "";
		pojo.Post post = BoraAPI.createPost(dataManager.getToken(), content);
		assertEquals(content, post.text);
		dataManager.setPostContent(content);
	}

	@Then("[API] user can validate that the post they created previously is not there")
	public void api_user_can_validate_that_the_post_they_created_previously_is_not_there() {
		List<pojo.Post> posts = BoraAPI.getAllPosts(dataManager.getToken());
		String expectedPostContent = dataManager.getPostContent();
		String userId = dataManager.getUser()._id;
		boolean found = false;
		for (pojo.Post post : posts) {
			if (post.text.equals(expectedPostContent) && post.user.equals(userId)) {
				found = true;
				break;
			}
		}
		assertFalse(found, "The damn post is still there");
	}

}

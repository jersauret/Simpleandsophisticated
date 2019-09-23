//package fr.projet.controller.test;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.hamcrest.core.Is;
//import org.hamcrest.core.IsNull;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//
//public class UserIntegrationTest extends IntegrationTest {
//
//	@Test
//	public void getApiUsersTest() throws Exception {
//		mockMvc.perform(get("/api/users")
//				.accept(MediaType.APPLICATION_JSON_UTF8))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//			.andExpect(jsonPath("$[0].id", Is.is(4)))
//			.andExpect(jsonPath("$[1].id", Is.is(6)));
//	}
//	
//	@Test
//	public void postApiUsersTest_ShouldReturnCode201() throws Exception {
//		mockMvc.perform(post("/api/users")
//				.contentType(MediaType.APPLICATION_JSON_UTF8)
//				.accept(MediaType.APPLICATION_JSON_UTF8)
//				.content("{"
//						+ "    \"login\": \"abdel\","
//						+ "    \"name\": \"abdel\","
//						+ "    \"password\": \"abdel\""
//						+ "}"))
//			.andDo(print())
//			.andExpect(status().isCreated())
//			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//			.andExpect(jsonPath("$.id", IsNull.notNullValue()));
//	}
//	
//	@Test
//	public void postApiUsersTest_ShouldReturnCode5xx() throws Exception {
//		mockMvc.perform(post("/api/users")
//				.contentType(MediaType.APPLICATION_JSON_UTF8)
//				.accept(MediaType.APPLICATION_JSON_UTF8)
//				.content("{"
//						+ "    \"id\": 12,"
//						+ "    \"login\": \"abdel\","
//						+ "    \"name\": \"abdel\","
//						+ "    \"password\": \"abdel\""
//						+ "}"))
//			.andDo(print())
//			.andExpect(status().isBadRequest());
//	}
//
//}

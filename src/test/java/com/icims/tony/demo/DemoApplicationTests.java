package com.icims.tony.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateClass() throws Exception {
		JSONObject newClassJson = new JSONObject();
		newClassJson.put("subject", "Science");
		newClassJson.put("room", "101A");
		
		// Create a new class object
		MvcResult postResult = mockMvc.perform(post("/school/1/class").content(newClassJson.toString())).andDo(print())
			    .andExpect(status().isOk())
				.andExpect(jsonPath("$.subject").value("Science"))
				.andExpect(jsonPath("$.room").value("101A"))
				.andExpect(jsonPath("$.schoolId").value(1))
				.andExpect(jsonPath("$.classId").isNotEmpty()).andReturn();
		int classId = new JSONObject(postResult.getResponse().getContentAsString()).getInt("classId");
		
		mockMvc.perform(get("/school/1/class" + classId)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.subject").value("Science"))
				.andExpect(jsonPath("$.room").value("101A"))
				.andExpect(jsonPath("$.schoolId").value(1))
				.andExpect(jsonPath("$.classId").value(1)).andReturn();
		
		JSONObject updatedClassJson = new JSONObject();
		updatedClassJson.put("subject", "Math");
		updatedClassJson.put("room", "102B");

		// Update the existing class object
		mockMvc.perform(put("/school/1/class" + classId).content(newClassJson.toString())).andDo(print())
			    .andExpect(status().isOk())
				.andExpect(jsonPath("$.subject").value("Math"))
				.andExpect(jsonPath("$.room").value("102B"))
				.andExpect(jsonPath("$.schoolId").value(1))
				.andExpect(jsonPath("$.classId").value(1)).andReturn();
		
		mockMvc.perform(get("/school/1/class" + classId)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.subject").value("Math"))
				.andExpect(jsonPath("$.room").value("102B"))
				.andExpect(jsonPath("$.schoolId").value(1))
				.andExpect(jsonPath("$.classId").value(1)).andReturn();

		// Remove the existing class object
		mockMvc.perform(delete("/school/1/class" + classId)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		// If your bold, have the api return 404 when there is no class in the database
		// mockMvc.perform(get("/school/1/class" + classId)).andDo(print())
		//	.andExpect(status().isNotFound()).andReturn();
	}

}

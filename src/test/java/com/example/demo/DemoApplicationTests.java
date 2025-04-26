package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
// @AutoConfigureMockMvc
class DemoApplicationTests {

	// @Autowired
	// private MockMvc mockMvc;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	// @Test
	// void contextLoads() {
	// }

	// @Test
	// void endpointWhenUserAuthorityThenAuthorized() throws Exception {
	// 	this.mockMvc.perform(get("/")).andExpect(status().isOk());

	// }

	// @Test
	// public void loginUser() throws Exception {
	// 	// @formatter:off
	// 	this.mockMvc.perform(formLogin().user("admin").password("1234"))
	// 			.andExpect(authenticated());
	// 	// @formatter:on
	// }

	// @Test
	// public void addUser(){
	// 	User user = new User("kambing",passwordEncoder.encode("1234"));
	// 	userRepository.save(user);

	// }


}

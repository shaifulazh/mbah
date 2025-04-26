package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
// @AutoConfigureMockMvc
class DemoApplicationTests {

	// @Autowired
	// private MockMvc mockMvc;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	MobileRepository mobileRepository;

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

	@Test
	public void addUser(){
		User user = new User("kambing",passwordEncoder.encode("1234"));
		userRepository.save(user);

		Mobile mobile = new Mobile("iphone", passwordEncoder.encode("1234"));
		mobileRepository.save(mobile);
	}


}

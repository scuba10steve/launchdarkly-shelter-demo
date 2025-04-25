package com.shelter.launchdarklyshelterdemo;

import com.shelter.launchdarklyshelterdemo.policy.LocalPolicyService;
import com.shelter.launchdarklyshelterdemo.policy.Policy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LocalPolicyService policyService;

	@Test
    void policiesReturned() throws Exception {
		List<Policy> examplePolicies = List.of(
				new Policy("Steven"),
				new Policy("Emmy"),
				new Policy("Travis")
		);
		Mockito.when(policyService.findAll()).thenReturn(examplePolicies);

		mockMvc.perform(get("/policies"))
				.andExpect(status().isOk());
    }
}

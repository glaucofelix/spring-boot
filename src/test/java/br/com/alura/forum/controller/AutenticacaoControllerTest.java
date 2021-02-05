package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest // carrega tudo
@AutoConfigureMockMvc // para poder carregar o MockMvc
//@WebMvcTest //para testar controler so carrega coisad o mvc, mas no caso como vamos usar repository, vamos carregar tudo com o @SpringBootTest
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"xxxxx@email.com\",\"senha\":\"123456\"}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).
				content(json).
				contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status()
						.is(400));

	}

}

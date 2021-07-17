package es.cic.bootcamp.ejercicio007.coche;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class CocheControllerIntegracionTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private CocheController cocheController;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	
	@Test
	void testEncender() throws Exception {
		try {
			int potencia=cocheController.encender();
			mvc.perform(get("/encender"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().string(String.valueOf(potencia)));
		} catch (CocheException e) {
			mvc.perform(get("/encender"))
			   .andDo(print())
			   .andExpect(status().is5xxServerError());
		}		
	}

}

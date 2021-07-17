package es.cic.bootcamp.ejercicio007.coche;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CocheControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEncender() {
		try {
			mvc.perform(get("/encender"))
				.andExpect(status().is5xxServerError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

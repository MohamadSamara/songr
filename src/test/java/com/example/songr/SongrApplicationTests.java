package com.example.songr;

import com.example.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {
	@Test
	public void testAlbumConstructorAndGetters() {

		Album album = new Album("Test Album", "Test Artist", 10, 100, "test.png");

		assertEquals("Test Album", album.getTitle());
		assertEquals("Test Artist", album.getArtist());
		assertEquals(10, album.getSongCount());
		assertEquals(100, album.getLength());
		assertEquals("test.png", album.getImageUrl());
	}

	@Test
	public void testAlbumSetters() {

		Album album = new Album("Initial Title", "Initial Artist", 5, 500, "initial.png");

		album.setTitle("New Title");
		album.setArtist("New Artist");
		album.setSongCount(2);
		album.setLength(200);
		album.setImageUrl("new.png");

		assertEquals("New Title", album.getTitle());
		assertEquals("New Artist", album.getArtist());
		assertEquals(2, album.getSongCount());
		assertEquals(200, album.getLength());
		assertEquals("new.png", album.getImageUrl());
	}

	@Autowired
	MockMvc mockMvc;
	@Test
	public void TestHelloRoute() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("<h1>hello</h1>")));
	}

}

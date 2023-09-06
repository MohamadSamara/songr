package com.example.songr;

import com.example.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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

}

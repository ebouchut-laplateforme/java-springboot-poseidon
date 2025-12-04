package com.nnk.springboot;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RatingTests {

	@Autowired
	private RatingRepository ratingRepository;

	@Test
	public void ratingTest() {
		Rating rating = new Rating();
		rating.setMoodysRating("Moodys Rating");
		rating.setSandPRating("Sand PRating");
		rating.setFitchRating("Fitch Rating");
		rating.setOrderNumber(10);

		// ~~~~ Save
		rating = ratingRepository.save(rating);

		assertNotNull(rating.getId());
		assertEquals(10, rating.getOrderNumber());

		// ~~~~ Update
		rating.setOrderNumber(20);
		rating = ratingRepository.save(rating);

		assertEquals(20, rating.getOrderNumber());

		// ~~~~ Find
		List<Rating> allRatings = ratingRepository.findAll();

		assertFalse(allRatings.isEmpty());

		// ~~~~ Delete
		Integer id = rating.getId();
		ratingRepository.delete(rating);

		Optional<Rating> maybeRating = ratingRepository.findById(id);
		assertFalse(maybeRating.isPresent());
	}
}

package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BidTests {

	@Autowired
	private BidListRepository bidListRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	@WithMockUser(username = "joe")
	public void bidListTest() {
		BidList bid = BidList.builder()
				.account("Account Test")
				.type("Type Test")
				.bidQuantity(10D)
				.build();

		// ~~~~ Save
		BidList savedBidList = bidListRepository.saveAndFlush(bid);

		assertNotNull(savedBidList.getBidListId());
		assertEquals(10D, savedBidList.getBidQuantity());
		assertEquals("Type Test", savedBidList.getType());

		// Invalidate the in-memory entity cache
		// to ensure upcoming find.* method call will read from the database
		entityManager.clear();

		BidList foundBidList = bidListRepository
				.findById(savedBidList.getBidListId())
				.orElseThrow(() -> new IllegalArgumentException("Cannot find the BidList in DB"));

		assertEquals(10D, foundBidList.getBidQuantity());
		assertEquals("Type Test", foundBidList.getType());

		// ~~~~ Update
		bid.setBidQuantity(20D);
		bid = bidListRepository.save(bid);

		assertEquals(20D, bid.getBidQuantity());

		// ~~~~ Find
		List<BidList> listResult = bidListRepository.findAll();

		assertFalse(listResult.isEmpty());

		// ~~~~ Delete
		Integer id = bid.getBidListId();
		bidListRepository.delete(bid);

		Optional<BidList> bidList = bidListRepository.findById(id);
		assertFalse(bidList.isPresent());
	}
}

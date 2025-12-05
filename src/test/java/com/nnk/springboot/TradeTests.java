package com.nnk.springboot;

import com.nnk.springboot.config.JpaAuditingConfiguration;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	@WithMockUser(username = "jack")
	public void tradeTest() {
		Trade trade = Trade.builder()
				.account("Trade Account")
				.type("Type")
				.build();

		// ~~~~~~~~ Save
		Trade savedTrade = tradeRepository.saveAndFlush(trade);

		// Test the cached trade
		assertNotNull(savedTrade.getTradeId());
		assertEquals("Trade Account", savedTrade.getAccount());

		// Invalidate the entity in-memory cache
		// to ensure upcoming find.* will really read from database
		entityManager.clear();

		// Read the trade from the database (not from the cache)
		Trade foundTrade = tradeRepository
                .findById(savedTrade.getTradeId())
                .orElseThrow(() -> new IllegalArgumentException("Inserted Trade not found in DB"));

        assertEquals("Trade Account", foundTrade.getAccount());

		// ~~~~~~~~ Update
		trade.setAccount("Trade Account Update");
		trade = tradeRepository.save(trade);

		assertEquals("Trade Account Update", trade.getAccount());

		// ~~~~~~~~ Find
		List<Trade> listResult = tradeRepository.findAll();

		assertFalse(listResult.isEmpty());

		// ~~~~~~~~ Delete
		Integer id = trade.getTradeId();
		tradeRepository.delete(trade);

		Optional<Trade> tradeList = tradeRepository.findById(id);
		assertFalse(tradeList.isPresent());
	}
}

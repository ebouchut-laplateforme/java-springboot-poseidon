package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	@Test
	public void tradeTest() {
		Trade trade = Trade.builder()
				.account("Trade Account")
				.type("Type")
				.build();

		// ~~~~~~~~ Save
		trade = tradeRepository.save(trade);

		assertNotNull(trade.getTradeId());
        assertEquals("Trade Account", trade.getAccount());

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

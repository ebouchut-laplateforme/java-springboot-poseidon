package com.nnk.springboot;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RuleTests {

	@Autowired
	private RuleNameRepository ruleNameRepository;

	@Test
	public void ruleTest() {
		RuleName rule = RuleName.builder()
				.name("Rule Name")
				.description("Description")
				.json("Json")
				.template("Template")
				.sqlStr("SQL")
				.sqlPart("SQL Part")
				.build();

		// ~~~~~~~~ Save
		rule = ruleNameRepository.save(rule);

		assertNotNull(rule.getId());
		assertEquals("Rule Name", rule.getName());

		//  ~~~~~~~~ Update
		rule.setName("Rule Name Update");
		rule = ruleNameRepository.save(rule);

		assertEquals("Rule Name Update", rule.getName());

		//  ~~~~~~~~ Find
		List<RuleName> listResult = ruleNameRepository.findAll();

		assertFalse(listResult.isEmpty());

		//  ~~~~~~~~ Delete
		Integer id = rule.getId();
		ruleNameRepository.delete(rule);

		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
		assertFalse(ruleList.isPresent());
	}
}

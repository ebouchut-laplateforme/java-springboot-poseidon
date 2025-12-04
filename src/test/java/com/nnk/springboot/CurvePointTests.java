package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO: Move to com.nnk.springboot.repositories
 * TODO: Mock me
 *
 */
@SpringBootTest
public class CurvePointTests {

	@Autowired
	private CurvePointRepository curvePointRepository;

	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = CurvePoint.builder()
				.curveId(10)
				.term(10D)
				.value(30D)
				.build();

		// Save
		curvePoint = curvePointRepository.save(curvePoint);

		assertNotNull(curvePoint.getId());
		assertEquals(10, curvePoint.getCurveId());


		// Update
		curvePoint.setCurveId(20);
		curvePoint = curvePointRepository.save(curvePoint);

		assertEquals(20, curvePoint.getCurveId());


		// Find
		List<CurvePoint> listResult = curvePointRepository.findAll();

		assertFalse(listResult.isEmpty());


		// Delete
		Integer id = curvePoint.getId();
		curvePointRepository.delete(curvePoint);

		Optional<CurvePoint> maybeCurvePoint = curvePointRepository.findById(id);
		assertFalse(maybeCurvePoint.isPresent());
	}
}

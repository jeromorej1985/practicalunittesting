package com.manors.parkview.practicalunittesting.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.manors.parkview.practicalunittesting.model.Discount;
import com.opencsv.bean.CsvToBeanBuilder;

public class DiscountCalculator {
	private List<Discount> discounts;
	private static final String FILENAME = "financial.csv";

	@SuppressWarnings("unchecked")
	public DiscountCalculator() throws IllegalStateException, FileNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		discounts = new CsvToBeanBuilder(new FileReader(classLoader.getResource(FILENAME).getFile()))
				.withType(Discount.class).build().parse();
	}

	public double calculateDiscount(double value) {
		Optional<Discount> result = discounts.stream()
			.filter(discount -> discount.getValue() == value)
			.findFirst();

		if (result.isPresent()){
			return result.get().getDiscount();
		} else {
			throw new NoSuchElementException();
		}
	}	

}

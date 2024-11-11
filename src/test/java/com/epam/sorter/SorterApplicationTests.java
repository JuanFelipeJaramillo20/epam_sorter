package com.epam.sorter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(Parameterized.class)
class SorterApplicationTests {

	private final String[] input;
	private final String expectedOutput;

	public SortingAppTest(String[] input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testCases() {
		return Arrays.asList(new Object[][]{
				{new String[]{}, "Please provide between 1 and 10 integer arguments.\n"},
				{new String[]{"5"}, "Sorted numbers: [5]\n"},
				{new String[]{"10", "2", "3"}, "Sorted numbers: [2, 3, 10]\n"},
				{new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}, "Please provide between 1 and 10 integer arguments.\n"},
				{new String[]{"a", "b", "c"}, "All arguments must be integers.\n"}
		});
	}

	@Test
	public void testSortingApp() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		SortingApp.main(input);
		assertEquals(expectedOutput, outputStream.toString());
	}

}

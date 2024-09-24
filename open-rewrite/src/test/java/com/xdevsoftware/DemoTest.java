package com.xdevsoftware;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * Testcode from:
 * https://docs.openrewrite.org/running-recipes/popular-recipe-guides/migrate-from-junit-4-to-junit-5
 */

public class DemoTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Before
	public void before() {
	}

	@AfterClass
	public static void afterClass() {
	}

	@Test(expected = RuntimeException.class)
	public void foo() throws IOException {
		File tempFile = folder.newFile();
		File tempFile2 = folder.newFile("filename");
		File tempDir = folder.getRoot();
		File tempDir2 = folder.newFolder("parent", "child");
		File tempDir3 = folder.newFolder("subdir");
		File tempDir4 = folder.newFolder();
		String foo = "foo";
		throw new RuntimeException(foo);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void foo2() {
		int arr = new int[] {}[0];
	}

	@Rule
	public ExpectedException throwz = ExpectedException.none();

	@Test
	public void foo3() {
		throwz.expect(RuntimeException.class);
		throw new RuntimeException();
	}

	@Test
	public void assertsStuff() {
		Assert.assertEquals("One is one", 1, 1);
		Assert.assertArrayEquals("Empty is empty", new int[] {}, new int[] {});
		Assert.assertNotEquals("one is not two", 1, 2);
		Assert.assertFalse("false is false", false);
		Assert.assertTrue("true is true", true);
		Assert.assertEquals("foo is foo", "foo", "foo");
		Assert.assertNull("null is null", null);

	}

	@Test(timeout = 500)
	public void bar() {
	}
}

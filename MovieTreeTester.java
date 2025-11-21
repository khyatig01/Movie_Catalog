import java.util.ArrayList;
import java.util.NoSuchElementException;

/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Movie Catalog
// Course: CS 300 Spring 2021
//
// Author: Khyati Gupta
// Email: kgupta44@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class checks the correctness of the implementation of the methods
 * defined in the class MovieTree.
 *
 */

public class MovieTreeTester {

	/**
	 * Checks the correctness of the implementation of both addMovie() and
	 * toString() methods implemented in the MovieTree class. This unit test
	 * considers at least the following scenarios. (1) Create a new empty MovieTree,
	 * and check that its size is 0, it is empty, and that its string representation
	 * is an empty string "". (2) try adding one movie and then check that the
	 * addMovie() method call returns true, the tree is not empty, its size is 1,
	 * and the .toString() called on the tree returns the expected output. (3) Try
	 * adding another movie which is smaller that the movie at the root, (4) Try
	 * adding a third movie which is greater than the one at the root, (5) Try
	 * adding at least two further movies such that one must be added at the left
	 * subtree, and the other at the right subtree. For all the above scenarios, and
	 * more, double check each time that size() method returns the expected value,
	 * the add method call returns true, and that the .toString() method returns the
	 * expected string representation of the contents of the binary search tree in
	 * an increasing order from the smallest to the greatest movie with respect to
	 * year, rating, and then name. (6) Try adding a movie already stored in the
	 * tree. Make sure that the addMovie() method call returned false, and that the
	 * size of the tree did not change.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testAddMovieToStringSize() {

		System.out.println("Running testAddMovieToStringSize()");

		MovieTree movieTree = null;
		Movie movie1 = new Movie(2016, 7.4, "Moonlight");
		Movie movie2 = new Movie(2010, 8.8, "Inception");
		Movie movie3 = new Movie(1995, 6.8, "Clueless");
		Movie movie4 = new Movie(2014, 8.5, "Whiplash");
		Movie movie5 = new Movie(2016, 8.4, "Interstellar");
		Movie movie6 = new Movie(2017, 8.4, "Dunkirk");
		String expectedString = null;

		// TEST 1 - When the tree is empty.
		try {

			movieTree = new MovieTree();

			if (movieTree.size() != 0) {
				System.out.println("  Test 1 failed. Size is not 0 by default.");
				return false;
			}

			if (!movieTree.isEmpty()) {
				System.out.println("  Test 1 failed. movieTree.isEmpty() does not return true for an empty tree.");
				return false;
			}

			expectedString = "";

			if (!movieTree.toString().equals(expectedString)) {
				System.out.println("  Test 1 failed. String representation returned " + movieTree.toString()
						+ "  instead of an empty string.");
				return false;
			}

		} catch (Exception e) {
			System.out.println("  Test 1 failed. Unexpected exception thrown - " + e.getMessage() + ".");
			e.printStackTrace();
			return false;
		}

		// TEST 2 - adding movies
		{
			movieTree = new MovieTree();

			// TEST 2.1 - adding one movie. Tests addMovie(), size(), isEmpty(),
			// toString().
			try {

				if (!movieTree.addMovie(movie1)) {
					System.out.println(
							"  Test 2.1 failed. MovieTree.addMovie() does not return true after adding a movie to an empty tree.");
					return false;
				}

				if (movieTree.size() != 1) {
					System.out.println("  Test 2.1 failed. Size is not 1 after adding a movie to an empty tree.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.1 failed. MovieTree.isEmpty() does not return false after adding a movie to an empty tree.");
					return false;
				}

				expectedString = "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.1 failed. String representation returned " + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.1 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.2 - adding an older movie. Tests addMovie(), size(), isEmpty(),
			// toString().
			try {

				if (!movieTree.addMovie(movie2)) {
					System.out.println(
							"  Test 2.2 failed.  MovieTree.addMovie() does not return true after adding a second movie.");
					return false;
				}

				if (movieTree.size() != 2) {
					System.out.println("  Test 2.2 failed. Size is not 2 after adding a second movie.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.2 failed.  MovieTree.isEmpty() does not return false after adding a second movie.");
					return false;
				}

				expectedString = "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.2 failed. String representation returned\n" + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.2 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.3 - adding oldest movie. Tests addMovie(), size(), isEmpty(),
			// toString().
			try {

				if (!movieTree.addMovie(movie3)) {
					System.out.println(
							"  Test 2.3 failed. MovieTree.addMovie() does not return true after adding a third movie.");
					return false;
				}

				if (movieTree.size() != 3) {
					System.out.println("  Test 2.3 failed. Size is not 3 after adding a third movie.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.3 failed.  MovieTree.isEmpty() does not return false after adding a third movie.");
					return false;
				}

				expectedString = "[(Year: 1995) (Rate: 6.8) (Name: Clueless)]" + "\n"
						+ "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.3 failed. String representation returned\n" + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.3 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.4 - adding movie in left subtree. Tests addMovie(), size(),
			// isEmpty(), toString().
			try {

				if (!movieTree.addMovie(movie4)) {
					System.out.println(
							"  Test 2.4 failed. MovieTree.addMovie() does not return true after adding a fourth movie.");
					return false;
				}

				if (movieTree.size() != 4) {
					System.out.println("  Test 2.4 failed. Size is not 4 after adding a fourth movie.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.4 failed. MovieTree.isEmpty() does not return false after adding a fourth movie.");
					return false;
				}

				expectedString = "[(Year: 1995) (Rate: 6.8) (Name: Clueless)]" + "\n"
						+ "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2014) (Rate: 8.5) (Name: Whiplash)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.4 failed. String representation returned\n" + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.4 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.5 - adding a movie in right subtree. Tests addMovie(), size(),
			// isEmpty(), toString().
			try {

				if (!movieTree.addMovie(movie5)) {
					System.out.println(
							"  Test 2.5 failed.  MovieTree.addMovie() does not return true after adding a fifth movie.");
					return false;
				}

				if (movieTree.size() != 5) {
					System.out.println("  Test 2.5 failed. Size is not 5 after adding a fifth movie.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.5 failed. MovieTree.isEmpty() does not return false after adding a fifth movie.");
					return false;
				}

				expectedString = "[(Year: 1995) (Rate: 6.8) (Name: Clueless)]" + "\n"
						+ "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2014) (Rate: 8.5) (Name: Whiplash)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n"
						+ "[(Year: 2016) (Rate: 8.4) (Name: Interstellar)]" + "\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.5 failed. String representation returned\n" + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.5 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.6 - adding best movie in right subtree. Tests addMovie(), size(),
			// isEmpty(), toString().
			try {

				if (!movieTree.addMovie(movie6)) {
					System.out.println(
							"  Test 2.6 failed.  MovieTree.addMovie() does not return true after adding a sixth movie.");
					return false;
				}

				if (movieTree.size() != 6) {
					System.out.println("  Test 2.6 failed. Size is not 5 after adding a sixth movie.");
					return false;
				}

				if (movieTree.isEmpty()) {
					System.out.println(
							"  Test 2.6 failed. MovieTree.isEmpty() does not return false after adding a sixth movie.");
					return false;
				}

				expectedString = "[(Year: 1995) (Rate: 6.8) (Name: Clueless)]" + "\n"
						+ "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2014) (Rate: 8.5) (Name: Whiplash)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n"
						+ "[(Year: 2016) (Rate: 8.4) (Name: Interstellar)]" + "\n"
						+ "[(Year: 2017) (Rate: 8.4) (Name: Dunkirk)]" + "\n";

				if (!movieTree.toString().equals(expectedString)) {
					System.out.println("  Test 2.6 failed. String representation returned\n" + movieTree.toString()
							+ "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.6 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

			// TEST 2.7 - adding a movie with a repeated key field. Tests addMovie(),
			// size(), toString().
			try {

				if (movieTree.addMovie(movie6)) {
					System.out.println(
							"  Test 2.7 failed. MovieTree.addMovie() does not return false after adding a movie with a repeated key field.");
					return false;
				}

				if (movieTree.size() != 6) {
					System.out.println(
							"  Test 2.7 failed. Size has changed after adding a movie with a repeated key field.");
					return false;
				}

				expectedString = "[(Year: 1995) (Rate: 6.8) (Name: Clueless)]" + "\n"
						+ "[(Year: 2010) (Rate: 8.8) (Name: Inception)]" + "\n"
						+ "[(Year: 2014) (Rate: 8.5) (Name: Whiplash)]" + "\n"
						+ "[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]" + "\n"
						+ "[(Year: 2016) (Rate: 8.4) (Name: Interstellar)]" + "\n"
						+ "[(Year: 2017) (Rate: 8.4) (Name: Dunkirk)]" + "\n";
				if (!movieTree.toString().equals(expectedString)) {
					System.out.println(
							"  Test 2.7 failed. After adding a movie with a repeated key field, string representation returned\n"
									+ movieTree.toString() + "  instead of\n" + expectedString + ".");
					return false;
				}

			} catch (Exception e) {
				System.out.println("  Test 2.7 failed. Unexpected exception thrown - " + e.getMessage() + ".");
				e.printStackTrace();
				return false;
			}

		}

		System.out.println("  testAddMovieToStringSize() passed.\n");
		return true;
	}

	/**
	 * This method checks mainly for the correctness of the MovieTree.contains()
	 * method. It must consider at least the following test scenarios. (1) Create a
	 * new MovieTree. Then, check that calling the contains() method on an empty
	 * MovieTree returns false. (2) Consider a MovieTree of height 3 which contains
	 * at least 5 movies. Then, try to call contains() method to search for the
	 * movie having a match at the root of the tree. (3) Then, search for a movie at
	 * the right and left subtrees at different levels considering successful and
	 * unsuccessful search operations. Make sure that the contains() method returns
	 * the expected output for every method call.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testContains() {

		System.out.println("Running testContains()");

		MovieTree movieTree = new MovieTree();
		Movie movie1 = new Movie(2016, 7.4, "Moonlight");
		Movie movie2 = new Movie(2010, 8.8, "Inception");
		Movie movie3 = new Movie(1995, 6.8, "Clueless");
		Movie movie4 = new Movie(2014, 8.5, "Whiplash");
		Movie movie5 = new Movie(2016, 8.4, "Interstellar");
		Movie movie6 = new Movie(2017, 8.4, "Dunkirk");

		// TEST 1 - Calling the contains() method on an empty tree.
		if (movieTree.contains(2016, 7.4, "Moonlight")) {
			System.out.println(
					" Test 1 failed. Tree is empty and hence, element should not be contained. However, contains() reaturned true");
			return false;
		}

		movieTree.addMovie(movie1);

		// TEST 2 - Calling the contains() method on tree with one node.
		if (!movieTree.contains(2016, 7.4, "Moonlight")) {
			System.out.println(" Test 2 failed. Tree contains element. However, contains() reaturned false");
			return false;
		}

		movieTree.addMovie(movie2);
		movieTree.addMovie(movie3);
		movieTree.addMovie(movie4);
		movieTree.addMovie(movie5);
		movieTree.addMovie(movie6);

		// TEST 3 - Calling the contains() method on a tree of height 3 and at least 5
		// movies.
		if (!movieTree.contains(2014, 8.5, "Whiplash")) {
			System.out.println(" Test 3 failed. Tree contains element. However, contains() reaturned false");
			return false;
		}

		// TEST 4 - Calling the contains() method on a tree of height 3 and at least 5
		// movies.
		if (movieTree.contains(2017, 8.5, "La La Land")) {
			System.out.println(" Test 4 failed. Tree does not contain element. However, contains() reaturned true");
			return false;
		}

		System.out.println("  testContains() passed.\n");
		return true;
	}

	/**
	 * Checks for the correctness of MovieTree.height() method. This test must
	 * consider several scenarios such as, (1) ensures that the height of an empty
	 * movie tree is zero. (2) ensures that the height of a tree which consists of
	 * only one node is 1. (3) ensures that the height of a MovieTree with the
	 * following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
	 * (*)
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testHeight() {

		try {
			System.out.println("Running testHeight()");

			MovieTree movieTree = new MovieTree();
			Movie movie1 = new Movie(2016, 7.4, "Moonlight");
			Movie movie2 = new Movie(2010, 8.8, "Inception");
			Movie movie3 = new Movie(1995, 6.8, "Clueless");
			Movie movie4 = new Movie(2014, 8.5, "Whiplash");
			Movie movie5 = new Movie(2016, 8.4, "Interstellar");
			Movie movie6 = new Movie(2017, 8.4, "Dunkirk");
			Movie movie7 = new Movie(2008, 8.5, "The Dark Knight");

			// TEST 1 - Calling the height() method on an empty tree.
			if (movieTree.height() != 0) {
				System.out.println(
						" Test 1 failed. Tree is empty and hence, height should be zero. However, height calcuated is "
								+ movieTree.height());
				return false;
			}

			movieTree.addMovie(movie1);
			// TEST 2 - Calling the height() method on tree with one node.

			if (movieTree.height() != 1) {
				System.out.println(
						" Test 2 failed. Tree has one node and hence, height should be one. However, height calcuated is "
								+ movieTree.height());
				return false;
			}

			movieTree.addMovie(movie2);
			movieTree.addMovie(movie3);
			movieTree.addMovie(movie4);
			movieTree.addMovie(movie5);
			movieTree.addMovie(movie6);
			movieTree.addMovie(movie7);

			// TEST 3 - Calling the height() method on tree with multiple nodes.

			if (movieTree.height() != 4) {
				System.out.println(
						" Test 3 failed. Height should be four. However, height calcuated is " + movieTree.height());
				return false;
			}
			System.out.println("  testHeight() passed.\n");
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * Checks for the correctness of MovieTree.getBestMovie() method.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testGetBestMovie() {

		try {
			System.out.println("Running testGetBestMovie()");

			MovieTree movieTree = new MovieTree();

			Movie movie1 = new Movie(2016, 7.4, "Moonlight");
			Movie movie2 = new Movie(2010, 8.8, "Inception");
			Movie movie3 = new Movie(1995, 6.8, "Clueless");
			Movie movie4 = new Movie(2014, 8.5, "Whiplash");
			Movie movie5 = new Movie(2016, 8.4, "Interstellar");
			Movie movie6 = new Movie(2017, 8.4, "Dunkirk");
			Movie movie7 = new Movie(2008, 8.5, "The Dark Knight");

			// TEST 1 - Calling the getBestMovie() method on an empty tree.
			if (movieTree.getBestMovie() != null) {
				System.out.println(" Test 1 failed. Tree is empty and hence, best movie is null. However, calcuated is "
						+ movieTree.getBestMovie());
				return false;
			}

			movieTree.addMovie(movie1);
			// TEST 2 - Calling the getBestMovie() method on tree with one node.

			if (movieTree.getBestMovie() != movie1) {
				System.out.println(
						" Test 2 failed. Tree has one node and hence, best movie should be should be '[(Year: 2016) (Rate: 7.4) (Name: Moonlight)]'. However, best movie calcuated is "
								+ movieTree.getBestMovie());
				return false;
			}

			movieTree.addMovie(movie2);
			movieTree.addMovie(movie3);
			movieTree.addMovie(movie4);
			movieTree.addMovie(movie5);
			movieTree.addMovie(movie6);
			movieTree.addMovie(movie7);

			// TEST 3 - Calling the getBestMovie() method on tree with multiple nodes.

			if (movieTree.getBestMovie() != movie6) {
				System.out.println(
						" Test 3 failed. Best movie should be '[(Year: 2017) (Rate: 8.4) (Name: Dunkirk)]'. However, best movie calcuated is "
								+ movieTree.getBestMovie());
				return false;
			}
			System.out.println("  testGetBestMovie() Test passed.\n");
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Checks for the correctness of MovieTree.lookup() method. This test must
	 * consider at least 3 test scenarios. (1) Ensures that the MovieTree.lookup()
	 * method throws a NoSuchElementException when called on an empty tree. (2)
	 * Ensures that the MovieTree.lookup() method returns an array list which
	 * contains all the movies satisfying the search criteria of year and rating,
	 * when called on a non empty movie tree with one match, and two matches and
	 * more. Vary your search criteria such that the lookup() method must check in
	 * left and right subtrees. (3) Ensures that the MovieTree.lookup() method
	 * throws a NoSuchElementException when called on a non-empty movie tree with no
	 * search results found.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testLookup() {

		System.out.println("Running testLookup()");

		MovieTree movieTree = new MovieTree();

		ArrayList<Movie> list = new ArrayList<Movie>();

		Movie movie1 = new Movie(2016, 7.4, "Moonlight");
		Movie movie2 = new Movie(2010, 8.8, "Inception");
		Movie movie3 = new Movie(1995, 6.8, "Clueless");
		Movie movie4 = new Movie(2014, 8.5, "Whiplash");
		Movie movie5 = new Movie(2016, 8.4, "Interstellar");
		Movie movie6 = new Movie(2017, 8.4, "Dunkirk");
		Movie movie7 = new Movie(2008, 8.5, "The Dark Knight");

		int flag = 0;

		try {

			// TEST 1 - Calling the MovieTree.lookup() method on an empty tree.

			list = movieTree.lookup(2006, 7.1);
		}

		catch (NoSuchElementException e) {

			flag++;
		}

		if (flag != 1) {

			System.out.println(" Test 1 failed. Exception not caught");
			return false;
		}

		movieTree.addMovie(movie1);

		// TEST 2 - Calling the MovieTree.lookup() method on tree with one node.

		list = movieTree.lookup(2016, 7.4);

		if (list.size() != 1 || !list.contains(movie1)) {
			System.out.println(
					" Test 2 failed. Tree has one node and contains lookup movie. However, this is not returned.");
			return false;
		}

		movieTree.addMovie(movie2);
		movieTree.addMovie(movie3);
		movieTree.addMovie(movie4);
		movieTree.addMovie(movie5);
		movieTree.addMovie(movie6);
		movieTree.addMovie(movie7);

		// TEST 3 - Calling the MovieTree.lookup() method on tree with multiple nodes.

		list = movieTree.lookup(2016, 7.4);

		if (list.size() != 2 || !list.contains(movie1) || !list.contains(movie5)) {
			System.out.println(
					" Test 3 failed. Arraylist with two movies: MoonLight and Interstellar should be returned. However, this is not returned. ");
			return false;
		}
		System.out.println("  testLookup() Test passed.\n");
		return true;
	}

	/**
	 * Calls the test methods
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		testAddMovieToStringSize();
		testContains();
		testHeight();
		testGetBestMovie();
		testLookup();

	}

}
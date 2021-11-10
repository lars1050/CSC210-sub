import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList {

	static Song iggy = new Song("Nightclubbing","Iggy Pop","The Idiot",1977);
	static Song pil = new Song("Swan Lake","Public Image Ltd.","Second Edition",1980);
	static Song femmes = new Song("Add It Up","Violent Femmes","Violent Femmes",1983);

	public static void main(String[] args) {

		// Initial add() and peek() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), peek() needs to be correct to confirm song was added.
		* To test peek(), add() needs to be correct to confirm location of song.
		*/

		System.out.println("\n\nSanity check test of add, length, peek.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		List songs = new List(5);
		songs.add(iggy);
		Assert.assertEquals(1,songs.length(),"First Add (length)");
		Assert.assertEquals(iggy,songs.peek(0),"Fird Add (iggy)");
		System.out.println("\nSanity Check complete!");
		/* Once the above are confirmed to be working, the rest of the testing can proceed.
		*/

		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
	} // end main


	/* __________________________________________________________________ */
	public static void testSearches() {
		System.out.println("\n\nTesting List search methods ...");

		List songs;

		// check that search compares values (ignoring case), not references
		Song femmes2 = new Song("add IT up","violent femmes","violent femmes",1983);
		Song iggy2 = new Song("niGHtclubbing","Iggy pop","The idiot",1977);
		Song pil2 = new Song("SWAN lake","Public image Ltd.","Second edition",1980);

		Song s = new Song("a", "b", "c");

		songs = new List(5);
		songs.add(femmes);
		songs.add(iggy);
		songs.add(pil);

		System.out.println("------------testing peek()");
		Assert.assertEquals(femmes,songs.peek(0),"Peek at index 0");
		Assert.assertEquals(iggy,songs.peek(1),"Peek at index 1");
		Assert.assertEquals(pil,songs.peek(2),"Peek at index 2");
		Assert.assertEquals(null,songs.peek(3), "Peek invalid >count");
		Assert.assertEquals(null,songs.peek(5), "Peek invalid >length");
		Assert.assertEquals(null,songs.peek(-1), "Peek invalid -1");

		System.out.println("------------Testing location()");
		Assert.assertEquals(0, songs.location(femmes2), "locate first");
		Assert.assertEquals(1, songs.location(iggy2), "locate middle");
		Assert.assertEquals(2, songs.location(pil2), "locate last");
		Assert.assertEquals(-1, songs.location(s), "locate but not in list");
	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\nTesting List add methods ...");

		List tunes;

		// more songs to work with
		Song wire = new Song("Map Ref 41 Degrees", "Wire", "154", 1979);
		Song heat = new Song("A New Kind of Water","Fame" ,"Post-Punk",1981);
		Song tv = new Song("Dorian Gray","TV Personalities","Kids Love It",1981);
		Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");

		System.out.println("--------------add(Song)");
		tunes = new List(3);

		Assert.assertEquals(0,tunes.length(),"pre-add (length)");
		tunes.add(iggy);
		Assert.assertEquals(1,tunes.length(),"add first (length)");
		Assert.assertEquals(iggy,tunes.peek(0),"add first (value)");
		tunes.add(pil);
		Assert.assertEquals(2,tunes.length(),"add 2nd (length)");
		Assert.assertEquals(pil,tunes.peek(1),"add 2nd (value)");
		tunes.add(femmes);
		Assert.assertEquals(3,tunes.length(),"add to capacity (length)");
		Assert.assertEquals(femmes,tunes.peek(2),"add to capacity (value)");
		tunes.add(iggy);
		Assert.assertEquals(3,tunes.length(),"add attempt over capacity (length)");
		Assert.assertEquals(femmes,tunes.peek(2),"add attempt over capacity (value)");


		System.out.println("--------------set(Song, index)");
		tunes = new List(6);
		// †his assumes that add is working correctly!
		tunes.add(iggy);
		tunes.add(pil);
		tunes.add(femmes);
	}

	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\nTesting List remove methods ...");

		// This is assuming add, length, contains is working!

		List jams;

		Song femmes2 = new Song("add IT up","violent femmes","violent femmes",1983);
		Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");

		jams = new List(5);
		jams.add(iggy);
		jams.add(pil);
		jams.add(femmes);
		jams.add(sonic);


		System.out.println("--------------remove(Song)");
		// songs = {iggy,pil,femmes,sonic}
		Assert.assertEquals(4,jams.length(),"pre-removal (length)");

		jams.remove(pil);
		// songs = {iggy,femmes,sonic}
		Assert.assertEquals(3,jams.length(),"remove middle (length)");
		Assert.assertEquals(iggy,jams.peek(0),"remove middle (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove middle (2nd song)");
		Assert.assertEquals(sonic,jams.peek(2),"remove middle (3rd song)");

		jams.remove(sonic);
		// songs = {iggy,femmes}
		Assert.assertEquals(2,jams.length(),"remove at end (length)");
		Assert.assertEquals(iggy,jams.peek(0),"remove at end (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove at end (2nd song)");

		jams.remove(iggy);
		// songs = {femmes}
		Assert.assertEquals(1,jams.length(),"remove first (length)");
		Assert.assertEquals(femmes,jams.peek(0),"remove first (1st song)");

		jams.remove(femmes2);
		// songs = {}
		Assert.assertEquals(0,jams.length(),"remove last element (length)");
		Assert.assertEquals(null,jams.peek(0),"remove last");

		// remove invalid song. list is empty
		jams.remove(femmes);
		Assert.assertEquals(0,jams.length(),"remove from empty");
		jams.add(pil);
		jams.remove(femmes);
		Assert.assertEquals(1,jams.length(),"remove not in list");
		Assert.assertEquals(pil,jams.peek(0),"remove not in list (1st song)");

	}
} // end class Main

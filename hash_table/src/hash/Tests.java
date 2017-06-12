package hash;

import hash.HashTable;

public class Tests {
	
	public static void run() {
		testAddExists();
		testProbing();
		testGet();
		testRemove();
	}

	public static void testAddExists() {
	  HashTable states = new HashTable(100);
	  
	  states.add("Texas", "Austin");
	
	  assert(states.exists("Texas"));
	}

	public static void testProbing() {
	  // setting high load to force collisions
	  HashTable states = new HashTable(8);
	
	  states.add("Texas", "Austin");
	  states.add("California", "Sacramento");
	  states.add("New Mexico", "Santa Fe");
	  states.add("Florida", "Tallahassee");
	  states.add("Oregon", "Salem");
	  states.add("Washington", "Olympia");
	  states.add("Utah", "Salt Lake City");
	  states.add("New York", "Albany");
	  states.add("Minnesota", "St. Paul");

	  //  Texas: 1
	  //  California: 0
	  //  New Mexico: 5
	  //  Florida: 5
	  //  Oregon: 4
	  //  Washington: 0
	  //  Utah: 6
	  //  New York: 7
	  //  Minnesota: 6

	  //  0: California:Sacramento
	  //  1: Texas:Austin
	  //  2: Washington:Olympia
	  //  3: New York:Albany
	  //  4: Oregon:Salem
	  //  5: New Mexico:Santa Fe
	  //  6: Florida:Tallahassee
	  //  7: Utah:Salt Lake City

	  assert(states.exists("California"));
	  assert(states.exists("New Mexico"));
	  assert(states.exists("Florida"));
	  assert(!states.exists("Minnesota"));  // no room
	}

	public static void testGet() {
	  HashTable states = new HashTable(100);

	  states.add("Texas", "Austin");

	  assert(states.get("Texas") == "Austin");
	}

	public static void testRemove() {
	  HashTable states = new HashTable(100);

	  states.add("Texas", "Austin");

	  assert(states.exists("Texas"));

	  states.remove("Texas");

	  assert(!states.exists("Texas"));
	}
}

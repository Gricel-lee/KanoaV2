package uoy.mrs.uoy.mrs.types.impl;

//Use as a MultiKey where object is declared
//this class is needed as MultiKeyMap does not allow to declare the type of object: 
//e.g:
/**Map of two keys (loc1,loc2) to distance (path)*/ //path.get(l1,l2) 
//public MultiKeyMap<String, Object> paths = new MultiKeyMap<>(); //path.get(l1,l2) = 45.0 - distance
// For the paths, we need to declare what type of object it is (Path) to access its methods.

public class MultiKey {
    private String key1;
    private String key2;

    public MultiKey(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }
    

	public String getKey1() {
		return key1;
	}

	public String getKey2() {
		return key2;
	}
    
    
    // Add getters, equals, and hashCode methods as needed
}


// - Example how to use it: 
//public class MultiKeyMapExample {
//    public static void main(String[] args) {
//        Map<MultiKey, Path> multiKeyMap = new HashMap<>();
//
//        // Example entries
//        MultiKey key1 = new MultiKey("key1a", "key1b");
//        Path path1 = /* your Path object */;
//        multiKeyMap.put(key1, path1);
//
//        MultiKey key2 = new MultiKey("key2a", "key2b");
//        Path path2 = /* your Path object */;
//        multiKeyMap.put(key2, path2);
//
//        // Retrieve values
//        Path retrievedPath = multiKeyMap.get(new MultiKey("key1a", "key1b"));
//        System.out.println("Retrieved path: " + retrievedPath);
//    }
//}


// Also, to check if a key exists
//MultiKey keyToCheck = new MultiKey("key1a", "key1b");
//if (multiKeyMap.containsKey(keyToCheck)) {
//    System.out.println("Key exists. Value: " + multiKeyMap.get(keyToCheck));
//} else {
//    System.out.println("Key does not exist.");
//}
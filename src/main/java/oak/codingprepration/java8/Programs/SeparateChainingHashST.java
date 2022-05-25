package oak.codingprepration.java8.Programs;

public class SeparateChainingHashST<Key, Value> {
	private int N; // number of key-value pairs
	private int M; // hash table size
	private SequentialSearchST<Key, Value>[] st; // array of ST objects

	public SeparateChainingHashST() {
		this(3);
	}

	public SeparateChainingHashST(int M) { // Create M linked lists.
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++)
			st[i] = new SequentialSearchST();
	}

	private int hash(Key key) {
		int result = (key.hashCode() & 0x7fffffff) % M;
		System.out.println("key:"+key+" hash:"+result);		
		return result;
	}

	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}

	public static void main(String[] args) {
		SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<String, Integer>();
		separateChainingHashST.put("E", 11);
		separateChainingHashST.put("P", 21);
		separateChainingHashST.put("M", 31);
		separateChainingHashST.put("E", 32);
	}

}

package oak.codingprepration.java8.Programs;

public class LinearProbingHashST<Key, Value> {
	private int N; // number of key-value pairs in the table
	private int M = 5; // size of linear-probing table
	private Key[] keys; // the keys
	private Value[] vals; // the values

	public LinearProbingHashST(int cap) {
		this.M=cap;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}


	private int hash(Key key) {
	   int hash=(key.hashCode() & 0x7fffffff) % M;
	   System.out.println("key:"+key+" hash:"+hash);
		return hash;
	}

	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for (int i = 0; i < M; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}

	public void put(Key key, Value val) {
		if (N >= M / 2)
			resize(2 * M); // double M (see text)
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				return vals[i];
		return null;
	}
	
	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> linearProbingHashST = new LinearProbingHashST<String, Integer>();
		linearProbingHashST.put("E", 11);
		linearProbingHashST.put("P", 21);
		linearProbingHashST.put("M", 31);
		linearProbingHashST.put("E", 32);
	}
}

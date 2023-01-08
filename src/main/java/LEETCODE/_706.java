package LEETCODE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _706 {
	private static class MyHashMap {
		private List<List<Entry>> hashChain;
		private static final int capacity = 10000;

		public MyHashMap() {
			hashChain = new ArrayList<>(capacity);
		}

		public void put(int key, int value) {
			int hash = key % capacity;
			List<Entry> chain = hashChain.get(hash);
			if (chain == null) {
				hashChain.set(hash, new LinkedList<>());
				chain = hashChain.get(hash);
			}

			boolean overwrite = false;
			Iterator<Entry> iterator = chain.iterator();
			while (iterator.hasNext()) {
				Entry next = iterator.next();
				if (next.key == key) {
					next.value = value;
					overwrite = true;
					break;
				}
			}

			if (!overwrite) {
				chain.add(new Entry(key, value));
			}
		}

		public int get(int key) {
			int hash = key  % capacity;
			List<Entry> chain = hashChain.get(hash);
			if (chain != null) {
				Iterator<Entry> iterator = chain.iterator();
				while (iterator.hasNext()) {
					Entry next = iterator.next();
					if (next.key == key) {
						return next.value;
					}
				}
			}

			return -1;
		}

		public void remove(int key) {
			int hash = key  % capacity;
			List<Entry> chain = hashChain.get(hash);
			if (chain != null) {
				Iterator<Entry> iterator = chain.iterator();
				int index = -1;
				int target = -1;
				while (iterator.hasNext()) {
					index++;
					Entry next = iterator.next();
					if (next.key == key) {
						target = index;
						break;
					}
				}

				if (target >= 0) {
					chain.remove(target);
				}
			}
		}

		private static class Entry {
			public int key;
			public int value;

			public Entry(int key, int value) {
				this.key = key;
				this.value = value;
			}
		}
	}
}

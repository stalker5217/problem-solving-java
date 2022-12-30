package LEETCODE;

public class _208 {
	private static class Trie {
		private Trie[] children;
		private boolean terminal;

		public Trie() {
			this.children = new Trie[26];
			this.terminal = false;
		}

		public void insert(String word) {
			if (word.length() == 0) {
				terminal = true;
				return;
			}

			int next = toIndex(word.charAt(0));

			if (children[next] == null) {
				children[next] = new Trie();
			}
			children[next].insert(word.substring(1));
		}

		public boolean search(String word) {
			Trie current = this;
			for (int i = 0 ; i < word.length() ; i++) {
				int next = toIndex(word.charAt(i));
				if (current.children[next] == null) {
					return false;
				}

				current = current.children[next];
			}

			return current != null && current.terminal;
		}

		public boolean startsWith(String prefix) {
			Trie current = this;
			for (int i = 0 ; i < prefix.length() ; i++) {
				int next = toIndex(prefix.charAt(i));
				if (current.children[next] == null) {
					return false;
				}

				current = current.children[next];
			}

			return current != null;
		}

		private int toIndex(char c) {
			return c - 'a';
		}
	}
}

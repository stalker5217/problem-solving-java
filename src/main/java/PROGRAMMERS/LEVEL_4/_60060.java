package PROGRAMMERS.LEVEL_4;

import java.util.*;

/**
 * 가사 검색
 */

public class _60060{
    public static void main(String[] args) {
        Solution_60060 s = new Solution_60060();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        for(int cur : s.solution(words, queries)){
            System.out.println(cur);
        }
    }
}

class Solution_60060 {
    public int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();

        TrieNode[] root = new TrieNode[10001];
        TrieNode[] reverseRoot = new TrieNode[10001];

        for(int i = 1 ; i <= 10000 ; i++){
            root[i] = new TrieNode();
            reverseRoot[i] = new TrieNode();
        }

        for(String word : words){
            int wordLen = word.length();
            root[wordLen].insert(word, 0);
            StringBuilder sb = new StringBuilder(word);
            reverseRoot[wordLen].insert(sb.reverse().toString(), 0);
        }

        for(String query : queries){
            int wordLen = query.length();
            if(query.charAt(0) != '?') answer.add(root[wordLen].find(query, 0));
            else{
                StringBuilder sb = new StringBuilder(query);
                answer.add(reverseRoot[wordLen].find(sb.reverse().toString(), 0));
            }
        }

        return answer.stream().mapToInt(n->n).toArray();
    }
}

class TrieNode{
    private static final int ALPHABET = 26;

    private final TrieNode[] children = new TrieNode[ALPHABET];
    private boolean isTerminal;
    private int wordsCnt;

    public TrieNode(){
        for(int i =  0 ; i < ALPHABET ; i++){
            children[i] = null;
        }
        isTerminal = false;
        wordsCnt = 0;
    }

    private int toNumber(char ch){
        return ch - 'a';
    }

    public void insert(String s, int index){
        if(index == s.length()){
            isTerminal = true;
            return;
        }

        int next = toNumber(s.charAt(index));
        if(children[next] == null){
            children[next] = new TrieNode();
        }
        wordsCnt++;
        children[next].insert(s, index+1);
    }

    public int find(String s, int index){
        if(index == s.length()){
            return isTerminal ? 1 : 0;
        }

        if(s.charAt(index) == '?') return wordsCnt;

        int next = toNumber(s.charAt(index));

        if(children[next] == null) return 0;
        else return children[next].find(s, index+1);
    }
}
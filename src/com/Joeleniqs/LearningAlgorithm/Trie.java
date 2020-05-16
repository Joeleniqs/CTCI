package com.Joeleniqs.LearningAlgorithm;

public class Trie {
        Trie [] children = new Trie[26];
        boolean isWord;
        /** Initialize your data structure here. */
        public Trie() {

        }
        public int getCharIndex(char c){
            return c - 'a';
        }
        public Trie getNode(char c){
            return children[getCharIndex(c)];
        }
        public void setNode(char c, Trie t){
            children[getCharIndex(c)] = t;
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(word,0);
        }
        public void insert(String word,int index){
            if(word.length() == index) return;
            var current = word.charAt(index);
            var Node = getNode(current);
            if(Node == null) {
                Node = new Trie();
                setNode(current,Node);
            }
            if(word.length()-1 == index) Node.isWord = true;

            Node.insert(word,index+1);
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            return search(word,0);
        }
        public boolean search(String word,int index){
            if(word.length() == index) return false;

            var current = word.charAt(index);
            var Node = children[getCharIndex(current)];
            if(Node == null ) return false;

            if(word.length()-1 == index && Node.isWord) return true;

            return Node.search(word,index+1);
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(prefix,0);
    }
    public boolean startsWith(String prefix,int index){
        if(prefix.length() == index) return true;

        var current = prefix.charAt(index);
        var Node = children[getCharIndex(current)];
        if(Node == null ) return false;

        if(prefix.length()-1 == index) return true;

        return Node.startsWith(prefix,index+1);
    }
    public void invoke(){
            Trie tt = new Trie();
            tt.insert("apples");
        System.out.println(tt.search("app"));
        System.out.println(tt.startsWith("app"));
        tt.insert("app");
        System.out.println(tt.search("app"));
            System.out.print(tt);
    }

}

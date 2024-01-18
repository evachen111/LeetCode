package Grind75;

//208
public class Trie {
    private int size = 26;
    public Trie[] children = new Trie[size];
    public boolean isEndOfWord;

    public Trie() {
        this.isEndOfWord = false;
    }

    public void insert(String word) {
        Trie p = this;
        for (int i = 0; i <word.length(); i++){
            if (p.children[word.charAt(i)-'a'] == null){
                p.children[word.charAt(i)-'a'] = new Trie();
            }
            p = p.children[word.charAt(i)-'a'];
        }
        p.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie p = this;
        for (int i = 0; i <word.length(); i++){
            if (p.children[word.charAt(i)-'a'] == null){
                return false;
            }
            p = p.children[word.charAt(i)-'a'];
        }
        if (!p.isEndOfWord){
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Trie p = this;
        for (int i = 0; i <prefix.length(); i++){
            if (p.children[prefix.charAt(i)-'a'] == null){
                return false;
            }
            p = p.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
import java.util.*;

public class TrieDataStructure
{
    public static void main(String args[])
    {
        Trie words = new Trie();
        words.add("hello");
        words.add("hey");
        words.add("hi");
        words.add("apple");
        words.add("app");
        words.add("egg");
        words.add("elephant");
        words.add("banana");
        words.add("bank");
        words.add("ban");
        words.add("bang");
        System.out.println(words.has("egg"));
        System.out.println(words.has("ap"));
        System.out.println(words.has("ban"));
        System.out.println(words.has("banana"));
        System.out.println(words.suggest(""));
    }
}
class Trie
{
    char c;
    Trie[] children;
    boolean word;
    public Trie()
    {
        c=0;
        children = new Trie[26];
        word=false;
    }
    public void add(String s)
    {
        if (s.isEmpty())
        {
            this.word=true;
            return;
        }
        int index=s.charAt(0)-'a';
        if (children[index]==null)
        {
            children[index]=new Trie();
        }
        children[index].add(s.substring(1));
    }
    public boolean has(String s)
    {
        if (s.isEmpty())
            return word;
        int index=s.charAt(0)-'a';
        if (children[index]==null)
            return false;
        return children[index].has(s.substring(1));
    }
    public Set suggest(String s)
    {
        Trie tmp=this;
        Set<String> words = new TreeSet<>();
        if (has(s))
            words.add(s);
        if (s=="")
            return words;
        for (int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            tmp=tmp.children[index];
            if (tmp==null)
                return words;
        }
        Queue<Integer> queue = new LinkedList<>();
        Queue<String> word = new LinkedList<>();
        Queue<Trie> trie = new LinkedList<>();
        
        for (int i=0;i<26;i++)
            if (tmp.children[i]!=null)
            {
                queue.add(i);
                word.add(s);
                trie.add(tmp.children[i]);
            }
        while (!queue.isEmpty())
        {
            int index=queue.remove();
            String str=word.remove();
            char newChar=(char)(index+'a');
            Trie curr=trie.remove();
            if (isNull(curr.children))
                words.add(str+newChar);
            else
            {
                if (curr.word)
                    words.add(str+newChar);
                for (int i=0;i<26;i++)
                    if (curr.children[i]!=null)
                    {
                        queue.add(i);
                        word.add(str+newChar);
                        trie.add(curr.children[i]);
                    }
            }
        }
        return (words);
    }
    private boolean isNull(Trie tmp[])
    {
        for (int i=0;i<26;i++)
            if (tmp[i]!=null)
                return false;
        return true;
    }
}
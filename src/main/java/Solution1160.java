public class Solution1160 {
    public int countCharacters(String[] words,String chars){
        int[] chars_count=count(chars);
        int len=0;
        for (int i = 0; i <words.length ; i++) {
            int[] word_count=count(words[i]);
            if (compare(chars_count,word_count)){
                len+=words[i].length();
            }
        }
        return len;

    }
    //检查字母表中出现的次数是否覆盖单词的字母出现次数
    private boolean compare(int[] chars_count,int[] word_count){
        for (int i = 0; i <26 ; i++) {
            if (chars_count[i]<word_count[i]){
                return false;
            }
        }
        return true;
    }

    //统计单词中字母的个数
    private int[] count(String word){
        int[] counter=new int[26];
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            counter[c-'a']++;
        }
        return counter;
    }
}

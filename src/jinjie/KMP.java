package jinjie;

public class KMP {

    private static int getIndexOf(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length() || str2.length() < 1)
            return -1;
        char[] cs1 = str1.toCharArray(), cs2 = str2.toCharArray();
        int i = 0, j = 0;
        int[] next = getNextArray(cs2);
        while (i < cs1.length && j < cs2.length) {
            if (cs1[i] == cs2[j]) {
                i++;
                j++;
            } else if (next[j] == -1)
                i++;
            else
                j = next[j];
        }
        return j == cs2.length ? i - j : -1;
    }

    private static int[] getNextArray(char[] cs) {
        if (cs.length == 1)
            return new int[]{-1};
        int[] next = new int[cs.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2, cn = 0;
        while (pos < next.length) {
            if (cs[pos - 1] == cs[cn])
                next[pos++] = ++cn;
            else if (cn > 0)
                cn = next[cn];
            else
                next[pos++] = 0;
        }
        return next;
    }

    public static void main(String[] args){
        System.out.println(getIndexOf("abcdefg","defhg"));
    }
}

package jinjie;

public class Manacher {
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1, pR = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    private static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++)
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLcpsLength("abcabcabaa"));
    }
}

package string.easy;

public class _686_Repeated_String_Match {

    /**
     * 不是特别懂
     *
     * 先重复A， 直到长度超过B。 如果contains B, 那就是最小的cnt了。
     * 如果没contain, 还可以再尝试下家cnt+1个A。 因为这种情况会包含从A中的每一个char起始的substring情况。
     *
     * Imagine we wrote S = A+A+A+.... If B is to be a substring of S,
     * we only need to check whether some S[0:], S[1:], ..., S[len(A) - 1:] starts with B,
     * as S is long enough to contain B, and S has period at most len(A).
     *
     * Now, suppose q is the least number for which len(B) <= len(A * q).
     * We only need to check whether B is a substring of A * q or A * (q+1).
     * If we try k < q, then B has larger length than A * q and therefore can't be a substring.
     * When k = q+1, A * k is already big enough to try all positions for B; namely, A[i:i+len(B)] == B for i = 0, 1, ..., len(A) - 1.
     */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int q = 0;
        while(sb.length() < B.length()){
            sb.append(A);
            q++;
        }

        if(sb.toString().contains(B))
            return q;

        sb.append(A);
        if(sb.toString().contains(B))
            return q+1;

        return -1;
    }

    /**
     * 方法1： KMP
     * 奇怪的KMP实现， 再看看更好的。
     */
    public int repeatedStringMatchKMP(String A, String B) {

        StringBuilder sb = new StringBuilder();
        int q = 0;
        while(sb.length() < B.length()){
            sb.append(A);
            q++;
        }

        if(KMP(sb.toString(), B))
            return q;

        sb.append(A);
        if(KMP(sb.toString(), B))
            return q+1;

        return -1;
    }

    public boolean KMP(String text, String pattern){
        int[] lps = compute_prefixes(pattern);
        int i = 0, j = 0;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }

        if(j == pattern.length())
            return true;

        return false;
    }

    private int[] compute_prefixes(String pattern){
        int[] lps = new int[pattern.length()];
        int idx = 0;
        for(int i = 1; i < pattern.length(); ){
            if(pattern.charAt(idx) == pattern.charAt(i)){
                lps[i] = idx+1;
                idx++;
                i++;
            }
            else{
                if(idx != 0){
                    idx = lps[idx-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

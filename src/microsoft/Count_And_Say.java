package microsoft;

public class Count_And_Say {
    /**
     * "aaaabbbbcccd" to "a4b4c3d1", encode & decode
     */
    public static String encode(String s) {
        if (s == null) return s;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        char cur = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == cur) {
                cnt++;
            } else {
                sb.append(cur);
                sb.append(cnt);
                cur = arr[i];
                cnt = 1;
            }
        }
        sb.append(cur);
        sb.append(cnt);
        return sb.toString();
    }

    public static String decode(String s) {
        //"a4b4c3d1"
        if (s == null) return s;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        char cur = arr[0];
        int cnt = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (i == arr.length || !Character.isDigit(arr[i])) {
                int num = Integer.valueOf(s.substring(i - cnt, i)); //b4c
                while (num > 0) {
                    sb.append(cur);
                    num--;
                }
                if (i < arr.length) cur = arr[i];
                cnt = 0;
            } else {
                cnt++;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
//        System.out.println(encode("aaaabbbbcccd"));
        String a = "a4b4c3d1";
        System.out.println(decode(a));
    }
}

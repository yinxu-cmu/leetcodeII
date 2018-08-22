package string.easy;

public class _551_Student_Attendance_Record_I {

    /**
     * easy.
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int acnt = 0;
        int lcnt = 0;
        boolean cont = false;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                if (cont) {
                    lcnt++;
                    if (lcnt > 2) {
                        return false;
                    }
                } else {
                    cont = true;
                    lcnt++;
                }
            } else {
                if (ch == 'A') {
                    acnt++;
                    if (acnt > 1) {
                        return false;
                    }
                }
                cont = false;
                lcnt = 0;
            }


        }
        return true;
    }
}

package dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number
 *
 * @author Dr. King
 *
 */
public class StudentIDComparator implements Comparator<Student> {

    /**
     * Compares students based on id number in ascending order
     *
     * @param one
     *            Student being Compared
     * @param two
     *            Student we are Comparing to
     */
    @Override
    public int compare ( final Student one, final Student two ) {
        if ( one.getId() - two.getId() < 0 ) {
            return -1;
        }
        else if ( one.getId() - two.getId() > 0 ) {
            return 1;
        }
        return 0;
    }

}

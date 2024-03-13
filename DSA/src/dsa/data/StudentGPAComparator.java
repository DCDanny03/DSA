package dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 *
 * @author Dr. King
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

    /**
     * Compares students based on GPA in descending order
     *
     * @param one
     *            Student being Compared
     * @param two
     *            Student we are Comparing to
     */
    @Override
    public int compare ( final Student one, final Student two ) {
        if ( one.getGpa() > two.getGpa() ) {
            return -1;
        }
        else if ( one.getGpa() < two.getGpa() ) {
            return 1;
        }
        return 0;
    }

}

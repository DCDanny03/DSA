package dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 *
 * @author Dr. King
 *
 */
public class Student implements Comparable<Student>, Identifiable {

    /**
     * First Name
     */
    private String first;
    /**
     * Last Name
     */
    private String last;
    /**
     * Student ID Number
     */
    private int    id;
    /**
     * Credit Hours
     */
    private int    creditHours;
    /**
     * Student GPA
     */
    private double gpa;
    /**
     * Student Unity ID
     */
    private String unityID;

    /**
     * Student Constructor
     *
     * @param first
     *            first name
     * @param last
     *            last name
     * @param id
     *            student id number as int
     * @param creditHours
     *            student credit hours as int
     * @param gpa
     *            gpa as double
     * @param unityID
     *            unity id as string
     */
    public Student ( final String first, final String last, final int id, final int creditHours, final double gpa,
            final String unityID ) {
        this.first = first;
        this.last = last;
        this.id = id;
        this.creditHours = creditHours;
        this.gpa = gpa;
        this.unityID = unityID;
    }

    /**
     * First Name getter
     *
     * @return the first
     */
    public String getFirst () {
        return first;
    }

    /**
     * First Namer setter
     *
     * @param first
     *            the first to set
     */
    public void setFirst ( final String first ) {
        this.first = first;
    }

    /**
     * Last Name getter
     *
     * @return the last
     */
    public String getLast () {
        return last;
    }

    /**
     * last name setter
     *
     * @param last
     *            the last to set
     */
    public void setLast ( final String last ) {
        this.last = last;
    }

    /**
     * id getter
     *
     * @return the id
     */
    @Override
    public int getId () {
        return id;
    }

    /**
     * id setter
     *
     * @param id
     *            the id to set
     */
    public void setId ( final int id ) {
        this.id = id;
    }

    /**
     * credit hours getter
     *
     * @return the creditHours
     */
    public int getCreditHours () {
        return creditHours;
    }

    /**
     * credit hours setter
     *
     * @param creditHours
     *            the creditHours to set
     */
    public void setCreditHours ( final int creditHours ) {
        this.creditHours = creditHours;
    }

    /**
     * gpa getter
     *
     * @return the gpa
     */
    public double getGpa () {
        return gpa;
    }

    /**
     * gpa setter
     *
     * @param gpa
     *            the gpa to set
     */
    public void setGpa ( final double gpa ) {
        this.gpa = gpa;
    }

    /**
     * unity id getter
     *
     * @return the unityID
     */
    public String getUnityID () {
        return unityID;
    }

    /**
     * unity id setter
     *
     * @param unityID
     *            the unityID to set
     */
    public void setUnityID ( final String unityID ) {
        this.unityID = unityID;
    }

    @Override
    public int compareTo ( final Student other ) {
        // TODO Auto-generated method stub
        if ( this.last.compareTo( other.last ) == 0 ) {
            if ( this.first.compareTo( other.first ) == 0 ) {
                if ( this.id - other.id < 0 ) {
                    return -1;
                }
                else if ( this.id - other.id > 0 ) {

                    return 1;
                }
                else {
                    return 0;
                }
            }
            else {
                return this.first.compareTo( other.first );
            }
        }
        else {
            return this.last.compareTo( other.last );
        }

        // return 0;
    }

    @Override
    public int hashCode () {
        return Objects.hash( creditHours, first, gpa, id, last, unityID );
    }

    @Override
    public boolean equals ( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Student other = (Student) obj;
        return creditHours == other.creditHours && Objects.equals( first, other.first )
                && Double.doubleToLongBits( gpa ) == Double.doubleToLongBits( other.gpa ) && id == other.id
                && Objects.equals( last, other.last ) && Objects.equals( unityID, other.unityID );
    }

    @Override
    public String toString () {
        return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
                + gpa + ", unityID=" + unityID + "]";
    }

}

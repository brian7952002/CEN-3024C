public class Name
{
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String suffix;


    public Name(String firstName, String middleInitial, String lastName, String suffix)
    {
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public Name(String firstName, String middleInitial, String lastName)
    {
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setLastName(lastName);
    }

    public Name(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName)
    {
        firstName = firstName.toUpperCase();
        this.firstName = firstName;
        if (firstName.length() > 0) {
            char c = firstName.charAt(0);
            firstName = firstName.toLowerCase().substring(1);
            this.firstName = c + firstName;
        }
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setMiddleInitial(String middleInitial)
    {

            middleInitial = middleInitial.toUpperCase();
            this.middleInitial = middleInitial;

    }

    public String getMiddleInitial()
    {
        return middleInitial;
    }

    public void setLastName(String lastName)
    {
        lastName = lastName.toUpperCase();
        this.lastName = lastName;
        if (lastName.length() > 0) {
            char c = lastName.charAt(0);
            lastName = lastName.toLowerCase().substring(1);
            this.lastName = c + lastName;
        }
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public String toString()
    {
        String result;
        if(suffix != null)
        {
            result = firstName + " " + middleInitial + " " + lastName + " " +suffix;

        }
        else if(suffix == null && middleInitial != null)
        {
            result = firstName + " " + middleInitial + " " + lastName;
        }
        else
        {
            result = firstName + " " + lastName;
        }
        System.out.println(result);
        return result;
    }
}

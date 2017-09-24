import java.util.Comparator;

public class GuestNameComporator implements Comparator<Guest> {


    @Override
    public int compare(Guest guest1, Guest guest2) {
            String guest1Name = guest1.getName();
            String guest2Name = guest2.getName();
            return guest1Name.compareTo(guest2Name);


    }
}

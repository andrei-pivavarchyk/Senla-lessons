package entity;

public class Guest extends Entity {
    private String name;
    private String surname;

    public Guest(int id,String name, String surName) {
        super(id);
        this.name = name;
        this.surname = surName;

        System.out.println(new StringBuilder(String.valueOf(this)).append(" was created"));
    }


    public String getName() {
        return this.name;
    }

    public String getSurName() {
        return this.surname;
    }

    public String toString() {
        return String.format("Guest  %s %s ", this.name, this.surname);
    }


/*
    public Date getDepartureDate() {
        Date departureDate = new Date();
        for (int i = 0; i < this.guestRoom.getCurrenGuestInfo().size(); i++) {
            if (this.equals(this.guestRoom.getCurrenGuestInfo().get(i).getGuest())) {
                departureDate = this.guestRoom.getCurrenGuestInfo().get(i).getDepartureDate();
            }
        }
        return departureDate;
    }

    public void setGuestInfo(GuestInfo guestInfo) {
        this.guestInfo = guestInfo;
    }

    public GuestInfo getGuestInfo() {
        return this.guestInfo;
    }

    public long getPay() {
        long firstDate = new GregorianCalendar().getTime().getTime();
        long secondDate = this.getGuestInfo().getDepartureDate().getTime();
        long allDaysLeaving = (secondDate - firstDate) / 86400000;
        return (secondDate - firstDate) / 86400000;
    }

    public Room getGuestRoom() {
        return this.guestRoom;
    }

    public void setGuestRoom(Room room) {
        this.guestRoom = room;
    }

    public void addService(Service service, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        service.setDate(calendar.getTime());
        service.setGuest(this);
        this.allGuestService.add(service);
    }
    public ArrayList<Service> getAllGuestService() {
        return this.allGuestService;
    }

    */


}

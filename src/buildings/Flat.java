package buildings;

public class Flat {
    private static final int  DEF_ROOMS = 2;
    private static final int  DEF_AREA = 50;

    private int area;
    private int numberOfRooms;

    public Flat() {
        this(DEF_AREA,DEF_ROOMS);
    }
    public Flat(int area ) {
        this(area,DEF_ROOMS);
    }
    public Flat(int area, int numberOfRooms) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
    }
    public int getArea() {
        return area;
    }
    public void setArea(int area) {
        this.area = area;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
package buildings;

public class Main {

    public static void main(String[] args) {
        int [] countFlat = {2,3};
        Dwelling dwelling = new Dwelling(2,countFlat);
        System.out.println(dwelling.getCountFlats());
        dwelling.getArrayFloors()[0].addNewFlat(0,new Flat(20,1));
        dwelling.getArrayFloors()[0].addNewFlat(1,new Flat(30,2));
        dwelling.getArrayFloors()[0].addNewFlat(4,new Flat(15,1));
        dwelling.getArrayFloors()[0].setFlat(0,new Flat(45,1));
        dwelling.getArrayFloors()[1].addNewFlat(1,new Flat(55,2));
        dwelling.getArrayFloors()[1].addNewFlat(2,new Flat(70,1));
        System.out.println(dwelling.getAreaFlats());
        dwelling.addNewFlat(17,new Flat(90,1));
        System.out.println(dwelling.getAreaFlats());
        System.out.println(dwelling.getCountRoomsOnDwelling());
        System.out.println(dwelling.getBestSpace().getArea());
        dwelling.getArrayFloors()[1].removeFlat(9);
        System.out.println(dwelling.getBestSpace().getArea());
        for (int i=0;i<dwelling.getCountFlats();i++)
        {
            System.out.print(dwelling.sortByAreaFlats()[i].getArea()+" ");
        }
    }
}

package buildings;

public class DwellingFloor {
    private int size;
    private Flat [] arrayFlat;
    //Конструктор может принимать количество квартир на этаже.
    public DwellingFloor(int countFlats) {
        arrayFlat = new Flat[countFlats];
      this.size = countFlats;
    }
    //Конструктор может принимать массив квартир этажа.
    public DwellingFloor(Flat[] arrayFlat) {
        this.arrayFlat = arrayFlat;
        this.size = arrayFlat.length;
    }
    //метод получения количества квартир на этаже
    public int getSize() {
        return arrayFlat.length;
    }
    //метод получения общей площади квартир этажа
    public int getAreaFlats() {
        int areaFlats = 0;
        for(int i=0; i<arrayFlat.length;i++)
        {
            if(arrayFlat[i]!=null)
            areaFlats += arrayFlat[i].getArea();
        }
        return areaFlats;
    }
    //метод получения общего количества комнат этажа
    public int getCountRoomsOnFloor() {
        int allNomberFlats = 0;
        for(int i=0; i<size;i++)
        {
            if(arrayFlat[i]!=null)
           allNomberFlats += arrayFlat[i].getNumberOfRooms();
        }
        return allNomberFlats;
    }
    //метод получения массива квартир этажа
    public Flat[] getArrayFlat() {
        return arrayFlat;
    }
    //метод получения объекта квартиры по её номеру на этаже
    public  Flat getFlatToNumber(int i)
    {
        return arrayFlat[i];
    }
    //метод изменения квартиры
    public void setFlat (int number, Flat newFlat)
    {
        if(number<size) {
            arrayFlat[number]=newFlat;
        }
    }
    //метод добавления новой квартиры на этаже по будущему номеру квартиры
    public void addNewFlat (int number, Flat newFlat)
    {
        if(size==arrayFlat.length) {//если массив полностью заполнен квартирами
            while (number >= arrayFlat.length) {
                Flat[] newArrayFlat = new Flat[2 * arrayFlat.length];
                System.arraycopy(arrayFlat, 0, newArrayFlat, 0, arrayFlat.length);
                arrayFlat = newArrayFlat;
            }
        }
        else
        {
            System.arraycopy(arrayFlat, number, arrayFlat, number+1, arrayFlat.length-number-1);
        }
        arrayFlat[number]=newFlat;
        size=arrayFlat.length;

    }
    //метод удаления квартиры по её номеру на этаже
    public void removeFlat(int number)
    {
        if(number<size&&arrayFlat[number]!=null) {
            System.arraycopy(arrayFlat, number+1, arrayFlat, number, size-number-1);
        }
        size=arrayFlat.length;
    }
    //метод получения самой большой по площади квартиры этажа
    public Flat getBestSpace(){
        Flat flatMaxArea = new Flat(0,0);
        for(int i=1; i<arrayFlat.length;i++)
        {
            if((getArrayFlat()[i]!=null)&&(getArrayFlat()[i].getArea()>flatMaxArea.getArea())){
                flatMaxArea = getArrayFlat()[i];
            }
        }
        return  flatMaxArea;
    }

}
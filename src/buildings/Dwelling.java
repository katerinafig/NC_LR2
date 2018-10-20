package buildings;

public class Dwelling{
    private int size;
    private DwellingFloor [] arrayFloors ;
    //Конструктор может принимать количество этажей и массив количества квартир по этажам
    public Dwelling(int size,int [] countsFlat)
    {
        if(size==countsFlat.length) {
            arrayFloors = new DwellingFloor[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                arrayFloors[i] = new DwellingFloor(countsFlat[i]);
            }
        }
    }
    //Конструктор может принимать массив этажей дома.
    public Dwelling (DwellingFloor [] arrayFloors)
    {
        this.arrayFloors = arrayFloors;
    }
    //метод получения общего количества этажей дома
    public int getSize() {
        return size;
    }
    //метод получения общего количества квартир дома
    public int getCountFlats() {
        int countFlats = 0;
        for(int i=0;i<size;i++) {
            countFlats += arrayFloors[i].getSize();
        }
        return countFlats;
    }
    //метод получения общей площади квартир дома
    public int getAreaFlats() {
        int areaFlats = 0;
        for(int i=0;i<size;i++) {
            areaFlats += arrayFloors[i].getAreaFlats();
        }
        return areaFlats;
    }
    //метод получения общего количества комнат дома
    public int getCountRoomsOnDwelling() {
        int countRooms = 0;
        for(int i=0;i<getSize();i++) {
            countRooms += arrayFloors[i].getCountRoomsOnFloor();
        }
        return countRooms;
    }
    //метод получения массива этажей жилого дома
    public DwellingFloor[] getArrayFloors() {
        return arrayFloors;
    }
    //метод получения объкта этажа по его номеру в доме
    public  DwellingFloor getFloorToNumber(int i)
    {
        return getArrayFloors()[i];
    }
    //метод изменения этажа по его номеру и ссылке на этаж
    public void setFloor (int number, DwellingFloor newFloor)
    {
        if(number<getSize()) {
            getArrayFloors()[number]=newFloor;
        }
    }
    //метод получения объекта расположения квартиры в доме по её номеру в доме
    public LocationFlatDTO getLocationFlat(int number)
    {
        LocationFlatDTO location = null;
        int tempSize=0;
        int count = 0;
        if(number < getCountFlats()){
            for (int i = 0; i < size; i++) {
                tempSize = arrayFloors[i].getSize();
                if(number-count>=tempSize){
                   count += tempSize;
                }
                else{
                    location=new LocationFlatDTO(i,number-count);
                }
            }
        }
        return location;
    }
    //метод получения объекта квартиры по её номеру в доме
    public Flat getFlatToNumber(int number) {

        LocationFlatDTO temp = getLocationFlat(number);
        if(temp!=null) {
            return getArrayFloors()[temp.floor].getFlatToNumber(temp.flat);
        }
        else  return null;
    }
    //метод изменения квартиры по её номеру в доме и ссылке на квартиру
    public void setFlat (int number, Flat newFlat) {

        LocationFlatDTO temp = getLocationFlat(number);
        if(temp!=null) {
            getArrayFloors()[temp.floor].setFlat(temp.flat, newFlat);
        }
    }
    //метод добавления новой квартиры по её номеру в доме и ссылке на квартиру без увеличения числа этажей
    public void addNewFlat (int number, Flat newFlat)//подумой!!!
    {
        LocationFlatDTO temp = getLocationFlat(number);
        if(temp!=null) {
            getArrayFloors()[temp.floor].addNewFlat(temp.flat, newFlat);
        }
        else getArrayFloors()[size-1].addNewFlat(number-getCountFlats()+getArrayFloors()[size-1].getSize(), newFlat);
    }
    //метод удаления квартиры по её номеру в доме
    public void removeFlat(int number)
    {
        LocationFlatDTO temp = getLocationFlat(number);
        if(temp!=null) {
            getArrayFloors()[temp.floor].removeFlat(temp.flat);
        }
    }
    //метод получения самой большой по площади квартиры дома
    public Flat getBestSpace(){
        Flat flatMaxArea = arrayFloors[0].getBestSpace();
        for(int i=1;i<size;i++) {
            Flat temp = arrayFloors[i].getBestSpace();
            if(flatMaxArea.getArea() < temp.getArea())
            {
                flatMaxArea = temp;
            }
        }
        return flatMaxArea;
    }
    //Метод получения отсортированного по убыванию площадей массива квартир
    public Flat [] sortByAreaFlats()
    {
        int k=0;
        Flat buf = null;
        Flat [] arrayFlat = new Flat[getCountFlats()];
        for(int i=0;i<getArrayFloors().length;i++) {
            for(int j=0; j<getArrayFloors()[i].getSize();j++) {
                if(getArrayFloors()[i].getArrayFlat()[j]!=null)
                arrayFlat[k] = getArrayFloors()[i].getArrayFlat()[j];
                else arrayFlat[k] = new Flat(-1,0);
                k++;
            }
        }
        for (int out = getCountFlats() - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arrayFlat[in].getArea() < arrayFlat[in + 1].getArea()) {
                    buf = arrayFlat[in];
                    arrayFlat[in] = arrayFlat[in + 1];
                    arrayFlat[in + 1] = buf;
                }
            }
        }
        return arrayFlat;
    }

}
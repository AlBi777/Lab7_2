import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        smartphone sp;
        int n;
        do {
            out.println("Введите количество телефонов на складе(n>0):");
            n = in.nextInt();
        } while (n < 1);
        sp = new smartphone();


        for (int i = 0; i < n; i++) {
            sp = new smartphone();
            out.println("Введите характеристики " + (i + 1) + " модели: ");
            sp.input();
            l.add(sp);
        }

        shop mag;

        do {
            out.println("Введите количество телефонов в магазине(n>0):");
            n = in.nextInt();
        } while (n < 1);
        mag = new shop();


        for (int i = 0; i < n; i++) {
            mag = new shop();
            out.println("Введите характеристики " + (i + 1) + " модели: ");
            mag.input();
            l.add(mag);
        }
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }



    }
}

class flagman {
    protected int price;
    protected int year;
    protected flagman(int pri, int ye) { price = pri; year = ye; }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цену:");
        price= in.nextInt();
        System.out.println("Введите год изготовления:");
        year = in.nextInt();

    }

    public void print(){
        System.out.println("Цена - " + price + ", год изготовления  - " + year);
    }
}

class shop extends smartphone{
    flagman fl;

    public shop(flagman fla,String name_get, camera cam_get, battery bat_get, memory mem_get, screen scr_get, systema sys_get)
    {
        fl = fla;
        name = name_get;
        camera_get = cam_get;
        battery_get = bat_get;
        memory_get = mem_get;
        screen_get = scr_get;
        system_get = sys_get;

        if (number != 0)number--;
    }

    public  shop(){
        flagman fla = new flagman(0,0);
        reset();
        fl =fla;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название:");
        name = in.nextLine();
        camera_get.input();
        battery_get.input();
        memory_get.input();
        screen_get.input();
        system_get.input();
        fl.input();
        number++;
    }
    public void print(){
        System.out.println("Название модели: "+name);
        camera_get.print();
        battery_get.print();
        memory_get.print();
        screen_get.print();
        system_get.print();
        fl.print();
    }

}










class res{
    public int param;
}
class smartphone {
    protected String name;
    protected camera camera_get;
    protected battery battery_get;
    protected memory memory_get;
    protected screen screen_get;
    protected systema system_get;
    protected static int number = 0;

    public smartphone(){

        reset();
    }
    public void reset(){
        camera _camera = new camera(0, 0);
        battery _battery = new battery(0, "type");
        memory _memory = new memory(0, 0);
        screen _screen = new screen(0, "type");
        systema _system = new systema("name", 0);

        name = "";
        camera_get = _camera;
        battery_get = _battery;
        memory_get = _memory;
        screen_get = _screen;
        system_get = _system;

        if (number != 0)number--;
    }
    public smartphone(systema sys_get) {
        system_get = sys_get;
    }
    public smartphone(String name_get, camera cam_get, battery bat_get, memory mem_get, screen scr_get, systema sys_get)
    {
        name = name_get;
        camera_get = cam_get;
        battery_get = bat_get;
        memory_get = mem_get;
        screen_get = scr_get;
        system_get = sys_get;
    }
    public static void num(){
        System.out.println("Количество моделей на складе - " + number);
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название:");
        name = in.nextLine();
        camera_get.input();
        battery_get.input();
        memory_get.input();
        screen_get.input();
        system_get.input();
        number++;
    }

    public void print(){
        System.out.println("Название модели: "+name);
        camera_get.print();
        battery_get.print();
        memory_get.print();
        screen_get.print();
        system_get.print();
    }

    public void battery_status() {
        int month;
        System.out.println("\nПроверка емкости батареи.");
        System.out.println("Сколько месяцев прошло с покупки: ");
        Scanner in = new Scanner(System.in);
        month = in.nextInt();
        System.out.println("Примерная емкость батареи - " + (this.battery_get.capacity - (this.battery_get.capacity / 100 * month)));
    }

    public void check() {
        System.out.println("Проверка."); int choice; Scanner in = new Scanner(System.in);
        if (this.battery_get.type.equals(this.battery_get.types[0]) || this.battery_get.type.equals(this.battery_get.types[1]) || this.battery_get.type.equals(this.battery_get.types[2])) {
        }
        else {
            System.out.println("Тип батареи не соответствует Li-Ion, NiCd, NIMH.\n Оставить(0) или изменить(1) тип: ");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Введите тип батареи:");
                this.battery_get.type = in.next();
            }
        }
        if (this.screen_get.type.equals(this.screen_get.types[0]) || this.screen_get.type.equals(this.screen_get.types[1]) || this.screen_get.type.equals(this.screen_get.types[2])) {}
        else {
            System.out.println("Тип батареи не соответствует IPS, OLED, AMOLED.\n Оставить(0) или изменить(1) тип: ");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Введите тип экрана:");
                this.screen_get.type = in.next();
            }
        }
        System.out.println("Проверка завершена!");
    }
    public void MaxCamera(res a){
        if (a.param < this.camera_get.main_camera && this.camera_get.main_camera != 0)a.param = this.camera_get.main_camera;
    }
}

class camera {
    public int main_camera;
    public int front_camera;

    public camera(int main, int front) {
        main_camera = main;
        front_camera = front;
    }
    public camera(int main){
        main_camera = main;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите разрешение(Мп) главной камеры:");
        main_camera = in.nextInt();
        System.out.println("Введите разрешение(Мп) фронтальной камеры:");
        front_camera = in.nextInt();

    }

    public void print(){
        System.out.println("Камера(Мп). Главная - " + main_camera + ", фронтальная  - " + front_camera);
    }

}

class battery {
    public int capacity;
    public String type;
    public String[] types = { "Li-Ion","NIMH", "NiCd" };

    public battery(int cap,String typ) {
        capacity = cap;
        type = typ;
    }
    public battery(int cap){
        capacity = cap;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип батареи:");
        type = in.nextLine();
        System.out.println("Введите емкость(мАч) батареи:");
        capacity = in.nextInt();


    }

    public void print(){
        System.out.println("Батарея(мАч). Емкость - " + capacity + ", тип  - " + type);
    }

}

class memory {
    public int ram;
    public int rom;

    public memory(int ra,int ro) {
        ram = ra;
        rom = ro;
    }
    public memory(int ro){
        rom = ro;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объем(Гб) RAM:");
        ram = in.nextInt();
        System.out.println("Введите объем(Гб) ROM:");
        rom = in.nextInt();

    }

    public void print(){
        System.out.println("Память(Гб). RAM - " + ram + " Гб, ROM  - " + rom + " Гб");
    }

}

class screen {
    public float diagonal;
    public String type;
    public String[] types = {"IPS","AMOLED","OLED"};

    public screen(float dia,String typ) {
        diagonal = dia;
        type = typ;
    }
    public screen(float dia){
        diagonal = dia;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип экрана:");
        type = in.nextLine();
        System.out.println("Введите диагональ(Дюйм) экрана:");
        diagonal = in.nextFloat();


    }

    public void print(){
        System.out.println("Экран. Диагональ - " + diagonal + " Дюйм, тип  - " + type);
    }

}

class systema {
    public String name;
    public int version;

    public systema(String nam,int ver) {
        name = nam;
        version = ver;
    }
    public systema(String nam){
        name = nam;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название ОС:");
        name = in.nextLine();
        System.out.println("Введите версию ОС:");
        version = in.nextInt();

    }

    public void print(){
        System.out.println("Система. ОС - " + name + ", Версия  - " + version);
    }

}



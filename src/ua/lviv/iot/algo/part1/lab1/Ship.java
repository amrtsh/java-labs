package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    private double id = 10.4;
    private String nameOfShip;
    private String captainName;
    private String currentPort;
    private double maxSpeed;
    private double maxCapacity;
    private double currentLoad;
    private double currentSpeed;

    public static Ship instance = new Ship();

    public static Ship getInstance() {

        return instance;
    }

    public void dock(String port) {
        this.currentPort = port;
        System.out.println("Поточний порт корабля:" + currentPort);

    }
    public void setSpeed(double speed) {
        if (speed <= this.maxSpeed) {
            this.currentSpeed = speed;
            System.out.println("Поточна швидкість корабля:" + currentSpeed);
        }
    }

    public void load(double weight) {
        if (this.currentLoad + weight <= this.maxCapacity) {
            this.currentLoad += weight;
        }
        else {
            System.out.println("Неможливо завантажити, перевищує максимальну вантажопідйомність.");
        }
    }
    public void unload(double weight) {
        if (this.currentLoad - weight >= 0) {
            this.currentLoad -= weight;
        }
        else {
            System.out.println("Неможливо вивантажити, вантаж відсутній.");
        }
    }

    public static void main(String[] args) {
        Ship[] ships = new Ship[4];
        ships[0] = new Ship();
        ships[1] = new Ship(9, "Carpe Diem", "Ferdinand Magellan", "Shenzhen",
                46.3, 10.000, 0, 40);
        ships[2] = Ship.getInstance();
        ships[3] = Ship.getInstance();
        //ships[1].dock("Збараж");

        int i = 0;
        while (i < ships.length) {
            System.out.println(ships[i]);
            i++;
        }
    }
}
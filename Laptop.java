package s6copy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Laptop {
    int id;
    String issuer;
    String screenType;
    int screenSize;
    int ram;
    int ssdSize;
    String CPU;
    String videoCard;
    String os;
    String color;

    @Override
    public String toString() {
        return String.format("%d, %s, %s screen, %d, %d RAM, %d SSD, %s, %s, %s, %s", 
                                    id, issuer, screenType, screenSize, ram, ssdSize, CPU, videoCard, os, color);
    }
   
    @Override
    public int hashCode() {
        return id;
    }
    
    public static HashSet<Laptop> deleteLaptop(HashSet<Laptop> startSet, Scanner scan) {
        System.out.println("Inout ID of the laptop");
        int inputID = scan.nextInt();
        for (Laptop comp: startSet) 
            if (comp.hashCode() == inputID)
                startSet.remove(comp);
        return startSet;
    }

    public static void findChoice(int k, Object f, int min, int max, HashSet<Laptop> startSet) {
        HashSet<Laptop> newSet = new HashSet<>();
        for (Laptop comp: startSet) {
            switch (k) {
                case 0:
                    if ((int) f == comp.id) 
                        newSet.add(comp);
                        continue;
                case 3:
                case 4:
                case 5:
                    if ((int) f >= min && (int) f <= max)
                        newSet.add(comp);
                        continue;
                case 1:
                    if ((String) f == comp.issuer)
                        newSet.add(comp);
                        continue;
                case 2:
                    if ((String) f == comp.screenType)
                        newSet.add(comp);
                        continue;
                case 6:
                    if ((String) f == comp.CPU)
                        newSet.add(comp);
                        continue;
                case 7:
                    if ((String) f == comp.videoCard)
                        newSet.add(comp);
                        continue;
                case 8:
                    if ((String) f == comp.os)
                        newSet.add(comp);
                        continue;
                case 9:
                    if ((String) f == comp.color)
                        newSet.add(comp);
                        continue;
            }
    }
        if (newSet.isEmpty())
            System.out.println("No laptops found");
        else
            for (Laptop comp: newSet)
                System.out.println(comp);
    }

    public static  void filtrationChoice(HashSet<Laptop> startSet, Scanner scan) {
        System.out.println("What filter would you like to add?\n0: od\n1: issuer\n2: screen type\n3: screen size\n4: RAM\n5: SSd size\n6: CPU\n7: video card\n8: operation system\n9: color");
        int k = scan.nextInt();
        generateOptions(startSet, k, scan);
    }

    public static void generateOptions(HashSet<Laptop> startSet, int k, Scanner scan) {
        HashMap<Integer, Object> choices = new HashMap<>();
        int i = 0;
        int min = 0;
        int max = 0;
        if (k == 3 || k == 4 || k == 5) {
            System.out.println("Input the minimal value");
            min = scan.nextInt();
            System.out.println("Input the maximial value");
            max = scan.nextInt();
        }
        for (Laptop comp: startSet) {
            System.out.println(comp);
            switch (k) {
                case 0:
                if (!choices.containsValue(comp.id)){
                    choices.put(i, comp.id);
                    i++;
                }
                    continue;    
                case 3:
                if (comp.screenSize >= min && comp.screenSize <= max)
                    if (!choices.containsValue(comp.screenSize)){
                        choices.put(i, comp.screenSize);
                        i++;
                    }
                        continue;
                case 4:
                if (comp.ram >= min && comp.ram <= max)
                    if (!choices.containsValue(comp.ram)){
                        choices.put(i, comp.ram);
                        i++;
                    }
                        continue;
                case 5:
                if (comp.ssdSize >= min && comp.ssdSize <= max)
                    if (!choices.containsValue(comp.ssdSize)){
                        choices.put(i, comp.ssdSize);
                        i++;
                    }
                        continue;
                case 1:
                if (!choices.containsValue(comp.issuer)){
                    choices.put(i, comp.issuer);
                    i++;
                }
                    continue;
                case 2:
                if (!choices.containsValue(comp.screenType)){
                    choices.put(i, comp.screenType);
                    i++;
                }
                    continue;
                case 6:
                if (!choices.containsValue(comp.CPU)){
                    choices.put(i, comp.CPU);
                    i++;
                }
                    continue;
                case 7:
                if (!choices.containsValue(comp.videoCard)){
                    choices.put(i, comp.videoCard);
                    i++;
                }
                    continue;
                case 8:
                if (!choices.containsValue(comp.os)){
                    choices.put(i, comp.os);
                    i++;
                }
                    continue;
                case 9:
                if (!choices.containsValue(comp.color)){
                    choices.put(i, comp.color);
                    i++;
                }
                    continue;
                }
            }
        Object filt = 1;
        if (max == 0) {
            System.out.println(choices + "\nWhich fliter would you like to add?");
            filt = choices.get(scan.nextInt());
        }
        findChoice(k, filt, min, max, startSet);
    }

    public static Laptop addLaptop(Scanner scan) {
        Laptop comp = new Laptop();
        System.out.println("Input id");
        comp.id = scan.nextInt();
        scan.nextLine();
        System.err.println("Input the issuer");
        comp.issuer = scan.nextLine();
        System.out.println("Input screen type");
        comp.screenType = scan.nextLine();
        System.out.println("Input screen size");
        comp.screenSize = scan.nextInt();
        System.out.println("Input ram");
        comp.ram = scan.nextInt();
        System.out.println("Input ssd size");
        comp.ssdSize = scan.nextInt();
        scan.nextLine();
        System.out.println("Input CPU");
        comp.CPU = scan.nextLine();
        System.out.println("Input video card");
        comp.videoCard = scan.nextLine();
        System.out.println("Input operating system");
        comp.os = scan.nextLine();
        System.out.println("Input color");
        comp.color = scan.nextLine();
        return comp;
    }
}

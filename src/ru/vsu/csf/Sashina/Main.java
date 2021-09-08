package ru.vsu.csf.Sashina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите массив целых чисел: ");
        String s = scan.nextLine();
        String [] str = s.split(" ");
        int [] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println();
        System.out.print("Введите номер k-го наименьшего элемента: ");
        int k = scan.nextInt();
        System.out.println("----------------------------------------------------");
        QuickSelect sort = new QuickSelect();
        System.out.print("k-ый наименьший элемент: " + sort.quickSelect(arr, 0, arr.length - 1, k));
    }
}

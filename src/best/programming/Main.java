package best.programming;

/* Exercise description

Napisać program, który tworzy dwuwymiarową tablicę liczb całkowitych o losowej wielkości (wylosowanej z
zakresu [10, 20]), gdzie liczba wierszy jest taka sama, jak liczba kolumn.
Następnie tablica zostaje uzupełniona liczbami losowymi z zakresu [-100, 100], z wyjątkiem elementów
znajdujących się na przekątnej tablicy, które w (losowo) ok. 50% przypadków otrzymują wartość 1, a w
pozostałych 50% przypadków wartość -1.
W wyniku działania programu należy wyświetlić na ekran:
• dwie największe liczby zapisane w tabeli,
• stosunek sumy liczb leżących w komórkach tablicy o parzystych indeksach wierszy i nieparzystych
indeksach kolumn,
• liczbę komórek, których wartość jest mniejsza od iloczynu indeksu wiesza i kolumny tej komórki.

Uwaga,
nie należy używać (importować) żadnych dodatkowych bibliotek, poza klasą niezbędną do obsługi losowania liczb.
*/

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int arraySize = random.nextInt(11) + 10;
        int [][] array = new int[arraySize][arraySize];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int evenRowSum = 0;
        int oddColSum = 0;

        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                if(i == j){
                    boolean element = random.nextBoolean();
                    if(element){
                        array[i][j] = 1;
                    } else {
                        array[i][j] = -1;
                    }
                } else {
                    int element = random.nextInt(201) - 100;
                    array[i][j] = element;
                }
                if(max1 < array[i][j]){
                    max2 = max1;
                    max1 = array[i][j];
                }
                if(max2 < array[i][j]){
                    max2 = array[i][j];
                }
                if(i % 2 == 0){
                    evenRowSum += array[i][j];
                }
                if(j % 2 == 1){
                    oddColSum += array[i][j];
                }
            }
        }

        for(int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }

        System.out.println("First max number: " + max1);
        System.out.println("Second max number: " + max2);
        System.out.println("Sum of values in even rows: " + evenRowSum);
        System.out.println("Sum of values in odd columns: " + oddColSum);
        System.out.println("The ratio of sumEvenRows to oddSumCol: " + evenRowSum * 1.0 / oddColSum);
    }
}

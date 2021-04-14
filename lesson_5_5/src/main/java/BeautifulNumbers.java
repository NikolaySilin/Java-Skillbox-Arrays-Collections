import java.util.*;

public class BeautifulNumbers {

    public static void main(String[] args) {

        numbers();

    }

    public static void numbers() {

        String[] letters = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У"};

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> sortedArrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>(arrayList);
        TreeSet<String> treeSet = new TreeSet<>(arrayList);

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < 199; k++) {
                    String letter = letters[i];
                    String region = String.valueOf(k);
                    if (k < 10) {
                        region = "0" + region;
                    }
                    String number = String.format("%s%d%d%d%s%s%s", letter, j, j, j, letter, letter, region);
                    arrayList.add(number);
                    sortedArrayList.add(number);
                    hashSet.add(number);
                    treeSet.add(number);

                }
            }
        }

        Collections.sort(sortedArrayList);

        System.out.println("Сгенерировано " + arrayList.size() + " красивых номеров");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер: ");
            String stateNumber = scanner.nextLine();
            long a = System.nanoTime();
            if (arrayList.contains(stateNumber)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            long b = System.nanoTime();
            if (Collections.binarySearch(sortedArrayList, stateNumber) >= 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            long c = System.nanoTime();
            if (hashSet.contains(stateNumber)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            long d = System.nanoTime();
            if (treeSet.contains(stateNumber)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            }
        }
    }
}

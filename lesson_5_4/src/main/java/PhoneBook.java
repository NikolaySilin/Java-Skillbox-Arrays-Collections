import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneBook {

    private static final String NOTICE = "Выберете действие и введите команду: " +
            "\nADD - добавить новый контакт " +
            "\nLIST - показать список уже имеющихся контактов" +
            "\nNAME - найти контакт по имени" +
            "\nDEL - удалить контакт";
    private static final String INCORRECT_NUMBER_PHONE = "Номер введен неверно, выбрасываю в начало цикла.\n";
    private static final String INCORRECT_NAME = "Имя введено неправильно, выбрасываю в начало цикла.\n";

    private static String name;
    private static String phone;
    private static String answer;

    public static void main(String[] args) {
        diary();
    }

    public static void diary() {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Коля", "89221309404");
        hashMap.put("Евгений", "89321305804");
        hashMap.put("Сергей", "89637772020");
        hashMap.put("Антон", "89828997003");

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        for (; ; ) {
            System.out.println(NOTICE);

            String command = scanner1.nextLine();

            if (command.equalsIgnoreCase("ADD")) {
                System.out.println("Вы выбрали добавление контакта" + "\nВведите имя:");
                name = scanner2.nextLine();
                if (checkingForAName(hashMap)) {
                    if (nameValidate(name)) {
                        System.out.println("Введите номер: ");
                        phone = scanner3.nextLine();
                        if (phoneValidate(phone)) {
                            if (checkingThePhoneNumber(hashMap)) {
                                hashMap.put(name, phone);
                                System.out.println("Вы ввели имя и номер телефона" +
                                        " желаете посмотреть список ?");
                                answer = scanner4.nextLine();
                                if (answer.equalsIgnoreCase("Да")) {
                                    printMap(hashMap);
                                }
                            }
                            if (!checkingThePhoneNumber(hashMap)) {
                                System.out.println("Такой номер уже существует");
                            }
                            hashMap.put(name, phone);
                            System.out.println("Вы ввели имя и номер телефона" +
                                    " желаете посмотреть список ?");
                            answer = scanner4.nextLine();
                            if (answer.equalsIgnoreCase("Да")) {
                                printMap(hashMap);
                            }
                        } else if (!phoneValidate(phone)) {
                            System.out.println(INCORRECT_NUMBER_PHONE);
                            continue;
                        }
                    } else if (!nameValidate(name)) {
                        System.out.println(INCORRECT_NAME);
                        continue;
                    }
                } else if (!checkingForAName(hashMap)) {
                    System.out.print("Такое имя уже существует, его номер: ");
                    printValue(hashMap);
                }
            } else if (command.equalsIgnoreCase("LIST")) {
                System.out.println("Список: ");
                printMap(hashMap);
            } else if (command.equalsIgnoreCase("NAME")) {
                System.out.println("введите имя:");
                name = scanner2.nextLine();
                if (!checkingForAName(hashMap)) {
                    System.out.println("Его(её) номер: ");
                    printValue(hashMap);
                }
            } else if (command.equalsIgnoreCase("DEL")) {
                printMap(hashMap);
                System.out.println("Введите имя контакта которого хотите удалить: ");
                name = scanner2.nextLine();
                if (!checkingForAName(hashMap)) {
                    removeValue(hashMap);
                    System.out.println("Контакт удален!");
                } else if (checkingForAName(hashMap)) {
                    System.out.print(INCORRECT_NAME);
                }
            }
        }
    }

    private static void removeValue(Map<String, String> hashMap) {
        hashMap.remove(name);
    }

    private static void printValue(Map<String, String> hashMap) {
        System.out.println(hashMap.get(name) + "\n");
    }

    private static void printMap(Map<String, String> hashMap) {

        for (String list : hashMap.keySet()) {

            System.out.println(list + " / " + hashMap.get(list));
        }
        System.out.println();
    }

    public static boolean checkingThePhoneNumber(Map<String, String> hashMap) {
        if (hashMap.containsValue(phone)) {
            return false;
        }
        return true;
    }

    public static boolean checkingForAName(Map<String, String> hashMap) {
        if (hashMap.containsKey(name)) {
            return false;
        }
        return true;
    }

    public static boolean nameValidate(String input) {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean phoneValidate(String input) {
        String regx = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3,4}\\)?[\\- ]?)?[\\d\\- ]{5,10}$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private static final String NOTICE = "Выберете действие и введите команду: " +
            "\nADD - добавить новый контакт " +
            "\nLIST - показать список уже имеющихся контактов" +
            "\nNAME - найти контакт по имени" +
            "\nEDIT - редактировать контакт" +
            "\nDEL - удалить контакт";

    private static final String INCORRECT_NUMBER_PHONE = "Номер введен неверно, выбрасываю в начало цикла.\n";
    private static final String INCORRECT_NAME = "Имя введено неправильно, выбрасываю в начало цикла.\n";
    private static final String PHONE_NUMBER = "Введите номер: ";
    private static final String CONTACT_NAME = "Введите имя: ";
    private static final String ENTERED_NAME_AND_PHONE = "Вы ввели имя и номер телефона" +
            " желаете посмотреть список ?";
    private static final String NUMBER_IS_REPEATED = "Такой номер уже существует, выбрасываю в начало цикла.\n";

    private static String name;
    private static String newname;
    private static String phone;
    private static String newphone;
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
                        System.out.println(PHONE_NUMBER);
                        phone = scanner3.nextLine();
                        if (phoneValidate(phone)) {
                            if (checkingThePhoneNumber(hashMap)) {
                                hashMap.put(name, phone);
                                System.out.println(ENTERED_NAME_AND_PHONE);
                                answer = scanner4.nextLine();
                                if (answer.equalsIgnoreCase("Да")) {
                                    printMap(hashMap);
                                }
                            }
                            if (!checkingThePhoneNumber(hashMap)) {
                                System.out.println(NUMBER_IS_REPEATED);
                                continue;
                            }
                            hashMap.put(name, phone);
                            System.out.println(ENTERED_NAME_AND_PHONE);
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
                System.out.println(CONTACT_NAME);
                name = scanner2.nextLine();
                if (!checkingForAName(hashMap)) {
                    System.out.println("Его(её) номер: ");
                    printValue(hashMap);
                }
            } else if (command.equalsIgnoreCase("EDIT")) {
                System.out.println("Введите имя контакта который хотите изменить: ");
                name = scanner2.nextLine();
                if (!checkingForAName(hashMap)) {
                    System.out.println("Контакт найден:");
                    printKeyAndValueByKey(hashMap);
                    System.out.println("Вы хотите изменить имя или номер ?");
                    answer = scanner3.nextLine();
                    if (answer.equalsIgnoreCase("Имя")) {
                        System.out.println(CONTACT_NAME);
                        newname = scanner4.nextLine();
                        if (!checkingForAName(hashMap)) {
                            System.out.println("Повторяешься))");
                        } else if (checkingForAName(hashMap)) {
                            setKey(hashMap);
                            System.out.println("Имя изменено!");
                            printKeyAndValueByNewKey(hashMap);
                        }
                    } else if (answer.equalsIgnoreCase("Номер")) {
                        System.out.println(PHONE_NUMBER);
                        newphone = scanner4.nextLine();
                        if (checkingThePhoneNumber(hashMap)) {
                            System.out.println(NUMBER_IS_REPEATED);
                        } else if (!checkingThePhoneNumber(hashMap)) {
                            setValue(hashMap);
                            System.out.println("Номер изменен!");
                        }
                    }
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

    private static void setKey(Map<String, String> map) {
        map.put(newname, map.remove(name));
    }

    private static void setValue(Map<String, String> map) {
        map.put(name, newphone);
    }


    private static void removeValue(Map<String, String> map) {
        map.remove(name);
    }

    private static void printKeyAndValueByNewKey(Map<String, String> map) {
        System.out.println(newname + " / " + map.get(newname) + "\n");
    }

    private static void printKeyAndValueByKey(Map<String, String> map) {
        System.out.println(name + " / " + map.get(name) + "\n");
    }

    private static void printValue(Map<String, String> map) {
        System.out.println(map.get(name) + "\n");
    }

    private static void printMap(Map<String, String> map) {

        for (String list : map.keySet()) {

            System.out.println(list + " / " + map.get(list));
        }
        System.out.println();
    }

    public static boolean checkingThePhoneNumber(Map<String, String> map) {
        if (map.containsValue(phone)) {
            return false;
        }
        return true;
    }

    public static boolean checkingForAName(Map<String, String> map) {
        if (map.containsKey(name)) {
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
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final String CHOOSE_COMMAND = "Выберете действие и введите команду: \nADD - добавить новый e-mail \nLIST - показать список уже имеющихся адресов";

    public static void main(String[] args)
    {
        treeSet();
    }

    public static void treeSet()
    {

        String commandInput;
        String emailInput;
        String response;

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("main@example.com");
        treeSet.add("sobaka@yandex.ru");
        treeSet.add("alpha@foxtrot.gov");
        treeSet.add("ex@caliber.com");
        treeSet.add("putin@yahoo.com");
        treeSet.add("medvedev@rambler.org");

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        System.out.println(CHOOSE_COMMAND);

        commandInput = scanner1.nextLine();

        if (commandInput.equalsIgnoreCase("ADD"))
        {
            System.out.println("Вы выбрали команду ADD, введите e-mail: ");
            emailInput = scanner2.nextLine();
            if (isValidEmail(emailInput) == false)
            {
                treeSet.add(emailInput);
                System.out.println("e-mail введен верно, и добавлен в список.");
                System.out.println("Хотите посмотреть список имеющихся e-mail адресов ?");
                response = scanner3.nextLine();
                if (response.equalsIgnoreCase("Да"))
                {
                    for (String list : treeSet)
                    {
                        System.out.println(list);
                    }
                }
                else if (response.equalsIgnoreCase("Нет"))
                {
                    System.out.println("Завершаю программу.");
                }
                else
                {
                    System.out.println("Команда введена неправильно, завершаю программу.");
                }
            }
            else
            {
                System.out.println("e-mail введен не верно, повторите попытку.");
            }
        }
        else if (commandInput.equalsIgnoreCase("LIST"))
        {
            for (String list : treeSet)
            {
                System.out.println(list);
            }
        }
    }

    static Pattern emailPattern = Pattern.compile("[a-zA-Z0-9[!#$%&'()*+,/\\-_\\.\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\"\\.]]+");
    public static boolean isValidEmail(String email)
    {
        Matcher m = emailPattern.matcher(email);
        return !m.matches();
    }
}

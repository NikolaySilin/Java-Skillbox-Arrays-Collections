package ru.geekbrains.nikolaysilin.task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String CHOOSE_ACTION_MESSAGE = "Выберите и введите одну из комманд: \nADD \nEDIT \nDELETE \nLIST";
    public static final String EXIT = "Завершаю работу программы";
    public static final String ATTENTION = "Важно помнить что индексы в списке начинаются с НУЛЯ!";


    public static void main(String[] args)
    {

        todoList();

    }

    public static void todoList()
    {
       ArrayList<String> todoList = new ArrayList<String>()
        {{
            add("Выкинуть мусор");
            add("Купить сыр");
            add("Помыть кота");
            add("Пропылесосить");
            add("Заправить машину");
            add("Выгулять собаку");
            add("Собрать малину");
        }};


        System.out.println(CHOOSE_ACTION_MESSAGE);

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        System.out.println("\nВведите комманду: ");

        String text = scanner1.nextLine();
        String dealTextInput;
        int dealNumberInput;
        String answerOfQuestion;

        loop: // я знаю что это плохо, но чет не додумался лучше сделать, еще не вечер, я еще научусь)
        if (text.equalsIgnoreCase("LIST"))
        {
            for(String list : todoList)
            {
                System.out.println(list);
            }
        }
        else if (text.equalsIgnoreCase("ADD"))
        {
            System.out.println("Вы хотите добавить по индексу ?");
            answerOfQuestion = scanner1.nextLine();
            if (answerOfQuestion.equalsIgnoreCase("Да"))
            {
                System.out.println(ATTENTION);
                System.out.print("Выберете индекс, в который хотите записать задачу: ");
                dealNumberInput = scanner2.nextInt();
                System.out.println("Вы выбрали индекс: " + dealNumberInput);
                System.out.println("Введите задачу которую хотите записать в индекс " + dealNumberInput);
                dealTextInput = scanner3.nextLine();
                todoList.add(dealNumberInput, dealTextInput);
                System.out.println("Вы успешно заменили задачу под индексом: " + dealNumberInput);
                System.out.println("Вам показать список задач?");
                answerOfQuestion = scanner4.nextLine();
                if (answerOfQuestion.equalsIgnoreCase("Да"))
                {
                    for(String list : todoList)
                    {
                        System.out.println(list);
                    }
                }
                else if(answerOfQuestion.equalsIgnoreCase("Нет"))
                {
                    break loop;
                }
            }
            else if(answerOfQuestion.equalsIgnoreCase("Нет"))
            {
                System.out.println("Введите задачу: ");
                dealTextInput = scanner1.nextLine();
                todoList.add(dealTextInput);
                System.out.println("Задача " + dealTextInput + " добавлена в конец списка");
                System.out.println("Вам показать список задач?");
                answerOfQuestion = scanner2.nextLine();
                if (answerOfQuestion.equalsIgnoreCase("Да"))
                {
                    for(String list : todoList)
                    {
                        System.out.println(list);
                    }
                }
                else if(answerOfQuestion.equalsIgnoreCase("Нет"))
                {
                    break loop;
                }
            }

        }
        else if (text.equalsIgnoreCase("EDIT"))
        {
            System.out.println(ATTENTION);
            System.out.print("Выберете индекс задачи, которую хотите изменить: ");
            dealNumberInput = scanner1.nextInt();
            System.out.println("Вы выбрали индекс: " + dealNumberInput);
            System.out.println("Введите задачу которую хотите записать в индекс " + dealNumberInput);
            dealTextInput = scanner2.nextLine();
            todoList.set(dealNumberInput, dealTextInput);
            System.out.println("Вы успешно заменили задачу под индексом: " + dealNumberInput);
            System.out.println("Хотите посмотреть измененный список задач ?");
            answerOfQuestion = scanner3.nextLine();
            if (answerOfQuestion.equalsIgnoreCase("Да"))
            {
                for(String list : todoList)
                {
                    System.out.println(list);
                }
            }
            else if(answerOfQuestion.equalsIgnoreCase("Нет"))
            {
                System.out.println();
                break loop;
            }
        }
        else if (text.equalsIgnoreCase("DELETE"))
        {
            System.out.print("Выберете индекс задачи, которую хотите удалить: ");
            dealNumberInput = scanner1.nextInt();
            System.out.println("Вы выбрали индекс: " + dealNumberInput);
            System.out.println("Вы уверены что хотите удалить задачу под индексом - " + dealNumberInput + " ?");
            answerOfQuestion = scanner2.nextLine();
            if (answerOfQuestion.equalsIgnoreCase("Да"))
            {
               todoList.remove(dealNumberInput);
            }
            else if(answerOfQuestion.equalsIgnoreCase("Нет"))
            {
                System.out.println(EXIT);
                break loop;
            }
            System.out.println("Хотите посмотреть измененный список задач ?");
            answerOfQuestion = scanner3.nextLine();
            if (answerOfQuestion.equalsIgnoreCase("Да"))
            {
                for(String list : todoList)
                {
                    System.out.println(list);
                }
            }
            else if(answerOfQuestion.equalsIgnoreCase("Нет"))
            {
                System.out.println(EXIT);
                break loop;
            }
        }
        else
        {
            System.out.println("Неправильно введена команда! Завершаю программу.");
        }

    }

}

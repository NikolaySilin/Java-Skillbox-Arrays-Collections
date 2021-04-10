package ru.geekbrains.nikolaysilin.task;

public class Main
{
    public static void main(String[] args)
    {
        //pheasant();
        //sick();
        ex();
    }

    public static void pheasant()
    {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+"); // Значение \\s - означает разделение по пробелам, \\s+ - от 1 пробела до бесконечности.
        // ,? - есть запятая или нету, для этого ставим вопросительный знак.

        for (int i = colors.length - 1; i >= 0; i--)
        {
            System.out.println(colors[i]);
        }
    }

    public static void sick()
    {
//        float maximumPatientTemperature = 40f;
//        float minimumPatientTemperature = 32f;
        float maximumTemperatureOfAHealthyPerson = 36.9f;
        float minimumTemperatureOfAHealthyPerson = 36.2f;

        float[] arraySick = {32.2f, 32.9f, 33.4f, 35.7f, 36.0f, 36.5f, 36.6f, 37.0f, 37.8f, 38.2f, 39.1f, 39.3f, 40.0f};

        System.out.print("Temperature of patients: ");
        for (int i = 0; i < arraySick.length; i++)
        {
            System.out.print(arraySick[i] + "  ");
        }

        float sum = 0;
        for (int i = 0; i < arraySick.length; i++)
        {
            sum = sum + arraySick[i];
        }

        float avgTemp = sum / arraySick.length;

        System.out.print("\nAverage temperature of patients: ");
        System.out.print(avgTemp);

        System.out.print("\nNumber of healthy patients: ");
        int n = 0;
        for (int i = 0; i < arraySick.length; i++)
        {
            if (arraySick[i] < maximumTemperatureOfAHealthyPerson && arraySick[i] > minimumTemperatureOfAHealthyPerson)
            {
                n++;
            }
        }
        System.out.println(n);
    }

    public static void ex()
    {
        int size = 8;
        char ex = 'x';

        char [][] arr = new char[size][size];

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (j == i || j == arr.length - 1 - i)
                {
                    arr[i][j] = ex;
                }
            }
        }

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}



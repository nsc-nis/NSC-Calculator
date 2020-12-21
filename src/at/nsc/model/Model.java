package at.nsc.model;

import java.util.ArrayList;

/**NSC Calculator - Model
 * @author Niklas Schachl
 * @version 1.4, 21.12.2020
 */
public class Model
{
    private static ArrayList<String> list_values = new ArrayList<String>();
    private static ArrayList<Double> list_numbers = new ArrayList<Double>();

    public static double calculate()
    {
        double result = 0;

        for (int i = 0; i < list_values.size(); i++)
        {
            String s = list_values.get(i);
            try
            {
                list_numbers.add(Double.parseDouble(s));
            }
            catch (Exception exception)
            {

            }
        }

        for (int j = 0; j < list_values.size(); j++)
        {
            String s = list_values.get(j);
            switch (s)
            {
                case "+":
                    result = plus(result);
                    break;
                case "-":
                    result = minus(result);
                    break;
                case "*":
                    result = multiply(result);
                    break;
                case "/":
                    result = divide(result);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void add(String operator)
    {
        list_values.add(operator);
    }

    private static double plus(double result)
    {
        for (int i = 0; i < list_numbers.size(); i++)
        {
            result = result + list_numbers.get(i);
        }
        return result;
    }

    private static double minus(double result)
    {
        for (int i = 0; i < list_numbers.size(); i++)
        {
            result = result - list_numbers.get(i);
        }
        return result;
    }

    private static double multiply(double result)
    {
        try
        {
            for (int i = 0; i < list_numbers.size(); i++)
            {
                result = list_numbers.get(i) * list_numbers.get(i+1);
            }
        }
        catch (Exception exception)
        {

        }
        return result;
    }

    private static double divide(double result)
    {
        try
        {
            for (int i = 0; i < list_numbers.size(); i++)
            {
                result = list_numbers.get(i) / list_numbers.get(i+1);
            }
        }
        catch (Exception exception)
        {

        }
        return result;
    }
}

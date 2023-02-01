import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String url = "https://lubart-miniatures.com/shop/page/7/";
        System.out.print("Введите число ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String result = Functions.increase(url, n);
        System.out.println(result);
        String[] urls = new String[]{"https://lubart-miniatures.com/shop/page/7/", "https://lubart-miniatures.com/shop/page/9/", "https://lubart-miniatures.com/shop/page/20/", "https://lubart-miniatures.com/shop/page/1/", "https://lubart-miniatures.com/shop/page/4/", "https://lubart-miniatures.com/shop/page/2/", "https://lubart-miniatures.com/shop/page/98/"};
        System.out.println(Arrays.toString(urls));
        System.out.println(Arrays.toString(Functions.evenNumbers(urls)));
    }
}


//https://lubart-miniatures.com/shop/page/7/
//Задача 1
//Написать функцию, которая инкрементирует значение последнего ендпоинта на N-ое кол-во и вовзвращает полученный результат
//Задача 2
//Написать тест, который будет проверять корректность работы данной функции. Учесть, что к ссылке могут добавляться query параметры. Входные данные должны обрабатываться одним методом.
//Задача 3
//Написать тест, который будет производить http запрос на этот url и проверять существование подобного типа страницы
//Задача 4
//написать функцию, которая на вход получает список ссылок подобного вида, и возвращает список только с четными значениями последнего ендпоинта остортированных от меньшего к большему. В списке не больше 20 элементов
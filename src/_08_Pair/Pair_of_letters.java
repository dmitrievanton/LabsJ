package _08_Pair;

public class Pair_of_letters {

    // Метод удаляет подряд идущие пары из строки
    //составим работу над строками через StringBuilder
    static String deletePairedLetters1(String input){

        if(input.length() <= 1){
            return input;
        }

        var result = new StringBuilder(input.length());

        for (int i = 1; i < input.length();)
        {
            if (input.charAt(i) == input.charAt(i - 1)){

                //если не находим пар - возвращаем строку
                if(i + 1 == input.length()){
                    return result.toString();
                }

                i+=2;
                //при увеличение индекса наступает конец строки - добавляем последний символ и возвращаем строку
                if(i >= input.length())
                {
                    result.append(input.charAt(i - 1));
                    return result.toString();
                }
                continue;
            }
            else
            {
                //не найдя дубликатов, добавляем последний символ в строку результата
                result.append(input.charAt(i - 1));
            }
            i++;
        }

        //ОБЯЗАТЕЛЬНО - последний символ в строке всегда добавляем в конец, если не вышли из функции по ветке дубликатов
        result.append(input.charAt(input.length() - 1));

        return result.toString();
    }
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collection_training {

    public static void main(String[] args) {

        // 1. Дана строка. При помощи HashMap сделать подсчет слов в строке (сколько каждое слово встречается в строке)

        String str = "I love java as like others java, to be java developer is great to be good";
        //избавляемся от всех знаков препинания и прочих символов, затем делим строку на слова
        String strWithoutPunctuationMarks = str.replaceAll("[^a-zA-Zа-яА-Я]", " ");
        String[] wordsArray = strWithoutPunctuationMarks.split("\\s+");
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < wordsArray.length; i++) {
            Integer counter = map.get(wordsArray[i]);
            map.put(wordsArray[i], (counter == null) ? 1 : (counter + 1));
            //слово - это ключ, а значение в map - это число раз, сколько это слово встечается
            // метод get возвращает null если ключ отсутствует, т.е. слово появилось впервые и value=1, а если не впервые - работает счетчик +1
        }
        System.out.println(map);

        // 2. Создать HashMap, содержащий пары значений: имя игрушки и объект класс игрушки (Product)
        //Перебрать и распечатать пары значений, набор из имен  и набор из значений продуктов. Для каждого из переборов создать свой метод

        Map<String, Product> toys = new HashMap<>();
        toys.put("Barbie", new Product("Doll"));
        toys.put("Lego", new Product("Constructor"));
        toys.put("Bear", new Product("SoftToy"));
//        System.out.println(toys.entrySet());
        printEntrySet(toys);
//        System.out.println(toys.keySet());
        printKeySet(toys);
//        System.out.println(toys.values());
        printValues(toys);

        // почему не доступна функция getName() применительно к Product? Как сделать, чтобы выводился только список имен объектов Product в Map?
        // например:
        // не [Product{name='Constructor'}, Product{name='Doll'}, Product{name='SoftToy'}]
        // а  ['Constructor', 'Doll', 'SoftToy']
        // т.е. вопрос в том, как сделать список значений любого из полей объектов в Map?


    }

    public static <K, V> void printEntrySet(Map<K, V> map) {
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        for (Map.Entry<K, V> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static <K, V> void printKeySet(Map<K, V> map) {
        for (K key : map.keySet()) {
            System.out.println(key);
        }
    }

    public static <K, V> void printValues(Map<K, V> map) {
        Iterator<V> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }


}


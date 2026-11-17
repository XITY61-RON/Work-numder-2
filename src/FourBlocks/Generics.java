package FourBlocks;

import java.io.File;
import java.util.*;

public class Generics {
    public static <T> List<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
    static class AnyArray<T> {
        private T[] array;
        public AnyArray(T[] array) {
            this.array = array;
        }
        public T[] getArray() {
            return array;
        }
    }
    public static <T> T getElementByIndex(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }
    public static void printFirstFiveFromDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Каталог не найден: " + dirPath);
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) return;

        List<File> fileList = new ArrayList<>(Arrays.asList(files));
        System.out.println("Первые 5 элементов в каталоге " + dirPath + ":");
        for (int i = 0; i < Math.min(5, fileList.size()); i++) {
            System.out.println("  " + fileList.get(i).getName());
        }
    }
    static class Solution {
        @SafeVarargs
        public static <T> List<T> newArrayList(T... elements) {
            return new ArrayList<>(Arrays.asList(elements));
        }
        @SafeVarargs
        public static <T> Set<T> newHashSet(T... elements) {
            return new HashSet<>(Arrays.asList(elements));
        }

        public static <K, V> Map<K, V> newHashMap(K key, V value) {
            Map<K, V> map = new HashMap<>();
            map.put(key, value);
            return map;
        }
    }
    public static void main(String[] args) {
        System.out.println("1: Array to List");
        Integer[] intArr = {1, 2, 3, 4};
        List<Integer> list1 = arrayToList(intArr);
        System.out.println(list1);

        String[] strArr = {"A", "B", "C"};
        List<String> list2 = arrayToList(strArr);
        System.out.println(list2);

        System.out.println("2: AnyArray");
        AnyArray<String> anyStr = new AnyArray<>(new String[]{"Hello", "World"});
        System.out.println(Arrays.toString(anyStr.getArray()));

        System.out.println("3: Get Element by Index");
        System.out.println("Element at 2: " + getElementByIndex(intArr, 2));

        System.out.println("4: Directory first 5 files");
        printFirstFiveFromDir(".");

        System.out.println("5: Solution Collection Methods");
        List<String> list = Solution.newArrayList("Apple", "Banana", "Cherry");
        System.out.println("ArrayList: " + list);

        Set<Integer> set = Solution.newHashSet(1, 2, 3, 2, 1);
        System.out.println("HashSet: " + set);

        Map<String, Integer> map = Solution.newHashMap("One", 1);
        System.out.println("HashMap: " + map);
    }
}

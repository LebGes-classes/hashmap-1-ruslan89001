public class Main {
    public static void main(String[] args) {
        Hash_Map<String, Integer> map = new Hash_Map<>();
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);
        System.out.println("Значение ключа 'два': " + map.get("два"));
        System.out.println("Содержит ли map ключ 'три': " + map.containsKey("три"));
        System.out.println("Размер map: " + map.size());
        map.remove("один");
        System.out.println("Размер map после удаления: " + map.size());
        System.out.println("Содержит ли map значение 2: " + map.containsValue(2));
    }
}
package arrayReverse;

class Country {
    String name;
    String lang;
    int population;
    int area;

    Country(String name, String lang, int population, int area) {
        this.name = name;
        this.lang = lang;
        this.population = population;
        this.area = area;
    }

    public String toString() {
        return "Name: " + name + ", Language: " + lang +
               ", Population: " + population + ", Area: " + area;
    }
}

public class HashTable {
    private Entry[] entries = new Entry[11];
    private int size;

    private class Entry {
        Object key, value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    public Object get(Object key) {
        int h = hash(key);
        if (entries[h] != null && entries[h].key.equals(key)) {
            return entries[h].value;
        }
        return null;
    }

    public void put(Object key, Object value) {
        int h = hash(key);
        entries[h] = new Entry(key, value);
        ++size;
    }

    public Object remove(Object key) {
        int h = hash(key);
        if (entries[h] != null && entries[h].key.equals(key)) {
            Object temp = entries[h].value;
            entries[h] = null;
            --size;
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable h1 = new HashTable();

        Country c1 = new Country("Pakistan", "Urdu", 2000000, 7860000);
        Country c2 = new Country("India", "Hindi", 2000000, 7860000);
        Country c3 = new Country("Syria", "Arabic", 2000000, 7860000);
        Country c4 = new Country("Egypt", "Arabic", 2000000, 7860000);
        Country c5 = new Country("Palestine", "Arabic", 2000000, 7860000);
        Country c6 = new Country("Iran", "Farsi", 2000000, 7860000);
        Country c7 = new Country("Turkey", "Turkish", 3000000, 9000000);
        Country c8 = new Country("China", "Mandarin", 5000000, 10000000);
        Country c9 = new Country("Japan", "Japanese", 2500000, 377975);
        Country c10 = new Country("Afghanistan", "Pashto", 1500000, 652000);

        h1.put("PK", c1);
        h1.put("IN", c2);
        h1.put("SY", c3);
        h1.put("EG", c4);
        h1.put("PS", c5);
        h1.put("IR", c6);
        h1.put("CN", c8);
        h1.put("JP", c9);
        h1.put("AF", c10);

        System.out.println(h1.get("PK"));
        System.out.println(h1.get("IN"));
        System.out.println(h1.get("SY")); // 🔴 yahan null aa sakta hai
        System.out.println(h1.get("EG"));
        System.out.println(h1.get("PS"));
        System.out.println(h1.get("IR"));
        System.out.println(h1.get("CN"));
        System.out.println(h1.get("JP"));
        System.out.println(h1.get("AF"));
        System.out.println("PK hash: " + "PK".hashCode()%11);
        System.out.println("IN hash: " + "IN".hashCode()%11);
        System.out.println("SY hash: " + "SY".hashCode()%11);
        System.out.println("EG hash: " + "EG".hashCode()%11);
        System.out.println("PS hash: " + "PS".hashCode()%11);
        System.out.println("IR hash: " + "IR".hashCode()%11);
        System.out.println("CN hash: " + "CN".hashCode()%11);
        System.out.println("JP hash: " + "JP".hashCode()%11);
        System.out.println("AF hash: " + "AF".hashCode()%11);

    }
}

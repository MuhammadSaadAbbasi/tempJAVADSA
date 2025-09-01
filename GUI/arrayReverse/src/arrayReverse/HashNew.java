package arrayReverse;


public class HashNew {
	
	private Entry[] entries;
	private int size,used;
	private float loadFactor;
	private final Entry NIL = new Entry(null,null);
	public HashNew(float loadFactor,int capacity) {
		entries =  new Entry[capacity];
		this.loadFactor=loadFactor;
	}
	public HashNew(int capacity) {
    	this(0.75F,capacity);
    }
	public HashNew() {
    	this(101);
    }
    private class Entry {
        Object key, value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    
    }
    private int hash(Object key) {
    	if(key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    public Object get(Object key) {
        int h = hash(key);
        for(int i = 0 ; i <entries.length;i++) {
        	int j = nextProbe(h,i);
        	Entry entry = entries[j];
        	if(entry == null)break;
        	if(entry == NIL)continue;
        	if(entry.key.equals(key)) return entry.value;
        }
        
        return null;
    }

    public Object put(Object key, Object value) {
    	if(used > loadFactor*entries.length)rehash();
        int h = hash(key);
        for(int i = 0 ; i <entries.length;i++) {
        	int j = nextProbe(h,i);
        	Entry entry = entries[j];
        	if(entry == null) {
        		entries[j] = new Entry(key,value);
        		++size;
        		++used;
        		return null;
        	}
        	if(entry==NIL)continue;
        	if(entry.key.equals(key)) {
        		Object oldVal= entry.value;
        		entries[j].value=value;
        		return oldVal;
        	}
        	
        }
        return null;
    }
    public Object hashTo(Object key) {
    	return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    public Object remove(Object key) {
    	int h = hash(key);
        for(int i = 0 ; i <entries.length;i++) {
        	int j = nextProbe(h,i);
        	Entry entry = entries[j];
        	if(entry == null)break;
        	if(entry == NIL)continue;
        	if(entry.key.equals(key)) {
        		Object oldVal= entry.value;
        		entries[j]=NIL;
        		--size;
        		return oldVal;
        	
        	}

        }
        return null;
    }
    private int nextProbe(int h , int i) {
    	return (h+i)%entries.length;
    }
    private void rehash() {
    	Entry oldEntries [] = entries;
    	entries = new Entry[2*oldEntries.length+1];
    	for(int k = 0;k <oldEntries.length; k++) {
    		Entry entry = oldEntries[k];
    		if(entry == null || entry == NIL)continue;
    		int h = hash(entry.key);
    		for(int i =0 ; i <entries.length ; i++) {
    			int j = nextProbe(h,i);
    			if(entries[j]==null) {
    				entries[j] = entry;
    				break;
    			}
    		}
    	}
    	used = size;
    }
    public static void main(String [] args) {
    	HashNew h = new HashNew();
        Object[][] countries = new Object[30][2]; // [key , Country]

        countries[0][0] = "PK";
        countries[0][1] = new Country("Pakistan", "Urdu", 240000000, 881913);

        countries[1][0] = "IN";
        countries[1][1] = new Country("India", "Hindi", 1400000000, 3287263);

        countries[2][0] = "CN";
        countries[2][1] = new Country("China", "Mandarin", 1410000000, 9596961);

        countries[3][0] = "US";
        countries[3][1] = new Country("United States", "English", 331000000, 9833517);

        countries[4][0] = "RU";
        countries[4][1] = new Country("Russia", "Russian", 144000000, 17098242);

        countries[5][0] = "BR";
        countries[5][1] = new Country("Brazil", "Portuguese", 213000000, 8515767);

        countries[6][0] = "JP";
        countries[6][1] = new Country("Japan", "Japanese", 126000000, 377975);

        countries[7][0] = "DE";
        countries[7][1] = new Country("Germany", "German", 83000000, 357022);

        countries[8][0] = "FR";
        countries[8][1] = new Country("France", "French", 67000000, 551695);

        countries[9][0] = "GB";
        countries[9][1] = new Country("United Kingdom", "English", 67000000, 243610);

        countries[10][0] = "IT";
        countries[10][1] = new Country("Italy", "Italian", 60000000, 301340);

        countries[11][0] = "ES";
        countries[11][1] = new Country("Spain", "Spanish", 47000000, 505990);

        countries[12][0] = "CA";
        countries[12][1] = new Country("Canada", "English/French", 38000000, 9984670);

        countries[13][0] = "AU";
        countries[13][1] = new Country("Australia", "English", 25000000, 7692024);

        countries[14][0] = "SA";
        countries[14][1] = new Country("Saudi Arabia", "Arabic", 35000000, 2149690);

        countries[15][0] = "IR";
        countries[15][1] = new Country("Iran", "Persian", 85000000, 1648195);

        countries[16][0] = "TR";
        countries[16][1] = new Country("Turkey", "Turkish", 85000000, 783562);

        countries[17][0] = "EG";
        countries[17][1] = new Country("Egypt", "Arabic", 104000000, 1002450);

        countries[18][0] = "ZA";
        countries[18][1] = new Country("South Africa", "Multiple", 60000000, 1221037);

        countries[19][0] = "NG";
        countries[19][1] = new Country("Nigeria", "English", 206000000, 923769);

        countries[20][0] = "MX";
        countries[20][1] = new Country("Mexico", "Spanish", 128000000, 1964375);

        countries[21][0] = "KR";
        countries[21][1] = new Country("South Korea", "Korean", 51000000, 100210);

        countries[22][0] = "ID";
        countries[22][1] = new Country("Indonesia", "Indonesian", 273000000, 1904569);

        countries[23][0] = "AR";
        countries[23][1] = new Country("Argentina", "Spanish", 45000000, 2780400);

        countries[24][0] = "BD";
        countries[24][1] = new Country("Bangladesh", "Bengali", 166000000, 148460);

        countries[25][0] = "TH";
        countries[25][1] = new Country("Thailand", "Thai", 70000000, 513120);

        countries[26][0] = "VN";
        countries[26][1] = new Country("Vietnam", "Vietnamese", 97000000, 331212);

        countries[27][0] = "MY";
        countries[27][1] = new Country("Malaysia", "Malay", 32000000, 330803);

        countries[28][0] = "PH";
        countries[28][1] = new Country("Philippines", "Filipino/English", 109000000, 300000);

        countries[29][0] = "IQ";
        countries[29][1] = new Country("Iraq", "Arabic", 40000000, 438317);

        for (int i = 0; i < countries.length; i++) {
            h.put(countries[i][0], countries[i][1]);
        }
        for (int i = 0; i < countries.length; i++) {
           System.out.println( h.get(countries[i][0]));
        }
        for (int i = 0; i < countries.length; i++) {
        	System.out.println(h.hashTo(countries[i][0]));
            }
        // Example: Print all
//        for (int i = 0; i < countries.length; i++) {
//            System.out.println(countries[i][0] + " -> " + countries[i][1]);
//        }

    }

}



/****************************************************************
 *
 * File: CSC220Dictionary.java
 * By: Jasmine Menjivar
 * Date: 11/14/25
 *
 * Description: This file is used by the "dictionaryDriver" class
 * to copy enum objects and store them in a multimap.
 *
 ****************************************************************/

package MyDictionary;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class CSC220Dictionary {
    private enum Entry {
        //objects
        BOOK_NOUN("Book", "A written work published in printed or electronic form."),
        BOOK_VERB("Book", "To arrange for someone to have a seat on a plane."),
        BOOKABLE("Bookable", "Can be ordered in advance."),
        BOOKCASE("Bookcase", "A piece of furniture with shelves."),
        BOOKBINDER("Bookbinder", "A person who fastens the pages of books."),
        CSC220_1("CSC220", "Data Structures."),
        CSC220_2("CSC220", "Ready to create complex data structures."),
        CSC220_3("CSC220", "To create data structures.");

        private String key;
        private String value;

        private Entry(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    //copies enum objects onto multimap for driver to access
    public Multimap<String, String> createMultimap (){
        Multimap <String, String> dictionary = ArrayListMultimap.create();

        for(Entry entry : Entry.values()){
            dictionary.put(entry.getKey(), entry.getValue());
        }

        return dictionary;
    }


}

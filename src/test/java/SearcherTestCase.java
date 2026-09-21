import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uem.insw.Searcher;

public class SearcherTestCase {
    Searcher searcher;

    @BeforeEach 
    public void setUp() {
        searcher = new Searcher();
    }

    @Test
    public void testSeachWord (){
        List <String> palabras = new ArrayList<>();
        palabras.add("Hola");
        palabras.add("Que");
        palabras.add("Tal");

        boolean resultado = searcher.searchWord("Hola", palabras);
        assertEquals(true, resultado);
        boolean resultado2 = searcher.searchWord("Adios", palabras);
        assertEquals(false, resultado2);
    }

    @Test 
    public void testgetWordByIndex(){
        List <String> palabras = new ArrayList<>();
        palabras.add("Hola");
        palabras.add("Que");
        palabras.add("Tal");

        String resultado = searcher.getWordByIndex(palabras, 0);
        assertEquals("Hola", resultado);
        String resultado2 = searcher.getWordByIndex(palabras, 3);
        assertEquals(null, resultado2);
    }

    @Test 
    public void searchByPrefix (){
        List <String> palabras = new ArrayList<>();
        palabras.add("Preentreno");
        palabras.add("Preparacion");
        palabras.add("Presentacion");
        palabras.add("Inmovil");
        palabras.add("Incapaz");

        List<String> resultado = searcher.searchByPrefix("Pre", palabras);
        assertEquals(3, resultado.size());
        List<String> resultado2 = searcher.searchByPrefix("On", palabras);
        assertEquals(0, resultado2.size());
    }

    @Test 
    public void TestFilterByKeyword () {
        List <String> palabras = new ArrayList<>();
        palabras.add("Leñador");
        palabras.add("Leña");
        palabras.add("Casa");

        List<String> resultado = searcher.filterByKeyword("Leña", palabras);
        assertEquals(2, resultado.size());
        List<String> resultado2 = searcher.filterByKeyword("Movil", palabras);
        assertEquals(0, resultado2.size());
    }

    @Test
    public void TestSearchExactPhrase (){
        List <String> frases = new ArrayList<>(); 
        frases.add("Hola, que tal?");
        frases.add("Me llamo Sara");
        frases.add("Me gusta jugar al LoL");

        boolean resultado = searcher.searchExactPhrase("Me gusta jugar al LoL", frases); 
        assertEquals(true, resultado);
        boolean resultado2 = searcher.searchExactPhrase("Me gustan mucho los helados", frases); 
        assertEquals(false, resultado2);
    }
}

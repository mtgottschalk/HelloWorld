
package helloworld;
import static kiss.API.*;

/**
 *
 * @author mtgottschalk
 */
public class HelloWorld {
    

    void testRun(){
        try (Close out = outExpect("Hello World!")){
            run();
        }
    }
    void run(){
        println("Hello World!");
    }
    void testConvert() {
        byte x = -1;
        assert x == (byte) 0b1111_1111;
        int y = x;
        assert y == -1;
    }

    void testLoops() {
        try (Close out = outExpect(0, EOL,1, EOL,2, EOL,3, EOL)){
            int n = 4;
            int i = 0;
            while (i < n) {
                if (i == 2){ ++i; continue;}
                println(i);
                i++;
            }
        }
        
        try (Close out = outExpect(0, EOL,1, EOL,2, EOL,3, EOL)){
            int n = 4;
            
           for (int i = 0 ; i < n; ++i) {
                if (i == 2){ continue;}
               println(i);
            }
        }
        
        String [] words = new String[] {"this", "that", "other"};
        assert words[0].equals("this");
        assert words[1].equals("that");
        assert words[2].equals("other");
        assert words.length ==3;
        
        String [] nouns = new String[2];
        assert nouns[0] == null;
        assert nouns[1] == null;
        assert words.length ==2;
        
        for (int i=0; i < words.length; ++i){
            println(words[i]);
        }
        
        for(String word : words){
            println(word);
        }
    }
    int instanceValue = 0;
    
    void methodExample() {
        int localValue = 0;
        ++instanceValue;
        ++localValue;
        println("instance : " + instanceValue);
        println("local : " + localValue);
    }
    
    long factorial(int n){
        if (n>1) {
            return n*factorial(n-1);
        } else{
            return 1;
        }
    }
    
    void testFunction() {
        methodExample();
        methodExample();
        methodExample();
        
        assert factorial(1)==1;
        assert factorial(5)==120;
    }
    void testString(){
        String hi = "hello";
        assert hi.length()==5;
        assert hi.substring(1,3).equals("el");
        
        hi = hi + " world";
        
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(" world");
        sb.append(" *");
        sb.append(13);
        String hw = sb.toString();
        
        println(hw);
    }
    void testClock(){
        Clock clock = test(new Clock());
    }
    
}

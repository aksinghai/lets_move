package OldTest;

import java.util.HashMap;
import java.util.Map;

class AA {
    int a;

    public AA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this);
        System.out.println("Called");
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("Hashcode "+ a);
        return a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}

public class EqualHashDemo {
    public static void main(String[] args) {
        Map<AA, Integer> map = new HashMap<>();
        AA AA1 = new AA(1);
        AA AA2 = new AA(2);
        AA AA3 = new AA(1);
        map.put(AA1, 1);
        map.put(AA2, 2);
        map.put(AA3, 3);
        System.out.println(map.get(AA1));
    }
}

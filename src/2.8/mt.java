/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class mt {
    public static List<Station> Ar = new ArrayList<Station>();
    public static List<Line> As = new ArrayList<Line>();
    public static int At = -1;
    public static int Au = -1;

    public static void Aw() {
        mrk.At();
    }

    public static class Station {
        public double x;
        public double z;
        public String name = "";
        public int color = -65536;
    }

    public static class Line {
        public int a;
        public int b;
    }
}

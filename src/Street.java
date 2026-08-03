/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Street {
    public List<double[]> points = new ArrayList<double[]>();
    public String name = "";
    public String cityMarker = "";

    public Street() {
    }

    public Street(List list, String string) {
        this.points = list;
        this.name = string;
    }

    public Street(List list, String string, String string2) {
        this.points = list;
        this.name = string;
        this.cityMarker = string2;
    }
}

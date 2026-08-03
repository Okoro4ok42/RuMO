/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Building {
    public int type;
    public double x;
    public double z;
    public String name = "";
    public String owner = "";
    public String address = "";
    public String houseNumber = "";
    public String info = "";
    public List<Resident> residents = new ArrayList<Resident>();
    public String cityMarker = "";

    public Building() {
    }

    public Building(int n, double d, double d2, String string) {
        this.type = n;
        this.x = d;
        this.z = d2;
        this.cityMarker = string;
    }

    public static class Resident {
        public String nick = "";
        public String apartment = "";

        public Resident() {
        }

        public Resident(String string, String string2) {
            this.nick = string;
            this.apartment = string2;
        }
    }
}

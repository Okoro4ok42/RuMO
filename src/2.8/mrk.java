/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.reflect.TypeToken
 *  net.minecraft.client.Minecraft
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import net.minecraft.client.Minecraft;

public class mrk {
    public static List<Entry> Ar = new ArrayList<Entry>();

    public static void As() {
        try {
            File file;
            File file2 = new File(Minecraft.cc(), "markers.json");
            if (file2.exists()) {
                file2.renameTo(new File(Minecraft.cc(), "rumo.json"));
            }
            if ((file = new File(Minecraft.cc(), "rumo.json")).exists()) {
                String string = new Scanner(file).useDelimiter("\\Z").next();
                if (string.contains("\"markers\"")) {
                    Gson gson = new Gson();
                    Data data = (Data)gson.fromJson(string, Data.class);
                    if (data != null) {
                        Ar = data.markers != null ? data.markers : new ArrayList<Entry>();
                        ArrayList arrayList = (ArrayList)Ar;
                        if (data.stations != null) {
                            mt.Ar = data.stations;
                        }
                        if (data.lines != null) {
                            mt.As = data.lines;
                        }
                        if (data.streets != null) {
                            dyn.cityStreets = new ArrayList<Street>(data.streets);
                        }
                        if (data.buildings != null) {
                            dyn.cityBuildings = new ArrayList<Building>(data.buildings);
                        }
                        if (data.citizens != null) {
                            dyn.cityCitizens = new ArrayList<Citizen>(data.citizens);
                        }
                        if (data.mayors != null) {
                            dyn.cityMayors = new HashMap<String, String>(data.mayors);
                        }
                        dyn.BH = data.showMetro;
                        dyn.BI = data.showMarkers;
                    }
                } else {
                    Gson gson = new Gson();
                    List list = (List)gson.fromJson(string, new TypeToken<List<Entry>>(){}.getType());
                    if (list != null) {
                        Ar = list;
                    }
                }
                mt.Aw();
            }
        }
        catch (Exception exception) {
            System.out.println("Markers: load error " + exception.getMessage());
        }
    }

    public static void At() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Data data = new Data();
            data.markers = Ar;
            data.stations = mt.Ar;
            data.lines = mt.As;
            data.streets = dyn.cityStreets;
            data.buildings = dyn.cityBuildings;
            data.citizens = dyn.cityCitizens;
            data.mayors = dyn.cityMayors;
            data.showMetro = dyn.BH;
            data.showMarkers = dyn.BI;
            FileWriter fileWriter = new FileWriter(new File(Minecraft.cc(), "rumo.json"));
            gson.toJson((Object)data, (Appendable)fileWriter);
            fileWriter.close();
        }
        catch (Exception exception) {
            System.out.println("Markers: save error " + exception.getMessage());
        }
    }

    public static void Au(String string) {
        try {
            block22: {
                Gson gson;
                block21: {
                    Object object;
                    int n;
                    boolean bl;
                    gson = new Gson();
                    if (!string.contains("\"markers\"")) break block21;
                    Data data = (Data)gson.fromJson(string, Data.class);
                    if (data == null) break block22;
                    if (data.markers != null) {
                        for (Entry object2 : data.markers) {
                            bl = false;
                            for (n = Ar.size() - 1; n >= 0; --n) {
                                object = Ar.get(n);
                                if (!(Math.abs(((Entry)object).x - object2.x) < 1.0) || !(Math.abs(((Entry)object).z - object2.z) < 1.0)) continue;
                                Ar.set(n, object2);
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            Ar.add(object2);
                        }
                    }
                    if (data.stations != null) {
                        for (mt.Station station : data.stations) {
                            bl = false;
                            for (n = mt.Ar.size() - 1; n >= 0; --n) {
                                object = mt.Ar.get(n);
                                if (!(Math.abs(((mt.Station)object).x - station.x) < 1.0) || !(Math.abs(((mt.Station)object).z - station.z) < 1.0)) continue;
                                mt.Ar.set(n, station);
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            mt.Ar.add(station);
                        }
                    }
                    if (data.lines != null) {
                        mt.As.addAll(data.lines);
                    }
                    if (data.streets != null) {
                        for (Street street : data.streets) {
                            bl = false;
                            for (n = 0; n < dyn.cityStreets.size(); ++n) {
                                object = dyn.cityStreets.get(n);
                                if (!((Street)object).name.equals(street.name) || !((Street)object).cityMarker.equals(street.cityMarker)) continue;
                                dyn.cityStreets.set(n, street);
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            dyn.cityStreets.add(street);
                        }
                    }
                    if (data.buildings != null) {
                        for (Building building : data.buildings) {
                            bl = false;
                            for (n = 0; n < dyn.cityBuildings.size(); ++n) {
                                object = dyn.cityBuildings.get(n);
                                if (!(Math.abs(((Building)object).x - building.x) < 1.0) || !(Math.abs(((Building)object).z - building.z) < 1.0) || !((Building)object).cityMarker.equals(building.cityMarker)) continue;
                                dyn.cityBuildings.set(n, building);
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            dyn.cityBuildings.add(building);
                        }
                    }
                    if (data.citizens != null) {
                        for (Citizen citizen : data.citizens) {
                            bl = false;
                            for (n = 0; n < dyn.cityCitizens.size(); ++n) {
                                object = dyn.cityCitizens.get(n);
                                if (!((Citizen)object).name.equals(citizen.name) || !((Citizen)object).cityMarker.equals(citizen.cityMarker)) continue;
                                dyn.cityCitizens.set(n, citizen);
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            dyn.cityCitizens.add(citizen);
                        }
                    }
                    if (data.mayors == null) break block22;
                    dyn.cityMayors.putAll(data.mayors);
                    break block22;
                }
                List list = (List)gson.fromJson(string, new TypeToken<List<Entry>>(){}.getType());
                if (list != null) {
                    for (Object e : list) {
                        Entry entry = (Entry)e;
                        boolean bl = false;
                        for (Entry entry2 : Ar) {
                            if (!(Math.abs(entry2.x - entry.x) < 1.0) || !(Math.abs(entry2.z - entry.z) < 1.0)) continue;
                            bl = true;
                            break;
                        }
                        if (bl) continue;
                        Ar.add(entry);
                    }
                }
            }
            mrk.At();
            mt.Aw();
        }
        catch (Exception exception) {
            System.out.println("Markers: import error " + exception.getMessage());
        }
    }

    private static class Data {
        List<Entry> markers = new ArrayList<Entry>();
        List<mt.Station> stations = new ArrayList<mt.Station>();
        List<mt.Line> lines = new ArrayList<mt.Line>();
        List<Street> streets = new ArrayList<Street>();
        List<Building> buildings = new ArrayList<Building>();
        List<Citizen> citizens = new ArrayList<Citizen>();
        Map<String, String> mayors = new HashMap<String, String>();
        boolean showMetro = true;
        boolean showMarkers = true;

        private Data() {
        }
    }

    public static class Entry {
        public double x;
        public double z;
        public String name = "";
        public String desc = "";
        public int color = -65536;
        public int importance = 0;
        public boolean isStation = false;
        public String stName = "";
    }
}

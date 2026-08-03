/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

private static class mrk.Data {
    List<mrk.Entry> markers = new ArrayList<mrk.Entry>();
    List<mt.Station> stations = new ArrayList<mt.Station>();
    List<mt.Line> lines = new ArrayList<mt.Line>();
    List<Street> streets = new ArrayList<Street>();
    List<Building> buildings = new ArrayList<Building>();
    List<Citizen> citizens = new ArrayList<Citizen>();
    Map<String, String> mayors = new HashMap<String, String>();
    boolean showMetro = true;
    boolean showMarkers = true;

    private mrk.Data() {
    }
}

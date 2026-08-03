/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  rd
 */
import java.util.ArrayList;
import java.util.List;

public class mtl
extends kc {
    private kc Aa;
    private int Ab = 0;
    private boolean Ac = false;
    private List<Integer> filteredIndices = new ArrayList<Integer>();
    private String searchText = "";
    private boolean searchFocused = false;

    public mtl(kc kc2) {
        this.Aa = kc2;
    }

    private static String strip(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7' || c == '\u00a7') {
                ++i;
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString().toLowerCase();
    }

    private void rebuildFilter() {
        this.filteredIndices.clear();
        String string = mtl.strip(this.searchText);
        for (int i = 0; i < mt.Ar.size(); ++i) {
            mt.Station station = mt.Ar.get(i);
            if (!string.isEmpty() && !mtl.strip(station.name).contains(string)) continue;
            this.filteredIndices.add(i);
        }
    }

    public void aQ() {
        this.rebuildFilter();
        int n = Math.max(1, (this.filteredIndices.size() + 3) / 4);
        if (this.Ab >= n) {
            this.Ab = Math.max(0, n - 1);
        }
        if (this.Ab < 0) {
            this.Ab = 0;
        }
        this.rU.clear();
        if (this.Ab > 0) {
            this.rU.add(new jt(10, this.width / 2 - 60, this.height - 24, 20, 20, "<"));
        }
        this.rU.add(new jt(0, this.width / 2 - 30, this.height - 24, 60, 20, rd.gH().al("rumo.back")));
        if (this.Ab < n - 1) {
            this.rU.add(new jt(11, this.width / 2 + 40, this.height - 24, 20, 20, ">"));
        }
    }

    protected void a(jt jt2) {
        if (this.Ac) {
            return;
        }
        this.Ac = true;
        if (jt2.id == 0) {
            this.qI.a(this.Aa);
        }
        if (jt2.id == 10) {
            --this.Ab;
            this.aQ();
        }
        if (jt2.id == 11) {
            ++this.Ab;
            this.aQ();
        }
        this.Ac = false;
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.qI.a(this.Aa);
            return;
        }
        if (this.searchFocused) {
            if (n == 14 || n == 211) {
                if (this.searchText.length() > 0) {
                    this.searchText = this.searchText.substring(0, this.searchText.length() - 1);
                }
                this.Ab = 0;
                this.rebuildFilter();
                return;
            }
            if (c >= ' ' && this.searchText.length() < 30) {
                this.searchText = this.searchText + c;
                this.Ab = 0;
                this.rebuildFilter();
            }
        }
    }

    protected void h(int n, int n2, int n3) {
        int n4;
        super.h(n, n2, n3);
        if (n3 != 0) {
            return;
        }
        int n5 = 4;
        boolean bl = this.searchFocused = n >= this.width / 2 - 100 && n < this.width / 2 + 100 && n2 >= n5 && n2 < n5 + 14;
        if (this.searchFocused) {
            return;
        }
        for (int i = n4 = this.Ab * 4; i < this.filteredIndices.size() && i < n4 + 4; ++i) {
            int n6 = this.filteredIndices.get(i);
            mt.Station station = mt.Ar.get(n6);
            int n7 = 36 + (i - n4) * 38;
            if (n >= this.width / 2 + 63 && n < this.width / 2 + 90 && n2 >= n7 + 20 && n2 < n7 + 32) {
                coord.Ar = station.x;
                coord.As = station.z;
                this.qI.a((kc)new dyn());
                return;
            }
            if (n >= this.width / 2 + 97 && n < this.width / 2 + 130 && n2 >= n7 + 20 && n2 < n7 + 32) {
                this.qI.a((kc)new mte(station, n6, (kc)this));
                return;
            }
            if (n < this.width / 2 + 135 || n >= this.width / 2 + 165 || n2 < n7 + 20 || n2 >= n7 + 32) continue;
            mt.Ar.remove(n6);
            mt.Aw();
            this.aQ();
            return;
        }
    }

    public void a(int n, int n2, float f) {
        this.dj();
        this.rebuildFilter();
        int n3 = this.Ab * 4;
        int n4 = this.filteredIndices.size();
        int n5 = Math.max(1, (n4 + 3) / 4);
        int n6 = 4;
        this.d(this.width / 2 - 100, n6, this.width / 2 + 100, n6 + 14, this.searchFocused ? -1342177281 : -1610612736);
        String string = this.searchText + (this.searchFocused && System.currentTimeMillis() % 1000L < 500L ? "_" : "");
        this.b(this.pX, rd.gH().al("rumo.search") + " " + string, this.width / 2 - 96, n6 + 2, 0xE0E0E0);
        this.a(this.pX, rd.gH().al("rumo.stationsList") + " (" + n4 + ")" + (n5 > 1 ? " " + rd.gH().al("rumo.page") + " " + (this.Ab + 1) + "/" + n5 : ""), this.width / 2, n6 + 18, 0xFFFFFF);
        for (int i = n3; i < n4 && i < n3 + 4; ++i) {
            int n7 = this.filteredIndices.get(i);
            mt.Station station = mt.Ar.get(n7);
            int n8 = 36 + (i - n3) * 38;
            this.d(this.width / 2 - 160, n8, this.width / 2 + 160, n8 + 36, -1610612736);
            this.d(this.width / 2 - 160, n8 + 36, this.width / 2 + 160, n8 + 37, -1342177281);
            this.b(this.pX, "\u00a7l" + station.name, this.width / 2 - 150, n8 + 2, station.color);
            this.b(this.pX, "X:" + (int)station.x + " Z:" + (int)station.z, this.width / 2 - 150, n8 + 14, 0x808080);
            this.b(this.pX, rd.gH().al("rumo.go"), this.width / 2 + 67, n8 + 24, 0xE0E0E0);
            this.b(this.pX, rd.gH().al("rumo.edit"), this.width / 2 + 100, n8 + 24, 0xE0E0E0);
            this.b(this.pX, rd.gH().al("rumo.del"), this.width / 2 + 135, n8 + 24, -23296);
        }
        if (n4 == 0) {
            this.b(this.pX, rd.gH().al("rumo.emptyList"), this.width / 2 - 20, 40, 0x808080);
        }
        super.a(n, n2, f);
    }
}

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

public class sli
extends kc {
    private kc Aa;
    private int Ab;
    private List<Integer> filteredIndices = new ArrayList<Integer>();
    private String searchText = "";
    private boolean searchFocused = false;

    public sli(kc kc2) {
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
        String string = sli.strip(this.searchText);
        for (int i = 0; i < dyn.cityStreets.size(); ++i) {
            Street street = dyn.cityStreets.get(i);
            if (!street.cityMarker.equals(dyn.cityActiveName) || !string.isEmpty() && !sli.strip(street.name).contains(string)) continue;
            this.filteredIndices.add(i);
        }
    }

    public void aQ() {
        this.rU.clear();
        this.rebuildFilter();
        int n = this.filteredIndices.size();
        int n2 = Math.max(1, (n + 3) / 4);
        if (this.Ab >= n2) {
            this.Ab = n2 - 1;
        }
        if (this.Ab < 0) {
            this.Ab = 0;
        }
        this.rU.add(new jt(100, this.width / 2 - 54, this.height - 28, 20, 20, "<"));
        this.rU.add(new jt(101, this.width / 2 - 26, this.height - 28, 20, 20, ">"));
        this.rU.add(new jt(102, this.width / 2 + 4, this.height - 28, 50, 20, rd.gH().al("rumo.back")));
    }

    public void dO() {
    }

    protected void a(jt jt2) {
        if (jt2.id == 100 && this.Ab > 0) {
            --this.Ab;
            this.aQ();
        }
        if (jt2.id == 101) {
            ++this.Ab;
            this.aQ();
        }
        if (jt2.id == 102) {
            if (this.Aa instanceof dyn) {
                ((dyn)this.Aa).aQ();
            }
            this.qI.a(this.Aa);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            if (this.Aa instanceof dyn) {
                ((dyn)this.Aa).aQ();
            }
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
        super.h(n, n2, n3);
        if (n3 != 0) {
            return;
        }
        int n4 = 30;
        boolean bl = this.searchFocused = n >= 4 && n < this.width - 4 && n2 >= n4 && n2 < n4 + 14;
        if (this.searchFocused) {
            return;
        }
        int n5 = this.filteredIndices.size();
        for (int i = 0; i < 4 && this.Ab * 4 + i < n5; ++i) {
            int n6 = this.Ab * 4 + i;
            int n7 = 44 + i * 34;
            int n8 = this.filteredIndices.get(n6);
            Street street = dyn.cityStreets.get(n8);
            if (n >= this.width - 80 && n < this.width - 50 && n2 >= n7 + 16 && n2 < n7 + 28) {
                if (!street.points.isEmpty()) {
                    double d = 0.0;
                    double d2 = 0.0;
                    for (double[] dArray : street.points) {
                        d += dArray[0];
                        d2 += dArray[1];
                    }
                    dyn.goTargetX = d / (double)street.points.size();
                    dyn.goTargetZ = d2 / (double)street.points.size();
                }
                if (this.Aa instanceof dyn) {
                    ((dyn)this.Aa).aQ();
                }
                this.qI.a(this.Aa);
                return;
            }
            if (n >= this.width - 48 && n < this.width - 18 && n2 >= n7 + 16 && n2 < n7 + 28) {
                dyn.cityEditingStreetIdx = n8;
                this.qI.a((kc)new str(this.Aa));
                return;
            }
            if (n < this.width - 16 || n >= this.width || n2 < n7 + 16 || n2 >= n7 + 28) continue;
            dyn.cityStreets.remove(n8);
            mrk.At();
            this.aQ();
            return;
        }
    }

    private static double streetLength(Street street) {
        double d = 0.0;
        for (int i = 1; i < street.points.size(); ++i) {
            double d2 = street.points.get(i)[0] - street.points.get(i - 1)[0];
            double d3 = street.points.get(i)[1] - street.points.get(i - 1)[1];
            d += Math.sqrt(d2 * d2 + d3 * d3);
        }
        return d;
    }

    public void a(int n, int n2, float f) {
        int n3;
        int n4 = this.filteredIndices.size();
        int n5 = Math.max(1, (n4 + 3) / 4);
        int n6 = 30;
        boolean bl = n >= 4 && n < this.width - 4 && n2 >= n6 && n2 < n6 + 14;
        this.d(4, n6, this.width - 4, n6 + 14, this.searchFocused ? -1342177281 : -1610612736);
        String string = this.searchText + (this.searchFocused && System.currentTimeMillis() % 1000L < 500L ? "_" : "");
        this.b(this.pX, rd.gH().al("rumo.search") + " " + string, 8, n6 + 2, 0xE0E0E0);
        this.a(this.pX, rd.gH().al("rumo.streetsList") + " (" + n4 + ") " + rd.gH().al("rumo.page") + " " + (this.Ab + 1) + "/" + n5, 4, 4, 0xFFFFFF);
        this.d(2, 42, this.width - 2, 44 + Math.min(n4 - this.Ab * 4, 4) * 34 + 10, -1610612736);
        for (int i = 0; i < 4 && (n3 = this.Ab * 4 + i) < n4; ++i) {
            int n7 = this.filteredIndices.get(n3);
            Street street = dyn.cityStreets.get(n7);
            int n8 = 44 + i * 34;
            boolean bl2 = n >= 4 && n < this.width - 84 && n2 >= n8 && n2 < n8 + 30;
            this.d(4, n8, this.width - 84, n8 + 30, bl2 ? -1342177281 : -1610612736);
            this.b(this.pX, street.name, 8, n8 + 2, 0xE0E0E0);
            double d = sli.streetLength(street);
            this.b(this.pX, String.format("%.0f m", d), 8, n8 + 14, 0x808080);
            boolean bl3 = n >= this.width - 80 && n < this.width - 50 && n2 >= n8 + 16 && n2 < n8 + 28;
            boolean bl4 = n >= this.width - 48 && n < this.width - 18 && n2 >= n8 + 16 && n2 < n8 + 28;
            boolean bl5 = n >= this.width - 16 && n < this.width && n2 >= n8 + 16 && n2 < n8 + 28;
            this.b(this.pX, rd.gH().al("rumo.go"), this.width - 78, n8 + 18, bl3 ? 0x55FF55 : 0x808080);
            this.b(this.pX, rd.gH().al("rumo.edit"), this.width - 46, n8 + 18, bl4 ? 0xFFFF55 : 0x808080);
            this.b(this.pX, " X", this.width - 14, n8 + 18, bl5 ? -65536 : 0x808080);
        }
        if (n4 == 0) {
            this.b(this.pX, rd.gH().al("rumo.emptyList"), 4, 44, 0x808080);
        }
        super.a(n, n2, f);
    }
}

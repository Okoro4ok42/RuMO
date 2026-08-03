/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  rd
 */
import java.util.ArrayList;

public class str
extends kc {
    private String Aa = "";
    private String oldStreetName = "";
    private kc Ac;

    public str(kc kc2) {
        this.Ac = kc2;
        if (dyn.cityEditingStreetIdx >= 0 && dyn.cityEditingStreetIdx < dyn.cityStreets.size()) {
            Street street = dyn.cityStreets.get(dyn.cityEditingStreetIdx);
            this.Aa = street.name;
            this.oldStreetName = street.name;
            dyn.cityStreetPoints.clear();
            dyn.cityStreetPoints.addAll(street.points);
        }
    }

    public void aQ() {
        this.rU.clear();
        this.rU.add(new jt(100, this.width / 2 - 50, this.height / 2 + 24, 50, 20, rd.gH().al("rumo.save")));
        this.rU.add(new jt(101, this.width / 2 + 4, this.height / 2 + 24, 50, 20, rd.gH().al("rumo.cancel")));
    }

    public void dO() {
    }

    protected void a(jt jt2) {
        if (jt2.id == 100) {
            if (!this.Aa.isEmpty() && dyn.cityStreetPoints.size() >= 2) {
                if (dyn.cityEditingStreetIdx >= 0 && dyn.cityEditingStreetIdx < dyn.cityStreets.size()) {
                    Street street = dyn.cityStreets.get(dyn.cityEditingStreetIdx);
                    String string = street.name;
                    street.name = this.Aa;
                    street.points = new ArrayList<double[]>(dyn.cityStreetPoints);
                    if (!string.isEmpty() && !string.equals(this.Aa)) {
                        for (Building building : dyn.cityBuildings) {
                            if (!building.address.equals(string)) continue;
                            building.address = this.Aa;
                        }
                    }
                } else {
                    Street street = new Street(new ArrayList<double[]>(dyn.cityStreetPoints), this.Aa, dyn.cityActiveName);
                    dyn.cityStreets.add(street);
                }
                mrk.At();
            }
            dyn.cityStreetPoints.clear();
            dyn.cityEditingStreetIdx = -1;
            this.qI.a(this.Ac);
        }
        if (jt2.id == 101) {
            dyn.cityStreetPoints.clear();
            dyn.cityEditingStreetIdx = -1;
            this.qI.a(this.Ac);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            dyn.cityStreetPoints.clear();
            this.qI.a(this.Ac);
            return;
        }
        if (n == 14 || n == 211) {
            if (this.Aa.length() > 0) {
                this.Aa = this.Aa.substring(0, this.Aa.length() - 1);
            }
            return;
        }
        if (c >= ' ') {
            this.Aa = this.Aa + c;
        }
    }

    public void a(int n, int n2, float f) {
        this.a(this.pX, rd.gH().al("rumo.streetName"), this.width / 2 - this.pX.aD(rd.gH().al("rumo.streetName")) / 2, this.height / 2 - 16, 0xFFFFFF);
        this.d(this.width / 2 - 52, this.height / 2 - 4, this.width / 2 + 52, this.height / 2 + 12, -1610612736);
        String string = this.Aa + (System.currentTimeMillis() % 1000L < 500L ? "_" : "");
        this.b(this.pX, string, this.width / 2 - 50, this.height / 2, 0xE0E0E0);
        super.a(n, n2, f);
    }
}

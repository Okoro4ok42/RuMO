/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  org.lwjgl.input.Keyboard
 *  rd
 */
import org.lwjgl.input.Keyboard;

public class mte
extends kc {
    private String Aa = "";
    private String Ab = "";
    private String Ac = "";
    private int Ad = -1;
    private kc Ae;
    private boolean Af = false;
    private int Ag = -1;
    private int Ah = -1;

    public mte(double d, double d2) {
        this.Aa = String.valueOf((int)d);
        this.Ab = String.valueOf((int)d2);
    }

    public mte(double d, double d2, kc kc2) {
        this(d, d2);
        this.Ae = kc2;
        this.Af = true;
    }

    public mte(double d, double d2, int n, kc kc2) {
        this(d, d2);
        this.Ad = n;
        this.Ae = kc2;
    }

    public mte(mt.Station station, int n, kc kc2) {
        this.Aa = String.valueOf((int)station.x);
        this.Ab = String.valueOf((int)station.z);
        this.Ac = station.name;
        this.Ag = n;
        this.Ae = kc2;
        this.Af = true;
    }

    public mte(double d, double d2, int n, kc kc2, int n2) {
        this(d, d2, n, kc2);
        this.Ah = n2;
    }

    public void aQ() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.rU.add(new jt(1, this.width / 2 + 4, this.height - 30, 80, 20, this.Ag >= 0 ? rd.gH().al("rumo.save") : rd.gH().al("rumo.create")));
        this.rU.add(new jt(0, this.width / 2 - 84, this.height - 30, 80, 20, rd.gH().al("rumo.cancel")));
    }

    public void dO() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    protected void a(jt jt2) {
        if (jt2.id == 1) {
            try {
                if (this.Ag >= 0 && this.Ag < mt.Ar.size()) {
                    mt.Station station = mt.Ar.get(this.Ag);
                    station.name = this.Ac.isEmpty() ? "Station" + (this.Ag + 1) : this.Ac;
                } else {
                    mt.Line line;
                    mt.Station station = new mt.Station();
                    station.x = Double.parseDouble(this.Aa);
                    station.z = Double.parseDouble(this.Ab);
                    station.name = this.Ac.isEmpty() ? "Station" + (mt.Ar.size() + 1) : this.Ac;
                    mt.Ar.add(station);
                    int n = mt.Ar.size() - 1;
                    if (this.Ah >= 0 && this.Ah < mt.As.size()) {
                        line = mt.As.get(this.Ah);
                        int n2 = line.a;
                        int n3 = line.b;
                        mt.As.remove(this.Ah);
                        mt.Line line2 = new mt.Line();
                        line2.a = n2;
                        line2.b = n;
                        mt.As.add(line2);
                        mt.Line line3 = new mt.Line();
                        line3.a = n;
                        line3.b = n3;
                        mt.As.add(line3);
                    }
                    if (this.Ad >= 0 && this.Ad < mt.Ar.size() - 1) {
                        line = new mt.Line();
                        line.a = this.Ad;
                        line.b = n;
                        mt.As.add(line);
                    }
                    if (!this.Af) {
                        coord.Ar = station.x;
                        coord.As = station.z;
                    }
                }
                mt.Aw();
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (this.Af) {
                this.qI.a((kc)(this.Ae != null ? this.Ae : new dyn()));
            } else {
                this.qI.a((kc)new dyn());
            }
        } else {
            coord.Ar = Double.NaN;
            coord.As = Double.NaN;
            this.qI.a((kc)(this.Ae != null ? this.Ae : new dyn()));
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            coord.Ar = Double.NaN;
            coord.As = Double.NaN;
            this.qI.a((kc)(this.Ae != null ? this.Ae : new dyn()));
            return;
        }
        if (n == 14 && this.Ac.length() > 0) {
            this.Ac = this.Ac.substring(0, this.Ac.length() - 1);
        }
        if (c >= ' ' && this.Ac.length() < 40) {
            this.Ac = this.Ac + c;
        }
    }

    public void a(int n, int n2, float f) {
        this.dj();
        this.a(this.pX, this.Ag >= 0 ? rd.gH().al("rumo.editStation") : rd.gH().al("rumo.newStation"), this.width / 2, 20, 0xFFFFFF);
        int n3 = this.width / 2 - 100;
        this.b(this.pX, rd.gH().al("rumo.name"), n3, 50, 0xA0A0A0);
        this.d(n3 - 1, 45, n3 + 200 + 1, 63, -6250336);
        this.d(n3, 46, n3 + 200, 62, -16777216);
        String string = this.Ac + (System.currentTimeMillis() % 800L < 400L ? "_" : " ");
        this.b(this.pX, string, n3 + 2, 50, 0xFFFFA0);
        this.b(this.pX, rd.gH().al("rumo.x"), n3, 76, 0xA0A0A0);
        this.d(n3 - 1, 71, n3 + 90 + 1, 89, -6250336);
        this.d(n3, 72, n3 + 90, 88, -16777216);
        this.b(this.pX, this.Aa, n3 + 2, 76, 0xE0E0E0);
        this.b(this.pX, rd.gH().al("rumo.z"), n3 + 105, 76, 0xA0A0A0);
        this.d(n3 + 104 - 1, 71, n3 + 200 + 1, 89, -6250336);
        this.d(n3 + 104, 72, n3 + 200, 88, -16777216);
        this.b(this.pX, this.Ab, n3 + 106, 76, 0xE0E0E0);
        super.a(n, n2, f);
    }
}

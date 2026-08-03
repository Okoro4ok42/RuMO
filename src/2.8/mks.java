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

public class mks
extends kc {
    private String Aa = "";
    private String Ab = "";
    private String Ac = "";
    private String Ad = "";
    private int Ae = 0;
    private int Af = 0;
    private int Ag = 0;
    private int Ah = -65536;
    private int Ai = 0;
    private int Aj = -1;
    private kc Ak;
    private static final int[] Aw = new int[]{-65536, -30720, -256, -16711936, -16711681, -16776961, -10079233, -1};

    public mks(double d, double d2) {
        this.Aa = String.valueOf((int)d);
        this.Ab = String.valueOf((int)d2);
    }

    public mks(double d, double d2, kc kc2) {
        this(d, d2);
        this.Ak = kc2;
    }

    public mks(mrk.Entry entry, int n, kc kc2) {
        this(entry, n);
        this.Ak = kc2;
    }

    public mks(mrk.Entry entry, int n) {
        this.Aa = String.valueOf((int)entry.x);
        this.Ab = String.valueOf((int)entry.z);
        this.Ac = entry.name;
        this.Ad = entry.desc;
        this.Ah = entry.color;
        this.Ai = entry.importance;
        this.Aj = n;
        this.Ae = this.Ac.length();
        this.Af = this.Ad.length();
    }

    public void aQ() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.rU.add(new jt(1, this.width / 2 + 4, this.height - 30, 80, 20, rd.gH().al("rumo.save")));
        this.rU.add(new jt(0, this.width / 2 - 84, this.height - 30, 80, 20, rd.gH().al("rumo.cancel")));
    }

    public void dO() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    protected void a(jt jt2) {
        if (jt2.id == 1) {
            try {
                double d = Double.parseDouble(this.Aa);
                double d2 = Double.parseDouble(this.Ab);
                for (int i = 0; i < mrk.Ar.size(); ++i) {
                    if (i == this.Aj) continue;
                    mrk.Entry entry = mrk.Ar.get(i);
                    if (!(Math.abs(entry.x - d) < 1.0) || !(Math.abs(entry.z - d2) < 1.0)) continue;
                    return;
                }
                mrk.Entry entry = new mrk.Entry();
                entry.x = d;
                entry.z = d2;
                entry.name = this.Ac.isEmpty() ? "marker" : this.Ac;
                entry.desc = this.Ad;
                entry.color = this.Ah;
                entry.importance = this.Ai;
                if (this.Aj >= 0) {
                    mrk.Ar.set(this.Aj, entry);
                } else {
                    mrk.Ar.add(entry);
                }
                mrk.At();
            }
            catch (Exception exception) {
                return;
            }
            this.qI.a(this.Ak != null ? this.Ak : (kc)null);
        } else {
            this.qI.a(this.Ak != null ? this.Ak : (kc)null);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.qI.a(this.Ak != null ? this.Ak : (kc)null);
            return;
        }
        if (n == 15) {
            this.Ag = (this.Ag + 1) % 4;
            return;
        }
        if (n == 14) {
            if (this.Ag == 0 && this.Ac.length() > 0) {
                if (this.Ae > this.Ac.length()) {
                    this.Ae = this.Ac.length();
                }
                if (this.Ae > 0) {
                    this.Ac = this.Ac.substring(0, this.Ae - 1) + this.Ac.substring(this.Ae);
                    --this.Ae;
                }
            }
            if (this.Ag == 1 && this.Ad.length() > 0) {
                if (this.Af > this.Ad.length()) {
                    this.Af = this.Ad.length();
                }
                if (this.Af > 0) {
                    this.Ad = this.Ad.substring(0, this.Af - 1) + this.Ad.substring(this.Af);
                    --this.Af;
                }
            }
            if (this.Ag == 2 && this.Aa.length() > 0) {
                if (this.Ae > this.Aa.length()) {
                    this.Ae = this.Aa.length();
                }
                if (this.Ae > 0) {
                    this.Aa = this.Aa.substring(0, this.Ae - 1) + this.Aa.substring(this.Ae);
                    --this.Ae;
                }
            }
            if (this.Ag == 3 && this.Ab.length() > 0) {
                if (this.Af > this.Ab.length()) {
                    this.Af = this.Ab.length();
                }
                if (this.Af > 0) {
                    this.Ab = this.Ab.substring(0, this.Af - 1) + this.Ab.substring(this.Af);
                    --this.Af;
                }
            }
            return;
        }
        if (n == 203 || n == 205 || n == 199 || n == 207) {
            if (this.Ag == 2) {
                if (n == 203 && this.Ae > 0) {
                    --this.Ae;
                }
                if (n == 205 && this.Ae < this.Aa.length()) {
                    ++this.Ae;
                }
                if (n == 199) {
                    this.Ae = 0;
                }
                if (n == 207) {
                    this.Ae = this.Aa.length();
                }
            }
            if (this.Ag == 3) {
                if (n == 203 && this.Af > 0) {
                    --this.Af;
                }
                if (n == 205 && this.Af < this.Ab.length()) {
                    ++this.Af;
                }
                if (n == 199) {
                    this.Af = 0;
                }
                if (n == 207) {
                    this.Af = this.Ab.length();
                }
            }
            return;
        }
        if (c >= ' ') {
            String string = String.valueOf(c);
            boolean bl = string.matches("[0-9\\-]");
            if (this.Ag == 0 && this.Ac.length() < 40) {
                if (this.Ae > this.Ac.length()) {
                    this.Ae = this.Ac.length();
                }
                this.Ac = this.Ac.substring(0, this.Ae) + c + this.Ac.substring(this.Ae);
                ++this.Ae;
            }
            if (this.Ag == 1 && this.Ad.length() < 300) {
                if (this.Af > this.Ad.length()) {
                    this.Af = this.Ad.length();
                }
                this.Ad = this.Ad.substring(0, this.Af) + c + this.Ad.substring(this.Af);
                ++this.Af;
            }
            if (this.Ag == 2 && this.Aa.length() < 12 && bl) {
                if (this.Ae > this.Aa.length()) {
                    this.Ae = this.Aa.length();
                }
                this.Aa = this.Aa.substring(0, this.Ae) + c + this.Aa.substring(this.Ae);
                ++this.Ae;
            }
            if (this.Ag == 3 && this.Ab.length() < 12 && bl) {
                if (this.Af > this.Ab.length()) {
                    this.Af = this.Ab.length();
                }
                this.Ab = this.Ab.substring(0, this.Af) + c + this.Ab.substring(this.Af);
                ++this.Af;
            }
        }
    }

    protected void h(int n, int n2, int n3) {
        super.h(n, n2, n3);
        if (n3 == 0) {
            int n4;
            int n5;
            int n6;
            int n7 = this.width / 2 - 120;
            for (n6 = 0; n6 < Aw.length; ++n6) {
                n5 = n7 + n6 * 26;
                n4 = 98;
                if (n < n5 || n >= n5 + 24 || n2 < n4 || n2 >= n4 + 20) continue;
                this.Ah = Aw[n6];
                return;
            }
            for (n6 = 0; n6 < 3; ++n6) {
                n5 = n7 + n6 * 80;
                n4 = 122;
                if (n < n5 || n >= n5 + 72 || n2 < n4 || n2 >= n4 + 16) continue;
                this.Ai = n6;
                return;
            }
        }
    }

    public void a(int n, int n2, float f) {
        int n3;
        int n4;
        this.dj();
        int n5 = this.width / 2 - 120;
        this.a(this.pX, this.Aj >= 0 ? rd.gH().al("rumo.editMarker") : rd.gH().al("rumo.newMarker"), this.width / 2, 10, 0xFFFFFF);
        this.b(this.pX, rd.gH().al("rumo.name"), n5, 30, 0xA0A0A0);
        this.d(n5 - 1, 25, n5 + 220 + 1, 43, -6250336);
        this.d(n5, 26, n5 + 220, 42, -16777216);
        String string = this.Ai == 1 ? "\u00a7l" : (this.Ai == 2 ? "\u00a7o" : "\u00a7n");
        String string2 = string + this.Ac + (this.Ag == 0 && System.currentTimeMillis() % 800L < 400L ? "_" : " ");
        this.b(this.pX, string2.length() > 40 ? string2.substring(0, 40) : string2, n5 + 2, 30, this.Ag == 0 ? this.Ah : 0xE0E0E0);
        this.b(this.pX, rd.gH().al("rumo.desc"), n5, 54, 0xA0A0A0);
        this.d(n5 - 1, 49, n5 + 220 + 1, 67, -6250336);
        this.d(n5, 50, n5 + 220, 66, -16777216);
        String string3 = this.Ad + (this.Ag == 1 && System.currentTimeMillis() % 800L < 400L ? "_" : " ");
        this.b(this.pX, string3.length() > 36 ? string3.substring(0, 36) + ".." : string3, n5 + 2, 54, this.Ag == 1 ? 0xFFFFA0 : 0xE0E0E0);
        this.b(this.pX, rd.gH().al("rumo.x"), n5, 78, 0xA0A0A0);
        this.d(n5 - 1, 73, n5 + 100 + 1, 91, this.Ag == 2 ? -256 : -6250336);
        this.d(n5, 74, n5 + 100, 90, -16777216);
        this.b(this.pX, this.Aa, n5 + 2, 78, this.Ag == 2 ? 0xFFFFA0 : 0xE0E0E0);
        this.b(this.pX, rd.gH().al("rumo.z"), n5 + 115, 78, 0xA0A0A0);
        this.d(n5 + 114 - 1, 73, n5 + 220 + 1, 91, this.Ag == 3 ? -256 : -6250336);
        this.d(n5 + 114, 74, n5 + 220, 90, -16777216);
        this.b(this.pX, this.Ab, n5 + 116, 78, this.Ag == 3 ? 0xFFFFA0 : 0xE0E0E0);
        this.b(this.pX, rd.gH().al("rumo.color"), n5, 102, 0xA0A0A0);
        for (int i = 0; i < Aw.length; ++i) {
            n4 = n5 + i * 26;
            n3 = 98;
            this.d(n4 + 2, n3 + 2, n4 + 22, n3 + 18, Aw[i]);
            this.d(n4 + 1, n3 + 1, n4 + 23, n3 + 1, this.Ah == Aw[i] ? -256 : -16777216);
            this.d(n4 + 1, n3 + 19, n4 + 23, n3 + 19, this.Ah == Aw[i] ? -256 : -16777216);
            this.d(n4 + 1, n3 + 1, n4 + 1, n3 + 19, this.Ah == Aw[i] ? -256 : -16777216);
            this.d(n4 + 23, n3 + 1, n4 + 23, n3 + 19, this.Ah == Aw[i] ? -256 : -16777216);
        }
        this.b(this.pX, rd.gH().al("rumo.style"), n5, 126, 0xA0A0A0);
        String[] stringArray = new String[]{"\u00a7n" + rd.gH().al("rumo.default"), "\u00a7l" + rd.gH().al("rumo.important"), "\u00a7o" + rd.gH().al("rumo.minor")};
        for (n4 = 0; n4 < 3; ++n4) {
            n3 = n5 + n4 * 80;
            int n6 = 122;
            int n7 = this.Ai == n4 ? -1342177025 : -1610612736;
            this.d(n3, n6, n3 + 72, n6 + 16, n7);
            this.b(this.pX, stringArray[n4], n3 + 3, n6 + 4, 0xE0E0E0);
        }
        this.b(this.pX, rd.gH().al("rumo.tabSwitch"), 4, this.height - 12, 0x808080);
        super.a(n, n2, f);
    }
}

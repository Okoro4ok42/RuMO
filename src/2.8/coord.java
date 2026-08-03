/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  org.lwjgl.input.Keyboard
 */
import org.lwjgl.input.Keyboard;

public class coord
extends kc {
    public static double Ar = Double.NaN;
    public static double As = Double.NaN;
    private String Aa = "";
    private String Ab = "";
    private int Ac = 0;
    private int Ad = 0;
    private boolean Ae = true;
    private kc Af;

    public coord(kc kc2) {
        this.Af = kc2;
    }

    public void aQ() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.rU.add(new jt(1, this.width / 2 + 4, this.height - 30, 80, 20, "Go"));
        this.rU.add(new jt(0, this.width / 2 - 84, this.height - 30, 80, 20, "Cancel"));
    }

    public void dO() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    protected void a(jt jt2) {
        if (jt2.id == 1) {
            try {
                Ar = Double.parseDouble(this.Aa);
            }
            catch (Exception exception) {
                Ar = Double.NaN;
            }
            try {
                As = Double.parseDouble(this.Ab);
            }
            catch (Exception exception) {
                As = Double.NaN;
            }
            this.qI.a(this.Af);
        } else {
            Ar = Double.NaN;
            As = Double.NaN;
            this.qI.a(this.Af);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            Ar = Double.NaN;
            As = Double.NaN;
            this.qI.a(this.Af);
        } else if (n == 28 || n == 156) {
            try {
                Ar = Double.parseDouble(this.Aa);
            }
            catch (Exception exception) {
                Ar = Double.NaN;
            }
            try {
                As = Double.parseDouble(this.Ab);
            }
            catch (Exception exception) {
                As = Double.NaN;
            }
            this.qI.a(this.Af);
        } else if (n == 15 || c == '\t') {
            this.Ae = !this.Ae;
        } else if (n == 14) {
            if (this.Ae && this.Ac > 0) {
                this.Aa = this.Aa.substring(0, this.Ac - 1) + this.Aa.substring(this.Ac);
                --this.Ac;
            } else if (!this.Ae && this.Ad > 0) {
                this.Ab = this.Ab.substring(0, this.Ad - 1) + this.Ab.substring(this.Ad);
                --this.Ad;
            }
        } else if (n == 203) {
            if (this.Ae && this.Ac > 0) {
                --this.Ac;
            }
            if (!this.Ae && this.Ad > 0) {
                --this.Ad;
            }
        } else if (n == 205) {
            if (this.Ae && this.Ac < this.Aa.length()) {
                ++this.Ac;
            }
            if (!this.Ae && this.Ad < this.Ab.length()) {
                ++this.Ad;
            }
        } else if (n == 199) {
            if (this.Ae) {
                this.Ac = 0;
            } else {
                this.Ad = 0;
            }
        } else if (n == 207) {
            if (this.Ae) {
                this.Ac = this.Aa.length();
            } else {
                this.Ad = this.Ab.length();
            }
        } else if (c >= '0' && c <= '9' || c == '-') {
            if (this.Ae && this.Aa.length() < 12) {
                this.Aa = this.Aa.substring(0, this.Ac) + c + this.Aa.substring(this.Ac);
                ++this.Ac;
            } else if (!this.Ae && this.Ab.length() < 12) {
                this.Ab = this.Ab.substring(0, this.Ad) + c + this.Ab.substring(this.Ad);
                ++this.Ad;
            }
        }
    }

    public void a(int n, int n2, float f) {
        this.dj();
        this.a(this.pX, "Enter coordinates", this.width / 2, 20, 0xFFFFFF);
        this.b(this.pX, "X:", this.width / 2 - 100, 50, 0xA0A0A0);
        int n3 = this.width / 2 - 80;
        int n4 = 45;
        int n5 = 160;
        int n6 = 20;
        this.d(n3 - 1, n4 - 1, n3 + n5 + 1, n4 + n6 + 1, -6250336);
        this.d(n3, n4, n3 + n5, n4 + n6, -16777216);
        String string = this.Aa.substring(0, this.Ac) + (this.Ae && System.currentTimeMillis() % 800L < 400L ? "_" : " ") + this.Aa.substring(this.Ac);
        this.b(this.pX, string, n3 + 4, n4 + 6, this.Ae ? 0xFFFFA0 : 0xE0E0E0);
        this.b(this.pX, "Z:", this.width / 2 - 100, 80, 0xA0A0A0);
        int n7 = this.width / 2 - 80;
        int n8 = 75;
        this.d(n7 - 1, n8 - 1, n7 + n5 + 1, n8 + n6 + 1, -6250336);
        this.d(n7, n8, n7 + n5, n8 + n6, -16777216);
        String string2 = this.Ab.substring(0, this.Ad) + (!this.Ae && System.currentTimeMillis() % 800L < 400L ? "_" : " ") + this.Ab.substring(this.Ad);
        this.b(this.pX, string2, n3 + 4, n8 + 6, !this.Ae ? 0xFFFFA0 : 0xE0E0E0);
        super.a(n, n2, f);
    }
}

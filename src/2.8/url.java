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

public class url
extends kc {
    private String Aa = "";
    private int Ab = 0;
    private int Ac = 0;
    private kc Ae;

    public url(kc kc2) {
        this.Ae = kc2;
    }

    public void aQ() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.rU.add(new jt(1, this.width / 2 + 4, this.height - 30, 80, 20, rd.gH().al("gui.done")));
        this.rU.add(new jt(0, this.width / 2 - 84, this.height - 30, 80, 20, rd.gH().al("gui.cancel")));
        this.Aa = this.qI.qh.Wx;
        this.Ab = this.Aa.length();
    }

    public void dO() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    protected void a(jt jt2) {
        if (jt2.id == 1) {
            this.qI.qh.Wx = this.Aa;
            this.qI.a(this.Ae);
        } else {
            this.qI.a(this.Ae);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.qI.a(this.Ae);
        } else if (n == 28 || n == 156) {
            this.qI.qh.Wx = this.Aa;
            this.qI.a(this.Ae);
        } else if (n == 14 && !this.Aa.isEmpty() && this.Ab > 0) {
            this.Aa = this.Aa.substring(0, this.Ab - 1) + this.Aa.substring(this.Ab);
            --this.Ab;
        } else if (n == 203 && this.Ab > 0) {
            --this.Ab;
        } else if (n == 205 && this.Ab < this.Aa.length()) {
            ++this.Ab;
        } else if (n == 199) {
            this.Ab = 0;
        } else if (n == 207) {
            this.Ab = this.Aa.length();
        } else if (n == 211 && this.Ab < this.Aa.length()) {
            this.Aa = this.Aa.substring(0, this.Ab) + this.Aa.substring(this.Ab + 1);
        } else if (c != '\u0000' && this.Aa.length() < 300) {
            this.Aa = this.Aa.substring(0, this.Ab) + c + this.Aa.substring(this.Ab);
            ++this.Ab;
        }
    }

    public void a(int n, int n2, float f) {
        this.dj();
        this.a(this.pX, "Dynmap URL", this.width / 2, 30, 0xFFFFFF);
        this.b(this.pX, "URL:", this.width / 2 - 100, 60, 0xA0A0A0);
        int n3 = this.width / 2 - 100;
        int n4 = 74;
        int n5 = 200;
        int n6 = 20;
        this.d(n3, n4, n3 + n5, n4 + n6, -6250336);
        this.d(n3 + 1, n4 + 1, n3 + n5 - 1, n4 + n6 - 1, -16777216);
        String string = this.Aa.substring(0, this.Ab) + (this.Ac / 6 % 2 == 0 ? "_" : " ") + this.Aa.substring(this.Ab);
        this.b(this.pX, string, n3 + 4, n4 + 6, 0xE0E0E0);
        ++this.Ac;
        super.a(n, n2, f);
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  rd
 */
public class hotkeys
extends kc {
    private kc Aa;
    private int editingIdx = -1;
    private int editLocalIdx = -1;
    private int editPage = -1;
    private static final int VISIBLE = 10;
    private static String[][] groups = new String[][]{{"rumo.groupBasic", "hkGoto", "34", "rumo.goto", "hkReload", "19", "rumo.reload", "hkMarker", "50", "rumo.marker", "hkPm", "33", "rumo.pm", "hkPxAdj", "25", "rumo.padj", "hkPxMinus", "44", "rumo.pxMinus", "hkPxPlus", "45", "rumo.pxPlus", "", "0", "rumo.cityViewMode", "", "0", "rumo.cityEditMode"}, {"rumo.groupMetro", "hkMQ", "16", "rumo.metroStation", "hkMW", "17", "rumo.metroLine", "hkMA", "30", "rumo.metroDelSt", "hkMS", "31", "rumo.metroDelLine"}, {"rumo.groupCity", "hkQ", "16", "rumo.streetDraw", "hkW", "17", "rumo.houseW", "hkE", "18", "rumo.apartmentE", "hkR", "19", "rumo.landmarkR", "hkT", "20", "rumo.techT", "hkA", "30", "rumo.delA", "hkS", "31", "rumo.streetsList", "hkB", "48", "rumo.buildingsList", "hkC", "46", "rumo.citizensHint"}};

    public hotkeys(kc kc2) {
        this.Aa = kc2;
        this.editPage = 0;
        for (int i = 0; i < groups.length; ++i) {
            String[] stringArray = groups[i];
            int n = 1;
            while (n + 2 < stringArray.length) {
                if (!stringArray[n].isEmpty()) {
                    stringArray[n + 1] = String.valueOf(hotkeys.getFieldValue(stringArray[n]));
                }
                n += 3;
            }
        }
    }

    private static int getFieldValue(String string) {
        try {
            return dyn.class.getField(string).getInt(null);
        }
        catch (Exception exception) {
            return 0;
        }
    }

    private static void setFieldValue(String string, int n) {
        try {
            dyn.class.getField(string).setInt(null, n);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void aQ() {
        this.rU.clear();
        if (this.editPage > 0) {
            this.rU.add(new jt(10, this.width / 2 - 54, this.height - 28, 20, 20, "<"));
        }
        if (this.editPage < groups.length - 1) {
            this.rU.add(new jt(11, this.width / 2 - 26, this.height - 28, 20, 20, ">"));
        }
        this.rU.add(new jt(0, this.width / 2 + 4, this.height - 28, 50, 20, rd.gH().al("rumo.back")));
    }

    public void dO() {
    }

    protected void a(jt jt2) {
        if (jt2.id == 0) {
            this.saveHotkeys();
            if (this.Aa instanceof dyn) {
                ((dyn)this.Aa).aQ();
            }
            this.qI.a(this.Aa);
        }
        if (jt2.id == 10 && this.editPage > 0) {
            --this.editPage;
            this.editPage = this.editPage;
            this.editingIdx = -1;
            this.editLocalIdx = -1;
            this.aQ();
        }
        if (jt2.id == 11 && this.editPage < groups.length - 1) {
            ++this.editPage;
            this.editPage = this.editPage;
            this.editingIdx = -1;
            this.editLocalIdx = -1;
            this.aQ();
        }
    }

    private void saveHotkeys() {
        for (int i = 0; i < groups.length; ++i) {
            String[] stringArray = groups[i];
            int n = 1;
            while (n + 2 < stringArray.length) {
                if (!stringArray[n].isEmpty()) {
                    hotkeys.setFieldValue(stringArray[n], Integer.parseInt(stringArray[n + 1]));
                }
                n += 3;
            }
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.saveHotkeys();
            if (this.Aa instanceof dyn) {
                ((dyn)this.Aa).aQ();
            }
            this.qI.a(this.Aa);
            return;
        }
        if (this.editingIdx >= 0 && this.editPage == this.editPage) {
            int n2 = 1 + this.editLocalIdx * 3 + 1;
            String[] stringArray = groups[this.editPage];
            if (n2 < stringArray.length) {
                stringArray[n2] = String.valueOf(n);
            }
            this.editingIdx = -1;
            this.editLocalIdx = -1;
            return;
        }
    }

    protected void h(int n, int n2, int n3) {
        super.h(n, n2, n3);
        if (n3 != 0) {
            return;
        }
        String[] stringArray = groups[this.editPage];
        int n4 = (stringArray.length - 1) / 3;
        int n5 = 28;
        int n6 = 0;
        for (int i = 0; i < n4; ++i) {
            if (stringArray[1 + i * 3].isEmpty()) {
                ++n6;
                continue;
            }
            int n7 = n5 + n6 * 20;
            ++n6;
            if (n < 4 || n >= this.width - 4 || n2 < n7 || n2 >= n7 + 18) continue;
            if (this.editingIdx == i && this.editPage == this.editPage) {
                this.editingIdx = -1;
                this.editLocalIdx = -1;
            } else {
                this.editingIdx = i;
                this.editLocalIdx = i;
            }
            return;
        }
        this.editingIdx = -1;
        this.editLocalIdx = -1;
    }

    public static String keyCodeToName(int n) {
        switch (n) {
            case 1: {
                return "ESC";
            }
            case 14: {
                return "BS";
            }
            case 15: {
                return "TAB";
            }
            case 28: {
                return "ENTER";
            }
            case 29: {
                return "LCTRL";
            }
            case 42: {
                return "LSHIFT";
            }
            case 54: {
                return "RSHIFT";
            }
            case 56: {
                return "LALT";
            }
            case 57: {
                return "SPACE";
            }
            case 58: {
                return "CAPS";
            }
            case 100: {
                return "RALT";
            }
            case 157: {
                return "RCTRL";
            }
            case 199: {
                return "HOME";
            }
            case 207: {
                return "END";
            }
            case 201: {
                return "PGUP";
            }
            case 209: {
                return "PGDN";
            }
            case 203: {
                return "LEFT";
            }
            case 205: {
                return "RIGHT";
            }
            case 200: {
                return "UP";
            }
            case 208: {
                return "DOWN";
            }
            case 210: {
                return "INS";
            }
            case 211: {
                return "DEL";
            }
            case 59: {
                return "F1";
            }
            case 60: {
                return "F2";
            }
            case 61: {
                return "F3";
            }
            case 62: {
                return "F4";
            }
            case 63: {
                return "F5";
            }
            case 64: {
                return "F6";
            }
            case 65: {
                return "F7";
            }
            case 66: {
                return "F8";
            }
            case 67: {
                return "F9";
            }
            case 68: {
                return "F10";
            }
            case 87: {
                return "F11";
            }
            case 88: {
                return "F12";
            }
            case 41: {
                return "`";
            }
            case 12: {
                return "-";
            }
            case 13: {
                return "=";
            }
            case 26: {
                return "[";
            }
            case 27: {
                return "]";
            }
            case 43: {
                return "\\";
            }
            case 39: {
                return ";";
            }
            case 40: {
                return "'";
            }
            case 51: {
                return ",";
            }
            case 52: {
                return ".";
            }
            case 53: {
                return "/";
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return "" + (char)(48 + n - 2);
            }
            case 30: {
                return "A";
            }
            case 48: {
                return "B";
            }
            case 46: {
                return "C";
            }
            case 32: {
                return "D";
            }
            case 18: {
                return "E";
            }
            case 33: {
                return "F";
            }
            case 34: {
                return "G";
            }
            case 35: {
                return "H";
            }
            case 23: {
                return "I";
            }
            case 36: {
                return "J";
            }
            case 37: {
                return "K";
            }
            case 38: {
                return "L";
            }
            case 50: {
                return "M";
            }
            case 49: {
                return "N";
            }
            case 24: {
                return "O";
            }
            case 25: {
                return "P";
            }
            case 16: {
                return "Q";
            }
            case 19: {
                return "R";
            }
            case 31: {
                return "S";
            }
            case 20: {
                return "T";
            }
            case 22: {
                return "U";
            }
            case 47: {
                return "V";
            }
            case 17: {
                return "W";
            }
            case 45: {
                return "X";
            }
            case 21: {
                return "Y";
            }
            case 44: {
                return "Z";
            }
        }
        return "KEY_" + n;
    }

    public void a(int n, int n2, float f) {
        String[] stringArray = groups[this.editPage];
        String string = rd.gH().al(stringArray[0]);
        this.a(this.pX, string, this.width / 2, 4, 0xFFFF55);
        this.a(this.pX, this.editPage + 1 + "/" + groups.length, this.width - 20, 4, 0x606060);
        int n3 = 28;
        int n4 = (stringArray.length - 1) / 3;
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            String string2 = stringArray[1 + i * 3];
            boolean bl = string2.isEmpty();
            int n6 = n3 + n5 * 20;
            ++n5;
            if (!bl) {
                boolean bl2;
                boolean bl3 = this.editingIdx == i && this.editPage == this.editPage;
                boolean bl4 = bl2 = n >= 4 && n < this.width - 4 && n2 >= n6 && n2 < n6 + 18;
                this.d(4, n6, this.width - 4, n6 + 18, bl3 ? -1342177281 : (bl2 ? -1342177281 : -1610612736));
                String string3 = rd.gH().al(stringArray[1 + i * 3 + 2]);
                int n7 = Integer.parseInt(stringArray[1 + i * 3 + 1]);
                String string4 = bl3 ? "[" + rd.gH().al("rumo.pressKey") + "]" : hotkeys.keyCodeToName(n7);
                this.b(this.pX, string3 + " - " + string4, 8, n6 + 4, bl3 ? 0x55FF55 : 0xE0E0E0);
                continue;
            }
            this.d(4, n6, this.width - 4, n6 + 18, -1610612736);
            String string5 = rd.gH().al(stringArray[1 + i * 3 + 2]);
            this.b(this.pX, string5, 8, n6 + 4, 0x808080);
        }
        super.a(n, n2, f);
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  rd
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class bld
extends kc {
    private int Aa;
    private double Ab;
    private double Ac;
    private kc Ad;
    private String Ae = "";
    private String Af = "";
    private String Ah = "";
    private String Ai = "";
    private int Aj = 0;
    private int Ak = -1;
    private List<Building.Resident> Al = new ArrayList<Building.Resident>();
    private int Am = 0;
    private List<String> An = new ArrayList<String>();
    private boolean showStreetDrop = false;
    private int streetDropY = 0;
    private String streetFilter = "";
    private boolean showCitizenDrop = false;
    private int citizenDropY = 0;
    private String builderSearch = "";
    private boolean builderSearchFocused = false;

    public bld(int n, double d, double d2, kc kc2) {
        this.Aa = n;
        this.Ab = d;
        this.Ac = d2;
        this.Ad = kc2;
        this.An.add("");
        for (Street street : dyn.cityStreets) {
            if (!street.cityMarker.equals(dyn.cityActiveName)) continue;
            this.An.add(street.name);
        }
        double d3 = Double.MAX_VALUE;
        for (int i = 1; i < this.An.size(); ++i) {
            for (Street street : dyn.cityStreets) {
                double d4;
                double d5;
                double d6;
                if (!street.name.equals(this.An.get(i)) || street.points.isEmpty() || !((d6 = (d5 = street.points.get(0)[0] - d) * d5 + (d4 = street.points.get(0)[1] - d2) * d4) < d3)) continue;
                d3 = d6;
                this.Am = i;
            }
        }
    }

    public bld(int n, double d, double d2, kc kc2, Building building) {
        this(n, d, d2, kc2);
        this.Ae = building.name;
        this.Af = building.owner;
        this.Ah = building.info;
        this.Ai = building.houseNumber;
        this.Al = new ArrayList<Building.Resident>(building.residents);
        this.Ak = dyn.cityBuildings.indexOf(building);
        if (!building.address.isEmpty()) {
            for (int i = 0; i < this.An.size(); ++i) {
                if (!this.An.get(i).equals(building.address)) continue;
                this.Am = i;
                break;
            }
        }
    }

    public void aQ() {
        this.rU.clear();
        int n = 50;
        int n2 = this.width / 2 - n / 2;
        int n3 = this.height - 28;
        this.rU.add(new jt(100, n2, n3, n, 20, rd.gH().al("rumo.save")));
        this.rU.add(new jt(101, n2 + n + 4, n3, n, 20, rd.gH().al("rumo.cancel")));
    }

    public void dO() {
    }

    protected void a(jt jt2) {
        if (jt2.id == 100) {
            this.save();
            this.qI.a(this.Ad);
        }
        if (jt2.id == 101) {
            this.qI.a(this.Ad);
        }
    }

    private void save() {
        String string;
        Building building = new Building(this.Aa, this.Ab, this.Ac, dyn.cityActiveName);
        building.name = this.Ae;
        building.owner = this.Af.isEmpty() ? dyn.cityActiveName : this.Af;
        building.address = string = this.Am > 0 && this.Am < this.An.size() ? this.An.get(this.Am) : "";
        building.houseNumber = this.Ai;
        building.info = this.Ah;
        building.residents = this.Al;
        if (this.Ak >= 0 && this.Ak < dyn.cityBuildings.size()) {
            dyn.cityBuildings.set(this.Ak, building);
        } else {
            dyn.cityBuildings.add(building);
        }
        mrk.At();
    }

    private boolean isCitizenField() {
        if (this.Aa == 1 && this.Aj == 0) {
            return true;
        }
        if (this.Aa == 4 && this.Aj == 1) {
            return true;
        }
        return this.Aa == 2 && this.Aj >= 4 && (this.Aj - 4) % 2 == 0;
    }

    private String getTypedText() {
        if (this.Aa == 1 && this.Aj == 0) {
            return this.Af;
        }
        if (this.Aa == 3 && this.Aj == 1) {
            return this.Af;
        }
        if (this.Aa == 4 && this.Aj == 1) {
            return this.Af;
        }
        if (this.Aa == 2 && this.Aj >= 4) {
            int n = (this.Aj - 4) / 2;
            if ((this.Aj - 4) % 2 == 0 && n < this.Al.size()) {
                return this.Al.get((int)n).nick;
            }
        }
        if (this.isStreetField()) {
            return this.Am > 0 && this.Am < this.An.size() ? this.An.get(this.Am) : "";
        }
        return null;
    }

    private void setTypedText(String string) {
        if (this.Aa == 1 && this.Aj == 0) {
            this.Af = string;
            return;
        }
        if (this.Aa == 3 && this.Aj == 1) {
            int n = this.Af.lastIndexOf(44);
            this.Af = n >= 0 ? this.Af.substring(0, n + 1) + string : string;
            return;
        }
        if (this.Aa == 4 && this.Aj == 1) {
            this.Af = string;
            return;
        }
        if (this.Aa == 2 && this.Aj >= 4) {
            int n = (this.Aj - 4) / 2;
            if ((this.Aj - 4) % 2 == 0 && n < this.Al.size()) {
                this.Al.get((int)n).nick = string;
            }
        }
    }

    private boolean isStreetField() {
        int n = this.Aa == 3 || this.Aa == 4 ? 3 : 2;
        return this.Aj == n;
    }

    private List<String> getFilteredCitizens() {
        String string = this.getTypedText();
        if (string == null) {
            string = "";
        }
        String string2 = string.toLowerCase();
        if (this.Aa == 3 && this.Aj == 1) {
            int n = string.lastIndexOf(44);
            string2 = (n >= 0 ? string.substring(n + 1) : string).toLowerCase();
        }
        if (this.builderSearchFocused) {
            string2 = this.builderSearch.toLowerCase();
        }
        List<String> list = this.getCityCitizens();
        if (string2.isEmpty() && this.Aa != 3) {
            return list;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        if (this.Aa == 3 && !this.Af.isEmpty()) {
            for (String string3 : this.Af.split(",")) {
                hashSet.add(string3.trim().toLowerCase());
            }
        }
        for (String string4 : list) {
            if (hashSet.contains(string4.toLowerCase()) || !string2.isEmpty() && !string4.toLowerCase().contains(string2)) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }

    private List<String> getFilteredStreets() {
        String string = this.streetFilter.toLowerCase();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("");
        for (int i = 1; i < this.An.size(); ++i) {
            if (!string.isEmpty() && !this.An.get(i).toLowerCase().contains(string)) continue;
            arrayList.add(this.An.get(i));
        }
        return arrayList;
    }

    private List<String> getCityCitizens() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Citizen citizen : dyn.cityCitizens) {
            if (!citizen.cityMarker.equals(dyn.cityActiveName)) continue;
            arrayList.add(citizen.name);
        }
        return arrayList;
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
        return stringBuilder.toString();
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.qI.a(this.Ad);
            return;
        }
        if (n == 15) {
            int n2;
            int n3 = n2 = this.Aa == 3 || this.Aa == 4 ? 5 : 4;
            if (this.Aa == 2) {
                n2 = 4 + Math.max(1, this.Al.size()) * 2;
            }
            this.Aj = (this.Aj + 1) % n2;
            this.showCitizenDrop = false;
            this.showStreetDrop = false;
            return;
        }
        if (this.builderSearchFocused) {
            if ((n == 14 || n == 211) && this.builderSearch.length() > 0) {
                this.builderSearch = this.builderSearch.substring(0, this.builderSearch.length() - 1);
            }
            if (c >= ' ' && this.builderSearch.length() < 30) {
                this.builderSearch = this.builderSearch + c;
            }
            this.showCitizenDrop = true;
            return;
        }
        boolean bl = this.isCitizenField();
        boolean bl2 = this.isStreetField();
        if (bl2) {
            if ((n == 14 || n == 211) && this.streetFilter.length() > 0) {
                this.streetFilter = this.streetFilter.substring(0, this.streetFilter.length() - 1);
            }
            if (c >= ' ' && this.streetFilter.length() < 30) {
                this.streetFilter = this.streetFilter + c;
            }
            this.showStreetDrop = true;
            return;
        }
        if (!bl) {
            int n4;
            String string = null;
            if (this.Aj == 0 && (this.Aa == 3 || this.Aa == 4)) {
                string = this.Ae;
            } else if (this.Aj == 1 && this.Aa != 3 && this.Aa != 4) {
                string = this.Ai;
            } else if (this.Aj == 2 && (this.Aa == 3 || this.Aa == 4)) {
                string = this.Ai;
            } else if (this.Aj == 3 && this.Aa != 3 && this.Aa != 4) {
                string = this.Ah;
            } else if (this.Aj == 4 && (this.Aa == 3 || this.Aa == 4)) {
                string = this.Ah;
            } else if (this.Aa == 2 && this.Aj >= 4 && (this.Aj - 4) % 2 == 1) {
                n4 = (this.Aj - 4) / 2;
                while (this.Al.size() <= n4) {
                    this.Al.add(new Building.Resident());
                }
                string = this.Al.get((int)n4).apartment;
            }
            if (string == null) {
                return;
            }
            if ((n == 14 || n == 211) && string.length() > 0) {
                string = string.substring(0, string.length() - 1);
            }
            if (c >= ' ' && string.length() < 60) {
                string = string + c;
            }
            if (this.Aj == 0 && (this.Aa == 3 || this.Aa == 4)) {
                this.Ae = string;
            } else if (this.Aj == 1 && this.Aa != 3 && this.Aa != 4) {
                this.Ai = string;
            } else if (this.Aj == 2 && (this.Aa == 3 || this.Aa == 4)) {
                this.Ai = string;
            } else if (this.Aj == 3 && this.Aa != 3 && this.Aa != 4) {
                this.Ah = string;
            } else if (this.Aj == 4 && (this.Aa == 3 || this.Aa == 4)) {
                this.Ah = string;
            } else if (this.Aa == 2 && this.Aj >= 4 && (this.Aj - 4) % 2 == 1 && (n4 = (this.Aj - 4) / 2) < this.Al.size()) {
                this.Al.get((int)n4).apartment = string;
            }
            return;
        }
        String string = this.getTypedText();
        if (string == null) {
            string = "";
        }
        if ((n == 14 || n == 211) && string.length() > 0) {
            string = string.substring(0, string.length() - 1);
        }
        if (c >= ' ' && string.length() < 40) {
            string = string + c;
        }
        this.setTypedText(string);
        if (bl) {
            this.showCitizenDrop = true;
        }
        if (bl2) {
            this.showStreetDrop = true;
        }
    }

    protected void h(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        if (n3 != 0) {
            super.h(n, n2, n3);
            return;
        }
        super.h(n, n2, n3);
        int n7 = this.width / 2;
        int n8 = 24;
        int n9 = 12;
        if (this.showCitizenDrop) {
            List<String> list = this.getFilteredCitizens();
            int n10 = this.citizenDropY + n9;
            if (this.builderSearchFocused) {
                if (n >= 80 && n < n7 + 60 && n2 >= n10 && n2 < n10 + n9) {
                    this.builderSearchFocused = false;
                    this.builderSearch = "";
                    this.showCitizenDrop = false;
                    return;
                }
                n10 += n9;
            }
            if (n >= 80 && n < n7 + 60 && n2 >= n10 && n2 < n10 + n9) {
                this.setTypedText("");
                this.showCitizenDrop = false;
                this.builderSearchFocused = false;
                this.builderSearch = "";
                return;
            }
            for (int i = 0; i < list.size(); ++i) {
                int n11 = n10 + (i + 1) * n9;
                if (n < 80 || n >= n7 + 60 || n2 < n11 || n2 >= n11 + n9) continue;
                if (this.Aa == 3) {
                    this.Af = this.Af.isEmpty() ? list.get(i) : this.Af + "," + list.get(i);
                } else {
                    this.setTypedText(list.get(i));
                }
                this.showCitizenDrop = false;
                this.builderSearchFocused = false;
                this.builderSearch = "";
                return;
            }
            this.showCitizenDrop = false;
            this.builderSearchFocused = false;
            this.builderSearch = "";
            return;
        }
        if (this.showStreetDrop) {
            List<String> list = this.getFilteredStreets();
            int n12 = this.streetDropY;
            for (int i = 0; i < list.size(); ++i) {
                int n13 = n12 + i * n9;
                if (n < 80 || n >= n7 + 60 || n2 < n13 || n2 >= n13 + n9) continue;
                String string = list.get(i);
                if (string.isEmpty()) {
                    this.Am = 0;
                } else {
                    for (int j = 0; j < this.An.size(); ++j) {
                        if (!this.An.get(j).equals(string)) continue;
                        this.Am = j;
                        break;
                    }
                }
                this.streetFilter = "";
                this.showStreetDrop = false;
                return;
            }
            this.streetFilter = "";
            this.showStreetDrop = false;
            return;
        }
        if (this.Aa == 3 || this.Aa == 4) {
            if (n >= 4 && n < n7 + 60 && n2 >= n8 && n2 < n8 + n9) {
                this.Aj = 0;
            }
            n8 += n9;
        }
        if (this.Aa == 1) {
            n5 = n6 = this.Aa == 4 ? 1 : 0;
            if (n >= 4 && n < n7 + 60 && n2 >= n8 && n2 < n8 + n9) {
                this.Aj = n6;
                if (this.isCitizenField()) {
                    this.showCitizenDrop = !this.showCitizenDrop;
                    this.citizenDropY = n8;
                    return;
                }
            }
            n8 += n9;
        }
        n5 = n6 = this.Aa == 3 || this.Aa == 4 ? 2 : 1;
        if (n >= 4 && n < n7 + 60 && n2 >= n8 && n2 < n8 + n9) {
            this.Aj = n6;
        }
        int n14 = n8 += n9;
        if (n >= 4 && n < n7 + 60 && n2 >= n14 && n2 < n14 + n9) {
            this.Aj = this.Aa == 3 || this.Aa == 4 ? 3 : 2;
            this.showStreetDrop = !this.showStreetDrop;
            this.streetDropY = n14;
            return;
        }
        int n15 = n4 = this.Aa == 3 || this.Aa == 4 ? 4 : 3;
        if (n >= 4 && n < n7 + 60 && n2 >= (n8 += n9) && n2 < n8 + n9) {
            this.Aj = n4;
        }
        n8 += n9;
        if (this.Aa == 3) {
            if (n >= n7 + 50 && n < this.width && n2 >= n8 + 3 && n2 < n8 + n9 + 7) {
                this.Af = "";
                return;
            }
            if (n >= 80 && n < 140 && n2 >= (n8 += n9) && n2 < n8 + n9) {
                this.builderSearch = "";
                this.builderSearchFocused = true;
                this.showCitizenDrop = true;
                this.citizenDropY = n8;
                return;
            }
            n8 += n9;
        }
        if (this.Aa == 2) {
            if (n >= 80 && n < 140 && n2 >= n8 && n2 < n8 + n9) {
                this.Al.add(new Building.Resident());
                this.Aj = 4 + (this.Al.size() - 1) * 2;
                return;
            }
            n8 += n9;
            for (int i = 0; i < this.Al.size(); ++i) {
                int n16 = n8 + i * n9;
                if (n >= 4 && n < n7 - 4 && n2 >= n16 && n2 < n16 + n9) {
                    this.Aj = 4 + i * 2;
                    this.showCitizenDrop = !this.showCitizenDrop;
                    this.citizenDropY = n16;
                    return;
                }
                if (n < n7 || n >= n7 + 100 || n2 < n16 || n2 >= n16 + n9) continue;
                this.Aj = 4 + i * 2 + 1;
            }
        }
    }

    public void a(int n, int n2, float f) {
        List<String> list;
        String string;
        int n3;
        int n4;
        int n5;
        int n6;
        boolean bl;
        String string2;
        int n7;
        int n8;
        String string3;
        int n9 = this.width / 2;
        int n10 = 8;
        int n11 = 12;
        switch (this.Aa) {
            case 1: {
                string3 = rd.gH().al("rumo.privateHouse");
                break;
            }
            case 2: {
                string3 = rd.gH().al("rumo.apartment");
                break;
            }
            case 3: {
                string3 = rd.gH().al("rumo.landmark");
                break;
            }
            case 4: {
                string3 = rd.gH().al("rumo.technical");
                break;
            }
            default: {
                string3 = "";
            }
        }
        this.a(this.pX, string3, n9 - this.pX.aD(string3) / 2, n10, 0xFFFFFF);
        n10 += n11 + 4;
        if (this.Aa == 3 || this.Aa == 4) {
            this.b(this.pX, rd.gH().al("rumo.bname") + ":", 4, n10, this.Aj == 0 ? 0xFFFF55 : 0xAAAAAA);
            this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == 0 ? -1342177281 : -1610612736);
            this.b(this.pX, this.Ae, 82, n10, 0xE0E0E0);
            n10 += n11;
        }
        if (this.Aa == 1) {
            String string4;
            String string5;
            if (this.Aa == 3) {
                n8 = this.Af.isEmpty() ? 0 : this.Af.split(",").length;
                string5 = n8 > 1 ? rd.gH().al("rumo.builders") : rd.gH().al("rumo.builder");
            } else {
                string5 = rd.gH().al("rumo.owner");
            }
            n8 = this.Aa == 3 || this.Aa == 4 ? 1 : 0;
            n7 = this.Aj == n8 && (this.showCitizenDrop || this.isCitizenField()) ? 1 : 0;
            this.b(this.pX, string5 + ":", 4, n10, this.Aj == n8 ? 0xFFFF55 : 0xAAAAAA);
            this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == n8 ? -1342177281 : -1610612736);
            string2 = string4 = this.Af.isEmpty() ? "(" + dyn.cityActiveName + ")" : this.Af;
            if (this.Aj == n8 && this.showCitizenDrop) {
                string4 = this.Af + (System.currentTimeMillis() % 1000L < 500L ? "_" : "");
            }
            this.b(this.pX, string4, 82, n10, 0xE0E0E0);
            n10 += n11;
        }
        n7 = this.Aa == 3 || this.Aa == 4 ? 2 : 1;
        int n12 = n7;
        if (this.Aa == 3) {
            this.b(this.pX, rd.gH().al("rumo.houseNumber") + ":", 4, n10, this.Aj == n7 ? 0xFFFF55 : 0xAAAAAA);
            this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == n7 ? -1342177281 : -1610612736);
            this.b(this.pX, this.Ai, 82, n10, 0xE0E0E0);
        } else {
            this.b(this.pX, rd.gH().al("rumo.houseNumber") + ":", 4, n10, this.Aj == n7 ? 0xFFFF55 : 0xAAAAAA);
            this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == n7 ? -1342177281 : -1610612736);
            this.b(this.pX, this.Ai, 82, n10, 0xE0E0E0);
        }
        string2 = this.Am > 0 && this.Am < this.An.size() ? this.An.get(this.Am) : "---";
        n8 = this.isStreetField() && (this.showStreetDrop || n >= 80 && n < n9 + 60 && n2 >= n10 + n11 - 1 && n2 < n10 + n11 + 9) ? 1 : 0;
        int n13 = this.Aa == 3 || this.Aa == 4 ? 3 : 2;
        this.b(this.pX, rd.gH().al("rumo.street") + ":", 4, n10 += n11, this.Aj == n13 ? 0xFFFF55 : 0xAAAAAA);
        this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == n13 ? -1342177281 : -1610612736);
        if (this.Aj == n13 && this.showStreetDrop) {
            string2 = this.streetFilter + (System.currentTimeMillis() % 1000L < 500L ? "_" : "");
        }
        this.b(this.pX, "< " + string2 + " >", 82, n10, 0xE0E0E0);
        this.streetDropY = n10 + n11;
        int n14 = this.Aa == 3 || this.Aa == 4 ? 4 : 3;
        this.b(this.pX, rd.gH().al("rumo.info") + ":", 4, n10 += n11, this.Aj == n14 ? 0xFFFF55 : 0xAAAAAA);
        this.d(80, n10 - 1, n9 + 60, n10 + 9, this.Aj == n14 ? -1342177281 : -1610612736);
        int n15 = n9 + 58 - 82;
        String string6 = this.Ah;
        while (string6.length() > 0 && this.pX.aD(string6) > n15) {
            string6 = string6.substring(0, string6.length() - 1);
        }
        if (this.Ah.length() > string6.length()) {
            string6 = string6 + "..";
        }
        this.b(this.pX, string6, 82, n10, 0xE0E0E0);
        n10 += n11;
        if (this.Aa == 3) {
            String string7 = this.Af.isEmpty() ? rd.gH().al("rumo.builder") : rd.gH().al("rumo.builders");
            this.b(this.pX, string7 + ":", 4, n10, 0xAAAAAA);
            this.b(this.pX, this.Af.isEmpty() ? "---" : this.Af, 82, n10, 0xE0E0E0);
            bl = n >= n9 + 62 && n < this.width && n2 >= n10 && n2 < n10 + n11;
            this.b(this.pX, " X", n9 + 64, n10, bl ? -65536 : 0x808080);
            n6 = n >= 80 && n < 140 && n2 >= (n10 += n11) && n2 < n10 + n11 ? 1 : 0;
            this.b(this.pX, rd.gH().al("rumo.addBuilder"), 80, n10, n6 != 0 ? 0x55FF55 : 43520);
            n10 += n11;
        }
        if (this.Aa == 2) {
            boolean bl2 = n >= 80 && n < 140 && n2 >= (n10 += 4) && n2 < n10 + n11;
            this.b(this.pX, rd.gH().al("rumo.residents") + ":", 4, n10, 0xAAAAAA);
            this.b(this.pX, rd.gH().al("rumo.addResident"), 80, n10, bl2 ? 0x55FF55 : 43520);
            n10 += n11;
            for (n5 = 0; n5 < this.Al.size(); ++n5) {
                Building.Resident resident = this.Al.get(n5);
                n4 = this.Aj == 4 + n5 * 2 ? 1 : 0;
                n3 = this.Aj == 4 + n5 * 2 + 1 ? 1 : 0;
                this.b(this.pX, rd.gH().al("rumo.nick") + ":", 4, n10, n4 != 0 ? 0xFFFF55 : 0x888888);
                this.d(60, n10 - 1, n9 - 4, n10 + 9, n4 != 0 ? -1342177281 : -1610612736);
                string = resident.nick;
                if (n4 != 0 && this.showCitizenDrop) {
                    string = resident.nick + (System.currentTimeMillis() % 1000L < 500L ? "_" : "");
                }
                if (string.isEmpty()) {
                    string = "---";
                }
                this.b(this.pX, string, 62, n10, 0xE0E0E0);
                this.b(this.pX, rd.gH().al("rumo.apt") + ":", n9, n10, n3 != 0 ? 0xFFFF55 : 0x888888);
                this.d(n9 + 40, n10 - 1, n9 + 100, n10 + 9, n3 != 0 ? -1342177281 : -1610612736);
                this.b(this.pX, resident.apartment, n9 + 42, n10, 0xE0E0E0);
                n10 += n11;
            }
        }
        this.b(this.pX, rd.gH().al("rumo.tabSwitch"), 4, this.height - 42, 0x606060);
        super.a(n, n2, f);
        if (this.showStreetDrop) {
            list = this.getFilteredStreets();
            n5 = this.streetDropY;
            this.d(80, n5 - 1, n9 + 60, n5 + list.size() * n11, -1610612736);
            for (n4 = 0; n4 < list.size(); ++n4) {
                n6 = n5 + n4 * n11;
                n3 = n >= 80 && n < n9 + 60 && n2 >= n6 && n2 < n6 + n11 ? 1 : 0;
                string = n4 == 0 ? "---" : list.get(n4);
                boolean bl3 = bl = !list.get(n4).isEmpty() && this.Am > 0 && this.Am < this.An.size() && this.An.get(this.Am).equals(list.get(n4));
                this.b(this.pX, string, 82, n6, n3 != 0 ? 0x55FF55 : (bl ? 0xFFFF55 : 0xE0E0E0));
            }
        }
        if (this.showCitizenDrop) {
            list = this.getFilteredCitizens();
            n5 = this.citizenDropY + n11;
            if (this.builderSearchFocused) {
                this.d(80, n5 - 1, n9 + 60, n5 + n11, -1342177281);
                this.b(this.pX, this.builderSearch + (System.currentTimeMillis() % 1000L < 500L ? "_" : ""), 82, n5 + 2, 0xE0E0E0);
                n5 += n11;
            }
            this.d(80, n5 - 1, n9 + 60, n5 + (list.size() + 1) * n11, -1610612736);
            bl = n >= 80 && n < n9 + 60 && n2 >= n5 && n2 < n5 + n11;
            this.b(this.pX, "---", 82, n5, bl ? 0x55FF55 : 0xE0E0E0);
            for (n4 = 0; n4 < list.size(); ++n4) {
                n3 = n5 + (n4 + 1) * n11;
                n6 = n >= 80 && n < n9 + 60 && n2 >= n3 && n2 < n3 + n11 ? 1 : 0;
                this.b(this.pX, list.get(n4), 82, n3, n6 != 0 ? 0x55FF55 : 0xE0E0E0);
            }
        }
    }
}

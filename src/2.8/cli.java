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

public class cli
extends kc {
    private kc Aa;
    private int Ab;
    private int editingIdx = -1;
    private String editingName = "";
    private String oldEditingName = "";
    private List<Integer> filtered = new ArrayList<Integer>();
    private String searchText = "";
    private boolean searchFocused = false;
    private boolean mayorSelectionMode = false;

    public cli(kc kc2) {
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
        this.filtered.clear();
        String string = cli.strip(this.searchText);
        for (int i = 0; i < dyn.cityCitizens.size(); ++i) {
            Citizen citizen = dyn.cityCitizens.get(i);
            if (!citizen.cityMarker.equals(dyn.cityActiveName) || !string.isEmpty() && !cli.strip(citizen.name).contains(string)) continue;
            this.filtered.add(i);
        }
    }

    public void aQ() {
        this.rU.clear();
        this.rebuildFilter();
        int n = this.filtered.size();
        int n2 = Math.max(1, (n + 7) / 8);
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

    private void commitEdit() {
        if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
            int n = this.filtered.get(this.editingIdx);
            dyn.cityCitizens.get((int)n).name = this.editingName;
            mrk.At();
        }
    }

    private void renameCitizen(String string, String string2) {
        if (string.isEmpty() || string.equals(string2)) {
            return;
        }
        for (Building building : dyn.cityBuildings) {
            if (building.name.equals(string)) {
                building.name = string2;
            }
            for (Building.Resident resident : building.residents) {
                if (!resident.nick.equals(string)) continue;
                resident.nick = string2;
            }
            if (building.owner.isEmpty()) continue;
            if (building.owner.contains(",")) {
                String[] stringArray = building.owner.split(",");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < stringArray.length; ++i) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(stringArray[i].trim().equals(string) ? string2 : stringArray[i]);
                }
                building.owner = stringBuilder.toString();
                continue;
            }
            if (!building.owner.equals(string)) continue;
            building.owner = string2;
        }
        String string3 = dyn.cityMayors.get(dyn.cityActiveName);
        if (string.equals(string3)) {
            dyn.cityMayors.put(dyn.cityActiveName, string2);
        }
        mrk.At();
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
            if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                int n = this.filtered.get(this.editingIdx);
                this.renameCitizen(this.oldEditingName, this.editingName);
                dyn.cityCitizens.get((int)n).name = this.editingName;
            }
            this.editingIdx = -1;
            this.editingName = "";
            this.oldEditingName = "";
            if (this.Aa instanceof dyn) {
                ((dyn)this.Aa).aQ();
            }
            this.qI.a(this.Aa);
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                int n2 = this.filtered.get(this.editingIdx);
                this.renameCitizen(this.oldEditingName, this.editingName);
                dyn.cityCitizens.get((int)n2).name = this.editingName;
            }
            this.editingIdx = -1;
            this.editingName = "";
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
            return;
        }
        if (this.editingIdx >= 0) {
            if (n == 14 || n == 211) {
                if (this.editingName.length() > 0) {
                    this.editingName = this.editingName.substring(0, this.editingName.length() - 1);
                    this.commitEdit();
                }
                return;
            }
            if (n == 28 || n == 156) {
                if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                    int n3 = this.filtered.get(this.editingIdx);
                    this.renameCitizen(this.oldEditingName, this.editingName);
                    dyn.cityCitizens.get((int)n3).name = this.editingName;
                }
                this.editingIdx = -1;
                this.editingName = "";
                this.oldEditingName = "";
                return;
            }
            if (c >= ' ' && this.editingName.length() < 30) {
                this.editingName = this.editingName + c;
                this.commitEdit();
            }
        }
    }

    protected void h(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        super.h(n, n2, n3);
        if (n3 != 0) {
            return;
        }
        int n7 = 30;
        boolean bl = this.searchFocused = n >= 4 && n < this.width / 2 + 60 && n2 >= n7 && n2 < n7 + 14;
        if (this.searchFocused) {
            return;
        }
        this.rebuildFilter();
        int n8 = this.filtered.size();
        for (n6 = 0; n6 < 8 && (n5 = this.Ab * 8 + n6) < n8; ++n6) {
            n4 = 44 + n6 * 20;
            int n9 = this.filtered.get(n5);
            if (n >= this.width - 48 && n < this.width - 18 && n2 >= n4 + 4 && n2 < n4 + 16) {
                if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                    int n10 = this.filtered.get(this.editingIdx);
                    this.renameCitizen(this.oldEditingName, this.editingName);
                    dyn.cityCitizens.get((int)n10).name = this.editingName;
                }
                dyn.cityCitizens.remove(n9);
                if (this.editingIdx == n5) {
                    this.editingIdx = -1;
                    this.editingName = "";
                    this.oldEditingName = "";
                } else if (this.editingIdx > n5) {
                    --this.editingIdx;
                }
                mrk.At();
                this.aQ();
                return;
            }
            if (n >= this.width - 80 && n < this.width - 50 && n2 >= n4 + 4 && n2 < n4 + 16) {
                if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                    int n11 = this.filtered.get(this.editingIdx);
                    this.renameCitizen(this.oldEditingName, this.editingName);
                    dyn.cityCitizens.get((int)n11).name = this.editingName;
                }
                this.editingIdx = n5;
                this.editingName = dyn.cityCitizens.get((int)n9).name;
                this.oldEditingName = dyn.cityCitizens.get((int)n9).name;
                return;
            }
            if (n < 4 || n >= this.width - 84 || n2 < n4 || n2 >= n4 + 18) continue;
            if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                int n12 = this.filtered.get(this.editingIdx);
                this.renameCitizen(this.oldEditingName, this.editingName);
                dyn.cityCitizens.get((int)n12).name = this.editingName;
            }
            this.editingIdx = -1;
            this.editingName = "";
            this.oldEditingName = "";
            if (this.mayorSelectionMode) {
                String string = dyn.cityCitizens.get((int)n9).name;
                if (!string.isEmpty()) {
                    dyn.cityMayors.put(dyn.cityActiveName, string);
                    mrk.At();
                }
                this.mayorSelectionMode = false;
                return;
            }
            this.editingIdx = n5;
            this.editingName = dyn.cityCitizens.get((int)n9).name;
            this.oldEditingName = dyn.cityCitizens.get((int)n9).name;
            return;
        }
        int n13 = n6 = n >= 4 && n < this.width / 2 + 60 && n2 >= this.height - 28 && n2 < this.height - 14 ? 1 : 0;
        if (n6 != 0) {
            if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                n5 = this.filtered.get(this.editingIdx);
                this.renameCitizen(this.oldEditingName, this.editingName);
                dyn.cityCitizens.get((int)n5).name = this.editingName;
                this.editingIdx = -1;
                this.editingName = "";
                this.oldEditingName = "";
            }
            this.mayorSelectionMode = !this.mayorSelectionMode;
            return;
        }
        int n14 = n5 = n >= this.width / 2 + 58 && n < this.width / 2 + 58 + 60 && n2 >= this.height - 28 && n2 < this.height - 8 ? 1 : 0;
        if (n5 != 0) {
            if (this.editingIdx >= 0 && this.editingIdx < this.filtered.size()) {
                n4 = this.filtered.get(this.editingIdx);
                this.renameCitizen(this.oldEditingName, this.editingName);
                dyn.cityCitizens.get((int)n4).name = this.editingName;
                this.editingIdx = -1;
                this.editingName = "";
                this.oldEditingName = "";
            }
            dyn.cityCitizens.add(new Citizen("", dyn.cityActiveName));
            mrk.At();
            this.rebuildFilter();
            this.editingIdx = this.filtered.size() - 1;
            this.editingName = "";
            this.oldEditingName = "";
            this.Ab = Math.max(0, (this.filtered.size() - 1) / 8);
            this.aQ();
            return;
        }
    }

    public void a(int n, int n2, float f) {
        int n3;
        boolean bl;
        int n4;
        int n5;
        int n6;
        this.rebuildFilter();
        int n7 = this.filtered.size();
        int n8 = Math.max(1, (n7 + 7) / 8);
        int n9 = 30;
        this.d(4, n9, this.width / 2 + 60, n9 + 14, this.searchFocused ? -1342177281 : -1610612736);
        String string = this.searchText + (this.searchFocused && System.currentTimeMillis() % 1000L < 500L ? "_" : "");
        this.b(this.pX, rd.gH().al("rumo.search") + " " + string, 8, n9 + 2, 0xE0E0E0);
        this.d(2, 42, this.width - 2, 44 + Math.min(n7 - this.Ab * 8, 8) * 20 + 6, -1610612736);
        this.a(this.pX, rd.gH().al("rumo.citizensList") + " (" + n7 + ") " + rd.gH().al("rumo.page") + " " + (this.Ab + 1) + "/" + n8, 4, 4, 0xFFFFFF);
        for (n6 = 0; n6 < 8 && (n5 = this.Ab * 8 + n6) < n7; ++n6) {
            n4 = 44 + n6 * 20;
            int n10 = this.filtered.get(n5);
            bl = this.editingIdx == n5;
            this.d(4, n4, this.width - 84, n4 + 16, bl ? -1342177281 : -1610612736);
            if (bl) {
                this.b(this.pX, this.editingName + (System.currentTimeMillis() % 1000L < 500L ? "_" : ""), 8, n4 + 4, 0x55FF55);
            } else {
                this.b(this.pX, dyn.cityCitizens.get((int)n10).name, 8, n4 + 4, 0xE0E0E0);
            }
            n3 = n >= this.width - 80 && n < this.width - 50 && n2 >= n4 + 4 && n2 < n4 + 16 ? 1 : 0;
            boolean bl2 = n >= this.width - 48 && n < this.width - 18 && n2 >= n4 + 4 && n2 < n4 + 16;
            this.b(this.pX, rd.gH().al("rumo.edit"), this.width - 78, n4 + 4, n3 != 0 ? 0xFFFF55 : 0x808080);
            this.b(this.pX, " X", this.width - 46, n4 + 4, bl2 ? -65536 : 0x808080);
        }
        if (n7 == 0) {
            this.b(this.pX, rd.gH().al("rumo.emptyList"), 4, 44, 0x808080);
        }
        n4 = n >= (n6 = this.width / 2 + 58) && n < n6 + 60 && n2 >= this.height - 28 && n2 < this.height - 8 ? 1 : 0;
        this.b(this.pX, rd.gH().al("rumo.addCitizen"), n6 + 2, this.height - 22, n4 != 0 ? 0x55FF55 : 43520);
        String string2 = dyn.cityMayors.get(dyn.cityActiveName);
        if (string2 == null) {
            string2 = "";
        }
        bl = n >= 4 && n < this.width / 2 + 60 && n2 >= this.height - 28 && n2 < this.height - 14;
        n3 = this.mayorSelectionMode ? 0x55FF55 : 14329120;
        this.b(this.pX, rd.gH().al("rumo.mayor") + ": " + (string2.isEmpty() ? "---" : string2) + (this.mayorSelectionMode ? " " + rd.gH().al("rumo.selectCitizen") : ""), 4, this.height - 26, bl ? 0xFFFF55 : n3);
        if (this.editingIdx >= 0) {
            this.b(this.pX, rd.gH().al("rumo.tabSwitch"), 4, this.height - 40, 0x606060);
        }
        super.a(n, n2, f);
    }
}

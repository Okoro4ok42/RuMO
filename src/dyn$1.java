/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

/*
 * Signature claims super is java.lang.ObjectLjava.util.Comparator<Building$Resident>, not java.lang.Object - discarding signature.
 */
class dyn.1
implements Comparator {
    dyn.1() {
    }

    public int compare(Building.Resident resident, Building.Resident resident2) {
        try {
            return Integer.compare(Integer.parseInt(resident.apartment), Integer.parseInt(resident2.apartment));
        }
        catch (Exception exception) {
            return resident.apartment.compareTo(resident2.apartment);
        }
    }
}

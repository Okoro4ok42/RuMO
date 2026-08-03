/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jt
 *  kc
 *  net.minecraft.client.Minecraft
 *  rd
 */
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.Scanner;
import net.minecraft.client.Minecraft;

public class dyb
extends kc {
    private kc Aa;

    public dyb(kc kc2) {
        this.Aa = kc2;
    }

    public void aQ() {
        this.rU.add(new jt(0, this.width / 2 - 40, this.height - 30, 80, 20, rd.gH().al("rumo.back")));
        this.rU.add(new jt(10, this.width / 2 - 50, 70, 100, 20, rd.gH().al("rumo.import")));
        this.rU.add(new jt(11, this.width / 2 - 50, 100, 100, 20, rd.gH().al("rumo.reset")));
        this.rU.add(new jt(12, this.width / 2 - 50, 140, 100, 20, String.format(rd.gH().al("rumo.metroToggle"), dyn.BD ? rd.gH().al("rumo.on") : rd.gH().al("rumo.off"))));
        this.rU.add(new jt(13, this.width / 2 - 50, 170, 100, 20, "URL"));
    }

    protected void a(jt jt2) {
        if (jt2.id == 0) {
            this.qI.a(this.Aa);
        }
        if (jt2.id == 10) {
            new Thread(() -> {
                try {
                    FileDialog fileDialog = new FileDialog((Frame)null, "Import markers", 0);
                    fileDialog.setFilenameFilter((file, string) -> string.toLowerCase().endsWith(".json"));
                    File file2 = Minecraft.cc();
                    if (file2 != null && file2.exists()) {
                        fileDialog.setDirectory(file2.getAbsolutePath());
                    }
                    fileDialog.setVisible(true);
                    if (fileDialog.getFile() != null) {
                        File file3 = new File(fileDialog.getDirectory(), fileDialog.getFile());
                        Scanner scanner = new Scanner(file3);
                        String string2 = scanner.useDelimiter("\\Z").next();
                        scanner.close();
                        mrk.Au(string2);
                    }
                    fileDialog.dispose();
                }
                catch (Exception exception) {
                    System.out.println("Import: " + exception.getMessage());
                }
            }).start();
        }
        if (jt2.id == 11) {
            this.qI.a((kc)null);
        }
        if (jt2.id == 12) {
            dyn.BD = !dyn.BD;
            boolean bl = dyn.BD;
            if (dyn.BD) {
                dyn.cityMode = false;
                dyn.cityViewOnly = false;
                dyn.cityActiveName = "";
                dyn.cityTool = 0;
                dyn.cityStreetDraw = false;
                dyn.cityStreetPoints.clear();
            }
            if (!dyn.BD) {
                dyn.BE = -1;
                dyn.BF = -1;
            }
            ((jt)this.rU.get((int)3)).re = String.format(rd.gH().al("rumo.metroToggle"), dyn.BD ? rd.gH().al("rumo.on") : rd.gH().al("rumo.off"));
        }
        if (jt2.id == 13) {
            this.qI.a((kc)new url(this.Aa));
        }
    }

    protected void b(char c, int n) {
        if (n == 1) {
            this.qI.a(this.Aa);
        }
    }

    public void a(int n, int n2, float f) {
        this.dj();
        this.a(this.pX, rd.gH().al("rumo.settings"), this.width / 2, 10, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

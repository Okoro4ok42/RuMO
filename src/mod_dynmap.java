/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aat
 *  alz
 *  ama
 *  kc
 *  net.minecraft.client.Minecraft
 */
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import net.minecraft.client.Minecraft;

public class mod_dynmap
extends alz {
    public mod_dynmap() {
        try {
            ama.a((alz)this, (aat)Minecraft.ch().qh.Wz, (boolean)false);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void a(aat aat2) {
        try {
            Minecraft minecraft = Minecraft.ch();
            if (minecraft.qh.Wz.VV == aat2.VV) {
                if (minecraft.qa instanceof dyn) {
                    minecraft.a((kc)null);
                    return;
                }
                if (minecraft.qa != null) {
                    return;
                }
                minecraft.a((kc)new dyn());
            }
        }
        catch (Exception exception) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(new URI(Minecraft.ch().qh.Wx));
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public static void Ab(String string) {
        try {
            String string2 = System.getProperty("os.name").toLowerCase();
            if (string2.contains("windows")) {
                String[][] stringArrayArray = new String[][]{{System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\Application\\chrome.exe", "--incognito", "--new-window"}, {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "--incognito", "--new-window"}, {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "--incognito", "--new-window"}, {"C:\\Program Files\\Mozilla Firefox\\firefox.exe", "--private-window"}, {"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "--private-window"}, {System.getenv("LOCALAPPDATA") + "\\Microsoft\\Edge\\Application\\msedge.exe", "--inprivate", "--new-window"}, {"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe", "--inprivate", "--new-window"}, {"C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe", "--inprivate", "--new-window"}};
                for (String[] stringArray : stringArrayArray) {
                    if (!new File(stringArray[0]).exists()) continue;
                    String[] stringArray2 = new String[stringArray.length + 1];
                    stringArray2[0] = stringArray[0];
                    for (int i = 1; i < stringArray.length; ++i) {
                        stringArray2[i] = stringArray[i];
                    }
                    stringArray2[stringArray2.length - 1] = string;
                    Runtime.getRuntime().exec(stringArray2);
                    return;
                }
                Desktop.getDesktop().browse(new URI(string));
            } else {
                String[] stringArray = new String[]{"google-chrome", "firefox", "chromium-browser"};
                for (String string3 : stringArray) {
                    try {
                        Runtime.getRuntime().exec(new String[]{string3, "--new-window", string});
                        return;
                    }
                    catch (Exception exception) {
                    }
                }
                Desktop.getDesktop().browse(new URI(string));
            }
        }
        catch (Exception exception) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public String nQ() {
        return "Dynmap Mod 1.0";
    }
}

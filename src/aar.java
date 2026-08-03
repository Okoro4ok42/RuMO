/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaq
 *  aas
 *  aat
 *  atx
 *  ke
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.h
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GLContext
 *  rd
 *  sb
 *  ua
 *  vf
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.h;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GLContext;

public class aar {
    private static final String[] Ut = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
    private static final String[] Uu = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    public aat Uv;
    public aat Uw;
    public aat Ux;
    public aat Uy;
    public aat Uz;
    public aat UA;
    public aat UB;
    public aat UC;
    public aat UD;
    public aat UE;
    public aat UF;
    public aat UG;
    public aat UH;
    public aat UI;
    public aat UJ;
    public aat UK;
    public aat UL;
    public aat UM;
    public aat UN;
    public aat UO;
    public aat UQ;
    public aat[] UR;
    public boolean US = false;
    public int UT = 0;
    public boolean UU = false;
    public boolean UW = false;
    public boolean UX = false;
    public boolean UY = false;
    public float UZ = 1.0f;
    public boolean Va = false;
    public boolean Vb = false;
    public boolean Vc;
    public boolean Vd = false;
    public boolean Ve = false;
    public static boolean Vf = false;
    public static boolean Vg = true;
    public float Vh = 1.0f;
    public float Vi = 1.0f;
    public float Vj = 1.0f;
    public float Vk = 1.0f;
    public float Vl = 0.5f;
    public boolean Vm = false;
    public boolean Vn = false;
    public boolean Vo = false;
    public boolean Vp = true;
    public boolean Vq = false;
    public boolean Vr = false;
    public int Vs = 90;
    public boolean lU = true;
    public boolean Vt = true;
    public String Vu = "Default";
    public int Vv = 2;
    public String Vw = "";
    public float Vx = 0.0f;
    public int Vy = 0;
    public int Tf = 10;
    public String Vz = "ru_RU";
    public boolean VA = false;
    public float VB = 0.0f;
    public float VC = 0.25f;
    public boolean VD;
    public boolean VE = false;
    public boolean VF = true;
    public boolean VG = false;
    public boolean VH = true;
    public boolean VI = false;
    public boolean VJ = false;
    public boolean VK = true;
    public boolean VL = false;
    public boolean VM = false;
    public boolean VN = true;
    public boolean VO = false;
    public String VP = "default";
    public int VQ = 0;
    public Minecraft qI;
    private File VR;
    public aat Wz = new aat("key.dynmap", 49);
    public String Wx = "https://map.rubeta.net/";

    public aar(Minecraft minecraft, File file) {
        this();
        this.qI = minecraft;
        this.VR = new File(file, "options.txt");
        this.ju();
    }

    public aar() {
        this.Uv = new aat("key.forward", 17);
        this.Uw = new aat("key.left", 30);
        this.Ux = new aat("key.back", 31);
        this.Uy = new aat("key.right", 32);
        this.Uz = new aat("key.jump", 57);
        this.UA = new aat("key.inventory", 18);
        this.UB = new aat("key.drop", 16);
        this.UC = new aat("key.chat", 20);
        this.UD = new aat("key.command", 53);
        this.UE = new aat("key.playerlist", 15);
        this.UF = new aat("key.sneak", 42);
        this.UG = new aat("key.hidegui", 59);
        this.UH = new aat("key.screenshot", 60);
        this.UI = new aat("key.debuginfo", 61);
        this.UJ = new aat("key.thirdpersonview", 63);
        this.UK = new aat("key.infopanel", 64);
        this.UL = new aat("key.smoothcam", 66);
        this.UM = new aat("key.fullscreen", 87);
        this.UN = new aat("key.debug", 88);
        this.UO = new aat("key.backpack", 33);
        this.UQ = new aat("key.autowalk", 13);
        this.UR = new aat[]{this.Uv, this.Uw, this.Ux, this.Uy, this.Uz, this.UF, this.UQ, this.UB, this.UA, this.UO, this.UC, this.UD, this.UE, this.UG, this.UH, this.UJ, this.UK, this.UM, this.UI, this.UL, this.UN};
    }

    public String bF(int n) {
        return Keyboard.getKeyName((int)this.UR[n].VV);
    }

    public void J(int n, int n2) {
        this.UR[n].VV = n2;
        this.jv();
    }

    public void a(aat aat2, int n) {
        aat2.VV = n;
        this.jv();
    }

    public void a(aaq aaq2, float f) {
        switch (aas.VS[aaq2.ordinal()]) {
            case 1: {
                this.Vs = (int)f;
                Display.setVSyncEnabled((this.Vs < 20 ? 1 : 0) != 0);
                break;
            }
            case 2: {
                this.Vh = f / 100.0f;
                this.qI.qi.jz();
                break;
            }
            case 3: {
                this.Vi = f / 100.0f;
                this.qI.qi.jz();
                break;
            }
            case 4: {
                this.Vj = f / 100.0f;
                this.qI.qi.jz();
                break;
            }
            case 5: {
                this.Vk = f / 100.0f;
                this.qI.qi.jz();
                break;
            }
            case 6: {
                this.Vl = f / 100.0f;
                break;
            }
            case 7: {
                int n;
                this.Tf = (int)f;
                if (this.Tf > (int)aaq.RENDER_DISTANCE.js()) {
                    this.Tf = (int)aaq.RENDER_DISTANCE.js();
                }
                if ((float)this.Tf < aaq.RENDER_DISTANCE.jt()) {
                    this.Tf = (int)aaq.RENDER_DISTANCE.jt();
                }
                if (!(this.qI.pN instanceof h) || this.Tf <= (n = ((h)this.qI.pN).cP())) break;
                this.Tf = n;
                break;
            }
            case 8: {
                this.Vx = f / 100.0f;
                this.iE();
                break;
            }
            case 9: {
                this.VB = f / 100.0f;
                break;
            }
            case 10: {
                this.VC = f / 100.0f;
            }
        }
    }

    public void iE() {
        if (this.qI.qc != null) {
            this.qI.qc.iE();
        }
        if (this.qI.pO != null) {
            this.qI.pO.jc();
        }
    }

    public void a(aaq aaq2, int n) {
        switch (aas.VS[aaq2.ordinal()]) {
            case 11: {
                this.Vm = !this.Vm;
                break;
            }
            case 12: {
                this.Vn = !this.Vn;
                break;
            }
            case 13: {
                this.Vo = !this.Vo;
                break;
            }
            case 7: {
                this.Tf += n;
                if (this.Tf > (int)aaq.RENDER_DISTANCE.js()) {
                    this.Tf = (int)aaq.RENDER_DISTANCE.js();
                }
                if (this.Tf >= 3) break;
                this.Tf = (int)aaq.RENDER_DISTANCE.jt();
                break;
            }
            case 14: {
                this.Vy = this.Vy + n & 3;
                break;
            }
            case 15: {
                this.Vp = !this.Vp;
                break;
            }
            case 16: {
                this.Vr = !this.Vr;
                this.qI.pO.jc();
                this.qI.pO.iX();
                break;
            }
            case 17: {
                Vf = !Vf;
                this.qI.pW.ho();
                break;
            }
            case 18: {
                Vg = !Vg;
                break;
            }
            case 19: {
                this.Vq = !this.Vq;
                this.qI.ci();
            }
            case 20: {
                this.Vv = this.Vv + n & 3;
                break;
            }
            case 21: {
                this.lU = !this.lU;
                this.qI.pO.jc();
                break;
            }
            case 22: {
                this.VA = false;
                break;
            }
            case 23: {
                ke.dz().dn();
                break;
            }
            case 24: {
                ke.dz().dv();
                break;
            }
            case 25: {
                ke.dz().dx();
                break;
            }
            case 26: {
                ke.dz().dp();
                break;
            }
            case 27: {
                ke.dz().dr();
                break;
            }
            case 28: {
                ke.dz().dt();
                break;
            }
            case 29: {
                this.VF = !this.VF;
                break;
            }
            case 30: {
                this.Vt = !this.Vt;
                this.qI.pO.jc();
                break;
            }
            case 31: {
                this.VE = !this.VE;
                break;
            }
            case 32: {
                this.VH = !this.VH;
                break;
            }
            case 33: {
                this.VI = !this.VI;
                break;
            }
            case 34: {
                this.VJ = !this.VJ;
                break;
            }
            case 35: {
                this.VL = !this.VL;
                break;
            }
            case 36: {
                boolean bl = this.VM = !this.VM && GLContext.getCapabilities().OpenGL21;
                if (!this.VM) {
                    sb.destroy();
                    break;
                }
                sb.EY = false;
                break;
            }
            case 37: {
                this.VN = !this.VN;
                break;
            }
            case 38: {
                this.VG = !this.VG;
                break;
            }
            case 39: {
                this.VK = !this.VK;
                break;
            }
            case 40: {
                this.VO = !this.VO;
                vf.JW = this.VO ? vf.JV : vf.JU;
                break;
            }
            case 41: {
                boolean bl = ua.II = !ua.II;
                if (this.qI.pO == null) break;
                this.qI.pO.jc();
                break;
            }
            case 42: {
                this.VQ += 2;
                if (this.VQ > 2) {
                    this.VQ = 0;
                }
                this.qI.pO.h(null);
                switch (this.VQ) {
                    case 1: 
                    case 2: {
                        this.qI.pO = this.qI.pQ;
                        break;
                    }
                    default: {
                        this.qI.pO = this.qI.pP;
                    }
                }
                this.qI.pO.h(this.qI.pN);
                break;
            }
            case 43: {
                Minecraft.pB = !Minecraft.pB;
            }
        }
        this.jv();
        ke.dM();
    }

    public float a(aaq aaq2) {
        switch (aas.VS[aaq2.ordinal()]) {
            case 2: {
                return this.Vh * 100.0f;
            }
            case 3: {
                return this.Vi * 100.0f;
            }
            case 4: {
                return this.Vj * 100.0f;
            }
            case 5: {
                return this.Vk * 100.0f;
            }
            case 1: {
                return this.Vs;
            }
            case 7: {
                return this.Tf;
            }
            case 8: {
                return this.Vx * 100.0f;
            }
            case 9: {
                return this.VB * 100.0f;
            }
            case 10: {
                return this.VC * 100.0f;
            }
            case 6: {
                return this.Vl * 100.0f;
            }
        }
        return 0.0f;
    }

    public boolean b(aaq aaq2) {
        switch (aas.VS[aaq2.ordinal()]) {
            case 31: {
                return this.VE;
            }
            case 24: {
                return ke.dz().du();
            }
            case 25: {
                return ke.dz().dw();
            }
            case 27: {
                return ke.dz().dq();
            }
            case 28: {
                return ke.dz().ds();
            }
            case 32: {
                return this.VH;
            }
            case 33: {
                return this.VI;
            }
            case 34: {
                return this.VJ;
            }
            case 35: {
                return this.VL;
            }
            case 36: {
                return this.VM;
            }
            case 37: {
                return this.VN;
            }
            case 40: {
                return this.VO;
            }
            case 11: {
                return this.Vm;
            }
            case 12: {
                return this.Vn;
            }
            case 13: {
                return this.Vo;
            }
            case 15: {
                return this.Vp;
            }
            case 17: {
                return Vf;
            }
            case 18: {
                return Vg;
            }
            case 19: {
                return this.Vq;
            }
            case 16: {
                return this.Vr;
            }
            case 30: {
                return this.Vt;
            }
            case 29: {
                return this.VF;
            }
            case 38: {
                return this.VG;
            }
            case 39: {
                return this.VK;
            }
            case 41: {
                return ua.II;
            }
            case 43: {
                return Minecraft.pB;
            }
        }
        return false;
    }

    public String c(aaq aaq2) {
        rd rd2 = rd.gH();
        String string = rd2.al(aaq2.jr()) + ": ";
        switch (aas.VS[aaq2.ordinal()]) {
            case 6: {
                float f = this.a(aaq2);
                if (f == 0.0f) {
                    return string + rd2.al("options.sensitivity.min");
                }
                if (f == 100.0f) {
                    return string + rd2.al("options.sensitivity.max");
                }
                return string + (int)(f * 2.0f) + "%";
            }
            case 7: {
                return string + (int)this.a(aaq2) + " Chunks";
            }
            case 8: {
                float f = this.a(aaq2);
                if (f == 0.0f) {
                    return string + rd2.al("options.gamma.min");
                }
                if (f == 100.0f) {
                    return string + rd2.al("options.gamma.max");
                }
                return string + "+" + (int)f + "%";
            }
            case 9: {
                float f = this.a(aaq2);
                if (f == 0.0f) {
                    return string + rd2.al("options.fov.min");
                }
                if (f == 100.0f) {
                    return string + rd2.al("options.fov.max");
                }
                return string + "+" + (int)f + "%";
            }
            case 10: {
                float f = this.a(aaq2);
                if (f == 0.0f) {
                    return string + rd2.al("options.fogStart.min");
                }
                if (f == 100.0f) {
                    return string + rd2.al("options.fogStart.max");
                }
                return string + (int)f + "%";
            }
            case 1: {
                if (this.Vs < 20) {
                    return string + "VSync";
                }
                if (this.Vs > 240) {
                    return string + "Unlimited";
                }
                return string + this.Vs;
            }
            case 44: {
                return rd2.al(aaq2.jr());
            }
            case 20: {
                return rd2.al(Ut[this.Vv]);
            }
            case 13: {
                return this.Vo ? rd2.al("options.sneak.toggle") : rd2.al("options.sneak.hold");
            }
            case 23: {
                return rd2.al(ke.dz().dm().cR());
            }
            case 26: {
                return rd2.al(ke.dz().do().cR());
            }
            case 14: {
                return rd2.al(Uu[this.Vy]);
            }
            case 21: {
                return this.lU ? rd2.al("options.graphics.fancy") : rd2.al("options.graphics.fast");
            }
            case 42: {
                if (this.VQ == 1) {
                    return rd2.al("options.worldRenderer.experimantal");
                }
                if (this.VQ == 2) {
                    return rd2.al("options.worldRenderer.smoothbeta");
                }
                return rd2.al("options.worldRenderer.vanilla");
            }
        }
        if (aaq2.jp()) {
            return this.b(aaq2) ? rd2.al("options.on") : rd2.al("options.off");
        }
        if (aaq2.jo()) {
            float f = this.a(aaq2);
            return f == 0.0f ? string + rd2.al("options.off") : string + (int)f + "%";
        }
        return string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ju() {
        atx atx2;
        try {
            if (!this.VR.exists()) {
                return;
            }
            atx2 = new atx();
            try (aat[] aatArray = new BufferedReader(new FileReader(this.VR));){
                String string;
                while ((string = aatArray.readLine()) != null) {
                    aat aat2 = string.split(":");
                    if (((String[])aat2).length <= 1) continue;
                    atx2.put((Object)aat2[0], (Object)aat2[1]);
                }
            }
            this.Vh = this.parseFloat((String)atx2.a((Object)"music", (Object)String.valueOf(this.Vh)));
            this.Vi = this.parseFloat((String)atx2.a((Object)"sound", (Object)String.valueOf(this.Vi)));
            this.Vj = this.parseFloat((String)atx2.a((Object)"weather", (Object)String.valueOf(this.Vj)));
            this.Vk = this.parseFloat((String)atx2.a((Object)"jukebox", (Object)String.valueOf(this.Vk)));
            this.Vl = this.parseFloat((String)atx2.a((Object)"mouseSensitivity", (Object)String.valueOf(this.Vl)));
            this.Vx = this.parseFloat((String)atx2.a((Object)"gamma", (Object)String.valueOf(this.Vx)));
            this.iE();
            this.Vm = ((String)atx2.a((Object)"invertYMouse", (Object)String.valueOf(this.Vm))).equals("true");
            this.Tf = Integer.parseInt((String)atx2.a((Object)"viewDistance", (Object)String.valueOf(this.Tf)));
            this.Tf = this.Tf < 3 ? 3 : Math.min(this.Tf, 16);
            this.Vy = Integer.parseInt((String)atx2.a((Object)"guiScale", (Object)String.valueOf(this.Vy)));
            this.Vp = ((String)atx2.a((Object)"bobView", (Object)String.valueOf(this.Vp))).equals("true");
            Vf = ((String)atx2.a((Object)"anaglyph3d", (Object)String.valueOf(Vf))).equals("true");
            Vg = ((String)atx2.a((Object)"showFog", (Object)String.valueOf(Vg))).equals("true");
            ua.II = ((String)atx2.a((Object)"naturalTextures", (Object)String.valueOf(ua.II))).equals("true");
            this.Vr = ((String)atx2.a((Object)"advancedOpengl", (Object)String.valueOf(this.Vr))).equals("true");
            this.lU = ((String)atx2.a((Object)"fancyGraphics", (Object)String.valueOf(this.lU))).equals("true");
            this.Vt = ((String)atx2.a((Object)"ao", (Object)String.valueOf(this.Vt))).equals("true");
            this.Vs = Integer.parseInt((String)atx2.a((Object)"fpsLimit", (Object)String.valueOf(this.Vs)));
            this.Vv = Integer.parseInt((String)atx2.a((Object)"difficulty", (Object)String.valueOf(this.Vv)));
            this.Vu = (String)atx2.get((Object)"skin");
            this.Vw = (String)atx2.get((Object)"lastServer");
            this.VB = this.parseFloat((String)atx2.a((Object)"fov", (Object)String.valueOf(this.VB)));
            this.VC = this.parseFloat((String)atx2.a((Object)"fogStart", (Object)String.valueOf(this.VC)));
            this.VE = ((String)atx2.a((Object)"newBowModel", (Object)String.valueOf(this.VE))).equals("true");
            this.VD = ((String)atx2.a((Object)"extendedIDShowcase", (Object)String.valueOf(this.VD))).equals("true");
            this.Vz = (String)atx2.get((Object)"language");
            this.VP = (String)atx2.a((Object)"fullscreenResolution", (Object)"default");
            this.VH = ((String)atx2.a((Object)"renderClouds", (Object)String.valueOf(this.VH))).equals("true");
            this.VI = ((String)atx2.a((Object)"colourSunPhases", (Object)String.valueOf(this.VI))).equals("true");
            this.VJ = ((String)atx2.a((Object)"dynamicSky", (Object)String.valueOf(this.VJ))).equals("true");
            this.VF = Boolean.parseBoolean((String)atx2.a((Object)"minecartSound", (Object)"true"));
            this.VG = Boolean.parseBoolean((String)atx2.a((Object)"heldTooltips", (Object)"true"));
            this.Vq = Boolean.parseBoolean((String)atx2.a((Object)"betterFonts", (Object)"false"));
            this.Vn = Boolean.parseBoolean((String)atx2.a((Object)"autojump", (Object)"true"));
            this.Vo = Boolean.parseBoolean((String)atx2.a((Object)"sneakToggled", (Object)"true"));
            this.VL = Boolean.parseBoolean((String)atx2.a((Object)"entityCulling", (Object)"true"));
            this.VM = Boolean.parseBoolean((String)atx2.a((Object)"shaders", (Object)"false"));
            this.VN = Boolean.parseBoolean((String)atx2.a((Object)"widgetPickupItem", (Object)"true"));
            this.VO = Boolean.parseBoolean((String)atx2.a((Object)"indevWalk", (Object)"false"));
            this.VK = ((String)atx2.a((Object)"enableVignette", (Object)String.valueOf(this.VK))).equals("true");
            this.VQ = Integer.parseInt((String)atx2.a((Object)"worldRenderer", (Object)String.valueOf(this.VQ)));
            for (aat aat2 : this.UR) {
                if (!atx2.containsKey((Object)("key_" + aat2.VT))) continue;
                aat2.VV = Integer.parseInt((String)atx2.get((Object)("key_" + aat2.VT)));
            }
        }
        catch (Exception exception) {
            System.out.println("Failed to load options from file \"" + this.VR.getAbsolutePath() + "\": " + exception);
            exception.printStackTrace();
            return;
        }
        try {
            String string = URLDecoder.decode(atx2.getOrDefault("dynmapUrl", URLEncoder.encode(this.Wx, "UTF-8")), "UTF-8");
            if (!string.contains("://")) return;
            this.Wx = string;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private float parseFloat(String string) {
        if (string.equals("true")) {
            return 1.0f;
        }
        return string.equals("false") ? 0.0f : Float.parseFloat(string);
    }

    public void jv() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.VR));
            printWriter.println("dynmapUrl:" + URLEncoder.encode(this.Wx, "UTF-8"));
            printWriter.println("music:" + this.Vh);
            printWriter.println("sound:" + this.Vi);
            printWriter.println("weather:" + this.Vj);
            printWriter.println("jukebox:" + this.Vk);
            printWriter.println("invertYMouse:" + this.Vm);
            printWriter.println("mouseSensitivity:" + this.Vl);
            printWriter.println("gamma:" + this.Vx);
            printWriter.println("viewDistance:" + this.Tf);
            printWriter.println("guiScale:" + this.Vy);
            printWriter.println("bobView:" + this.Vp);
            printWriter.println("anaglyph3d:" + Vf);
            printWriter.println("showFog:" + Vg);
            printWriter.println("naturalTextures:" + ua.II);
            printWriter.println("advancedOpengl:" + this.Vr);
            printWriter.println("fpsLimit:" + this.Vs);
            printWriter.println("difficulty:" + this.Vv);
            printWriter.println("fancyGraphics:" + this.lU);
            printWriter.println("ao:" + this.Vt);
            printWriter.println("skin:" + this.Vu);
            printWriter.println("lastServer:" + this.Vw);
            printWriter.println("fov:" + this.VB);
            printWriter.println("fogStart:" + this.VC);
            printWriter.println("newBowModel:" + this.VE);
            printWriter.println("extendedIDShowcase:" + this.VD);
            printWriter.println("language:" + this.Vz);
            printWriter.println("fullscreenResolution:" + this.VP);
            printWriter.println("renderClouds:" + this.VH);
            printWriter.println("colourSunPhases:" + this.VI);
            printWriter.println("dynamicSky:" + this.VJ);
            printWriter.println("minecartSound:" + this.VF);
            printWriter.println("heldTooltips:" + this.VG);
            printWriter.println("betterFonts:" + this.Vq);
            printWriter.println("autojump:" + this.Vn);
            printWriter.println("sneakToggled:" + this.Vo);
            printWriter.println("entityCulling:" + this.VL);
            printWriter.println("shaders:" + this.VM);
            printWriter.println("widgetPickupItem:" + this.VN);
            printWriter.println("indevWalk:" + this.VO);
            printWriter.println("enableVignette:" + this.VK);
            printWriter.println("worldRenderer:" + this.VQ);
            for (aat aat2 : this.UR) {
                printWriter.println("key_" + aat2.VT + ":" + aat2.VV);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }
}

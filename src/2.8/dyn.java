/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  jt
 *  kc
 *  net.minecraft.client.Minecraft
 *  oj
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 *  rd
 *  yp
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class dyn
extends kc {
    private static final ExecutorService AB = new ThreadPoolExecutor(6, 12, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(600));
    private String Aa;
    private static String Ab = "flat";
    private int Ac = 2;
    private double Ad = 0.0;
    private double Ae = 0.0;
    private boolean Af = false;
    private int Ag = 0;
    private int Ah = 0;
    private long Ai = 0L;
    private File Aj;
    private Map<String, BufferedImage> Ak = new ConcurrentHashMap<String, BufferedImage>();
    private Map<String, Integer> Al = new HashMap<String, Integer>();
    private ConcurrentHashMap<String, Boolean> Am = new ConcurrentHashMap();
    private volatile List<double[]> An = new ArrayList<double[]>();
    private volatile List<String> Ao = new ArrayList<String>();
    private volatile List<Integer> Ap = new ArrayList<Integer>();
    private AtomicInteger Aq = new AtomicInteger(0);
    private AtomicInteger Ar = new AtomicInteger(0);
    private static boolean As = false;
    private int At = 0;
    private static boolean Au = false;
    private static final int[] Av = new int[]{0, 0, -64, -96, -112, -122, -125};
    private static final int[] Ax = new int[]{0, 0, 0, 0, 0, 0, 0};
    private boolean Ay = false;
    private long lastTileRefresh = 0L;
    private Map<String, Long> Az = new ConcurrentHashMap<String, Long>();
    private String BA = null;
    private String BC = null;
    public static boolean BD = false;
    public static int BE = -1;
    public static int BF = -1;
    public static boolean BH = true;
    public static boolean BI = true;
    public static boolean cityMode = false;
    public static boolean cityViewOnly = false;
    public static String cityActiveName = "";
    public static boolean cityStreetDraw = false;
    public static ArrayList<double[]> cityStreetPoints = new ArrayList();
    public static boolean cityStreetConfirm = false;
    public static String cityStreetName = "";
    public static int cityTool = 0;
    public static int cityEditingStreetIdx = -1;
    public static ArrayList<Street> cityStreets = new ArrayList();
    public static ArrayList<Building> cityBuildings = new ArrayList();
    public static ArrayList<Citizen> cityCitizens = new ArrayList();
    public static HashMap<String, String> cityMayors = new HashMap();
    public static double goTargetX = Double.NaN;
    public static double goTargetZ = Double.NaN;
    public static double savedCamX = Double.NaN;
    public static double savedCamZ = Double.NaN;
    public static int hkGoto = 34;
    public static int hkMarker = 50;
    public static int hkPm = 33;
    public static int hkPxAdj = 25;
    public static int hkPxMinus = 44;
    public static int hkPxPlus = 45;
    public static int hkQ = 16;
    public static int hkW = 17;
    public static int hkE = 18;
    public static int hkR = 19;
    public static int hkT = 20;
    public static int hkA = 30;
    public static int hkS = 31;
    public static int hkB = 48;
    public static int hkC = 46;
    public static int hkReload = 19;
    public static int hkMQ = 16;
    public static int hkMW = 17;
    public static int hkMA = 30;
    public static int hkMS = 31;
    private boolean rmbUsed = false;

    public void aQ() {
        Object object;
        this.Af = false;
        this.rU.clear();
        if (!Double.isNaN(savedCamX) && !Double.isNaN(savedCamZ) && Double.isNaN(goTargetX) && Double.isNaN(coord.Ar)) {
            goTargetX = savedCamX;
            goTargetZ = savedCamZ;
            savedCamX = Double.NaN;
            savedCamZ = Double.NaN;
        }
        if (!Double.isNaN(goTargetX) && !Double.isNaN(goTargetZ)) {
            if (Minecraft.ch().pR != null) {
                this.Ad = goTargetX - Minecraft.ch().pR.Yr;
                this.Ae = goTargetZ - Minecraft.ch().pR.Yt;
                object = this.Al.values().iterator();
                while (object.hasNext()) {
                    int n = object.next();
                    GL11.glDeleteTextures((int)n);
                }
                this.Al.clear();
                this.Ak.clear();
                this.Am.clear();
            }
            goTargetX = Double.NaN;
            goTargetZ = Double.NaN;
        } else if (!Double.isNaN(coord.Ar) && !Double.isNaN(coord.As)) {
            if (Minecraft.ch().pR != null) {
                this.Ad = coord.Ar - Minecraft.ch().pR.Yr;
                this.Ae = coord.As - Minecraft.ch().pR.Yt;
                object = this.Al.values().iterator();
                while (object.hasNext()) {
                    int n = object.next();
                    GL11.glDeleteTextures((int)n);
                }
                this.Al.clear();
                this.Ak.clear();
                this.Am.clear();
            }
            coord.Ar = Double.NaN;
            coord.As = Double.NaN;
        }
        this.Aa = this.qI.qh.Wx;
        if (!this.Aa.endsWith("/")) {
            this.Aa = this.Aa + "/";
        }
        if (this.Aj == null) {
            object = new File(Minecraft.cc(), "dynmapcache");
            if (!((File)object).exists()) {
                ((File)object).mkdirs();
            }
            this.Aj = object;
        }
        this.rU.add(new jt(104, 4, 4, 50, 20, rd.gH().al("rumo.set")));
        this.rU.add(new jt(102, 58, 4, 50, 20, rd.gH().al("rumo.list")));
        if (BD) {
            this.rU.add(new jt(105, 112, 4, 55, 20, rd.gH().al("rumo.stations")));
        }
        if (cityMode) {
            this.rU.add(new jt(116, 170, 4, 50, 20, rd.gH().al("rumo.streets")));
            this.rU.add(new jt(117, 222, 4, 55, 20, rd.gH().al("rumo.buildings")));
            this.rU.add(new jt(118, 279, 4, 50, 20, rd.gH().al("rumo.citizens")));
        }
        if (!Au) {
            Au = true;
            mrk.As();
            AB.submit(() -> this.Av());
        }
    }

    private void Av() {
        try {
            String string = this.Aw(this.Aa + "up/configuration");
            if (string == null) {
                return;
            }
            JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("worlds");
            if (jsonArray == null || jsonArray.size() == 0) {
                return;
            }
            JsonArray jsonArray2 = jsonArray.get(0).getAsJsonObject().getAsJsonArray("maps");
            if (jsonArray2 != null && jsonArray2.size() > 0 && jsonArray2.get(0).getAsJsonObject().has("prefix")) {
                Ab = jsonArray2.get(0).getAsJsonObject().get("prefix").getAsString();
            }
            As = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private String Aw(String string) {
        try {
            String string2;
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.setReadTimeout(4000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string2 = bufferedReader.readLine()) != null) {
                stringBuilder.append(string2);
            }
            bufferedReader.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return null;
        }
    }

    private void Ax() {
        long l = System.currentTimeMillis();
        if (l - this.Ai < 2000L) {
            return;
        }
        this.Ai = l;
        AB.submit(() -> {
            try {
                String string = this.Aw(this.Aa + "up/world/world/" + l);
                if (string == null) {
                    return;
                }
                JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("players");
                ArrayList<double[]> arrayList = new ArrayList<double[]>();
                ArrayList<String> arrayList2 = new ArrayList<String>();
                ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
                if (jsonArray != null) {
                    for (int i = 0; i < jsonArray.size(); ++i) {
                        String string2;
                        JsonObject jsonObject2 = jsonArray.get(i).getAsJsonObject();
                        arrayList.add(new double[]{jsonObject2.get("x").getAsDouble(), jsonObject2.get("z").getAsDouble()});
                        String string3 = jsonObject2.has("account") ? jsonObject2.get("account").getAsString() : jsonObject2.get("name").getAsString();
                        arrayList2.add(string3);
                        int n = this.Ay(string3);
                        String string4 = string2 = jsonObject2.has("world") ? jsonObject2.get("world").getAsString() : "";
                        if (string2.contains("nether") || string2.contains("DIM-1")) {
                            n = n & 0xFFFFFF | 0x50000000;
                        }
                        arrayList3.add(n);
                    }
                }
                this.An = arrayList;
                this.Ao = arrayList2;
                this.Ap = arrayList3;
                if (!As && jsonArray != null && jsonArray.size() > 0) {
                    JsonObject jsonObject3 = jsonArray.get(0).getAsJsonObject();
                    if (this.Ad == 0.0 && this.Ae == 0.0) {
                        this.Ad = jsonObject3.get("x").getAsDouble() - Minecraft.ch().pR.Yr;
                        this.Ae = jsonObject3.get("z").getAsDouble() - Minecraft.ch().pR.Yt;
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
    }

    private int Ay(String string) {
        int n = string.hashCode();
        int n2 = (n & 0xFF) + 80;
        int n3 = (n >> 8 & 0xFF) + 80;
        int n4 = (n >> 16 & 0xFF) + 80;
        return 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    private int Az(int n) {
        int n2 = this.Ac > 1 ? 1 << this.Ac - 1 : 1;
        return n >= 0 ? n / n2 * n2 : (n - n2 + 1) / n2 * n2;
    }

    private String AA(int n, int n2) {
        int n3 = this.Ac > 1 ? 1 << this.Ac - 1 : 1;
        int n4 = this.Az(n);
        int n5 = this.Az(n2);
        String string = "";
        for (int i = 1; i < this.Ac; ++i) {
            string = string + "z";
        }
        if (this.Ac > 1) {
            string = string + "_";
        }
        return Ab + "/" + (n4 >> 5) + "_" + (n5 >> 5) + "/" + string + n4 + "_" + n5 + ".png";
    }

    private void AB(String string) {
        String string2 = this.Aa + "tiles/world/" + string + "?_=" + System.currentTimeMillis();
        File file = new File(this.Aj, string.replace("/", "_").replace("\\", "_"));
        if (file.exists()) {
            long l = System.currentTimeMillis() - file.lastModified();
            if (l > 300000L) {
                file.delete();
            } else {
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    if (bufferedImage != null) {
                        this.Ak.put(string, bufferedImage);
                        this.Ar.incrementAndGet();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                this.Am.remove(string);
                return;
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string2).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedImage bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                if (bufferedImage != null) {
                    this.Ak.put(string, bufferedImage);
                    this.Ar.incrementAndGet();
                    try {
                        ImageIO.write((RenderedImage)bufferedImage, "png", file);
                    }
                    catch (Exception exception) {}
                }
            } else {
                httpURLConnection.disconnect();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.Am.remove(string);
    }

    private void AC() {
        int n;
        ArrayList<Object> arrayList;
        ArrayList<String> arrayList2;
        if (!As) {
            return;
        }
        Minecraft minecraft = Minecraft.ch();
        if (minecraft.pR == null) {
            return;
        }
        double d = minecraft.pR.Yr + this.Ad;
        double d2 = minecraft.pR.Yt + this.Ae;
        int n2 = (int)Math.floor(d / 64.0);
        int n3 = (int)Math.floor(d2 / -64.0);
        int n4 = this.Ac > 1 ? 1 << this.Ac - 1 : 1;
        n2 = this.Az(n2);
        n3 = this.Az(n3);
        int n5 = 2 + this.Ac / 2;
        long l = System.currentTimeMillis();
        if (l - this.lastTileRefresh > 300000L) {
            Object object;
            this.lastTileRefresh = l;
            arrayList2 = new ArrayList();
            arrayList = new ArrayList();
            for (String string : this.Al.keySet()) {
                object = string.replace(".png", "").split("_");
                if (((String[])object).length < 3) continue;
                try {
                    int n6 = Integer.parseInt(object[((String[])object).length - 2]);
                    int n7 = Integer.parseInt((String)object[((Object)object).length - 1]);
                    if (Math.abs(n6 - n2) > n5 * n4 * 2 || Math.abs(n7 - n3) > n5 * n4 * 2) {
                        arrayList2.add(string);
                        continue;
                    }
                    if (Math.abs(n6 - n2) > n5 * n4 || Math.abs(n7 - n3) > n5 * n4) continue;
                    arrayList.add(string);
                }
                catch (Exception exception) {}
            }
            for (String string : arrayList2) {
                this.Am.remove(string);
                object = this.Al.remove(string);
                if (object == null) continue;
                GL11.glDeleteTextures((int)((Integer)object));
            }
            for (String string : arrayList) {
                this.Am.remove(string);
                object = this.Al.remove(string);
                if (object != null) {
                    GL11.glDeleteTextures((int)((Integer)object));
                }
                this.Am.put(string, true);
                this.Aq.incrementAndGet();
                String string2 = string;
                AB.submit(() -> this.loadTile(string2));
            }
        }
        arrayList2 = new ArrayList<String>();
        arrayList = new ArrayList<Object>();
        for (n = n2 - n5 * n4; n < n2 + n5 * n4; n += n4) {
            for (int i = n3 - n5 * n4; i < n3 + n5 * n4; i += n4) {
                String string = this.AA(n, i);
                if (this.Am.containsKey(string) || this.Al.containsKey(string)) continue;
                double d3 = (double)n * 64.0 - d;
                double d4 = (double)i * 64.0 - d2;
                arrayList2.add(string);
                arrayList.add(d3 * d3 + d4 * d4);
            }
        }
        for (int i = 0; i < arrayList2.size() - 1; ++i) {
            for (int j = i + 1; j < arrayList2.size(); ++j) {
                if (!((Double)arrayList.get(j) < (Double)arrayList.get(i))) continue;
                Double d5 = (Double)arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, d5);
                String string = (String)arrayList2.get(i);
                arrayList2.set(i, (String)arrayList2.get(j));
                arrayList2.set(j, string);
            }
        }
        for (n = 0; n < arrayList2.size(); ++n) {
            String string = (String)arrayList2.get(n);
            this.Am.put(string, true);
            this.Aq.incrementAndGet();
            AB.submit(() -> this.loadTile(string));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void a(int n, int n2, float f) {
        String string;
        int n3;
        boolean bl;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int line;
        Object n40;
        Object d12;
        Map<String, BufferedImage> map;
        int n12;
        Object object;
        int n13;
        int n14;
        Object object2;
        int n15;
        int n16;
        int n17;
        int n18;
        Object object6;
        int n19;
        int n20;
        double d;
        double d2;
        this.dj();
        this.Ax();
        this.AC();
        boolean bl2 = false;
        if (cityMode && !cityActiveName.isEmpty() && Minecraft.ch() != null && Minecraft.ch().pR != null) {
            d2 = Minecraft.ch().pR.Yr;
            d = Minecraft.ch().pR.Yt;
            for (mrk.Entry object72 : mrk.Ar) {
                double n25;
                double d3;
                double d5;
                double d4;
                if (!object72.name.equals(cityActiveName) || !(d4 * (d5 = object72.x - d2) + d3 * (n25 = object72.z - d) < 2214144.0) || this.Ac >= 6) continue;
                bl2 = true;
                break;
            }
        }
        d2 = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
        d = 128.0 / (64.0 * d2);
        if (Mouse.isButtonDown((int)0) && !this.Af) {
            this.Af = true;
            this.Ag = n;
            this.Ah = n2;
        } else if (!Mouse.isButtonDown((int)0)) {
            this.Af = false;
        }
        if (this.Af) {
            this.Ad -= (double)(n - this.Ag) / d;
            this.Ae -= (double)(n2 - this.Ah) / d;
            this.Ag = n;
            this.Ah = n2;
        }
        if ((n20 = Mouse.getDWheel()) != 0 && (n19 = this.Ac + (n20 > 0 ? -1 : 1)) >= 1 && n19 <= 6 && n19 != this.Ac) {
            object6 = this.Al.values().iterator();
            while (object6.hasNext()) {
                int n22 = (Integer)object6.next();
                GL11.glDeleteTextures((int)n22);
            }
            this.Al.clear();
            this.Ak.clear();
            this.Ac = n19;
        }
        GL11.glBindTexture((int)3553, (int)0);
        object6 = Minecraft.ch();
        if (object6 != null && ((Minecraft)object6).pR != null && As) {
            double d7 = ((Minecraft)object6).pR.Yr + this.Ad;
            double object3 = ((Minecraft)object6).pR.Yt + this.Ae;
            n18 = (int)Math.floor(d7 / (double)((int)d2 * 64));
            n17 = (int)Math.floor(object3 / (double)((int)d2 * -64));
            n16 = 2 + this.Ac / 2;
            for (int iterator = n18 - n16; iterator < n18 + n16; ++iterator) {
                int entry = iterator * (int)d2;
                for (n15 = n17 - n16; n15 < n17 + n16; ++n15) {
                    object2 = n15 * (int)d2;
                    String string2 = this.AA(entry, (int)object2);
                    Integer n21 = this.Al.get(string2);
                    if (n21 == null) continue;
                    n14 = (int)(((double)entry * 64.0 + 32.0 * d2 - d7) * d + (double)this.width / 2.0 - 64.0);
                    n13 = (int)((-((double)object2) * 64.0 - 32.0 * d2 - object3) * d + (double)this.height / 2.0 - 64.0 - (double)Av[this.Ac]);
                    if (n14 + 128 <= 0 || n13 + 128 <= 0 || n14 >= this.width || n13 >= this.height) continue;
                    GL11.glBindTexture((int)3553, (int)n21);
                    object = yp.OZ;
                    object.iq();
                    n12 = -1;
                    object.bx(n12);
                    object.a((double)n14, (double)(n13 + 128), 0.0, 0.0, 1.0);
                    object.a((double)(n14 + 128), (double)(n13 + 128), 0.0, 1.0, 1.0);
                    object.a((double)(n14 + 128), (double)n13, 0.0, 1.0, 0.0);
                    object.a((double)n14, (double)n13, 0.0, 0.0, 0.0);
                    object.ir();
                }
            }
        }
        Map<String, BufferedImage> map2 = this.Ak;
        int n22 = 0;
        Map<String, BufferedImage> object8 = map = map2;
        synchronized (object8) {
            Iterator<Map.Entry<String, BufferedImage>> n28 = this.Ak.entrySet().iterator();
            while (n28.hasNext() && n22 < 8) {
                Map.Entry<String, BufferedImage> d10 = n28.next();
                if (this.Al.containsKey(d10.getKey())) {
                    n28.remove();
                    continue;
                }
                object = d10.getValue();
                n18 = GL11.glGenTextures();
                GL11.glBindTexture((int)3553, (int)n18);
                GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
                GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
                n17 = ((BufferedImage)object).getWidth();
                n16 = ((BufferedImage)object).getHeight();
                d12 = new int[n17 * n16];
                ((BufferedImage)object).getRGB(0, 0, n17, n16, (int[])d12, 0, n17);
                n40 = BufferUtils.createByteBuffer((int)(n17 * n16 * 4));
                for (n15 = 0; n15 < n17 * n16; ++n15) {
                    object2 = d12[n15];
                    ((ByteBuffer)n40).put((byte)(object2 >> 16 & 0xFF));
                    ((ByteBuffer)n40).put((byte)(object2 >> 8 & 0xFF));
                    ((ByteBuffer)n40).put((byte)(object2 & 0xFF));
                    ((ByteBuffer)n40).put((byte)(object2 >> 24 & 0xFF));
                }
                ((Buffer)n40).flip();
                GL11.glTexImage2D((int)3553, (int)0, (int)6408, (int)n17, (int)n16, (int)0, (int)6408, (int)5121, (ByteBuffer)n40);
                this.Al.put(d10.getKey(), n18);
                n28.remove();
                ++n22;
            }
        }
        GL11.glBindTexture((int)3553, (int)0);
        this.BA = null;
        if (((Minecraft)object6).pR != null) {
            double d9 = ((Minecraft)object6).pR.Yr + this.Ad;
            double d11 = ((Minecraft)object6).pR.Yt + this.Ae;
            d12 = this.An;
            n40 = this.Ap;
            List<String> i = this.Ao;
            n13 = Math.min(d12.size(), n40.size());
            line = Math.min(i.size(), n13);
            for (n15 = 0; n15 < line; ++n15) {
                double[] n26 = (double[])d12.get(n15);
                n11 = (int)((n26[0] - d9) * d + (double)this.width / 2.0);
                n10 = (int)((n26[1] - d11) * d + (double)this.height / 2.0);
                if (n11 <= 0 || n11 >= this.width || n10 <= 0 || n10 >= this.height) continue;
                n14 = (Integer)n40.get(n15);
                if (this.Ac > 1) {
                    this.b(this.pX, "~", n11 - 4, n10 - 4 - Ax[this.Ac], n14);
                } else {
                    this.d(n11 - 4, n10 - 1, n11 + 4, n10 + 1, n14);
                    this.d(n11 - 1, n10 - 4, n11 + 1, n10 + 4, n14);
                }
                if (n < n11 - 8 || n >= n11 + 8 || n2 < n10 - 8 || n2 >= n10 + 8) continue;
                this.BA = (String)i.get(n15);
            }
            if (this.BA != null) {
                n15 = n + 10;
                int station = n2 - 10;
                if (station < 4) {
                    station = 4;
                }
                this.b(this.pX, "\u00a7l" + this.BA, n15, station, 0xE0E0E0);
            }
        }
        GL11.glBindTexture((int)3553, (int)0);
        int n27 = this.width / 2;
        int n23 = this.height / 2;
        this.d(n27 - 2, n23 - 2, n27 + 2, n23 - 2, -16777216);
        this.d(n27 - 2, n23 + 2, n27 + 2, n23 + 2, -16777216);
        this.d(n27 - 2, n23 - 2, n27 - 2, n23 + 2, -16777216);
        this.d(n27 + 2, n23 - 2, n27 + 2, n23 + 2, -16777216);
        this.d(n27 - 1, n23 - 1, n27 + 1, n23 + 1, -1);
        if (BH && ((Minecraft)object6).pR != null) {
            double d13 = ((Minecraft)object6).pR.Yr + this.Ad;
            double d14 = ((Minecraft)object6).pR.Yt + this.Ae;
            GL11.glDisable((int)3553);
            GL11.glLineWidth((float)3.0f);
            GL11.glBegin((int)1);
            GL11.glColor3f((float)1.0f, (float)0.0f, (float)0.0f);
            for (mt.Line station : mt.As) {
                if (station.a >= mt.Ar.size() || station.b >= mt.Ar.size()) continue;
                mt.Station n29 = mt.Ar.get(station.a);
                mt.Station n30 = mt.Ar.get(station.b);
                n11 = (int)((n29.x - d13) * d + (double)this.width / 2.0);
                n10 = (int)((n29.z - d14) * d + (double)this.height / 2.0);
                n9 = (int)((n30.x - d13) * d + (double)this.width / 2.0);
                n14 = (int)((n30.z - d14) * d + (double)this.height / 2.0);
                GL11.glVertex2f((float)n11, (float)n10);
                GL11.glVertex2f((float)n9, (float)n14);
            }
            GL11.glEnd();
            GL11.glEnable((int)3553);
            for (int d15 = 0; d15 < mt.Ar.size(); ++d15) {
                mt.Station string9 = mt.Ar.get(d15);
                int d16 = (int)((string9.x - d13) * d + (double)this.width / 2.0);
                int n34 = (int)((string9.z - d14) * d + (double)this.height / 2.0);
                this.d(d16 - 2, n34 - 2, d16 + 2, n34 + 2, string9.color);
                if (n < d16 - 5 || n >= d16 + 5 || n2 < n34 - 5 || n2 >= n34 + 5) continue;
                n11 = this.pX.aD(string9.name);
                this.b(this.pX, string9.name, d16 - n11 / 2, n34 - 12, string9.color);
            }
        }
        if (cityMode && ((Minecraft)object6).pR != null) {
            float f2;
            double d19 = ((Minecraft)object6).pR.Yr + this.Ad;
            double d20 = ((Minecraft)object6).pR.Yt + this.Ae;
            double d5 = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
            double d6 = 128.0 / (64.0 * d5);
            GL11.glDisable((int)3553);
            GL11.glLineWidth((float)3.0f);
            for (Street bl4 : cityStreets) {
                if (bl4.points.size() < 2 || !bl4.cityMarker.equals(cityActiveName)) continue;
                GL11.glBegin((int)3);
                GL11.glColor3f((float)0.85f, (float)0.7f, (float)0.0f);
                for (n9 = 0; n9 < bl4.points.size(); ++n9) {
                    double[] dArray = bl4.points.get(n9);
                    f2 = (float)((dArray[0] - d19) * d6 + (double)this.width / 2.0);
                    float f3 = (float)((dArray[1] - d20) * d6 + (double)this.height / 2.0);
                    GL11.glVertex2f((float)f2, (float)f3);
                }
                GL11.glEnd();
            }
            if (cityStreetDraw && cityStreetPoints.size() > 0) {
                GL11.glBegin((int)3);
                GL11.glColor3f((float)1.0f, (float)0.85f, (float)0.2f);
                for (int bl3 = 0; bl3 < cityStreetPoints.size(); ++bl3) {
                    double[] n45 = cityStreetPoints.get(bl3);
                    float f4 = (float)((n45[0] - d19) * d6 + (double)this.width / 2.0);
                    f2 = (float)((n45[1] - d20) * d6 + (double)this.height / 2.0);
                    GL11.glVertex2f((float)f4, (float)f2);
                }
                GL11.glEnd();
            }
            GL11.glEnable((int)3553);
            for (Building building : cityBuildings) {
                int n24;
                Object object3;
                Object object4;
                int n25;
                if (!building.cityMarker.equals(cityActiveName)) continue;
                double d7 = (building.x - d19) * d6 + (double)this.width / 2.0;
                double d8 = (building.z - d20) * d6 + (double)this.height / 2.0;
                if (d7 < -50.0 || d7 > (double)(this.width + 50) || d8 < -50.0 || d8 > (double)(this.height + 50)) continue;
                switch (building.type) {
                    case 1: {
                        n25 = 43520;
                        break;
                    }
                    case 2: {
                        n25 = 35071;
                        break;
                    }
                    case 3: {
                        n25 = -22016;
                        break;
                    }
                    case 4: {
                        n25 = 0x888888;
                        break;
                    }
                    default: {
                        n25 = 0xFFFFFF;
                    }
                }
                if (building.type == 3) {
                    this.d((int)d7 - 4, (int)d8 - 4, (int)d7 + 4, (int)d8 + 4, n25);
                    this.d((int)d7 - 2, (int)d8 - 2, (int)d7 + 2, (int)d8 + 2, 0xFFFF55);
                } else if (building.type == 4) {
                    this.d((int)d7 - 3, (int)d8 - 3, (int)d7 + 3, (int)d8 + 3, n25);
                    this.d((int)d7 - 1, (int)d8 - 3, (int)d7 + 1, (int)d8 + 3, -1);
                    this.d((int)d7 - 3, (int)d8 - 1, (int)d7 + 3, (int)d8 + 1, -1);
                } else {
                    this.d((int)d7 - 3, (int)d8 - 3, (int)d7 + 3, (int)d8 + 3, n25);
                    this.d((int)d7 - 2, (int)d8 - 2, (int)d7 + 2, (int)d8 + 2, -1);
                }
                if (building.type == 3) {
                    this.b(this.pX, building.name, (int)d7 + 6, (int)d8 - 4, n25);
                } else if (building.type == 4) {
                    this.b(this.pX, building.name, (int)d7 + 6, (int)d8 - 4, n25);
                }
                if (!((double)n >= d7 - 10.0 && (double)n < d7 + 10.0 && (double)n2 >= d8 - 10.0 && (double)n2 < d8 + 10.0)) continue;
                n8 = (int)d7 + 10;
                n7 = (int)d8 + 6;
                ArrayList<Object> arrayList = new ArrayList<Object>();
                if (building.type == 1 && !building.owner.isEmpty()) {
                    arrayList.add(building.owner);
                }
                if (building.type == 2 && building.residents.size() > 0) {
                    object4 = new ArrayList(building.residents);
                    Collections.sort(object4, new Comparator(){

                        public int compare(Building.Resident resident, Building.Resident resident2) {
                            try {
                                return Integer.compare(Integer.parseInt(resident.apartment), Integer.parseInt(resident2.apartment));
                            }
                            catch (Exception exception) {
                                return resident.apartment.compareTo(resident2.apartment);
                            }
                        }
                    });
                    for (n6 = 0; n6 < ((ArrayList)object4).size(); ++n6) {
                        object3 = (Building.Resident)((ArrayList)object4).get(n6);
                        arrayList.add(((Building.Resident)object3).apartment + " | " + ((Building.Resident)object3).nick);
                    }
                }
                if (building.type == 3 && !building.owner.isEmpty()) {
                    void var54_124;
                    object4 = building.owner.split(",");
                    object3 = ((String[])object4).length > 1 ? rd.gH().al("rumo.builders") : rd.gH().al("rumo.builder");
                    String string3 = (String)object3 + ": ";
                    for (n24 = 0; n24 < ((Object)object4).length; ++n24) {
                        void var54_126;
                        String string4 = ((String)object4[n24]).trim();
                        if (string4.isEmpty()) continue;
                        if (n24 > 0) {
                            String string5 = (String)var54_124 + ", ";
                        }
                        if (var54_126.length() + string4.length() > 20 && n24 > 0) {
                            arrayList.add(var54_126);
                            String string6 = "  " + string4;
                            continue;
                        }
                        String string7 = (String)var54_126 + string4;
                    }
                    if (!var54_124.trim().isEmpty()) {
                        arrayList.add(var54_124);
                    }
                }
                if (building.type == 4 && !building.owner.isEmpty()) {
                    arrayList.add(building.owner);
                }
                if (!((String)(object4 = (!building.address.isEmpty() ? building.address + " - " : "") + building.houseNumber)).trim().isEmpty()) {
                    arrayList.add(object4);
                }
                if (!building.info.isEmpty()) {
                    object3 = building.info;
                    int n26 = 20;
                    while (((String)object3).length() > n26) {
                        arrayList.add("\u00a7o" + ((String)object3).substring(0, n26));
                        object3 = ((String)object3).substring(n26);
                    }
                    if (!((String)object3).isEmpty()) {
                        arrayList.add("\u00a7o" + object3);
                    }
                }
                if (arrayList.size() <= 0) continue;
                n6 = 0;
                for (String string8 : arrayList) {
                    n24 = this.pX.aD(string8);
                    if (n24 <= n6) continue;
                    n6 = n24;
                }
                this.d(n8 - 2, n7 - 2, n8 + n6 + 4, n7 + arrayList.size() * 10 + 2, -1610612736);
                for (int i = 0; i < arrayList.size(); ++i) {
                    this.b(this.pX, (String)arrayList.get(i), n8, n7 + i * 10, 0xE0E0E0);
                }
            }
        }
        if (BI && ((Minecraft)object6).pR != null) {
            double list = ((Minecraft)object6).pR.Yr + this.Ad;
            double n39 = ((Minecraft)object6).pR.Yt + this.Ae;
            for (int n43 : new int[]{2, 0, 1}) {
                for (mrk.Entry entry : mrk.Ar) {
                    int n28;
                    if (entry.importance != n43) continue;
                    int n29 = (int)((entry.x - list) * d + (double)this.width / 2.0);
                    n14 = (int)((entry.z - n39) * d + (double)this.height / 2.0);
                    if (n29 <= 0 || n29 >= this.width || n14 <= 0 || n14 >= this.height) continue;
                    String string9 = entry.importance == 1 ? "\u00a7l" : (entry.importance == 2 ? "\u00a7o" : "\u00a7n");
                    this.b(this.pX, string9 + entry.name, n29 + 6, n14 - 4, entry.color);
                    this.d(n29 - 3, n14 - 3, n29 + 3, n14 + 3, entry.color);
                    this.d(n29 - 2, n14 - 2, n29 + 2, n14 + 2, -1);
                    if (n < n29 - 6 || n >= n29 + 6 || n2 < n14 - 6 || n2 >= n14 + 6) continue;
                    String string10 = cityMayors.get(entry.name);
                    if (entry.desc.isEmpty() && (string10 == null || string10.isEmpty())) continue;
                    ArrayList<String> arrayList = new ArrayList<String>();
                    if (!entry.desc.isEmpty()) {
                        Object object5 = entry.desc;
                        n12 = 20;
                        while (((String)object5).length() > n12) {
                            arrayList.add("\u00a7o" + ((String)object5).substring(0, n12));
                            object5 = ((String)object5).substring(n12);
                        }
                        if (!((String)object5).isEmpty()) {
                            arrayList.add("\u00a7o" + (String)object5);
                        }
                    }
                    if (string10 != null && !string10.isEmpty()) {
                        arrayList.add(rd.gH().al("rumo.mayor") + ": " + string10);
                    }
                    n8 = 0;
                    for (String string11 : arrayList) {
                        n28 = this.pX.aD(string11);
                        if (n28 <= n8) continue;
                        n8 = n28;
                    }
                    n7 = n29 + 10;
                    int n30 = n14 + 6;
                    n28 = n8 + 6;
                    int n31 = arrayList.size() * 10 + 6;
                    this.d(n7 - 2, n30 - 2, n7 + n28 + 2, n30 + n31 + 2, -1610612736);
                    n6 = n30;
                    for (String string12 : arrayList) {
                        this.b(this.pX, string12, n7 + 1, n6 + 1, 0xE0E0E0);
                        n6 += 10;
                    }
                }
            }
        }
        List<String> list = this.Ao;
        object = this.Ap;
        int n32 = Math.min(list.size(), object.size());
        int n33 = this.width - 110;
        int n34 = (n32 + 12) / 13;
        if (n34 < 1) {
            n34 = 1;
        }
        if ((n5 = this.At / 13) < 0) {
            n5 = 0;
        }
        if (n5 >= n34) {
            n5 = n34 - 1;
        }
        this.At = n5 * 13;
        this.BC = null;
        for (n4 = 0; n4 < n32; ++n4) {
            boolean n44;
            if (n4 - this.At < 0 || n4 - this.At >= 13) continue;
            String string13 = list.get(n4);
            int bl5 = n33;
            int bl3 = 4 + (n4 - this.At) * 12;
            boolean bl4 = n44 = n >= bl5 && n < bl5 + 100 && n2 >= bl3 && n2 < bl3 + 12;
            if (n44) {
                this.BC = string13;
            }
            this.d(bl5, bl3, bl5 + 100, bl3 + 12, n44 ? -1342177281 : -1610612736);
            this.b(this.pX, string13, bl5 + 4, bl3 + 2, (Integer)object.get(n4));
        }
        if (n34 > 1) {
            n4 = 162;
            line = n >= n33 && n < n33 + 100 && n2 >= n4 && n2 < n4 + 12 ? 1 : 0;
            boolean n35 = n >= n33 && n < n33 + 100 && n2 >= n4 + 14 && n2 < n4 + 26;
            this.d(n33, n4, n33 + 100, n4 + 12, line != 0 ? -1342177281 : -1610612736);
            this.b(this.pX, n5 > 0 ? "\u25b2 " + rd.gH().al("rumo.page") + " " + n5 + "/" + n34 : "---", n33 + 4, n4 + 2, n5 > 0 ? 0xE0E0E0 : 0x606060);
            this.d(n33, n4 + 14, n33 + 100, n4 + 26, n35 ? -1342177281 : -1610612736);
            this.b(this.pX, n5 < n34 - 1 ? "\u25bc " + rd.gH().al("rumo.page") + " " + (n5 + 2) + "/" + n34 : "---", n33 + 4, n4 + 16, n5 < n34 - 1 ? 0xE0E0E0 : 0x606060);
        }
        boolean bl5 = bl = n >= (n3 = this.pX.aD(string = rd.gH().al("rumo.zoom") + " " + this.Ac + " | " + this.Ar + "/" + this.Aq + " | " + n32 + " " + rd.gH().al("rumo.players") + " | ") + 4) && n < n3 + this.pX.aD(rd.gH().al("rumo.hotkeys")) && n2 >= this.height - 12 && n2 < this.height;
        if (BD) {
            this.b(this.pX, hotkeys.keyCodeToName(hkMQ) + "=" + rd.gH().al("rumo.qstation"), 4, 35, 0x808080);
            this.b(this.pX, hotkeys.keyCodeToName(hkMW) + "=" + rd.gH().al("rumo.wline"), 4, 47, BF == -2 ? -16711936 : 0x808080);
            this.b(this.pX, hotkeys.keyCodeToName(hkMS) + "=" + rd.gH().al("rumo.sdelline"), 4, 59, BF == -3 ? -65536 : 0x808080);
            this.b(this.pX, hotkeys.keyCodeToName(hkMA) + "=" + rd.gH().al("rumo.adelst"), 4, 71, BF == -4 ? -65536 : 0x808080);
            this.a(this.pX, "X", this.width / 2, 4, -65536);
        }
        if (cityMode) {
            void var44_97;
            int n35 = 0x808080;
            for (mrk.Entry entry : mrk.Ar) {
                if (!entry.name.equals(cityActiveName)) continue;
                n35 = entry.color;
                break;
            }
            this.b(this.pX, rd.gH().al("rumo.cityMode") + ": " + cityActiveName, 4, 35, n35);
            int n36 = 47;
            if (!cityViewOnly) {
                this.b(this.pX, hotkeys.keyCodeToName(hkQ) + "=" + rd.gH().al("rumo.streetDraw"), 4, n36, cityStreetDraw ? -16711936 : 0x808080);
                this.b(this.pX, hotkeys.keyCodeToName(hkW) + "=" + rd.gH().al("rumo.houseW"), 4, (int)(var44_92 += 12), 0x808080);
                this.b(this.pX, hotkeys.keyCodeToName(hkE) + "=" + rd.gH().al("rumo.apartmentE"), 4, (int)(var44_93 += 12), 0x808080);
                this.b(this.pX, hotkeys.keyCodeToName(hkR) + "=" + rd.gH().al("rumo.landmarkR"), 4, (int)(var44_94 += 12), 0x808080);
                this.b(this.pX, hotkeys.keyCodeToName(hkT) + "=" + rd.gH().al("rumo.techT"), 4, (int)(var44_95 += 12), 0x808080);
                this.b(this.pX, hotkeys.keyCodeToName(hkA) + "=" + rd.gH().al("rumo.delA"), 4, (int)(var44_96 += 12), cityTool == 6 ? -65536 : 0x808080);
                var44_97 += 12;
            }
            this.b(this.pX, hotkeys.keyCodeToName(hkS) + "=" + rd.gH().al("rumo.streetsList"), 4, (int)var44_97, 0x808080);
            this.b(this.pX, hotkeys.keyCodeToName(hkB) + "=" + rd.gH().al("rumo.buildingsList"), 4, (int)(var44_98 += 12), 0x808080);
            this.b(this.pX, hotkeys.keyCodeToName(hkC) + "=" + rd.gH().al("rumo.citizensHint"), 4, (int)(var44_99 += 12), 0x808080);
            this.a(this.pX, "X", this.width / 2, 4, -65536);
        }
        if (!As) {
            string = rd.gH().al("rumo.loading");
        }
        this.b(this.pX, string, 4, this.height - 12, 0xA0A0A0);
        this.b(this.pX, rd.gH().al("rumo.hotkeys"), n3, this.height - 12, bl ? 0xFFFF55 : 0xA0A0A0);
        if (As && ((Minecraft)object6).pR != null) {
            this.b(this.pX, String.format(rd.gH().al("rumo.coords"), (int)(((Minecraft)object6).pR.Yr + this.Ad), (int)(((Minecraft)object6).pR.Yt + this.Ae)), 4, this.height - 24, 0x808080);
        }
        this.b(this.pX, rd.gH().al("rumo.metro"), 4, this.height - 38, BH ? -1 : 0x808080);
        this.b(this.pX, rd.gH().al("rumo.markers"), 4, this.height - 50, BI ? -1 : 0x808080);
        super.a(n, n2, f);
    }

    private void saveCamera() {
        if (Minecraft.ch().pR != null) {
            savedCamX = Minecraft.ch().pR.Yr + this.Ad;
            savedCamZ = Minecraft.ch().pR.Yt + this.Ae;
        }
    }

    private void AD() {
        if (Minecraft.ch().pR != null) {
            this.saveCamera();
            this.qI.a((kc)new coord(this));
        }
    }

    protected void a(jt jt2) {
        if (jt2.id == 100) {
            this.AD();
            return;
        }
        if (jt2.id == 104) {
            this.saveCamera();
            this.qI.a((kc)new dyb(this));
            return;
        }
        if (jt2.id == 102) {
            this.saveCamera();
            this.qI.a((kc)new mkl(this));
            return;
        }
        if (jt2.id == 105) {
            this.saveCamera();
            this.qI.a((kc)new mtl(this));
            return;
        }
        if (jt2.id == 116) {
            this.saveCamera();
            this.qI.a((kc)new sli(this));
            return;
        }
        if (jt2.id == 117) {
            this.saveCamera();
            this.qI.a((kc)new bli(this));
            return;
        }
        if (jt2.id == 118) {
            this.saveCamera();
            this.qI.a((kc)new cli(this));
            return;
        }
    }

    protected void b(char c, int n) {
        Object object;
        int n2;
        int n3;
        if (n == 1) {
            this.qI.a((kc)null);
        }
        if (n == 200) {
            n3 = (Math.min(this.Ao.size(), this.Ap.size()) + 12) / 13;
            if (n3 < 1) {
                n3 = 1;
            }
            if ((n2 = this.At / 13) > 0) {
                this.At = (n2 - 1) * 13;
            }
        }
        if (n == 208) {
            n3 = (Math.min(this.Ao.size(), this.Ap.size()) + 12) / 13;
            if (n3 < 1) {
                n3 = 1;
            }
            if ((n2 = this.At / 13) < n3 - 1) {
                this.At = (n2 + 1) * 13;
            }
        }
        if (n == hkGoto) {
            this.AD();
        }
        if (n == hkReload && !cityMode) {
            object = this.Al.values().iterator();
            while (object.hasNext()) {
                int n4 = object.next();
                GL11.glDeleteTextures((int)n4);
            }
            this.Al.clear();
            this.Ak.clear();
            this.Am.clear();
        }
        if (n == hkMarker && !BD && Minecraft.ch().pR != null) {
            this.saveCamera();
            this.qI.a((kc)new mks(Minecraft.ch().pR.Yr + this.Ad, Minecraft.ch().pR.Yt + this.Ae, (kc)this));
        }
        if (n == hkPxAdj) {
            boolean bl = this.Ay = !this.Ay;
        }
        if (this.Ay) {
            if (n == hkPxMinus) {
                int n5 = this.Ac;
                dyn.Ax[n5] = Ax[n5] - 1;
            }
            if (n == hkPxPlus) {
                int n6 = this.Ac;
                dyn.Ax[n6] = Ax[n6] + 1;
            }
        }
        if (n == hkPxPlus && BD) {
            BD = false;
            BE = -1;
            BF = -1;
            this.aQ();
        }
        if (cityMode && !cityViewOnly) {
            if (n == hkQ) {
                if (cityStreetDraw) {
                    cityStreetDraw = false;
                    cityStreetPoints.clear();
                } else {
                    cityStreetDraw = true;
                    cityStreetPoints.clear();
                }
            }
            if (n == hkW && Minecraft.ch().pR != null) {
                this.saveCamera();
                this.qI.a((kc)new bld(1, Minecraft.ch().pR.Yr + this.Ad, Minecraft.ch().pR.Yt + this.Ae, this));
            }
            if (n == hkE && Minecraft.ch().pR != null) {
                this.saveCamera();
                this.qI.a((kc)new bld(2, Minecraft.ch().pR.Yr + this.Ad, Minecraft.ch().pR.Yt + this.Ae, this));
            }
            if (n == hkR && Minecraft.ch().pR != null) {
                this.saveCamera();
                this.qI.a((kc)new bld(3, Minecraft.ch().pR.Yr + this.Ad, Minecraft.ch().pR.Yt + this.Ae, this));
            }
            if (n == hkT && Minecraft.ch().pR != null) {
                this.saveCamera();
                this.qI.a((kc)new bld(4, Minecraft.ch().pR.Yr + this.Ad, Minecraft.ch().pR.Yt + this.Ae, this));
            }
            if (n == hkA) {
                int n7 = cityTool = cityTool == 6 ? 0 : 6;
            }
        }
        if (cityMode) {
            if (n == hkS) {
                this.saveCamera();
                this.qI.a((kc)new sli(this));
            }
            if (n == hkB) {
                this.saveCamera();
                this.qI.a((kc)new bli(this));
            }
            if (n == hkC) {
                this.saveCamera();
                this.qI.a((kc)new cli(this));
            }
        }
        if (n == hkPm) {
            object = this.BA != null ? this.BA : this.BC;
            String string = object;
            if (object != null) {
                this.qI.a((kc)new oj("/m " + (String)object + " "));
            }
        }
        if (BD && Minecraft.ch().pR != null) {
            double d = Minecraft.ch().pR.Yr + this.Ad;
            double d2 = Minecraft.ch().pR.Yt + this.Ae;
            if (n == hkMQ) {
                boolean bl = false;
                for (mt.Station station : mt.Ar) {
                    if (!(Math.abs(station.x - d) < 1.0) || !(Math.abs(station.z - d2) < 1.0)) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    this.qI.a((kc)new mte(d, d2, (kc)this));
                }
                return;
            }
            if (n == hkMW) {
                if (BE >= 0 || BE == -2) {
                    BE = -1;
                    BF = -1;
                } else {
                    BE = -2;
                    BF = -2;
                }
            }
            if (n == hkMA) {
                if (BE >= 0 || BE == -4) {
                    BE = -1;
                    BF = -1;
                } else {
                    BE = -4;
                    BF = -4;
                }
            }
            if (n == hkMS) {
                if (BE >= 0 || BE == -3) {
                    BE = -1;
                    BF = -1;
                } else {
                    BE = -3;
                    BF = -3;
                }
            }
        }
    }

    protected void i(int n, int n2, int n3) {
        super.i(n, n2, n3);
        if (n3 == 1 && Keyboard.isKeyDown((int)56) && Minecraft.ch().pR != null) {
            double d = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
            double d2 = 128.0 / (64.0 * d);
            double d3 = Minecraft.ch().pR.Yr + this.Ad;
            double d4 = Minecraft.ch().pR.Yt + this.Ae;
            for (int i = 0; i < mrk.Ar.size(); ++i) {
                mrk.Entry entry = mrk.Ar.get(i);
                int n4 = (int)((entry.x - d3) * d2 + (double)this.width / 2.0);
                int n5 = (int)((entry.z - d4) * d2 + (double)this.height / 2.0);
                if (n < n4 - 10 || n >= n4 + 10 || n2 < n5 - 10 || n2 >= n5 + 10) continue;
                if (cityMode && cityActiveName.equals(entry.name)) {
                    if (cityViewOnly) {
                        cityViewOnly = false;
                    } else {
                        cityMode = false;
                        cityViewOnly = false;
                        cityActiveName = "";
                        cityTool = 0;
                        cityStreetDraw = false;
                        cityStreetPoints.clear();
                    }
                } else {
                    cityMode = true;
                    cityViewOnly = false;
                    cityActiveName = entry.name;
                    cityTool = 0;
                    cityStreetDraw = false;
                    BD = false;
                }
                this.aQ();
                this.rmbUsed = true;
                return;
            }
            return;
        }
        if (n3 == 1 && Minecraft.ch().pR != null) {
            double d = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
            double d5 = 128.0 / (64.0 * d);
            double d6 = Minecraft.ch().pR.Yr + this.Ad;
            double d7 = Minecraft.ch().pR.Yt + this.Ae;
            for (int i = 0; i < mrk.Ar.size(); ++i) {
                mrk.Entry entry = mrk.Ar.get(i);
                int n6 = (int)((entry.x - d6) * d5 + (double)this.width / 2.0);
                int n7 = (int)((entry.z - d7) * d5 + (double)this.height / 2.0);
                if (n < n6 - 10 || n >= n6 + 10 || n2 < n7 - 10 || n2 >= n7 + 10) continue;
                if (cityMode && cityActiveName.equals(entry.name)) {
                    cityMode = false;
                    cityViewOnly = false;
                    cityActiveName = "";
                    cityTool = 0;
                    cityStreetDraw = false;
                    cityStreetPoints.clear();
                } else {
                    cityMode = true;
                    cityViewOnly = true;
                    cityActiveName = entry.name;
                    cityTool = 0;
                    cityStreetDraw = false;
                    BD = false;
                }
                this.aQ();
                this.rmbUsed = true;
                return;
            }
        }
        if (n3 == 0) {
            this.rmbUsed = false;
        }
    }

    protected void h(int n, int n2, int n3) {
        block62: {
            int n4;
            double d;
            double d2;
            int n5;
            double d3;
            int n6;
            block63: {
                int n7;
                int n8;
                int n9;
                double d4;
                int n10;
                int n11;
                int n12;
                Object object;
                int n13;
                double d5;
                this.saveCamera();
                super.h(n, n2, n3);
                if (cityMode && Minecraft.ch().pR != null) {
                    if (Mouse.isButtonDown((int)0) && n >= this.width / 2 - 5 && n < this.width / 2 + 5 && n2 >= 0 && n2 < 12) {
                        cityMode = false;
                        cityActiveName = "";
                        cityTool = 0;
                        cityStreetDraw = false;
                        cityStreetPoints.clear();
                        this.aQ();
                        return;
                    }
                    double d6 = Minecraft.ch().pR.Yr + this.Ad;
                    double d7 = Minecraft.ch().pR.Yt + this.Ae;
                    double d8 = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
                    d5 = 128.0 / (64.0 * d8);
                    if (Mouse.isButtonDown((int)1) && cityStreetDraw) {
                        double d9 = (double)(n - this.width / 2) / d5 + d6;
                        double d10 = (double)(n2 - this.height / 2) / d5 + d7;
                        cityStreetPoints.add(new double[]{d9, d10});
                        cityStreetDraw = false;
                        cityTool = 0;
                        if (cityStreetPoints.size() >= 2) {
                            this.saveCamera();
                            this.qI.a((kc)new str(this));
                        } else {
                            cityStreetPoints.clear();
                        }
                        return;
                    }
                    if (Mouse.isButtonDown((int)0)) {
                        if (cityStreetDraw) {
                            double d11 = (double)(n - this.width / 2) / d5 + d6;
                            double d12 = (double)(n2 - this.height / 2) / d5 + d7;
                            cityStreetPoints.add(new double[]{d11, d12});
                            return;
                        }
                        if (cityTool == 2) {
                            this.saveCamera();
                            this.qI.a((kc)new bld(2, d6, d7, this));
                            return;
                        }
                        if (cityTool == 3) {
                            this.saveCamera();
                            this.qI.a((kc)new bld(3, d6, d7, this));
                            return;
                        }
                        if (cityTool == 4) {
                            this.saveCamera();
                            this.qI.a((kc)new bld(4, d6, d7, this));
                            return;
                        }
                        if (cityTool == 5) {
                            this.saveCamera();
                            this.qI.a((kc)new bld(5, d6, d7, this));
                            return;
                        }
                        if (cityTool == 6) {
                            for (n13 = cityBuildings.size() - 1; n13 >= 0; --n13) {
                                object = cityBuildings.get(n13);
                                double d13 = (((Building)object).x - d6) * d5 + (double)this.width / 2.0;
                                double d14 = (((Building)object).z - d7) * d5 + (double)this.height / 2.0;
                                if (!((double)n >= d13 - 5.0 && (double)n < d13 + 5.0 && (double)n2 >= d14 - 5.0 && (double)n2 < d14 + 5.0)) continue;
                                cityBuildings.remove(n13);
                                mrk.At();
                                return;
                            }
                        }
                    }
                    if (!Mouse.isButtonDown((int)0)) {
                        return;
                    }
                }
                if (!Mouse.isButtonDown((int)0)) break block62;
                Iterator<mt.Station> iterator = this.Ao;
                List<double[]> object2 = this.An;
                int n14 = Math.min(iterator.size(), object2.size());
                int n15 = this.width - 110;
                n6 = (n14 + 12) / 13;
                if (n6 < 1) {
                    n6 = 1;
                }
                if ((n12 = this.At / 13) < 0) {
                    n12 = 0;
                }
                if (n12 >= n6) {
                    n12 = n6 - 1;
                }
                if (n6 > 1) {
                    int n16 = 162;
                    if (n >= n15 && n < n15 + 100 && n2 >= n16 && n2 < n16 + 12 && n12 > 0) {
                        this.At = (n12 - 1) * 13;
                        return;
                    }
                    if (n >= n15 && n < n15 + 100 && n2 >= n16 + 14 && n2 < n16 + 26 && n12 < n6 - 1) {
                        this.At = (n12 + 1) * 13;
                        return;
                    }
                }
                for (n11 = 0; n11 < n14; ++n11) {
                    if (n11 - n12 * 13 < 0 || n11 - n12 * 13 >= 13) continue;
                    n10 = n15;
                    n13 = 4 + (n11 - n12 * 13) * 12;
                    if (n < n10 || n >= n10 + 100 || n2 < n13 || n2 >= n13 + 12) continue;
                    double[] dArray = object2.get(n11);
                    if (Minecraft.ch().pR != null) {
                        this.Ad = dArray[0] - Minecraft.ch().pR.Yr;
                        this.Ae = dArray[1] - Minecraft.ch().pR.Yt;
                        if (this.Ac > 1) {
                            this.Ac = 1;
                        }
                    }
                    return;
                }
                if (Mouse.isButtonDown((int)0)) {
                    if (n >= 4 && n < 50 && n2 >= this.height - 52 && n2 < this.height - 42) {
                        BI = !BI;
                        mrk.At();
                        return;
                    }
                    if (n >= 4 && n < 40 && n2 >= this.height - 40 && n2 < this.height - 30) {
                        BH = !BH;
                        mrk.At();
                        return;
                    }
                }
                n11 = Math.min(this.An.size(), this.Ap.size());
                n10 = this.pX.aD(rd.gH().al("rumo.zoom") + " " + this.Ac + " | " + this.Ar + "/" + this.Aq + " | " + n11 + " " + rd.gH().al("rumo.players") + " | ") + 4;
                if (n >= n10 && n < n10 + this.pX.aD(rd.gH().al("rumo.hotkeys")) && n2 >= this.height - 12 && n2 < this.height) {
                    this.saveCamera();
                    this.qI.a((kc)new hotkeys(this));
                    return;
                }
                if (this.Ac > 1) {
                    double d15 = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
                    d5 = 128.0 / (64.0 * d15);
                    d3 = Minecraft.ch().pR.Yr + this.Ad;
                    d4 = Minecraft.ch().pR.Yt + this.Ae;
                    for (n9 = 0; n9 < Math.min(this.An.size(), this.Ap.size()); ++n9) {
                        double[] dArray = this.An.get(n9);
                        n5 = (int)((dArray[0] - d3) * d5 + (double)this.width / 2.0);
                        n8 = (int)((dArray[1] - d4) * d5 + (double)this.height / 2.0) - Ax[this.Ac];
                        if (n < n5 - 8 || n >= n5 + 8 || n2 < n8 - 6 || n2 >= n8 + 6) continue;
                        this.Ad = dArray[0] - Minecraft.ch().pR.Yr;
                        this.Ae = dArray[1] - Minecraft.ch().pR.Yt;
                        this.Ac = 1;
                        return;
                    }
                }
                if (Minecraft.ch().pR != null) {
                    double d16 = this.Ac > 1 ? (double)(1 << this.Ac - 1) : 1.0;
                    d5 = 128.0 / (64.0 * d16);
                    d3 = Minecraft.ch().pR.Yr + this.Ad;
                    d4 = Minecraft.ch().pR.Yt + this.Ae;
                    for (n9 = 0; n9 < mrk.Ar.size(); ++n9) {
                        mrk.Entry entry = mrk.Ar.get(n9);
                        n5 = (int)((entry.x - d3) * d5 + (double)this.width / 2.0);
                        n8 = (int)((entry.z - d4) * d5 + (double)this.height / 2.0);
                        if (n < n5 - 6 || n >= n5 + 6 || n2 < n8 - 6 || n2 >= n8 + 6) continue;
                        if (BD && (BE == -2 || BE == -3 || BE == -4)) {
                            return;
                        }
                        if (Mouse.isButtonDown((int)0)) {
                            this.Ad = entry.x - Minecraft.ch().pR.Yr;
                            this.Ae = entry.z - Minecraft.ch().pR.Yt;
                            this.Ac = 1;
                        }
                        return;
                    }
                }
                if (!BD || !Mouse.isButtonDown((int)0)) break block62;
                if (n >= this.width / 2 - 5 && n < this.width / 2 + 5 && n2 >= 0 && n2 < 12) {
                    BD = false;
                    BE = -1;
                    BF = -1;
                    this.aQ();
                    return;
                }
                if (Minecraft.ch().pR == null) {
                    return;
                }
                d2 = Minecraft.ch().pR.Yr + this.Ad;
                d = Minecraft.ch().pR.Yt + this.Ae;
                d3 = 128.0 / (64.0 * (double)(this.Ac > 1 ? 1 << this.Ac - 1 : 1));
                int n17 = -1;
                double d6 = 1000000.0;
                for (n4 = 0; n4 < mt.Ar.size(); ++n4) {
                    object = mt.Ar.get(n4);
                    n8 = (int)((((mt.Station)object).x - d2) * d3 + (double)this.width / 2.0);
                    n7 = (int)((((mt.Station)object).z - d) * d3 + (double)this.height / 2.0);
                    if (n < n8 - 5 || n >= n8 + 5 || n2 < n7 - 5 || n2 >= n7 + 5) continue;
                    n17 = n4;
                    d6 = Math.abs(((mt.Station)object).x - d2) + Math.abs(((mt.Station)object).z - d);
                }
                if (n17 < 0) break block63;
                if (BE == -4) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (n7 = 0; n7 < mt.As.size(); ++n7) {
                        mt.Line line = mt.As.get(n7);
                        if (line.a != n17 && line.b != n17) continue;
                        arrayList.add(n7);
                    }
                    for (n7 = arrayList.size() - 1; n7 >= 0; --n7) {
                        mt.As.remove((Integer)arrayList.get(n7));
                    }
                    mt.Ar.remove(n17);
                    for (mt.Line line : mt.As) {
                        if (line.a > n17) {
                            --line.a;
                        }
                        if (line.b <= n17) continue;
                        --line.b;
                    }
                    mt.Aw();
                    BE = -1;
                    BF = -1;
                    return;
                }
                if (BE == -2 || BE == -3) {
                    BE = n17;
                    return;
                }
                if (BE >= 0 && BE < mt.Ar.size() && BE != n17) {
                    if (BF == -3) {
                        for (n4 = 0; n4 < mt.As.size(); ++n4) {
                            object = mt.As.get(n4);
                            if (!(((mt.Line)object).a == BE && ((mt.Line)object).b == n17 || ((mt.Line)object).a == n17 && ((mt.Line)object).b == BE)) continue;
                            mt.As.remove(n4);
                            mt.Aw();
                            break;
                        }
                    } else {
                        n4 = 1;
                        for (mt.Line line : mt.As) {
                            if (!(line.a == BE && line.b == n17 || line.a == n17 && line.b == BE)) continue;
                            n4 = 0;
                            break;
                        }
                        if (n4 != 0) {
                            object = new mt.Line();
                            ((mt.Line)object).a = BE;
                            ((mt.Line)object).b = n17;
                            mt.As.add((mt.Line)object);
                            mt.Aw();
                        }
                    }
                    BE = -1;
                    BF = -1;
                    return;
                }
                if (BE >= 0) break block62;
                this.Ad = mt.Ar.get((int)n17).x - Minecraft.ch().pR.Yr;
                this.Ae = mt.Ar.get((int)n17).z - Minecraft.ch().pR.Yt;
                this.Ac = 1;
                break block62;
            }
            if (BE == -3) {
                for (n4 = 0; n4 < mt.As.size(); ++n4) {
                    double d7;
                    double d8;
                    mt.Line line = mt.As.get(n4);
                    mt.Station station = mt.Ar.get(line.a);
                    mt.Station station2 = mt.Ar.get(line.b);
                    if (station.x == station2.x) {
                        d8 = (double)(n - this.width / 2) / d3 + d2;
                        d7 = (double)(n2 - this.height / 2) / d3 + d;
                        if (Math.abs(d8 - station.x) < 5.0 / d3 && d7 >= Math.min(station.z, station2.z) && d7 <= Math.max(station.z, station2.z)) {
                            mt.As.remove(n4);
                            mt.Aw();
                            BF = -1;
                            return;
                        }
                    }
                    if (station.z != station2.z) continue;
                    d8 = (double)(n - this.width / 2) / d3 + d2;
                    d7 = (double)(n2 - this.height / 2) / d3 + d;
                    if (!(Math.abs(d7 - station.z) < 5.0 / d3 && d8 >= Math.min(station.x, station2.x) && d8 <= Math.max(station.x, station2.x))) continue;
                    mt.As.remove(n4);
                    mt.Aw();
                    BF = -1;
                    return;
                }
            } else if (BE >= 0 && BE < mt.Ar.size()) {
                mt.Station station = mt.Ar.get(BE);
                for (n5 = 0; n5 < mt.As.size(); ++n5) {
                    double d20;
                    mt.Line line = mt.As.get(n5);
                    mt.Station station3 = mt.Ar.get(line.a);
                    mt.Station station4 = mt.Ar.get(line.b);
                    if (station3.x == station4.x) {
                        double d9 = (double)(n - this.width / 2) / d3 + d2;
                        d20 = (double)(n2 - this.height / 2) / d3 + d;
                        if (Math.abs(d9 - station3.x) < 5.0 / d3 && d20 >= Math.min(station3.z, station4.z) && d20 <= Math.max(station3.z, station4.z)) {
                            n6 = 0;
                            for (mt.Station station5 : mt.Ar) {
                                if (!(Math.abs(station5.x - station3.x) < 1.0) || !(Math.abs(station5.z - station.z) < 1.0)) continue;
                                n6 = 1;
                                break;
                            }
                            if (n6 == 0) {
                                this.qI.a((kc)new mte(station3.x, station.z, BE, this, n5));
                            }
                            return;
                        }
                    }
                    if (station3.z != station4.z) continue;
                    double d10 = (double)(n - this.width / 2) / d3 + d2;
                    d20 = (double)(n2 - this.height / 2) / d3 + d;
                    if (!(Math.abs(d20 - station3.z) < 5.0 / d3 && d10 >= Math.min(station3.x, station4.x) && d10 <= Math.max(station3.x, station4.x))) continue;
                    n6 = 0;
                    for (mt.Station station6 : mt.Ar) {
                        if (!(Math.abs(station6.x - station.x) < 1.0) || !(Math.abs(station6.z - station3.z) < 1.0)) continue;
                        n6 = 1;
                        break;
                    }
                    if (n6 == 0) {
                        this.qI.a((kc)new mte(station.x, station3.z, BE, this, n5));
                    }
                    return;
                }
            }
        }
    }

    public void dO() {
        if (!AB.isShutdown()) {
            for (int n : this.Al.values()) {
                GL11.glDeleteTextures((int)n);
            }
        }
        this.Ak.clear();
        this.Al.clear();
        this.Am.clear();
    }

    private void loadTile(String string) {
        this.AB(string);
    }
}

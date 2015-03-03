package javaoblig1.v15;

import java.io.*;

public abstract class Bok {

    private String forfatter, tittel;
    private int sideantall;
    private double pris;
    Bok neste;

    public Bok() {
    }

    public Bok(String f, String t, int sider, double p) {
        forfatter = f;
        tittel = t;
        sideantall = sider;
        pris = p;
        neste = null;
    }

    public String getForfatter() {
        return forfatter;
    }

    public String getTittel() {
        return tittel;
    }

//  < Leser  verdier fra fil og lagrer dem i de tilhørende datafeltene. >
    public boolean lesObjektFraFil(DataInputStream input) {

        return true;
    }

//  < Skriver  datafeltenes verdier til fil. >
    public void skrivObjektTilFil(DataOutputStream output) throws IOException {
        output.writeUTF(forfatter);
        output.writeUTF(tittel);
        output.writeInt(sideantall);
        output.writeDouble(pris);
    }

    @Override
    public String toString() {
        String s = forfatter + "; ";
        s += tittel + "; ";
        s += sideantall + " s., ";
        s += "kr. " + pris;
        return s;
    }
}

class Skolebok extends Bok {

    private int klassetrinn;
    private String skolefag;

    public Skolebok(String f, String t, int sider, double p, int kt, String fag) {
        super(f, t, sider, p);
        klassetrinn = kt;
        skolefag = fag;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "; trinn: " + klassetrinn;
        s += ", " + skolefag;
        return s;
    }
}

class Fagbok extends Bok {

    private String fagområde;

    public Fagbok(String f, String t, int sider, double p, String omr) {
        super(f, t, sider, p);
        fagområde = omr;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "; " + fagområde;
        return s;
    }
}

//Klassen har som oppgave å definere det som er felles for de
//forskjellige typene av romaner. Skal ikke instansieres.
abstract class Roman extends Bok {

    protected String sjanger;

    protected Roman(String f, String t, int sider, double p, String s) {
        super(f, t, sider, p);
        sjanger = s;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += ". Sjanger: " + sjanger;
        return s;
    }
}

class NorskRoman extends Roman {

    private String målform;

    public NorskRoman(String f, String t, int s, double p, String sj, String m) {
        super(f, t, s, p, sj);
        målform = m;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += ". " + målform;
        return s;
    }
}

class UtenlandskRoman extends Roman {

    private String språk;

    public UtenlandskRoman(String f, String t, int s, double p, String sj, String sp) {
        super(f, t, s, p, sj);
        språk = sp;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += ". " + språk;
        return s;
    }
}

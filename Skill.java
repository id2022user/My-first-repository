package NW.bean;

public class Skill {
    private String name;
    private int hp;
    private int mp;
    private int atk;
    private int dfe;
    private int grade;
    private boolean isStudy;

    public Skill(String name, int hp, int mp, int atk, int dfe, int grade, boolean isStudy) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.dfe = dfe;
        this.grade = grade;
        this.isStudy = isStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDfe() {
        return dfe;
    }

    public void setDfe(int dfe) {
        this.dfe = dfe;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isStudy() {
        return isStudy;
    }

    public void setStudy(boolean study) {
        isStudy = study;
    }
    public void set(){
        Player.hp=Player.hp+hp;
        Player.mp=Player.mp-mp;
        Player.atk=Player.atk+atk;
        Player.dfe=Player.dfe+dfe;


    }
}

package BE;

import java.util.Random;

public class Subject {
    private int id;
    private String name;
    private int absence;

    public Subject(String name) {
        setName(name);
        setAbsence(absence);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        Random rand = new Random();
        this.absence = 100 - rand.nextInt(20);
    }
}

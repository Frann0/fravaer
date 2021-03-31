package GUI.MODEL;

public class StudentModel {

    private static StudentModel instance;


    /**
     * Get the singleton instance of StudentModel.
     */
    public static StudentModel getInstance() {
        if (instance == null) instance = new StudentModel();
        return instance;
    }
}

package OOP26111;

public class IntUebung {
    public static void main(String[] args) {
        Student testStudent = new Student();
        testStudent.setMatrikel(98789234);
        MySamType3 la = student -> testStudent.getMatrikel();
        System.out.println(la.readMatrikel(testStudent));
    }
}

@FunctionalInterface
interface MySamType3 {
    int readMatrikel(Student studi);
}

class Student {

    private int matrikel;

    public int getMatrikel() {
        return matrikel;
    }

    public MySamType3 setMatrikel (int matrikel) {
        this.matrikel = matrikel;
        return null;
    }

}

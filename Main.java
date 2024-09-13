



public class Main {

    public static void main(String[] args) {
        Curso curso1 = new Curso("Matemáticas", "MAT101", "Dr. García");
        Curso curso2 = new Curso("Historia", "HIS201", "Lic. Pérez");
        Curso curso3 = new Curso("Programación", "CS301", "Ing. Martínez");

      
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "E001");
        Estudiante estudiante2 = new Estudiante("Ana Gómez", "E002");

        estudiante1.agregarCurso(curso1);
        estudiante1.agregarCurso(curso3);

        estudiante2.agregarCurso(curso2);
        estudiante2.agregarCurso(curso3);

       
        System.out.println("Información de los estudiantes:");
        System.out.println("----------------------------------");
        estudiante1.mostrarInformacion();
        System.out.println("----------------------------------");
        estudiante2.mostrarInformacion();
    }
}

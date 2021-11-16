package Serializa4;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        int media;

        Nota notas[] = new Nota[6];

        notas[0] = new Nota("Programacion");
        notas[1] = new Nota("Lenguajes de Marcas");
        notas[2] = new Nota("Bases de Datos");
        notas[3] = new Nota("Entornos de Desarrollo");
        notas[4] = new Nota("Sistemas Informaticos");
        notas[5] = new Nota("Formacion y Orientacion Laboral");

        pedirNotas(notas);

        media = calcularMedia(notas);

        volcarDatos(notas, media);

    }

    public static int calcularMedia(Nota[] notas) {
        int media = 0;
        for (Nota nota : notas) {
            media = media + nota.getNota();
        }

        media = media / 6;

        return media;
    }

    public static void pedirNotas(Nota[] notas) {
        int num;

        for (Nota nota : notas) {
            do {
                
                System.out.println("Indique la nota de " + nota.getMateria());
                num = Leer.datoInt("");
            } while (num > 10 || num < 0);
            nota.setNota(num);
        }
    }

    public static void volcarDatos(Nota[] notas, int media) {

        try {
            File fichero = new File("C:\\Flujo\\Ejercicio8\\notas.obj");

            if (!fichero.exists()) {
                fichero.createNewFile();
            }

            FileWriter fw = new FileWriter(fichero);

            for (Nota nota : notas) {
                fw.append(nota.toString() + "\n");
            }

            fw.append("La nota media del curso es: " + media);

            fw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

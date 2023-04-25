import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat formatCash = new DecimalFormat("$ #,###");
        DecimalFormat formatPerc = new DecimalFormat("##.###%");

        short tipoEmpleado;
        int valorHora, valorHoraExtra, asignacion, HorasConductor = 160, HorasGenerales = 100, HorasVigilacia = 336,
                pension, ARL, salud1, salario = 40000,
                resultado, descuento, total_a_pagar,
                valor = 160, horas_t = 100, horas_t2 = 336;
        String Nombre;

        double riesgoArl;

        System.out.println("------- MENÚ PRINCIPAL -------");
        System.out.println("Escoja el tipo de empleado:");
        System.out.println("1. ADMINISTRATIVO");
        System.out.println("2. OPERATIVO");

        while (true) {
            System.out.println("");
            System.out.print("Digite una opción (1 | 2): ");
            tipoEmpleado = entrada.nextShort();
            if (tipoEmpleado == 1 || tipoEmpleado == 2) {
                System.out.println("");
                break;
            }
            System.out.println("------ OPCIÓN INVALIDA ------");
        }
        switch (tipoEmpleado) {
            case 1:

                if (tipoEmpleado == 1) { // Administrativo
                    String cargo = "Auxiliar Administrativo";
                    valorHora = 20000;
                    valorHoraExtra = 25000;
                    riesgoArl = 0.00522;

                    System.out.print("Nombre del empleado: ");
                    Nombre = entrada.nextLine();
                    Nombre = entrada.nextLine();

                    System.out.print("Horas trabajadas en el mes: ");
                    short horasTrabajadas = entrada.nextShort();
                    int salarioBruto = valorHora * horasTrabajadas;

                    System.out.print("Horas extras trabajadas en el mes: ");
                    short horasExtrasTrabajadas = entrada.nextShort();
                    int totalHorasExtras = valorHoraExtra * horasExtrasTrabajadas;

                    int salud = (int) ((salarioBruto + totalHorasExtras) * 0.04);
                    int arl = (int) ((salarioBruto + totalHorasExtras) * riesgoArl);
                    int totalDescuentos = salud * 2;

                    int pagoTotal = salarioBruto + totalHorasExtras - totalDescuentos - arl;

                    System.out.println("");
                    System.out.println("*************************************************");
                    System.out.println("**************** VOLANTE DE PAGO ****************");
                    System.out.println("*************************************************");
                    System.out.println("Nombre: " + Nombre);
                    System.out.println("Cargo: " + cargo);
                    System.out.println("Horas Trabajadas (mes): " + horasTrabajadas);
                    System.out.println("Salario Bruto: " + formatCash.format(salarioBruto));
                    System.out.println("Horas Extras: " + horasExtrasTrabajadas);
                    System.out.println("Total Horas Extras: " + formatCash.format(totalHorasExtras));
                    System.out.println("");
                    System.out.println("*************************************************");
                    System.out.println("*************** DESCUENTOS DE LEY ***************");
                    System.out.println("*************************************************");
                    System.out.println("Salud(4%): " + formatCash.format(salud));
                    System.out.println("Pensión: " + formatCash.format(salud));
                    System.out.println("ARL(" + formatPerc.format(riesgoArl) + "): " + formatCash.format(arl));
                    System.out.println("Total Descuentos: " + formatCash.format(totalDescuentos));
                    System.out.println("");
                    System.out.println("Total a pagar: " + formatCash.format(pagoTotal));
                    System.out.println("");
                    System.out.println("*************************************************");
                    System.out.println("************ FIN DEL VOLANTE DE PAGO ************");
                    System.out.println("*************************************************");
                    break;
                }

            case 2:
                System.out.println("**********************************************************");
                System.out.println("*************!Bienvenido al menu operativo¡***************");
                System.out.println("**********************************************************");
                System.out.println("");
                System.out.println("¿Cual es su nombre?");
                Nombre = entrada.nextLine();
                Nombre = entrada.nextLine();

                System.out.println("");
                System.out.println("**********************************************************");
                System.out.println(Nombre + " Elija el cargo en el que se encuentra actualmente ");
                System.out.println("1. Conductor");
                System.out.println("2. Oficios generales");
                System.out.println("3. Vigilancia");
                System.out.println("**********************************************************");
                short option = entrada.nextShort();

                final short conductor = 1;
                final short oficiosGenerales = 2;
                final short vigilancia = 3;

                switch (option) {
                    case conductor:
                        // Sirve para hacer una conversion de numero ejemplo de floar o dooble a (int)
                        asignacion = (int) (salario * HorasConductor);
                        resultado = (int) (0.4 * asignacion);
                        salud1 = (int) (resultado * 0.125);

                        System.out.println("");

                        asignacion = (int) (salario * HorasConductor);
                        resultado = (int) (0.4 * asignacion);
                        pension = (int) (resultado * 0.16);

                        System.out.println("");

                        asignacion = (int) (salario * HorasConductor);
                        resultado = (int) (0.4 * asignacion);
                        ARL = (int) (resultado * 1.0044);
                        System.out.println("");

                        asignacion = (int) (salario * HorasConductor);

                        descuento = salud1 + pension + ARL;

                        total_a_pagar = asignacion - (salud1 + pension + ARL);

                        System.out.println("********************************************************");
                        System.out.println("****************** VOLANTE DE PAGO *********************");
                        System.out.println("********************************************************");
                        System.out.println("Nombre: " + Nombre);
                        System.out.println("Cargo: Conductor: ");
                        System.out.println("Horas trabajadas (mes): " + valor);
                        System.out.println("Salario bruto: " + asignacion);
                        System.out.println("");
                        System.out.println("********************************************************");
                        System.out.println("**************** DESCUENTOS DE LEY *********************");
                        System.out.println("********************************************************");
                        System.out.println("salud1 (4%): " + salud1);
                        System.out.println("Pension (4%): " + pension);
                        System.out.println("ARL (1.044%): " + ARL);
                        System.out.println("Total de descuentos: " + descuento);
                        System.out.println("");
                        System.out.println("Total a pagar: " + total_a_pagar);
                        System.out.println("");
                        System.out.println("******************************************************");
                        System.out.println("**************** FIN DEL VOLANTE DE PAGO *************");
                        System.out.println("******************************************************");
                        break;

                    case oficiosGenerales:
                        asignacion = (int) (salario * HorasGenerales);
                        resultado = (int) (0.4 * asignacion);
                        salud1 = (int) (resultado * 0.125);

                        System.out.println("");

                        asignacion = (int) (salario * HorasGenerales);
                        resultado = (int) (0.4 * asignacion);
                        pension = (int) (resultado * 0.16);

                        System.out.println("");

                        asignacion = (int) (salario * HorasGenerales);
                        resultado = (int) (0.4 * asignacion);
                        ARL = (int) (resultado * 0.00522);
                        System.out.println("");

                        asignacion = (int) (salario * HorasGenerales);

                        descuento = salud1 + pension + ARL;

                        total_a_pagar = asignacion - (salud1 + pension + ARL);

                        System.out.println("******************************************************");
                        System.out.println("**************** VOLANTE DE PAGO *********************");
                        System.out.println("******************************************************");
                        System.out.println("Nombre: " + Nombre);
                        System.out.println("Cargo: oficios generales");
                        System.out.println("Horas trabajadas (mes): " + horas_t);
                        System.out.println("Salario bruto: " + asignacion);
                        System.out.println("");
                        System.out.println("********************************************************");
                        System.out.println("**************** DESCUENTOS DE LEY *********************");
                        System.out.println("********************************************************");
                        System.out.println("salud1 (4%): " + salud1);
                        System.out.println("Pension (4%): " + pension);
                        System.out.println("ARL (0.522%): " + ARL);
                        System.out.println("Total de descuentos: " + descuento);
                        System.out.println("");
                        System.out.println("Total a pagar: " + total_a_pagar);
                        System.out.println("");
                        System.out.println("******************************************************");
                        System.out.println("**************** FIN DEL VOLANTE DE PAGO *************");
                        System.out.println("******************************************************");
                        break;

                    case vigilancia:
                        asignacion = (int) (salario * HorasVigilacia);
                        resultado = (int) (0.4 * asignacion);
                        salud1 = (int) (resultado * 0.125);

                        System.out.println("");

                        asignacion = (int) (salario * HorasVigilacia);
                        resultado = (int) (0.4 * asignacion);
                        pension = (int) (resultado * 0.16);

                        System.out.println("");

                        asignacion = (int) (salario * HorasVigilacia);
                        resultado = (int) (0.4 * asignacion);
                        ARL = (int) (resultado * 0.04350);
                        System.out.println("");

                        asignacion = (int) (salario * HorasVigilacia);

                        descuento = salud1 + pension + ARL;

                        total_a_pagar = asignacion - (salud1 + pension + ARL);

                        System.out.println("******************************************************");
                        System.out.println("**************** VOLANTE DE PAGO *********************");
                        System.out.println("******************************************************");
                        System.out.println("Nombre: " + Nombre);
                        System.out.println("Cargo: oficios generales");
                        System.out.println("Horas trabajadas (mes) " + horas_t2);
                        System.out.println("Salario bruto: " + asignacion);
                        System.out.println("");
                        System.out.println("********************************************************");
                        System.out.println("**************** DESCUENTOS DE LEY *********************");
                        System.out.println("********************************************************");
                        System.out.println("salud1 (4%): " + salud1);
                        System.out.println("Pension (4%): " + pension);
                        System.out.println("ARL (4.350%): " + ARL);
                        System.out.println("Total de descuentos: " + descuento);
                        System.out.println("");
                        System.out.println("Total a pagar: " + total_a_pagar);
                        System.out.println("");
                        System.out.println("******************************************************");
                        System.out.println("**************** FIN DEL VOLANTE DE PAGO *************");
                        System.out.println("******************************************************");
                        break;

                }

                entrada.close();
        }

    }
}

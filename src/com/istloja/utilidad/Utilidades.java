package com.istloja.utilidad;

public class Utilidades {

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    public boolean validarNumero(String numero) {
        if (numero.isEmpty()) {
            return false;
        } else if (numero.length() < 10) {
            return false;
        }
        try {
            int validarNumero = Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean validarCorreo(String correo) {
        int longitud = correo.length();
        char valor;
        for (char i = 0; i < longitud; i++) {
            valor = correo.charAt(i);
            if (valor == '@' && i == 0) {
                System.out.println("El correo no es correcto");
                break;
            }
            if (valor == '@') {
                System.out.println("Escribiste perfectamente el correo");
                break;
            } else if (i == longitud - 1) {
                System.out.println("El correo está mal, tiene que contener @ ");
                break;
            }
        }
        return false;
    }

}

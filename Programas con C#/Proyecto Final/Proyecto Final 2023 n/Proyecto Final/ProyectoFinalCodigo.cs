using System;
using System.Runtime.CompilerServices;
using System.Threading;

namespace ProyectoFinal
{
    class ProyectoFinal
    {
        public static void Main(string[] args)
        {
            PantallaMenu();
        }
        public static void PantallaMenu() {
            Console.WriteLine("-----------------------------------------------------------------");
            Console.WriteLine("------------Calculadora Matematica----------------------");
            Console.WriteLine("Ingrese a la Opcion Matematica que Quiera Calcular");
            Console.WriteLine("1- Número Primo: ");
            Console.WriteLine("2- Promedio de Notas: ");
            Console.WriteLine("3- números Impares: ");
            Console.WriteLine("4- interés Compuesto: ");
            Console.WriteLine("5- Potencia de un Número: ");
            Console.WriteLine("6- Salir: ");
            Console.WriteLine("-----------------------------------------------------------------");

            int opcion = Convert.ToInt32(Console.ReadLine());

            if (opcion == 1)
            {
                Console.WriteLine("-----------------------------------------------------------------");
                Console.WriteLine("Ingrese un numero: ");
                Int32 numero = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("-----------------------------------------------------------------");
                NúmeroPrimo(numero);
                return;
            }

            if (opcion == 2)
            {
                Console.WriteLine("Calculadora de Promedio de Notas");
                Console.WriteLine("--------------------------------");

                int cant = 1;

               cant = Convert.ToInt32(Console.ReadLine());

                double[] notas = new double[cant];

                for (int i = 0; i < cant; i++)
                {
                    Console.Write($"Ingrese la nota {i + 1}: ");
                    if (double.TryParse(Console.ReadLine(), out double nota))
                    {
                        notas[i] = nota;
                    }
                    else
                    {
                        Console.WriteLine("Por favor, ingrese un valor numérico.");
                        i--;
                    }
                }

                double promedio = PromedioListanotas(notas);

                Console.WriteLine($"El promedio de las notas es: {promedio}");
            }

            if (opcion == 3)
            {
                Console.WriteLine("Ingrese los números separados por espacios:");
                string input = Console.ReadLine();

                int[] numeros = Array.ConvertAll(input.Split(' '), int.Parse);

                int[] numerosImpares = listaNúmerosimpares(numeros);

                Console.WriteLine("Números impares:");
                foreach (int num in numerosImpares)
                {
                    Console.Write(num + " ");
                }
                Console.WriteLine("-----------------------------------------------------------------");
                Pregunta();
            }

            if (opcion == 4)
            {
                Console.WriteLine("-----------------------------------------------------------------");
                Console.Write("Escribe Tu Monto Inicial: ");
                double Inicial = double.Parse(Console.ReadLine());
                Console.Write("Escribe Tu Tasa de Interes: ");
                double Tasa = double.Parse(Console.ReadLine());
                Console.Write("Escribe El Tiempo: ");
                double year = double.Parse(Console.ReadLine());
                Console.WriteLine("-----------------------------------------------------------------");
                InterésCompuesto(Inicial, Tasa, year);
                return;
            }

            if (opcion == 5)
            {
                Console.WriteLine("-----------------------------------------------------------------");
                Console.WriteLine("Ingrese la Base:");
                double num1 = double.Parse(Console.ReadLine());
                Console.WriteLine("Ingrese el Exponente:");
                double num2 = double.Parse(Console.ReadLine());
                PotenciaNúmero(num1, num2);
                Console.WriteLine("-----------------------------------------------------------------");
                return;
            }

             if (opcion == 6)
             {
                 Salir();
             }
        }
        static int NúmeroPrimo(int primo)
        {
            int numeroPrimo = primo;
            if (numeroPrimo < 2)
            {
                Console.WriteLine($"{numeroPrimo} no es un número primo.");
            }
            else
            {
                bool esPrimo = true;

                for (int i = 2; i < numeroPrimo; i++)
                {
                    if (numeroPrimo % i == 0)
                    {
                        esPrimo = false;
                        break;
                    }
                }

                if (esPrimo)
                {
                    Console.WriteLine($"{numeroPrimo} es un número primo.");
                }
                else
                {
                    Console.WriteLine($"{numeroPrimo} no es un número primo.");
                }
            }

            Pregunta();

            return numeroPrimo;
        }
        static double PromedioListanotas(double[] notas)
        {
            double suma = 0;

            foreach (double nota in notas)
            {
                suma += nota;
            }

            double resultado = suma / notas.Length;
            Console.Write("El Resultado de sus es:"+" "+resultado);

            Pregunta();
            return suma;
            
           
            
        }
        static int[] listaNúmerosimpares(int[] numeros)
        {
            var impares = Array.FindAll(numeros, n => n % 2 != 0);

            return impares;
        }
        static double InterésCompuesto(double monto, double TasaInteres, double tiempo){
            double tasaDecimal = TasaInteres / 100.0;
            double MontoFinal = monto * Math.Pow((1 + tasaDecimal), tiempo);
            Console.Write("Tu  Monto Inicial de" + " " + monto + " " + "en tasa de "+" "
                +TasaInteres + " " + "en" + " "+ tiempo + " " + "Años es igula a = "+" "
                +MontoFinal + " " + "Monto Final en"+ " " + tiempo + " " + "Años");
            
            Pregunta();

            return MontoFinal;

          
        }
        static double PotenciaNúmero(double bas, double exponente){
            double Potencia = 1;
            for (int i = 0; i < exponente; i++)
            {
                Potencia *= bas;
            }
          
            Console.Write("El Numero"+" "+ bas+" "+"Elevado a la"+" "+exponente+" "+"es Igual a:"+" "+Potencia);
            
            Pregunta();
            
            return Potencia;

           
        }
        static void Pregunta()
        {
            Console.WriteLine("-----------------------------------------------------------------");
            Console.WriteLine("1-Deseas Volver al Menu: ");
            Console.WriteLine("2-Deseas Salir: ");
            int Elegir = Convert.ToInt32(Console.ReadLine());

            if (Elegir == 1)
            {
                PantallaMenu();
            }
            if (Elegir == 2)
            {
                Salir();
            }
            Console.WriteLine("-----------------------------------------------------------------");
        }
        static void Salir(){
            Console.WriteLine("-----------------------------------------------------------------");
            Console.WriteLine("Programa Hecho por Andres Rodriguez Liberato, Matricula 100520391");
            Console.WriteLine("Gracias por Usar Mi Programa. Usalo Pronto.....");
            Console.WriteLine("-----------------------------------------------------------------");
            Environment.Exit(0);
        }
    }
}
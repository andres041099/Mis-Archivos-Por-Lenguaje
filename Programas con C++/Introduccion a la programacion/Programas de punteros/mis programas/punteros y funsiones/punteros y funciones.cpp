/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<stdio.h>

using  namespace std;
void funcion(int valor1, int valor2)
{
    printf("Valor 1 = %d\n", valor1);
    printf("Valor 2 = %d\n", valor2);
}
int main(){
 
 void (*puntero_funcion)(int, int) = &funcion;
 cout<<"Los valores introducidos son: ";
 puntero_funcion(2, 5);
 
	


system ("pause");
return 0;
}




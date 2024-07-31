/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;
void intercambio(int&, int&);
int main(){
int num1=10,num2=15;
	
	cout<<"El valor almacenado en num1 es: "<<num1<<endl;
	cout<<"El valor almacenado en num2 es: "<<num2<<endl;
	
	intercambio(num1,num2);
	
	cout<<"El  valor intercambiado de num1 es: "<<num1<<endl;
	cout<<"El  valor intercambiado de num2 es: "<<num2<<endl;		


system ("pause");
return 0;
}
void intercambio(int& num1, int& num2){
	int aux;
	aux = num1;
	num1 = num2;
	num2 = aux;
}

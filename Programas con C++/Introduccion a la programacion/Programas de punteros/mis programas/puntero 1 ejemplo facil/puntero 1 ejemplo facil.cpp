/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<conio.h>
using  namespace std;

int main(){

	int num, *dir_num;
 
	cout<< "Entra cualquier numero: ";
		cin>>num;
		
	dir_num = &num;
	
	cout<< "El numero introduccido es : "<<*dir_num<<endl; 
	
	cout<< "Su direccion es: "<<dir_num<<endl; 

system ("pause");
return 0;
}



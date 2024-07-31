/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;

int main(){
	int numero[]= {1,2,3,4};

	int *dir_numero;

	
	dir_numero= numero;

		
		for (int i=0;i<5;i++){

	cout<<"El elemento del vector ["<<i<<"] es: "<<*dir_numero++<<endl;

	
	}

system ("pause");
return 0;
}

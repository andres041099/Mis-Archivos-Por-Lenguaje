/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;

int main(){
	int numero, *dir_numero;
	
	cout<<"Introdusca  un numero: "; cin>>numero; 
	
	dir_numero = &numero;
	
	if(*dir_numero%2==0){
		cout<<"El numero: "<<*dir_numero<<" es par"<<endl;
		cout<<" Su direccion es: "<<dir_numero<<endl;
	}
	else{
		cout<<"El numero: "<<*dir_numero<<" es impar"<<endl;
		cout<<"Su direccion es: "<<dir_numero<<endl;

    	}

system ("pause");
return 0;
}

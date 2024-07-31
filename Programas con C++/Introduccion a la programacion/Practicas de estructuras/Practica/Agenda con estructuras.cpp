/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
   Trabajo: agenda con estructuras
*/

#include<iostream>

using  namespace std;
struct agenda{
	int cod;
	string nom;
	string telf1;
	string telf2;
	string email;
	string tipo;
}agenda1;

int main(){
	cout<<"Introducir tu Nombre: ";
	cin>>agenda1.nom;
	cout<<"Introducir tu numero Telefonico: ";
	cin>>agenda1.telf1;
	cout<<"Introducir tu numero Celular : ";
	cin>>agenda1.telf2;
	cout<<"Introducir tu Email: ";
	cin>>agenda1.email;
	cout<<"Introducir tu Tipo: ";
	cin>>agenda1.tipo;
	cout<<"Introducir tu codigo: ";
	cin>>agenda1.cod;
	cout << "------------------------\n";
	  cout<<"Codigo: "<<agenda1.cod<<endl;
	 cout<<"Nombre :"<<agenda1.nom<<endl;
	 cout<<"Telefono :"<<agenda1.telf1<<endl;
	 cout<<"Celular :"<<agenda1.telf2<<endl;
	 cout<<"Email :"<<agenda1.email<<endl;
	 cout<<"Tipo :"<<agenda1.tipo<<endl;
system ("pause");
return 0;
}

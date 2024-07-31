/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<string.h>

using  namespace std;

int main(){
string p1,p2;
	cout<<"Introduce cualquir palabra o nombre: ";
		cin>>p1;
	cout<<"Introduce cualquier palabra o nombre: ";
		cin>>p2; 
	if(p1 == p2){
		cout<< "Son iguales: "<<p1<<" "<<" "<<p2<<endl;	
	}
	else {
		cout<< "No son iguales: "<<p1<<" " <<" "<<p2<<endl;
	}

system ("pause");
return 0;
}

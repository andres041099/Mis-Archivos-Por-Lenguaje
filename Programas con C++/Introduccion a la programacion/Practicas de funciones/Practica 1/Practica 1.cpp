/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;
float lam (float, float, float );
 
int main(){
float n1, n2, n3;
float mediadetres;

cout<< "Dijite el primer numeros: ";
cin>>n1;
cout<< "Dijite el segundo numeros: ";
cin>>n2;
cout<< "Dijite el tercero numeros: ";
cin>>n3;
mediadetres= lam(n1,  n2,  n3);
cout<<"la media de tres numero es: "<<mediadetres<<endl;

system ("pause");
return 0;
}

float lam (float a, float b, float c ){
float lamt= a+b+c/2;
	
}

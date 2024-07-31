/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;

void intercambio(float *, float *);
 
int main(){
float num1, num2;
cout<<"Introduce cualquier numero: ";
cin>>num1;
cout<<"Introduce cualquier numero: ";
cin>>num2;
intercambio(&num1, &num2);
cout<< "El valor intercambiado del primer valor es: "<<num1<<endl;
cout<< "El valor intercambiado del segundo valor es: "<<num2<<endl;
system ("pause");
return 0;
}
void intercambio(float *dirnum1, float *dirnum2){
	float aux;
	aux = *dirnum1;
	*dirnum1 = *dirnum2;
	*dirnum2 = aux;
}

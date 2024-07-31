/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<conio.h>
#include<string.h>

using  namespace std;

int main(){
	string cad;
	cout<<"Introduce anything: ";
	cin>>cad;
	string aux_cad = "";
    for (int i = cad.size(); i >=0 ; i--)
         aux_cad += cad[i];
         
	cout<<"The text is: "<<cad<<endl;
    cout<<"The inverted text is: "<<aux_cad<<endl;


system ("pause");
return 0;
}

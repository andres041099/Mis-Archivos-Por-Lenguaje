/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include <string>
#include <algorithm>
using  namespace std;

int main(){
	    string cadena;
	    cout<<"Introduce cualquier palabra: ";
	    cin>>cadena;
    string aux_cadena(cadena.begin(), cadena.end());
    reverse(aux_cadena.begin(), aux_cadena.end());
 
    cout<<"El texto normal es: "<<cadena<<endl;
    cout<<"El texto invertido es: "<<aux_cadena<<endl;
    return 0;


system ("pause");
return 0;
}

/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;

int main(){
int a=0, b=0;
float f=3.4f;
void *pv=&a;
cout<<"La direcion de a es: "<<&a<<endl;
cout<<"la direcion de b es: "<<&b<<endl;
cout<<"la direcion de f es: "<<&f<<endl;
cout<<"El valor de a  es: "<<a<<endl;
cout<<"El valor de b es: "<<b<<endl;
cout<<"El valor de f es: "<<f<<endl;
cout<<"El valor contenido en pv es: "<<pv<<endl;
system ("pause");
return 0;
}

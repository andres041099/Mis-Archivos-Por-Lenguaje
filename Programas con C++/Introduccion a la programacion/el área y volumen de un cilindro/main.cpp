/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

# include<iostream>




using  namespace std;

int main(){
float r, h, pi, alt, volu;
cout<<"introduce el area: "; 
cin>> r;
cout<<"introduce volumen: ";
 cin>> h;
pi= 3.14;
alt= 2*pi*r*h;
volu= pi*r*r*h;
cout<<"el area es: "<<alt<<endl;
cout<<"el volumen es: "<<volu<<endl;

system ("pause");
return 0;
}

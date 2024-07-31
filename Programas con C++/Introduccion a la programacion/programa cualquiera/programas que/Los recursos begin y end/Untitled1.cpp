/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<string.h>

using  namespace std;

int main(){
string cad,cad2;
cout<<"Introduce any word: ";
cin>>cad;
cout<<"Introduce another word: ";
cin>>cad2;
string::iterator inicio( cad.begin() );
string::iterator final(cad2.end() );
cout<<cad<< " " <<" "<<cad2<<endl;

system ("pause");
return 0;
}

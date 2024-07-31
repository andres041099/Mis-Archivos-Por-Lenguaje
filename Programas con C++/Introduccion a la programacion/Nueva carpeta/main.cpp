/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

# include<iostream>
# include<string.h>

using  namespace std;

int main(){
	
	 
	string nom, apel;
	cout<<"Introduce tu nombre: ";
	cin>> nom;
	
	cout<<"Introce tu apellido: ";
	cin>>apel;
	
	cout<<nom  <<"  " <<"  " <<apel  <<endl;
string estrella; 

cout<< "introduce tu superstrella favorita: ";
cin>>estrella;

switch( estrella){
case 1: cout<<"batista"; break;
case 2: cout<<"randy"; break;
default: cout<<"no existe....intenta de nuevo ";break;
}

int super;
cout<<"introduce tu superestrella favorita: ";
cin>> super; 


if(super= super ) {
	cout<< "batista "<< super<<"randy" << endl;

}

else{ cout<< "fallaste "<< super<< endl;
}




system ("pause");
return 0;
}

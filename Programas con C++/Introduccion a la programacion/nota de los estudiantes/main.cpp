/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

# include<iostream>
# include <string.h>

using  namespace std;

int main(){
	string nom, apel;
	
	cout<<"Introduce tu nombre: ";
	cin>> nom;
	
	cout<<"Introce tu apellido: ";
	cin>>apel;
	
	cout<<nom  <<"  " <<"  " <<apel  <<endl;
float ntt, nt1, nt2, nt3, nt4, dato1 = 80;
cout <<  "introduce tu primera nota: ";
cin>> nt1;
cout<<  "introduce tu segunda nota: ";
cin>> nt2;
cout<<  "introduce tu tercera nota: ";
cin>> nt3;
cout<<  "introduce tu cuarta nota: ";
cin>> nt4;
ntt= (nt1 + nt2 + nt3+nt4) /4;
if( ntt>=80) {
	cout << nom << " "<< " " << apel << " " << "" << " su resutado es: "<< ntt   <<"...pasate" << endl;

}

else{ cout << nom <<" " <<" " << apel << " " << " " << "su resutado es: "<< ntt <<"...se quemo"<< endl;
}


system ("pause");
return 0;
}

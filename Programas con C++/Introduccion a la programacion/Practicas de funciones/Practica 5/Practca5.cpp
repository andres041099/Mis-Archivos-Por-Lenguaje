/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;
void myor(int x,int y);
void pedirDatos();

int n1,n2;

int main(){
	pedirDatos();
	myor(n1,n2);
	
	system ("pause");
	return 0;
}

void pedirDatos(){	
	cout<<"Digite primer numeros: ";
	cin>>n1;
	cout<<"Digite segundo numeros: ";
	cin>>n2;
}

void myor(int x,int y){
	if(x>y){
		cout<<"el mayor es:"<<x<<endl;
		
	}
	else{
	cout<<"el mayor es:"<<y<<endl;	
	}
}

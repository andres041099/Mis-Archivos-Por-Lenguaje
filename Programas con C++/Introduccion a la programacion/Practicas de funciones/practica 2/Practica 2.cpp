/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;
int  factr(int, int, int );
int main(){
	int i, num, fact, elft;	
cout<<"Digite un numero: ";
 cin>>num;
	   elft= factr(num,i, fact);
		cout<<"El factorial del numero es igual a: "<<elft<<endl;
       		
			   if(elft>=100){
		
		cout<<elft<<" "<<" "<< "Esta en el rango de 100 a 10000 "<<endl;
		}
	else{
		
		cout <<elft<<" "<<" "<<"No testa en el rango "<<endl;
	}
	
system ("pause");
return 0;
}
int factr(int num, int i, int fact){
	for(i=1;i<=num;i++){
   	 fact= fact*i;
  }	

	
}



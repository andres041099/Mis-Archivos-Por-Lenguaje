/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>

using  namespace std;

int main(){
   int i, n, factorial;
     
   cout << "Introduce un numero: ";
   cin >> n;
   factorial=1;
   for(i=1;i<=n;i++){
   factorial = factorial * i;
   }
        
   cout<<"el factorial es"<<factorial<<endl; 
      
   
   	


system ("pause");
return 0;
}

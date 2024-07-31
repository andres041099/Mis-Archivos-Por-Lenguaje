/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include <iostream>

#include <vector> 
using  namespace std;

int main(){


vector<int> myvector{ 1, 2, 3, 4, 5 }; 
  
    // using begin() to print vector 
    for (auto it = myvector.begin(); 
         it != myvector.end(); ++it) 
        cout << ' ' << *it; 


system ("pause");
return 0;
}

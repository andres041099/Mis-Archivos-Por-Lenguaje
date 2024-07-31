/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<string.h>
#include <algorithm>
#include <cctype>

using  namespace std;

int main(){
   string s;
   cout<<"Introducir cualquier palabra: " ;
   cin>>s;

    std::transform(s.begin(), s.end(), s.begin(), ::toupper);

    cout << s << endl;

system ("pause");
return 0;
}

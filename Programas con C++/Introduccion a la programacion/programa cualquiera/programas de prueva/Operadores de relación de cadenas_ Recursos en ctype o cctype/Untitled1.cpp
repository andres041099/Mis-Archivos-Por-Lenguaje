/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/
#include <iostream>
#include <string>
#include <locale>
using namespace std;
int main(void){
locale loc;
string str("miami is so nice and i'm gonna go there" );
for (size_t i(0); i < str.length(); ++i){
if ( !isprint(str.at(i)) )
break;
cout << str.at(i);
}
return 0;
}

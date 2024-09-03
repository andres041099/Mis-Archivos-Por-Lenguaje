#include <iostream>
#include <vector>
#include "esconu.h"
#include <algorithm> // para usar find

using namespace std;

int main(void)
{
    BorraPantalla();
    
	string cadena("Felix Maria Ferreiras Guzman");
    
	
	vector<string> profesores;
	
	// CARGAMOS ALGUNOS ELEMENTOS EN EL <vector>
	
	profesores.push_back("Maria Antonieta Toyota Sanchez");
	profesores.push_back("Luiza Maria Ferreiras Guzman");
	profesores.push_back("Camioneta Luz Virgen Santa");
	profesores.push_back("Hennry Antonio Lopez Cruz");
	profesores.push_back("Felix Maria Ferreiras Guzman");
	profesores.push_back("Licenciado Churumusco Cruz Valdez");
	profesores.push_back("Informatica Maria Ferreiras Lopez");

	// HACEMOS LA BUSQUEDA
	
	vector<string>::const_iterator nombre;
	nombre =  find( profesores.begin(), profesores.end(), cadena );
	
	if( nombre  == profesores.end() )
		cout << endl << "=> No encontrado el nombre buscado: " << endl << "    " << cadena << endl;
	else
		cout << endl << "=> Encontrado !! el nombre: " << endl << endl << "   " << *nombre << endl;
	
	return 0;
}
